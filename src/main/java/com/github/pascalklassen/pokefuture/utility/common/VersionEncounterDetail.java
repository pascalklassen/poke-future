package com.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.game.version.Version;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

public final class VersionEncounterDetail {

    /**
     * The game version this encounter happens in.
     */
    @FetchAs(Version.class)
    @JsonProperty("version")
    private NamedAPIResource<Version> version;

    /**
     * The total percentage of all encounter potential.
     */
    @JsonProperty("max_chance")
    private int maxChance;

    /**
     * A list of encounters and their specifics.
     */
    @JsonProperty("encounter_details")
    private List<Encounter> encounterDetails;

    public VersionEncounterDetail() {
    }

    public NamedAPIResource<Version> getVersion() {
        return version;
    }

    public void setVersion(NamedAPIResource<Version> version) {
        this.version = version;
    }

    public int getMaxChance() {
        return maxChance;
    }

    public void setMaxChance(int maxChance) {
        this.maxChance = maxChance;
    }

    public List<Encounter> getEncounterDetails() {
        return encounterDetails;
    }

    public void setEncounterDetails(List<Encounter> encounterDetails) {
        this.encounterDetails = encounterDetails;
    }

    @Override
    public String toString() {
        return "VersionEncounterDetail{" +
                "version=" + version +
                ", maxChance=" + maxChance +
                ", encounterDetails=" + encounterDetails +
                '}';
    }
}
