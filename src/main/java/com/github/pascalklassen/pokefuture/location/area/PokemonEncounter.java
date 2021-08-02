package com.github.pascalklassen.pokefuture.location.area;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.pokemon.Pokemon;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.common.VersionEncounterDetail;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

public final class PokemonEncounter {

    /**
     * The Pokémon being encountered.
     */
    @FetchAs(Pokemon.class)
    @JsonProperty("pokemon")
    private NamedAPIResource<Pokemon> pokemon;

    /**
     * A list of versions and encounters with Pokémon that might happen in the referenced location area.
     */
    @JsonProperty("version_details")
    private List<VersionEncounterDetail> versionDetails;

    public PokemonEncounter() {
    }

    public NamedAPIResource<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(NamedAPIResource<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public List<VersionEncounterDetail> getVersionDetails() {
        return versionDetails;
    }

    public void setVersionDetails(List<VersionEncounterDetail> versionDetails) {
        this.versionDetails = versionDetails;
    }

    @Override
    public String toString() {
        return "PokemonEncounter{" +
                "pokemon=" + pokemon +
                ", versionDetails=" + versionDetails +
                '}';
    }
}
