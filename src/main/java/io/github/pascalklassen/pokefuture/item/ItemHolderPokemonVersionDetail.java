package io.github.pascalklassen.pokefuture.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.version.Version;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public final class ItemHolderPokemonVersionDetail {

    /**
     * How often this Pokémon holds this item in this version.
     */
    @JsonProperty("rarity")
    private int rarity;

    /**
     * The version that this item is held in by the Pokémon.
     */
    @FetchAs(Version.class)
    @JsonProperty("version")
    private NamedAPIResource<Version> version;

    public ItemHolderPokemonVersionDetail() {
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public NamedAPIResource<Version> getVersion() {
        return version;
    }

    public void setVersion(NamedAPIResource<Version> version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ItemHolderPokemonVersionDetail{" +
                "rarity=" + rarity +
                ", version=" + version +
                '}';
    }
}
