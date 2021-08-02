package io.github.pascalklassen.pokefuture.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.location.area.LocationArea;
import io.github.pascalklassen.pokefuture.location.region.Region;
import io.github.pascalklassen.pokefuture.utility.common.GenerationGameIndex;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Locations that can be visited within the games. Locations make up sizable portions of regions, like cities or routes.
 *
 * GET https://pokeapi.co/api/v2/location/{id or name}/
 */
@ResourceEntity
public final class Location {

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
     * The region this location can be found in.
     */
    @FetchAs(Region.class)
    @JsonProperty("region")
    private NamedAPIResource<Region> region;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A list of game indices relevent to this location by generation.
     */
    @JsonProperty("game_indices")
    private List<GenerationGameIndex> gameIndices;

    /**
     * Areas that can be found within this location.
     */
    @FetchAs(LocationArea.class)
    @JsonProperty("areas")
    private List<NamedAPIResource<LocationArea>> areas;

    public Location() {
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

    public NamedAPIResource<Region> getRegion() {
        return region;
    }

    public void setRegion(NamedAPIResource<Region> region) {
        this.region = region;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<GenerationGameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GenerationGameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public List<NamedAPIResource<LocationArea>> getAreas() {
        return areas;
    }

    public void setAreas(List<NamedAPIResource<LocationArea>> areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region=" + region +
                ", names=" + names +
                ", gameIndices=" + gameIndices +
                ", areas=" + areas +
                '}';
    }

    public static Future<Location> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Location.class, String.format("/location/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Location>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Location>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Location.class, String.format("/location?limit=%s&offset=%s", limit, offset));
    }

}
