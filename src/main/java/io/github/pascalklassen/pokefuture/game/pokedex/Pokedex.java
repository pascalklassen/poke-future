package io.github.pascalklassen.pokefuture.game.pokedex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.location.region.Region;
import io.github.pascalklassen.pokefuture.utility.common.Description;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A Pokédex is a handheld electronic encyclopedia device; one which is capable of recording and retaining information
 * of the various Pokémon in a given region with the exception of the national dex and some smaller dexes related to
 * portions of a region. See <a href="http://bulbapedia.bulbagarden.net/wiki/Pokedex">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/pokedex/{id or name}/
 */
@ResourceEntity
public final class Pokedex {

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
     * Whether or not this Pokédex originated in the main series of the video games.
     */
    @JsonProperty("is_main_series")
    private boolean isMainSeries;

    /**
     * The description of this resource listed in different languages.
     */
    @JsonProperty("descriptions")
    private List<Description> descriptions;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A list of Pokémon catalogued in this Pokédex and their indexes.
     */
    @JsonProperty("pokemon_entries")
    private List<PokemonEntry> pokemonEntries;

    /**
     * The region this Pokédex catalogues Pokémon for.
     */
    @FetchAs(Region.class)
    @JsonProperty("region")
    private NamedAPIResource<Region> region;

    /**
     * A list of version groups this Pokédex is relevant to.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_groups")
    private List<NamedAPIResource<VersionGroup>> versionGroups;

    public Pokedex() {
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

    public boolean isMainSeries() {
        return isMainSeries;
    }

    public void setMainSeries(boolean mainSeries) {
        isMainSeries = mainSeries;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<PokemonEntry> getPokemonEntries() {
        return pokemonEntries;
    }

    public void setPokemonEntries(List<PokemonEntry> pokemonEntries) {
        this.pokemonEntries = pokemonEntries;
    }

    public NamedAPIResource<Region> getRegion() {
        return region;
    }

    public void setRegion(NamedAPIResource<Region> region) {
        this.region = region;
    }

    public List<NamedAPIResource<VersionGroup>> getVersionGroups() {
        return versionGroups;
    }

    public void setVersionGroups(List<NamedAPIResource<VersionGroup>> versionGroups) {
        this.versionGroups = versionGroups;
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isMainSeries=" + isMainSeries +
                ", descriptions=" + descriptions +
                ", names=" + names +
                ", pokemonEntries=" + pokemonEntries +
                ", region=" + region +
                ", versionGroups=" + versionGroups +
                '}';
    }

    public static Future<Pokedex> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Pokedex.class, String.format("/pokedex/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Pokedex>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Pokedex>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Pokedex.class, String.format("/pokedex?limit=%s&offset=%s", limit, offset));
    }
}
