package com.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.pokemon.type.Type;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

@ResourceEntity
public final class PokemonType {

    /**
     * The order the Pokémon's types are listed in.
     */
    @JsonProperty("slot")
    private int slot;

    /**
     * The type the referenced Pokémon has.
     */
    @FetchAs(Type.class)
    @JsonProperty("type")
    private NamedAPIResource<Type> type;

    public PokemonType() {
    }

    public int getSlot() {
        return slot;
    }

    public NamedAPIResource<Type> getType() {
        return type;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public void setType(NamedAPIResource<Type> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PokemonType{" +
                "slot=" + slot +
                ", type=" + type +
                '}';
    }
}
