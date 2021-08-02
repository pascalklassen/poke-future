package io.github.pascalklassen.pokefuture.item.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.item.Item;
import io.github.pascalklassen.pokefuture.item.pocket.ItemPocket;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Item categories determine where items will be placed in the players bag.
 *
 * GET https://pokeapi.co/api/v2/item-category/{id or name}/
 */
@ResourceEntity
public final class ItemCategory {

    /**
     * The identifier for this resource.
     */
    @JsonProperty("id")
    private int id;

    /**
     * The name for this resource.
     */
    @JsonProperty("name")
    private String name;

    /**
     * A list of items that are a part of this category.
     */
    @FetchAs(Item.class)
    @JsonProperty("items")
    private List<NamedAPIResource<Item>> items;

    /**
     * The name of this item category listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * The pocket items in this category would be put in.
     */
    @FetchAs(ItemPocket.class)
    @JsonProperty("pocket")
    private NamedAPIResource<ItemPocket> pocket;

    public ItemCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NamedAPIResource<Item>> getItems() {
        return items;
    }

    public void setItems(List<NamedAPIResource<Item>> items) {
        this.items = items;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public NamedAPIResource<ItemPocket> getPocket() {
        return pocket;
    }

    public void setPocket(NamedAPIResource<ItemPocket> pocket) {
        this.pocket = pocket;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                ", names=" + names +
                ", pocket=" + pocket +
                '}';
    }

    public static Future<ItemCategory> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(ItemCategory.class, String.format("/item-category/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<ItemCategory>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<ItemCategory>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(ItemCategory.class, String.format("/item-category?limit=%s&offset=%s", limit, offset));
    }
}
