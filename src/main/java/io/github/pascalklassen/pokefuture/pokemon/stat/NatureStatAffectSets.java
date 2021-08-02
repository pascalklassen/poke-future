package io.github.pascalklassen.pokefuture.pokemon.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.nature.Nature;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

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
