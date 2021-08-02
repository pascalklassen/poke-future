package com.github.pascalklassen.pokefuture.pokemon.color;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import com.github.pascalklassen.pokefuture.utility.common.Name;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Colors used for sorting Pokémon in a Pokédex. The color listed in the Pokédex is usually the color most apparent or
 * covering each Pokémon's body. No orange category exists; Pokémon that are primarily orange are listed as red or
 * brown.
 *
 * GET https://pokeapi.co/api/v2/pokemon-color/{id or name}/
 */
@ResourceEntity
public final class PokemonColor {

    /**
     * The identifier for this resource.
     */
    @JsonProperty("id")
    private int id;

    /**
     * The identifier for this resource.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A list of the Pokémon species that have this color.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("pokemon_species")
    private List<NamedAPIResource<PokemonSpecies>> pokemonSpecies;

    public PokemonColor() {
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
        return "PokemonColor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", names=" + names +
                ", pokemonSpecies=" + pokemonSpecies +
                '}';
    }

    public static Future<PokemonColor> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(PokemonColor.class, String.format("/pokemon-color/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<PokemonColor>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<PokemonColor>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(PokemonColor.class, String.format("/pokemon-color?limit=%s&offset=%s", limit, offset));
    }
}
