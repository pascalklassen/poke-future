package com.github.pascalklassen.pokefuture.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.item.attribute.ItemAttribute;
import com.github.pascalklassen.pokefuture.item.category.ItemCategory;
import com.github.pascalklassen.pokefuture.utility.common.*;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.evolution.chain.EvolutionChain;
import com.github.pascalklassen.pokefuture.item.flingeffect.ItemFlingEffect;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * An item is an object in the games which the player can pick up, keep in their bag, and use in some manner. They have
 * various uses, including healing, powering up, helping catch Pokémon, or to access a new area.
 *
 * GET https://pokeapi.co/api/v2/item/{id or name}/
 */
@ResourceEntity
public final class Item {

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
     * The price of this item in stores.
     */
    @JsonProperty("cost")
    private int cost;

    /**
     * The power of the move Fling when used with this item.
     */
    @JsonProperty("fling_power")
    private int flingPower;

    /**
     * The effect of the move Fling when used with this item.
     */
    @FetchAs(ItemFlingEffect.class)
    @JsonProperty("fling_effect")
    private NamedAPIResource<ItemFlingEffect> flingEffect;

    /**
     * A list of attributes this item has.
     */
    @FetchAs(ItemAttribute.class)
    @JsonProperty("attributes")
    private List<NamedAPIResource<ItemAttribute>> attributes;

    /**
     * The category of items this item falls into.
     */
    @FetchAs(ItemCategory.class)
    @JsonProperty("category")
    private NamedAPIResource<ItemCategory> category;

    /**
     * The effect of this ability listed in different languages.
     */
    @JsonProperty("effect_entries")
    private List<VerboseEffect> effectEntries;

    /**
     * The flavor text of this ability listed in different languages.
     */
    @JsonProperty("flavor_text_entries")
    private List<VersionGrouFlavorText> flavorTextEntries;

    /**
     * A list of game indices relevent to this item by generation.
     */
    @JsonProperty("game_indices")
    private List<GenerationGameIndex> gameIndices;

    /**
     * The name of this item listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A set of sprites used to depict this item in the game.
     */
    @JsonProperty("sprites")
    private ItemSprites sprites;

    /**
     * A list of Pokémon that might be found in the wild holding this item.
     */
    @JsonProperty("held_by_pokemon")
    private List<ItemHolderPokemon> heldByPokemon;

    /**
     * An evolution chain this item requires to produce a bay during mating.
     */
    @FetchAs(EvolutionChain.class)
    @JsonProperty("baby_trigger_for")
    private APIResource<EvolutionChain> babyTriggerFor;

    /**
     * A list of the machines related to this item.
     */
    @JsonProperty("machines")
    private List<MachineVersionDetail> machines;

    public Item() {
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getFlingPower() {
        return flingPower;
    }

    public void setFlingPower(int flingPower) {
        this.flingPower = flingPower;
    }

    public NamedAPIResource<ItemFlingEffect> getFlingEffect() {
        return flingEffect;
    }

    public void setFlingEffect(NamedAPIResource<ItemFlingEffect> flingEffect) {
        this.flingEffect = flingEffect;
    }

    public List<NamedAPIResource<ItemAttribute>> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<NamedAPIResource<ItemAttribute>> attributes) {
        this.attributes = attributes;
    }

    public NamedAPIResource<ItemCategory> getCategory() {
        return category;
    }

    public void setCategory(NamedAPIResource<ItemCategory> category) {
        this.category = category;
    }

    public List<VerboseEffect> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<VerboseEffect> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public List<VersionGrouFlavorText> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<VersionGrouFlavorText> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public List<GenerationGameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GenerationGameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public ItemSprites getSprites() {
        return sprites;
    }

    public void setSprites(ItemSprites sprites) {
        this.sprites = sprites;
    }

    public List<ItemHolderPokemon> getHeldByPokemon() {
        return heldByPokemon;
    }

    public void setHeldByPokemon(List<ItemHolderPokemon> heldByPokemon) {
        this.heldByPokemon = heldByPokemon;
    }

    public APIResource<EvolutionChain> getBabyTriggerFor() {
        return babyTriggerFor;
    }

    public void setBabyTriggerFor(APIResource<EvolutionChain> babyTriggerFor) {
        this.babyTriggerFor = babyTriggerFor;
    }

    public List<MachineVersionDetail> getMachines() {
        return machines;
    }

    public void setMachines(List<MachineVersionDetail> machines) {
        this.machines = machines;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", flingPower=" + flingPower +
                ", flingEffect=" + flingEffect +
                ", attributes=" + attributes +
                ", category=" + category +
                ", effectEntries=" + effectEntries +
                ", flavorTextEntries=" + flavorTextEntries +
                ", gameIndices=" + gameIndices +
                ", names=" + names +
                ", sprites=" + sprites +
                ", heldByPokemon=" + heldByPokemon +
                ", babyTriggerFor=" + babyTriggerFor +
                ", machines=" + machines +
                '}';
    }

    public static Future<Item> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Item.class, String.format("/item/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Item>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Item>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Item.class, String.format("/item?limit=%s&offset=%s", limit, offset));
    }
}
