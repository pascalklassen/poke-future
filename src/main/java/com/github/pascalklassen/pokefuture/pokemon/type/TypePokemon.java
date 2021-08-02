package com.github.pascalklassen.pokefuture.pokemon.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.pokemon.Pokemon;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;

@ResourceEntity
public final class TypePokemon {

    /**
     * The order the Pokémon's types are listed in.
     */
    @JsonProperty("slot")
    private int slot;

    /**
     * The Pokémon that has the referenced type.
     */
    @FetchAs(Pokemon.class)
    @JsonProperty("pokemon")
    private NamedAPIResource<Pokemon> pokemon;

    public TypePokemon() {
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public NamedAPIResource<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(NamedAPIResource<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String toString() {
        return "TypePokemon{" +
                "slot=" + slot +
                ", pokemon=" + pokemon +
                '}';
    }
}
