package io.github.pascalklassen.pokefuture.item.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.item.Item;
import io.github.pascalklassen.pokefuture.utility.common.Description;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Item attributes define particular aspects of items, e.g. "usable in battle" or "consumable".
 *
 * GET https://pokeapi.co/api/v2/item-attribute/{id or name}/
 */
@ResourceEntity
public final class ItemAttribute {

    /**
     * The identifier for this resource.
     */
    private int id;

    /**
     * The name for this resource.
     */
    @JsonProperty("name")
    private String name;

    /**
     * A list of items that have this attribute.
     */
    @FetchAs(Item.class)
    @JsonProperty("items")
    private List<NamedAPIResource<Item>> items;

    /**
     * The name of this item attribute listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * The description of this item attribute listed in different languages.
     */
    @JsonProperty("descriptions")
    private List<Description> descriptions;

    public ItemAttribute() {
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

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "ItemAttribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                ", names=" + names +
                ", descriptions=" + descriptions +
                '}';
    }

    public static Future<ItemAttribute> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(ItemAttribute.class, String.format("/item-attribute/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<ItemAttribute>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<ItemAttribute>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(ItemAttribute.class, String.format("/item-attribute?limit=%s&offset=%s", limit, offset));
    }
}
