package io.github.pascalklassen.pokefuture.move;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.stat.Stat;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

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
