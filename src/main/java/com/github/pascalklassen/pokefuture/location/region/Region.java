package com.github.pascalklassen.pokefuture.location.region;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.game.generation.Generation;
import com.github.pascalklassen.pokefuture.game.pokedex.Pokedex;
import com.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import com.github.pascalklassen.pokefuture.location.Location;
import com.github.pascalklassen.pokefuture.utility.common.Name;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A region is an organized area of the Pokémon world. Most often, the main difference between regions is the species of
 * Pokémon that can be encountered within them.
 *
 * GET https://pokeapi.co/api/v2/region/{id or name}/
 */
@ResourceEntity
public final class Region {

    /**
     * The identifier for this resource.
     */
    @JsonProperty("id")
    private int id;

    /**
     * A list of locations that can be found in this region.
     */
    @FetchAs(Location.class)
    @JsonProperty("locations")
    private List<NamedAPIResource<Location>> locations;

    /**
     * The name for this resource.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * The generation this region was introduced in.
     */
    @FetchAs(Generation.class)
    @JsonProperty("main_generation")
    private NamedAPIResource<Generation> mainGeneration;

    /**
     * A list of pokédexes that catalogue Pokémon in this region.
     */
    @FetchAs(Pokedex.class)
    @JsonProperty("pokedexes")
    private List<NamedAPIResource<Pokedex>> pokedexes;

    /**
     * A list of version groups where this region can be visited.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_groups")
    private List<NamedAPIResource<VersionGroup>> versionGroup;

    public Region() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<NamedAPIResource<Location>> getLocations() {
        return locations;
    }

    public void setLocations(List<NamedAPIResource<Location>> locations) {
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public NamedAPIResource<Generation> getMainGeneration() {
        return mainGeneration;
    }

    public void setMainGeneration(NamedAPIResource<Generation> mainGeneration) {
        this.mainGeneration = mainGeneration;
    }

    public List<NamedAPIResource<Pokedex>> getPokedexes() {
        return pokedexes;
    }

    public void setPokedexes(List<NamedAPIResource<Pokedex>> pokedexes) {
        this.pokedexes = pokedexes;
    }

    public List<NamedAPIResource<VersionGroup>> getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(List<NamedAPIResource<VersionGroup>> versionGroup) {
        this.versionGroup = versionGroup;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", locations=" + locations +
                ", name='" + name + '\'' +
                ", names=" + names +
                ", mainGeneration=" + mainGeneration +
                ", pokedexes=" + pokedexes +
                ", versionGroup=" + versionGroup +
                '}';
    }

    public static Future<Region> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Region.class, String.format("/region/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Region>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Region>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Region.class, String.format("/region?limit=%s&offset=%s", limit, offset));
    }

}
