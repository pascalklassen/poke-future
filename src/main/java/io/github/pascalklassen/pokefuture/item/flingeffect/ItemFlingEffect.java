package io.github.pascalklassen.pokefuture.item.flingeffect;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.item.Item;
import io.github.pascalklassen.pokefuture.utility.common.Effect;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The various effects of the move "Fling" when used with different items.
 *
 * GET https://pokeapi.co/api/v2/item-fling-effect/{id or name}/
 */
@ResourceEntity
public final class ItemFlingEffect {

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
     * The result of this fling effect listed in different languages.
     */
    @JsonProperty("effect_entries")
    private List<Effect> effectEntries;

    /**
     * A list of items that have this fling effect.
     */
    @FetchAs(Item.class)
    @JsonProperty("items")
    private List<NamedAPIResource<Item>> items;

    public ItemFlingEffect() {
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

    public List<Effect> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<Effect> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public List<NamedAPIResource<Item>> getItems() {
        return items;
    }

    public void setItems(List<NamedAPIResource<Item>> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ItemFlingEffect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", effectEntries=" + effectEntries +
                ", items=" + items +
                '}';
    }

    public static Future<ItemFlingEffect> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(ItemFlingEffect.class, String.format("/item-fling-effect/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<ItemFlingEffect>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<ItemFlingEffect>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(ItemFlingEffect.class, String.format("/item-fling-effect?limit=%s&offset=%s", limit, offset));
    }
}
