package io.github.pascalklassen.pokefuture.pokemon.gender;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Genders were introduced in Generation II for the purposes of breeding Pokémon but can also result in visual
 * differences or even different evolutionary lines. Check out
 * <a href="https://bulbapedia.bulbagarden.net/wiki/Gender">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/gender/{id or name}/
 */
@ResourceEntity
public final class Gender {

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
     * A list of Pokémon species that can be this gender and how likely it is that they will be.
     */
    @JsonProperty("pokemon_species_details")
    private List<PokemonSpeciesGender> pokemonSpeciesDetails;

    /**
     * A list of Pokémon species that required this gender in order for a Pokémon to evolve into them.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("required_for_evolution")
    private List<NamedAPIResource<PokemonSpecies>> requiredForEvolution;

    public Gender() {
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

    public List<PokemonSpeciesGender> getPokemonSpeciesDetails() {
        return pokemonSpeciesDetails;
    }

    public void setPokemonSpeciesDetails(List<PokemonSpeciesGender> pokemonSpeciesDetails) {
        this.pokemonSpeciesDetails = pokemonSpeciesDetails;
    }

    public List<NamedAPIResource<PokemonSpecies>> getRequiredForEvolution() {
        return requiredForEvolution;
    }

    public void setRequiredForEvolution(List<NamedAPIResource<PokemonSpecies>> requiredForEvolution) {
        this.requiredForEvolution = requiredForEvolution;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pokemonSpeciesDetails=" + pokemonSpeciesDetails +
                ", requiredForEvolution=" + requiredForEvolution +
                '}';
    }

    public static Future<Gender> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Gender.class, String.format("/gender/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Gender>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Gender>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Gender.class, String.format("/gender?limit=%s&offset=%s", limit, offset));
    }

}
