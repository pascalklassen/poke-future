package io.github.pascalklassen.pokefuture.berry.flavor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.contest.type.ContestType;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Flavors determine whether a Pokémon will benefit or suffer from eating a berry based on their
 * <a href="https://pokeapi.co/docs/v2#natures">nature</a>. Check out
 * <a href="http://bulbapedia.bulbagarden.net/wiki/Flavor">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/berry-flavor/{id or name}/
 */
@ResourceEntity
public final class BerryFlavor {

    /**
     * The identifier for this resource.
     */
    @JsonProperty("id")
    private int id;

    /**
     * The name for this resource.
     */
    @JsonProperty("name")
    private String name;

    /**
     * A list of the berries with this flavor.
     */
    @JsonProperty("berries")
    private List<FlavorBerryMap> berries;

    /**
     * The contest type that correlates with this berry flavor.
     */
    @FetchAs(ContestType.class)
    @JsonProperty("contest_type")
    private NamedAPIResource<ContestType> contestType;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    public BerryFlavor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlavorBerryMap> getBerries() {
        return berries;
    }

    public void setBerries(List<FlavorBerryMap> berries) {
        this.berries = berries;
    }

    public NamedAPIResource<ContestType> getContestType() {
        return contestType;
    }

    public void setContestType(NamedAPIResource<ContestType> contestType) {
        this.contestType = contestType;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "BerryFlavor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", berries=" + berries +
                ", contestType=" + contestType +
                ", names=" + names +
                '}';
    }

    public static Future<BerryFlavor> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(BerryFlavor.class, String.format("/berry-flavor/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<BerryFlavor>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<BerryFlavor>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(BerryFlavor.class, String.format("/berry-flavor?limit=%s&offset=%s", limit, offset));
    }

}
