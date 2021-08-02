package io.github.pascalklassen.pokefuture.location.area.palpark;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Areas used for grouping Pokémon encounters in Pal Park. They're like habitats that are specific to
 * <a href="https://bulbapedia.bulbagarden.net/wiki/Pal_Park">Pal Park</a>.
 *
 * GET https://pokeapi.co/api/v2/pal-park-area/{id or name}/
 */
@ResourceEntity
public final class PalParkArea {

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
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A list of Pokémon encountered in thi pal park area along with details.
     */
    @JsonProperty("pokemon_encounters")
    private List<PalParkEncounterSpecies> pokemonEncounters;

    public PalParkArea() {
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

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<PalParkEncounterSpecies> getPokemonEncounters() {
        return pokemonEncounters;
    }

    public void setPokemonEncounters(List<PalParkEncounterSpecies> pokemonEncounters) {
        this.pokemonEncounters = pokemonEncounters;
    }

    @Override
    public String toString() {
        return "PalParkArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", names=" + names +
                ", pokemonEncounters=" + pokemonEncounters +
                '}';
    }

    public static Future<PalParkArea> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(PalParkArea.class, String.format("/pal-park-area/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<PalParkArea>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<PalParkArea>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(PalParkArea.class, String.format("/pal-park-area?limit=%s&offset=%s", limit, offset));
    }
}
