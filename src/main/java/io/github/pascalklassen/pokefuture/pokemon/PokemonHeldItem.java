package io.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.item.Item;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

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
