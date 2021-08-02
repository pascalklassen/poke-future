package io.github.pascalklassen.pokefuture.pokemon.ability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.Pokemon;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public final class AbilityPokemon {

    /**
     * Whether or not this a hidden ability for the referenced Pokémon.
     */
    @JsonProperty("is_hidden")
    private boolean isHidden;

    /**
     * Pokémon have 3 ability 'slots' which hold references to possible abilities they could have. This is the slot of
     * this ability for the referenced pokemon.
     */
    @JsonProperty("slot")
    private int slot;

    /**
     * The Pokémon this ability could belong to.
     */
    @FetchAs(Pokemon.class)
    @JsonProperty("pokemon")
    private NamedAPIResource<Pokemon> pokemon;

    public AbilityPokemon() {
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
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
        return "AbilityPokemon{" +
                "isHidden=" + isHidden +
                ", slot=" + slot +
                ", pokemon=" + pokemon +
                '}';
    }
}
