package io.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.generation.Generation;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

@ResourceEntity
public final class GenerationGameIndex {

    /**
     * The internal id of an API resource within game data.
     */
    @JsonProperty("game_index")
    private int gameIndex;

    /**
     * The generation relevent to this game index.
     */
    @FetchAs(Generation.class)
    @JsonProperty("generation")
    private NamedAPIResource<Generation> generation;

    public GenerationGameIndex() {
    }

    public int getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public NamedAPIResource<Generation> getGeneration() {
        return generation;
    }

    public void setGeneration(NamedAPIResource<Generation> generation) {
        this.generation = generation;
    }

    @Override
    public String toString() {
        return "GenerationGameIndex{" +
                "gameIndex=" + gameIndex +
                ", generation=" + generation +
                '}';
    }
}
