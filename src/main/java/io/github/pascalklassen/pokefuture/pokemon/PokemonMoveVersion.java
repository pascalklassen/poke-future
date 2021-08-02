package io.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.move.learnmethod.MoveLearnMethod;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public final class PokemonMoveVersion {

    /**
     * The method by which the move is learned.
     */
    @FetchAs(MoveLearnMethod.class)
    @JsonProperty("move_learn_method")
    private NamedAPIResource<MoveLearnMethod> moveLearnMethod;

    /**
     * The method by which the move is learned.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_group")
    private NamedAPIResource<VersionGroup> versionGroup;

    /**
     * The minimum level to learn the move.
     */
    @JsonProperty("level_learned_at")
    private int levelLearnedAt;

    public PokemonMoveVersion() {
    }

    public NamedAPIResource<MoveLearnMethod> getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public NamedAPIResource<VersionGroup> getVersionGroup() {
        return versionGroup;
    }

    public int getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public void setMoveLearnMethod(NamedAPIResource<MoveLearnMethod> moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

    public void setVersionGroup(NamedAPIResource<VersionGroup> versionGroup) {
        this.versionGroup = versionGroup;
    }

    public void setLevelLearnedAt(int levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    @Override
    public String toString() {
        return "PokemonMoveVersion{" +
                "moveLearnMethod=" + moveLearnMethod +
                ", versionGroup=" + versionGroup +
                ", levelLearnedAt=" + levelLearnedAt +
                '}';
    }
}
