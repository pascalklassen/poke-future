package io.github.pascalklassen.pokefuture.game.pokedex;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

@ResourceEntity
public final class PokemonEntry {

    /**
     * The index of this Pokémon species entry within the Pokédex.
     */
    @JsonProperty("entry_number")
    private int entryNumber;

    /**
     * The Pokémon species being encountered.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("pokemon_species")
    private NamedAPIResource<PokemonSpecies> pokemonSpecies;

    public PokemonEntry() {
    }

    public int getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(int entryNumber) {
        this.entryNumber = entryNumber;
    }

    public NamedAPIResource<PokemonSpecies> getPokemonSpecies() {
        return pokemonSpecies;
    }

    public void setPokemonSpecies(NamedAPIResource<PokemonSpecies> pokemonSpecies) {
        this.pokemonSpecies = pokemonSpecies;
    }

    @Override
    public String toString() {
        return "PokemonEntry{" +
                "entryNumber=" + entryNumber +
                ", pokemonSpecies=" + pokemonSpecies +
                '}';
    }
}
