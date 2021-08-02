package com.github.pascalklassen.pokefuture;

import com.github.pascalklassen.pokefuture.utility.internal.APIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.TypeClassHolder;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.codec.BodyCodec;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

public final class PokemonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonService.class);

    private PokemonService() {
    }

    public static <T> Future<T> fetchAs(@NotNull Class<T> clazz, @NotNull String uri) {
        return fetchAs(clazz, uri, false);
    }

    public static <T> Future<T> fetchAs(@NotNull Class<T> clazz, @NotNull String uri, boolean absolute) {
        Promise<T> promise = Promise.promise();

        HttpRequest<Buffer> request = absolute ?
                RequestFactory.newResourceRequest(uri) :
                RequestFactory.newRequest(String.format("/api/v2%s", uri));

        request.as(BodyCodec.json(clazz))
                .send(ar -> {
                    if (ar.succeeded()) {
                        T t = ar.result().body();
                        resolveFetchTypes(clazz, t);
                        promise.complete(t);
                    } else {
                        promise.fail(ar.cause());
                    }
                });

        return promise.future();
    }

    public static <T> Future<APIResourceList<T>> fetchResourceList(@NotNull Class<T> clazz, @NotNull String uri) {
        return fetchResourceList(clazz, uri, false);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> Future<APIResourceList<T>> fetchResourceList(@NotNull Class<T> clazz, @NotNull String uri, boolean absolute) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(uri);
        Promise<APIResourceList<T>> promise = Promise.promise();

        HttpRequest<Buffer> request = absolute ?
                RequestFactory.newResourceRequest(uri) :
                RequestFactory.newRequest(String.format("/api/v2%s", uri));

        request.as(BodyCodec.json(APIResourceList.class))
                .send(ar -> {
                    if (ar.succeeded()) {
                        APIResourceList t = ar.result().body();
                        t.setTypeClass(clazz);
                        //LOGGER.info("resolve resource list");
                        resolveFetchTypes(APIResourceList.class, t);
                        promise.complete(t);
                    } else {
                        promise.fail(ar.cause());
                    }
                });

        return promise.future();
    }

    public static <T> Future<NamedAPIResourceList<T>> fetchNamedResourceList(@NotNull Class<T> clazz, @NotNull String uri) {
        return fetchNamedResourceList(clazz, uri, false);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> Future<NamedAPIResourceList<T>> fetchNamedResourceList(@NotNull Class<T> clazz, @NotNull String uri, boolean absolute) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(uri);
        Promise<NamedAPIResourceList<T>> promise = Promise.promise();

        HttpRequest<Buffer> request = absolute ?
                RequestFactory.newResourceRequest(uri) :
                RequestFactory.newRequest(String.format("/api/v2%s", uri));

        request.as(BodyCodec.json(NamedAPIResourceList.class))
                .send(ar -> {
                    if (ar.succeeded()) {
                        NamedAPIResourceList t = ar.result().body();
                        t.setTypeClass(clazz);
                        //LOGGER.info("resolve resource list");
                        resolveFetchTypes(NamedAPIResourceList.class, t);
                        promise.complete(t);
                    } else {
                        promise.fail(ar.cause());
                    }
                });

        return promise.future();
    }

    /**
     * If you can see this. I am crazy. I need medical help. Please contact me.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void resolveFetchTypes(Class<?> clazz, Object t) {
        if (!clazz.isAnnotationPresent(ResourceEntity.class)) return;
        if (t == null) return;

        //LOGGER.info(String.format("Resolving Fetch Types for Class '%s'", clazz.getSimpleName()));

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getType().isPrimitive()) continue;
            field.setAccessible(true);

            //LOGGER.info(String.format("Inspecting Field '%s'", field.getName()));

            try {
                if (field.get(t) == null) continue;

                if (t instanceof NamedAPIResourceList) {
                    //LOGGER.info("Class was NamedAPIResourceList");
                    NamedAPIResourceList resourceList = (NamedAPIResourceList) t;

                    if (field.get(t) instanceof List) {
                        List<NamedAPIResource> list = (List<NamedAPIResource>) field.get(t);
                        list.forEach(obj -> {
                            obj.setTypeClass(resourceList.getTypeClass());
                            resolveFetchTypes(NamedAPIResource.class, obj);
                        });
                    }
                    continue;
                } else if (t instanceof APIResourceList) {
                    APIResourceList resourceList = (APIResourceList) t;

                    if (field.get(t) instanceof List) {
                        List<APIResourceList> list = (List<APIResourceList>) field.get(t);
                        list.forEach(obj -> {
                            obj.setTypeClass(resourceList.getTypeClass());
                            resolveFetchTypes(APIResourceList.class, obj);
                        });
                    }
                    continue;
                }

                if (field.isAnnotationPresent(FetchAs.class)) {
                    //LOGGER.info(String.format("Annotation was present on Field '%s'", field.getName()));
                    FetchAs fetchAs = field.getAnnotation(FetchAs.class);
                    Object o = field.get(t);

                    if (o instanceof List) {
                        //LOGGER.info(String.format("Field '%s' was type List<TypeClassHolder>", field.getName()));
                        List<TypeClassHolder> resources = (List<TypeClassHolder>) o;
                        resources.forEach(resource -> resource.setTypeClass(fetchAs.value()));
                    } else if (o instanceof TypeClassHolder) {
                        //LOGGER.info(String.format("Field '%s' was type TypeClassHolder", field.getName()));
                        TypeClassHolder resource = (TypeClassHolder) o;
                        resource.setTypeClass(fetchAs.value());
                    } else {
                        LOGGER.error(
                                String.format(
                                        "Field '%s' in Class '%s' was neither a List nor a TypeClassHolder.",
                                        field.getName(),
                                        clazz.getName()
                                )
                        );
                    }
                } else {
                    if (field.get(t) instanceof List) {
                        //LOGGER.info(String.format("Field '%s' was a generic List", field.getName()));
                        List<Object> list = (List<Object>) field.get(t);
                        list.forEach(obj -> resolveFetchTypes(obj.getClass(), obj));
                    } else {
                        //LOGGER.info(String.format("Field '%s' was a generic Object", field.getName()));
                        Object obj = field.get(t);
                        resolveFetchTypes(obj.getClass(), obj);
                    }
                }
            } catch (IllegalAccessException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
