package io.github.pascalklassen.pokefuture.pokemon.habitat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Habitats are generally different terrain Pokémon can be found in but can also be areas designated for rare or
 * legendary Pokémon.
 *
 * GET https://pokeapi.co/api/v2/pokemon-habitat/{id or name}/
 */
@ResourceEntity
public final class PokemonHabitat {

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
     * A list of the Pokémon species that can be found in this habitat.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("pokemon_species")
    private List<NamedAPIResource<PokemonSpecies>> pokemonSpecies;

    public PokemonHabitat() {
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

    public List<NamedAPIResource<PokemonSpecies>> getPokemonSpecies() {
        return pokemonSpecies;
    }

    public void setPokemonSpecies(List<NamedAPIResource<PokemonSpecies>> pokemonSpecies) {
        this.pokemonSpecies = pokemonSpecies;
    }

    @Override
    public String toString() {
        return "PokemonHabitat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", names=" + names +
                ", pokemonSpecies=" + pokemonSpecies +
                '}';
    }

    public static Future<PokemonHabitat> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(PokemonHabitat.class, String.format("/pokemon-habitat/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<PokemonHabitat>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<PokemonHabitat>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(PokemonHabitat.class, String.format("/pokemon-habitat?limit=%s&offset=%s", limit, offset));
    }
}
