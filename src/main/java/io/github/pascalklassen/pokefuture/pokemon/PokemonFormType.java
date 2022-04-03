package io.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.type.Type;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

@ResourceEntity
public final class PokemonFormType {

    /**
     * The order the Pokémon's types are listed in.
     */
    @JsonProperty("slot")
    private int slot;

    /**
     * The type the referenced Form has.
     */
    @FetchAs(Type.class)
    @JsonProperty("type")
    private NamedAPIResource<Type> type;

    public PokemonFormType() {
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public NamedAPIResource<Type> getType() {
        return type;
    }

    public void setType(NamedAPIResource<Type> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PokemonFormType{" +
                "slot=" + slot +
                ", type=" + type +
                '}';
    }
}
