package io.github.pascalklassen.pokefuture;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import io.github.pascalklassen.pokefuture.berry.Berry;
import io.github.pascalklassen.pokefuture.berry.firmness.BerryFirmness;
import io.github.pascalklassen.pokefuture.berry.flavor.BerryFlavor;
import io.github.pascalklassen.pokefuture.contest.effect.ContestEffect;
import io.github.pascalklassen.pokefuture.contest.supereffect.SuperContestEffect;
import io.github.pascalklassen.pokefuture.contest.type.ContestType;
import io.github.pascalklassen.pokefuture.encounter.condition.EncounterCondition;
import io.github.pascalklassen.pokefuture.encounter.condition.value.EncounterConditionValue;
import io.github.pascalklassen.pokefuture.encounter.method.EncounterMethod;
import io.github.pascalklassen.pokefuture.evolution.chain.EvolutionChain;
import io.github.pascalklassen.pokefuture.evolution.trigger.EvolutionTrigger;
import io.github.pascalklassen.pokefuture.game.generation.Generation;
import io.github.pascalklassen.pokefuture.game.pokedex.Pokedex;
import io.github.pascalklassen.pokefuture.game.version.Version;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.item.Item;
import io.github.pascalklassen.pokefuture.item.attribute.ItemAttribute;
import io.github.pascalklassen.pokefuture.item.category.ItemCategory;
import io.github.pascalklassen.pokefuture.item.flingeffect.ItemFlingEffect;
import io.github.pascalklassen.pokefuture.item.pocket.ItemPocket;
import io.github.pascalklassen.pokefuture.location.Location;
import io.github.pascalklassen.pokefuture.location.area.LocationArea;
import io.github.pascalklassen.pokefuture.location.area.palpark.PalParkArea;
import io.github.pascalklassen.pokefuture.location.region.Region;
import io.github.pascalklassen.pokefuture.move.Move;
import io.github.pascalklassen.pokefuture.move.ailment.MoveAilment;
import io.github.pascalklassen.pokefuture.move.battlestyle.MoveBattleStyle;
import io.github.pascalklassen.pokefuture.move.category.MoveCategory;
import io.github.pascalklassen.pokefuture.move.damageclass.MoveDamageClass;
import io.github.pascalklassen.pokefuture.move.learnmethod.MoveLearnMethod;
import io.github.pascalklassen.pokefuture.move.target.MoveTarget;
import io.github.pascalklassen.pokefuture.pokemon.Pokemon;
import io.github.pascalklassen.pokefuture.pokemon.ability.Ability;
import io.github.pascalklassen.pokefuture.pokemon.characteristic.Characteristic;
import io.github.pascalklassen.pokefuture.pokemon.color.PokemonColor;
import io.github.pascalklassen.pokefuture.pokemon.egg.EggGroup;
import io.github.pascalklassen.pokefuture.pokemon.form.PokemonForm;
import io.github.pascalklassen.pokefuture.pokemon.gender.Gender;
import io.github.pascalklassen.pokefuture.pokemon.growth.GrowthRate;
import io.github.pascalklassen.pokefuture.pokemon.habitat.PokemonHabitat;
import io.github.pascalklassen.pokefuture.pokemon.nature.Nature;
import io.github.pascalklassen.pokefuture.pokemon.shape.PokemonShape;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.pokemon.stat.Stat;
import io.github.pascalklassen.pokefuture.pokemon.stat.pokeathlon.PokeathlonStat;
import io.github.pascalklassen.pokefuture.pokemon.type.Type;
import io.github.pascalklassen.pokefuture.utility.internal.APIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.TypeClassHolder;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.language.Language;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.codec.BodyCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class PokemonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonService.class);

    private static boolean cachingEnabled = true;
    private static Map<Class<?>, Cache<String, Object>> caches;

    static {
        initializeCaches();
    }

    private PokemonService() {
    }

    public static <T> Future<T> fetchAs(@NotNull Class<T> clazz, @NotNull String uri) {
        return fetchAs(clazz, uri, false);
    }

    public static <T> Future<T> fetchAs(@NotNull Class<T> clazz, @NotNull String uri, boolean absolute) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(uri);

        Promise<T> promise = Promise.promise();

        if (cachingEnabled) {
            T value = getValue(clazz, uri);
            if (value != null) {
                return Future.succeededFuture(value);
            }
        }

        HttpRequest<Buffer> request = absolute ?
                RequestFactory.newResourceRequest(uri) :
                RequestFactory.newRequest(String.format("/api/v2%s", uri));

        request.as(BodyCodec.json(clazz))
                .send(ar -> {
                    if (ar.succeeded()) {
                        T t = ar.result().body();
                        resolveFetchTypes(clazz, t);
                        promise.complete(t);
                        if (cachingEnabled) {
                            LOGGER.debug(String.format("Cached Value: '%s' -> '%s'", uri, clazz.getSimpleName()));

                            setValue(clazz, uri, t);
                        }
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

    @SuppressWarnings("unchecked")
    private static <T> T getValue(@NotNull Class<T> clazz, @NotNull String uri) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(uri);

        if (!caches.containsKey(clazz)) {
            return null;
        }

        return (T) caches
                .get(clazz)
                .getIfPresent(uri);
    }

    private static <T> void setValue(@NotNull Class<T> clazz, @NotNull String key, @NotNull Object value) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(value);

        caches
                .get(clazz)
                .put(key, value);
    }

    public static void enableCaching() {
        cachingEnabled = true;
        initializeCaches();
    }

    public static void disableCaching() {
        cachingEnabled = false;
        invalidateAllCaches();
        caches = null;
    }

    private static Cache<String, Object> createCache() {
        return CacheBuilder
                .newBuilder()
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .build();
    }

    private static void initializeCaches() {
        caches = new HashMap<>();
        caches.put(Ability.class, createCache());
        caches.put(Berry.class, createCache());
        caches.put(BerryFirmness.class, createCache());
        caches.put(BerryFlavor.class, createCache());
        caches.put(Characteristic.class, createCache());
        caches.put(ContestType.class, createCache());
        caches.put(ContestEffect.class, createCache());
        caches.put(EggGroup.class, createCache());
        caches.put(EncounterMethod.class, createCache());
        caches.put(EncounterCondition.class, createCache());
        caches.put(EncounterConditionValue.class, createCache());
        caches.put(EvolutionChain.class, createCache());
        caches.put(EvolutionTrigger.class, createCache());
        caches.put(Generation.class, createCache());
        caches.put(Gender.class, createCache());
        caches.put(GrowthRate.class, createCache());
        caches.put(Item.class, createCache());
        caches.put(ItemCategory.class, createCache());
        caches.put(ItemAttribute.class, createCache());
        caches.put(ItemFlingEffect.class, createCache());
        caches.put(ItemPocket.class, createCache());
        caches.put(Language.class, createCache());
        caches.put(Location.class, createCache());
        caches.put(LocationArea.class, createCache());
        caches.put(Move.class, createCache());
        caches.put(MoveAilment.class, createCache());
        caches.put(MoveBattleStyle.class, createCache());
        caches.put(MoveCategory.class, createCache());
        caches.put(MoveDamageClass.class, createCache());
        caches.put(MoveLearnMethod.class, createCache());
        caches.put(MoveTarget.class, createCache());
        caches.put(Nature.class, createCache());
        caches.put(PalParkArea.class, createCache());
        caches.put(Pokedex.class, createCache());
        caches.put(Pokemon.class, createCache());
        caches.put(PokemonColor.class, createCache());
        caches.put(PokemonForm.class, createCache());
        caches.put(PokemonHabitat.class, createCache());
        caches.put(PokemonShape.class, createCache());
        caches.put(PokemonSpecies.class, createCache());
        caches.put(PokeathlonStat.class, createCache());
        caches.put(Region.class, createCache());
        caches.put(Stat.class, createCache());
        caches.put(SuperContestEffect.class, createCache());
        caches.put(Type.class, createCache());
        caches.put(Version.class, createCache());
        caches.put(VersionGroup.class, createCache());
    }

    private static void invalidateAllCaches() {
        if (caches != null) {
            for (Cache<String, Object> cache : caches.values()) {
                invalidateCache(cache);
            }
        }
    }

    private static void invalidateCache(@NotNull Cache<String, Object> cache) {
        Preconditions.checkNotNull(cache);

        cache.invalidateAll();
        cache.cleanUp();
    }

    /**
     * If you can see this. I am crazy. I need medical help. Please contact me.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void resolveFetchTypes(@NotNull Class<?> clazz, @Nullable Object object) {
        Preconditions.checkNotNull(clazz);

        if (!clazz.isAnnotationPresent(ResourceEntity.class)) return;
        if (object == null) return;

        LOGGER.debug(String.format("Resolving Fetch Types for Class '%s'", clazz.getSimpleName()));

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getType().isPrimitive()) continue;
            field.setAccessible(true);

            LOGGER.debug(String.format("%s:\tInspecting Field '%s'", clazz.getSimpleName(), field.getName()));

            try {
                Object value = field.get(object);

                if (value == null) continue;

                if (object instanceof NamedAPIResourceList) {
                    LOGGER.debug("Class was NamedAPIResourceList");

                    NamedAPIResourceList resourceList = (NamedAPIResourceList) object;

                    if (value instanceof List) {
                        List<NamedAPIResource> list = (List<NamedAPIResource>) value;
                        list.forEach(obj -> {
                            obj.setTypeClass(resourceList.getTypeClass());
                            resolveFetchTypes(NamedAPIResource.class, obj);
                        });
                    }
                    continue;
                } else if (object instanceof APIResourceList) {
                    APIResourceList resourceList = (APIResourceList) object;

                    if (value instanceof List) {
                        List<APIResourceList> list = (List<APIResourceList>) value;
                        list.forEach(obj -> {
                            obj.setTypeClass(resourceList.getTypeClass());
                            resolveFetchTypes(APIResourceList.class, obj);
                        });
                    }
                    continue;
                }

                if (field.isAnnotationPresent(FetchAs.class)) {
                    LOGGER.debug(String.format("Annotation was present on Field '%s'", field.getName()));

                    FetchAs fetchAs = field.getAnnotation(FetchAs.class);

                    if (value instanceof List) {
                        LOGGER.debug(String.format("Field '%s' was type List<TypeClassHolder>", field.getName()));

                        List<TypeClassHolder> resources = (List<TypeClassHolder>) value;
                        resources.forEach(resource -> resource.setTypeClass(fetchAs.value()));
                    } else if (value instanceof TypeClassHolder) {
                        LOGGER.debug(String.format("Field '%s' was type TypeClassHolder", field.getName()));
                        TypeClassHolder resource = (TypeClassHolder) value;
                        resource.setTypeClass(fetchAs.value());
                    } else {
                        LOGGER.error(
                                String.format(
                                        "Field '%s' in Class '%s' was neither a List nor a TypeClassHolder",
                                        field.getName(),
                                        clazz.getName()
                                )
                        );
                    }
                } else {
                    if (value instanceof List) {
                        LOGGER.debug(String.format("Field '%s' was a generic List", field.getName()));

                        List<Object> list = (List<Object>) value;
                        list.forEach(obj -> resolveFetchTypes(obj.getClass(), obj));
                    } else {
                        LOGGER.debug(String.format("Field '%s' was a generic Object", field.getName()));

                        resolveFetchTypes(value.getClass(), value);
                    }
                }
            } catch (IllegalAccessException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }
}
