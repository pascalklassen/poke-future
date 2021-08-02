package io.github.pascalklassen.pokefuture.evolution.trigger;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Evolution triggers are the events and conditions that cause a Pokémon to evolve. Check out
 * <a href="https://bulbapedia.bulbagarden.net/wiki/Methods_of_evolution">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/evolution-trigger/{id or name}/
 */
@ResourceEntity
public class EvolutionTrigger {

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
     * A list of pokemon species that result from this evolution trigger.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("pokemon_species")
    private List<NamedAPIResource<PokemonSpecies>> pokemonSpecies;

    public EvolutionTrigger() {
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
        return "EvolutionTrigger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", names=" + names +
                ", pokemonSpecies=" + pokemonSpecies +
                '}';
    }

    public static Future<EvolutionTrigger> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(EvolutionTrigger.class, String.format("/evolution-trigger/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<EvolutionTrigger>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<EvolutionTrigger>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(EvolutionTrigger.class, String.format("/evolution-trigger?limit=%s&offset=%s", limit, offset));
    }

}
