package com.github.pascalklassen.pokefuture.pokemon.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.github.pascalklassen.pokefuture.pokemon.nature.Nature;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

@ResourceEntity
public final class NatureStatAffectSets {

    /**
     * A list of natures and how they change the referenced stat.
     */
    @FetchAs(Nature.class)
    @JsonProperty("increase")
    private List<NamedAPIResource<Nature>> increase;

    /**
     * A list of natures and how they change the referenced stat.
     */
    @FetchAs(Nature.class)
    @JsonProperty("decrease")
    private List<NamedAPIResource<Nature>> decrease;

    public NatureStatAffectSets() {
    }

    public List<NamedAPIResource<Nature>> getIncrease() {
        return increase;
    }

    public void setIncrease(List<NamedAPIResource<Nature>> increase) {
        this.increase = increase;
    }

    public List<NamedAPIResource<Nature>> getDecrease() {
        return decrease;
    }

    public void setDecrease(List<NamedAPIResource<Nature>> decrease) {
        this.decrease = decrease;
    }

    @Override
    public String toString() {
        return "NatureStatAffectSets{" +
                "increase=" + increase +
                ", decrease=" + decrease +
                '}';
    }
}
