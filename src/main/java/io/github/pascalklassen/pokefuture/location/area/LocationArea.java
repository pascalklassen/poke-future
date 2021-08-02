package io.github.pascalklassen.pokefuture.location.area;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.location.Location;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Location areas are sections of areas, such as floors in a building or cave. Each area has its own set of possible
 * Pokémon encounters.
 *
 * GET https://pokeapi.co/api/v2/location-area/{id or name}/
 */
@ResourceEntity
public final class LocationArea {

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
     * The internal id of an API resource within game data.
     */
    @JsonProperty("game_index")
    private int gameIndex;

    /**
     * A list of methods in which Pokémon may be encountered in this area and how likely the method will occur depending
     * on the version of the game.
     */
    @JsonProperty("encounter_method_rates")
    private List<EncounterMethodRate> encounterMethodRates;

    /**
     * The region this location area can be found in.
     */
    @FetchAs(Location.class)
    @JsonProperty("location")
    private NamedAPIResource<Location> location;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A list of Pokémon that can be encountered in this area along with version specific details about the encounter.
     */
    @JsonProperty("pokemon_encounters")
    private List<PokemonEncounter> pokemonEncounters;

    public LocationArea() {
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

    public int getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public List<EncounterMethodRate> getEncounterMethodRates() {
        return encounterMethodRates;
    }

    public void setEncounterMethodRates(List<EncounterMethodRate> encounterMethodRates) {
        this.encounterMethodRates = encounterMethodRates;
    }

    public NamedAPIResource<Location> getLocation() {
        return location;
    }

    public void setLocation(NamedAPIResource<Location> location) {
        this.location = location;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<PokemonEncounter> getPokemonEncounters() {
        return pokemonEncounters;
    }

    public void setPokemonEncounters(List<PokemonEncounter> pokemonEncounters) {
        this.pokemonEncounters = pokemonEncounters;
    }

    @Override
    public String toString() {
        return "LocationArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gameIndex=" + gameIndex +
                ", encounterMethodRates=" + encounterMethodRates +
                ", location=" + location +
                ", names=" + names +
                ", pokemonEncounters=" + pokemonEncounters +
                '}';
    }

    public static Future<LocationArea> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(LocationArea.class, String.format("/location-area/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<LocationArea>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<LocationArea>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(LocationArea.class, String.format("/location-area?limit=%s&offset=%s", limit, offset));
    }

}
