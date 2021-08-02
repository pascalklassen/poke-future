package io.github.pascalklassen.pokefuture.location.area.palpark;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

@ResourceEntity
public final class PalParkEncounterSpecies {

    /**
     * The base score given to the player when this Pokémon is caught during a pal park run.
     */
    @JsonProperty("base_score")
    private int baseScore;

    /**
     * The base rate for encountering this Pokémon in this pal park area.
     */
    @JsonProperty("rate")
    private int rate;

    /**
     * The Pokémon species being encountered.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("pokemon_species")
    private NamedAPIResource<PokemonSpecies> pokemonSpecies;

    public PalParkEncounterSpecies() {
    }

    public int getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(int baseScore) {
        this.baseScore = baseScore;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public NamedAPIResource<PokemonSpecies> getPokemonSpecies() {
        return pokemonSpecies;
    }

    public void setPokemonSpecies(NamedAPIResource<PokemonSpecies> pokemonSpecies) {
        this.pokemonSpecies = pokemonSpecies;
    }

    @Override
    public String toString() {
        return "PalParkEncounterSpecies{" +
                "baseScore=" + baseScore +
                ", rate=" + rate +
                ", pokemonSpecies=" + pokemonSpecies +
                '}';
    }
}
