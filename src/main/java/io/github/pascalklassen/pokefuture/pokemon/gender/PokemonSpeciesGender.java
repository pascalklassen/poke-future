package io.github.pascalklassen.pokefuture.pokemon.gender;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;

public final class PokemonSpeciesGender {

    /**
     * The chance of this Pokémon being female, in eighths; or -1 for genderless.
     */
    @JsonProperty("rate")
    private int rate;

    /**
     * A Pokémon species that can be the referenced gender.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("pokemon_species")
    private NamedAPIResource<PokemonSpecies> pokemonSpecies;

    public PokemonSpeciesGender() {
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
        return "PokemonSpeciesGender{" +
                "rate=" + rate +
                ", pokemonSpecies=" + pokemonSpecies +
                '}';
    }
}
