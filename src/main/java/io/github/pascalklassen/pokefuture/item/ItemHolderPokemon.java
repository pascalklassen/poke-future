package io.github.pascalklassen.pokefuture.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.Pokemon;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

public final class ItemHolderPokemon {

    /**
     * The Pokémon that holds this item.
     */
    @FetchAs(Pokemon.class)
    @JsonProperty("pokemon")
    private NamedAPIResource<Pokemon> pokemon;

    /**
     * The details for the version that this item is held in by the Pokémon.
     */
    @JsonProperty("version_details")
    private List<ItemHolderPokemonVersionDetail> versionDetails;

    public ItemHolderPokemon() {
    }

    public NamedAPIResource<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(NamedAPIResource<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public List<ItemHolderPokemonVersionDetail> getVersionDetails() {
        return versionDetails;
    }

    public void setVersionDetails(List<ItemHolderPokemonVersionDetail> versionDetails) {
        this.versionDetails = versionDetails;
    }

    @Override
    public String toString() {
        return "ItemHolderPokemon{" +
                "pokemon=" + pokemon +
                ", versionDetails=" + versionDetails +
                '}';
    }
}
