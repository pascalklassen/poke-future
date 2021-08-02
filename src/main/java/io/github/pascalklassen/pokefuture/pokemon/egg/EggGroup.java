package io.github.pascalklassen.pokefuture.pokemon.egg;

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
 * Egg Groups are categories which determine which Pokémon are able to interbreed. Pokémon may belong to either one or
 * two Egg Groups. Check out <a href="https://bulbapedia.bulbagarden.net/wiki/Egg_Group">Bulbapedia</a> for greater
 * detail.
 *
 * GET https://pokeapi.co/api/v2/egg-group/{id or name}/
 */
@ResourceEntity
public final class EggGroup {

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
     * The name of this resource listed in different languages.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("pokemon_species")
    private List<NamedAPIResource<PokemonSpecies>> pokemonSpecies;

    public EggGroup() {
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
        return "EggGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", names=" + names +
                ", pokemonSpecies=" + pokemonSpecies +
                '}';
    }

    public static Future<EggGroup> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(EggGroup.class, String.format("/egg-group/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<EggGroup>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<EggGroup>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(EggGroup.class, String.format("/egg-group?limit=%s&offset=%s", limit, offset));
    }

}
