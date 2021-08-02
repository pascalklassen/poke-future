package io.github.pascalklassen.pokefuture.location.area;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.version.Version;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public final class EncounterVersionDetails {

    /**
     * The chance of an encounter to occur.
     */
    @JsonProperty("rate")
    private int rate;

    /**
     * The version of the game in which the encounter can occur with the given chance.
     */
    @FetchAs(Version.class)
    @JsonProperty("version")
    private NamedAPIResource<Version> version;

    public EncounterVersionDetails() {
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public NamedAPIResource<Version> getVersion() {
        return version;
    }

    public void setVersion(NamedAPIResource<Version> version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "EncounterVersionDetails{" +
                "rate=" + rate +
                ", version=" + version +
                '}';
    }
}
