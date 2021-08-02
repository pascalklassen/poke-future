package com.github.pascalklassen.pokefuture.move;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

public final class ContestComboDetail {

    /**
     * A list of moves to use before this move.
     */
    @FetchAs(Move.class)
    @JsonProperty("use_before")
    private List<NamedAPIResource<Move>> useBefore;

    /**
     * A list of moves to use after this move.
     */
    @FetchAs(Move.class)
    @JsonProperty("use_after")
    private List<NamedAPIResource<Move>> useAfter;

    public ContestComboDetail() {
    }

    public List<NamedAPIResource<Move>> getUseBefore() {
        return useBefore;
    }

    public void setUseBefore(List<NamedAPIResource<Move>> useBefore) {
        this.useBefore = useBefore;
    }

    public List<NamedAPIResource<Move>> getUseAfter() {
        return useAfter;
    }

    public void setUseAfter(List<NamedAPIResource<Move>> useAfter) {
        this.useAfter = useAfter;
    }

    @Override
    public String toString() {
        return "ContestComboDetail{" +
                "useBefore=" + useBefore +
                ", useAfter=" + useAfter +
                '}';
    }
}
