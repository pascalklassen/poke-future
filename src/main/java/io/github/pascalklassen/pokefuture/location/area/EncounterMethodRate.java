package io.github.pascalklassen.pokefuture.location.area;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.encounter.method.EncounterMethod;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

public final class EncounterMethodRate {

    /**
     * The method in which Pokémon may be encountered in an area.
     */
    @FetchAs(EncounterMethod.class)
    @JsonProperty("encounter_method")
    private NamedAPIResource<EncounterMethod> encounterMethod;

    /**
     * The chance of the encounter to occur on a version of the game.
     */
    @FetchAs(EncounterVersionDetails.class)
    @JsonProperty("version_details")
    private List<EncounterVersionDetails> versionDetails;

    public EncounterMethodRate() {
    }

    public NamedAPIResource<EncounterMethod> getEncounterMethod() {
        return encounterMethod;
    }

    public void setEncounterMethod(NamedAPIResource<EncounterMethod> encounterMethod) {
        this.encounterMethod = encounterMethod;
    }

    public List<EncounterVersionDetails> getVersionDetails() {
        return versionDetails;
    }

    public void setVersionDetails(List<EncounterVersionDetails> versionDetails) {
        this.versionDetails = versionDetails;
    }

    @Override
    public String toString() {
        return "EncounterMethodRate{" +
                "encounterMethod=" + encounterMethod +
                ", versionDetails=" + versionDetails +
                '}';
    }
}
