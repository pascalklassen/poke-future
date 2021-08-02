package io.github.pascalklassen.pokefuture.pokemon.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

import java.util.List;

@ResourceEntity
public final class MoveStatAffectSets {

    /**
     * A list of moves and how they change the referenced stat.
     */
    @JsonProperty("increase")
    private List<MoveStatAffect> increase;

    /**
     * A list of moves and how they change the referenced stat.
     */
    @JsonProperty("decrease")
    private List<MoveStatAffect> decrease;

    public MoveStatAffectSets() {
    }

    public List<MoveStatAffect> getIncrease() {
        return increase;
    }

    public void setIncrease(List<MoveStatAffect> increase) {
        this.increase = increase;
    }

    public List<MoveStatAffect> getDecrease() {
        return decrease;
    }

    public void setDecrease(List<MoveStatAffect> decrease) {
        this.decrease = decrease;
    }

    @Override
    public String toString() {
        return "MoveStatAffectSets{" +
                "increase=" + increase +
                ", decrease=" + decrease +
                '}';
    }
}
