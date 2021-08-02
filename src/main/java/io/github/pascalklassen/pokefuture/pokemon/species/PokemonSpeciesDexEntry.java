package io.github.pascalklassen.pokefuture.pokemon.species;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.pokedex.Pokedex;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

@ResourceEntity
public final class PokemonSpeciesDexEntry {

    /**
     * The index number within the Pokédex.
     */
    @JsonProperty("entry_number")
    private int entryNumber;

    /**
     * The Pokédex the referenced Pokémon species can be found in.
     */
    @FetchAs(Pokedex.class)
    @JsonProperty("pokedex")
    private NamedAPIResource<Pokedex> pokedex;

    public PokemonSpeciesDexEntry() {
    }

    public int getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(int entryNumber) {
        this.entryNumber = entryNumber;
    }

    public NamedAPIResource<Pokedex> getPokedex() {
        return pokedex;
    }

    public void setPokedex(NamedAPIResource<Pokedex> pokedex) {
        this.pokedex = pokedex;
    }

    @Override
    public String toString() {
        return "PokemonSpeciesDexEntry{" +
                "entryNumber=" + entryNumber +
                ", pokedex=" + pokedex +
                '}';
    }
}
