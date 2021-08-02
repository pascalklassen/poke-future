package io.github.pascalklassen.pokefuture.pokemon.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.move.Move;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public final class MoveStatAffect {

    /**
     * The maximum amount of change to the referenced stat.
     */
    @JsonProperty("change")
    private int change;

    /**
     * The move causing the change.
     */
    @FetchAs(Move.class)
    @JsonProperty("move")
    private NamedAPIResource<Move> move;

    public MoveStatAffect() {
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public NamedAPIResource<Move> getMove() {
        return move;
    }

    public void setMove(NamedAPIResource<Move> move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "MoveStatAffect{" +
                "change=" + change +
                ", move=" + move +
                '}';
    }
}
