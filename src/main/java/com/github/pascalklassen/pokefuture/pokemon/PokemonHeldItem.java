package com.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.github.pascalklassen.pokefuture.item.Item;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

@ResourceEntity
public final class PokemonHeldItem {

    /**
     * The item the referenced Pokémon holds.
     */
    @FetchAs(Item.class)
    @JsonProperty("item")
    private NamedAPIResource<Item> item;

    /**
     * The details of the different versions in which the item is held.
     */
    @JsonProperty("version_details")
    private List<PokemonHeldItemVersion> versionDetails;

    public PokemonHeldItem() {
    }

    public NamedAPIResource<Item> getItem() {
        return item;
    }

    public List<PokemonHeldItemVersion> getVersionDetails() {
        return versionDetails;
    }

    public void setItem(NamedAPIResource<Item> item) {
        this.item = item;
    }

    public void setVersionDetails(List<PokemonHeldItemVersion> versionDetails) {
        this.versionDetails = versionDetails;
    }

    @Override
    public String toString() {
        return "PokemonHeldItem{" +
                "item=" + item +
                ", versionDetails=" + versionDetails +
                '}';
    }
}
