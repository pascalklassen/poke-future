package com.github.pascalklassen.pokefuture.pokemon.stat.pokeathlon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.pokemon.nature.Nature;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;

public final class NaturePokeathlonStatAffect {

    /**
     * The maximum amount of change to the referenced Pokéathlon stat.
     */
    @JsonProperty("max_change")
    private int maxChange;

    /**
     * The nature causing the change.
     */
    @FetchAs(Nature.class)
    @JsonProperty("nature")
    private NamedAPIResource<Nature> nature;

    public NaturePokeathlonStatAffect() {
    }

    public int getMaxChange() {
        return maxChange;
    }

    public void setMaxChange(int maxChange) {
        this.maxChange = maxChange;
    }

    public NamedAPIResource<Nature> getNature() {
        return nature;
    }

    public void setNature(NamedAPIResource<Nature> nature) {
        this.nature = nature;
    }

    @Override
    public String toString() {
        return "NaturePokeathlonStatAffect{" +
                "maxChange=" + maxChange +
                ", nature=" + nature +
                '}';
    }
}
