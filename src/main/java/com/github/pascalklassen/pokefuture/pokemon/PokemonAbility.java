package com.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.pokemon.ability.Ability;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

@ResourceEntity
public final class PokemonAbility {

    /**
     * Whether or not this is a hidden ability.
     */
    @JsonProperty("is_hidden")
    private boolean isHidden;

    /**
     * The slot this ability occupies in this Pokémon species.
     */
    @JsonProperty("slot")
    private int slot;

    /**
     * The ability the Pokémon may have.
     */
    @FetchAs(Ability.class)
    @JsonProperty("ability")
    private NamedAPIResource<Ability> ability;

    public PokemonAbility() {
    }

    public boolean isHidden() {
        return isHidden;
    }

    public int getSlot() {
        return slot;
    }

    public NamedAPIResource<Ability> getAbility() {
        return ability;
    }

    public void setIsHidden(boolean hidden) {
        isHidden = hidden;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public void setAbility(NamedAPIResource<Ability> ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "PokemonAbility{" +
                "isHidden=" + isHidden +
                ", slot=" + slot +
                ", ability=" + ability +
                '}';
    }
}
