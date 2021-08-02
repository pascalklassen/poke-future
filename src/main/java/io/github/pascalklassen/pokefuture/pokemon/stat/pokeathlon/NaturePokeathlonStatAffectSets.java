package io.github.pascalklassen.pokefuture.pokemon.stat.pokeathlon;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class NaturePokeathlonStatAffectSets {

    /**
     * A list of natures and how they change the referenced Pokéathlon stat.
     */
    @JsonProperty("increase")
    private List<NaturePokeathlonStatAffect> increase;

    /**
     * A list of natures and how they change the referenced Pokéathlon stat.
     */
    @JsonProperty("decrease")
    private List<NaturePokeathlonStatAffect> decrease;

    public NaturePokeathlonStatAffectSets() {
    }

    public List<NaturePokeathlonStatAffect> getIncrease() {
        return increase;
    }

    public void setIncrease(List<NaturePokeathlonStatAffect> increase) {
        this.increase = increase;
    }

    public List<NaturePokeathlonStatAffect> getDecrease() {
        return decrease;
    }

    public void setDecrease(List<NaturePokeathlonStatAffect> decrease) {
        this.decrease = decrease;
    }

    @Override
    public String toString() {
        return "NaturePokeathlonStatAffectSets{" +
                "increase=" + increase +
                ", decrease=" + decrease +
                '}';
    }
}
