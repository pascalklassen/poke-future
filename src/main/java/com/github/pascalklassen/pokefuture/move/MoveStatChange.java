package com.github.pascalklassen.pokefuture.move;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.pokemon.stat.Stat;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public class MoveStatChange {

    /**
     * The amount of change.
     */
    @JsonProperty("change")
    private int change;

    /**
     * The stat being affected.
     */
    @FetchAs(Stat.class)
    @JsonProperty("stat")
    private NamedAPIResource<Stat> stat;

    public MoveStatChange() {
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public NamedAPIResource<Stat> getStat() {
        return stat;
    }

    public void setStat(NamedAPIResource<Stat> stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "MoveStatChange{" +
                "change=" + change +
                ", stat=" + stat +
                '}';
    }
}
