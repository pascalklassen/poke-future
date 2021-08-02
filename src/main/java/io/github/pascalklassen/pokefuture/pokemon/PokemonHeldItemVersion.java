package io.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.version.Version;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public final class PokemonHeldItemVersion {

    /**
     * The version in which the item is held.
     */
    @FetchAs(Version.class)
    @JsonProperty("version")
    private NamedAPIResource<Version> version;

    /**
     * How often the item is held.
     */
    @JsonProperty("rarity")
    private int rarity;

    public PokemonHeldItemVersion() {
    }

    public NamedAPIResource<Version> getVersion() {
        return version;
    }

    public int getRarity() {
        return rarity;
    }

    public void setVersion(NamedAPIResource<Version> version) {
        this.version = version;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    @Override
    public String toString() {
        return "PokemonHeldItemVersion{" +
                "version=" + version +
                ", rarity=" + rarity +
                '}';
    }
}
