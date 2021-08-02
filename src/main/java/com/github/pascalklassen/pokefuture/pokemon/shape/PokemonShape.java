package com.github.pascalklassen.pokefuture.pokemon.shape;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.common.Name;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Shapes used for sorting Pokémon in a Pokédex.
 *
 * GET https://pokeapi.co/api/v2/pokemon-shape/{id or name}/
 */
@ResourceEntity
public final class PokemonShape {

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
     * The "scientific" name of this Pokémon shape listed in different languages.
     */
    @JsonProperty("awesome_names")
    private List<AwesomeName> awesomeNames;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A list of the Pokémon species that have this shape.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("pokemon_species")
    private List<NamedAPIResource<PokemonSpecies>> pokemonSpecies;

    public PokemonShape() {
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

    public List<AwesomeName> getAwesomeNames() {
        return awesomeNames;
    }

    public void setAwesomeNames(List<AwesomeName> awesomeNames) {
        this.awesomeNames = awesomeNames;
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
        return "PokemonShape{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", awesomeNames=" + awesomeNames +
                ", names=" + names +
                ", pokemonSpecies=" + pokemonSpecies +
                '}';
    }

    public static Future<PokemonShape> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(PokemonShape.class, String.format("/pokemon-shape/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<PokemonShape>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<PokemonShape>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(PokemonShape.class, String.format("/pokemon-shape?limit=%s&offset=%s", limit, offset));
    }
}
