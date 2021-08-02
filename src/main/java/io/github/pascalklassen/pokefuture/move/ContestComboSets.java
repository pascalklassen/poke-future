package io.github.pascalklassen.pokefuture.move;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class ContestComboSets {

    /**
     * A detail of moves this move can be used before or after, granting additional appeal points in contests.
     */
    @JsonProperty("normal")
    private ContestComboDetail normalMovesDetail;

    /**
     * A detail of moves this move can be used before or after, granting additional appeal points in super contests.
     */
    @JsonProperty("super")
    private ContestComboDetail superMovesDetail;

    public ContestComboSets() {
    }

    public ContestComboDetail getNormalMovesDetail() {
        return normalMovesDetail;
    }

    public void setNormalMovesDetail(ContestComboDetail normalMovesDetail) {
        this.normalMovesDetail = normalMovesDetail;
    }

    public ContestComboDetail getSuperMovesDetail() {
        return superMovesDetail;
    }

    public void setSuperMovesDetail(ContestComboDetail superMovesDetail) {
        this.superMovesDetail = superMovesDetail;
    }

    @Override
    public String toString() {
        return "ContestComboSets{" +
                "normalMovesDetail=" + normalMovesDetail +
                ", superMovesDetail=" + superMovesDetail +
                '}';
    }
}
