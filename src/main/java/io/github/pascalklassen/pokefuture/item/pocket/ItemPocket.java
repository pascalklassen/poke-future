package io.github.pascalklassen.pokefuture.item.pocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.item.category.ItemCategory;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Pockets within the players bag used for storing items by category.
 *
 * GET https://pokeapi.co/api/v2/item-pocket/{id or name}/
 */
@ResourceEntity
public final class ItemPocket {

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
     * A list of item categories that are relevant to this item pocket.
     */
    @FetchAs(ItemCategory.class)
    @JsonProperty("categories")
    private List<NamedAPIResource<ItemCategory>> categories;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    public ItemPocket() {
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

    public List<NamedAPIResource<ItemCategory>> getCategories() {
        return categories;
    }

    public void setCategories(List<NamedAPIResource<ItemCategory>> categories) {
        this.categories = categories;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "ItemPocket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoties=" + categories +
                ", names=" + names +
                '}';
    }

    public static Future<ItemPocket> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(ItemPocket.class, String.format("/item-pocket/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<ItemPocket>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<ItemPocket>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(ItemPocket.class, String.format("/item-pocket?limit=%s&offset=%s", limit, offset));
    }
}
