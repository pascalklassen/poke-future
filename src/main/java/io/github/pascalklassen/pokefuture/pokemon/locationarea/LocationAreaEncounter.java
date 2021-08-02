package io.github.pascalklassen.pokefuture.pokemon.locationarea;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.location.area.LocationArea;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.common.VersionEncounterDetail;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

/**
 * Pokémon Location Areas are ares where Pokémon can be found.
 *
 * GET https://pokeapi.co/api/v2/pokemon/{id or name}/encounters
 */
public final class LocationAreaEncounter {

    /**
     * The location area the referenced Pokémon can be encountered in.
     */
    @FetchAs(LocationArea.class)
    @JsonProperty("location_area")
    private NamedAPIResource<LocationArea> locationArea;

    /**
     * A list of versions and encounters with the referenced Pokémon that might happen.
     */
    @JsonProperty("version_details")
    private List<VersionEncounterDetail> versionDetails;

    public LocationAreaEncounter() {
    }

    public NamedAPIResource<LocationArea> getLocationArea() {
        return locationArea;
    }

    public void setLocationArea(NamedAPIResource<LocationArea> locationArea) {
        this.locationArea = locationArea;
    }

    public List<VersionEncounterDetail> getVersionDetails() {
        return versionDetails;
    }

    public void setVersionDetails(List<VersionEncounterDetail> versionDetails) {
        this.versionDetails = versionDetails;
    }

    @Override
    public String toString() {
        return "LocationAreaEncounter{" +
                "locationArea=" + locationArea +
                ", versionDetails=" + versionDetails +
                '}';
    }
}
