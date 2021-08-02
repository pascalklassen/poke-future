package io.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.utility.internal.TypeClassHolder;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class APIResource<ResourceT> extends TypeClassHolder<ResourceT> {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIResource.class);

    /**
     * The URL of the referenced resource.
     */
    @JsonProperty("url")
    private String url;

    public APIResource() {
    }

    public Future<ResourceT> fetch() {
        if (getTypeClass() == null) {
            return Future.failedFuture(new NullPointerException("typeClass was null"));
        }

        return PokemonService.fetchAs(getTypeClass(), getUrl(), true);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "APIResource{" +
                "url='" + url + '\'' +
                '}';
    }

    public static <R, T extends APIResource<R>> Future<List<R>> composeAll(List<T> resourceList) {
        Promise<List<R>> promise = Promise.promise();

        CompositeFuture
                .any(
                        resourceList
                                .stream()
                                .map(APIResource::fetch)
                                .collect(Collectors.toList())
                ).onSuccess(fut -> promise.complete(fut.list()))
                .onFailure(promise::fail);

        return promise.future();
    }
}
