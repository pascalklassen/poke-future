package io.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.version.Version;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

@ResourceEntity
public final class VersionGameIndex {

    /**
     * The internal id of an API resource within game data.
     */
    @JsonProperty("game_index")
    private int gameIndex;

    /**
     * The version relevent to this game index.
     */
    @FetchAs(Version.class)
    @JsonProperty("version")
    private NamedAPIResource<Version> version;

    public VersionGameIndex() {
    }

    public int getGameIndex() {
        return gameIndex;
    }

    public NamedAPIResource<Version> getVersion() {
        return version;
    }

    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public void setVersion(NamedAPIResource<Version> version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "VersionGameIndex{" +
                "gameIndex=" + gameIndex +
                ", version=" + version +
                '}';
    }
}
