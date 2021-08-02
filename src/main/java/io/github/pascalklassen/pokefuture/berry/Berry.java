package io.github.pascalklassen.pokefuture.berry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.berry.firmness.BerryFirmness;
import io.github.pascalklassen.pokefuture.pokemon.type.Type;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.item.Item;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Berries are small fruits that can provide HP and status condition restoration, stat enhancement, and even damage
 * negation when eaten by Pokémon. Check out <a href="http://bulbapedia.bulbagarden.net/wiki/Berry">Bulbapedia</a> for
 * greater detail.
 *
 * GET https://pokeapi.co/api/v2/berry/{id or name}/
 */
@ResourceEntity
public final class Berry {

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
     * Time it takes the tree to grow one stage, in hours. Berry trees go through four of these growth stages before
     * they can be picked.
     */
    @JsonProperty("growth_time")
    private int growthTime;

    /**
     * The maximum number of these berries that can grow on one tree in Generation IV.
     */
    @JsonProperty("max_harvest")
    private int maxHarvest;

    /**
     * The power of the move "Natural Gift" when used with this Berry.
     */
    @JsonProperty("natural_gift_power")
    private int naturalGiftPower;

    /**
     * The size of this Berry, in millimeters.
     */
    @JsonProperty("size")
    private int size;

    /**
     * The smoothness of this Berry, used in making Pokéblocks or Poffins.
     */
    @JsonProperty("smoothness")
    private int smoothness;

    /**
     * The speed at which this Berry dries out the soil as it grows. A higher rate means the soil dries more quickly.
     */
    @JsonProperty("soil_dryness")
    private int soilDryness;

    /**
     * The firmness of this berry, used in making Pokéblocks or Poffins.
     */
    @FetchAs(BerryFirmness.class)
    @JsonProperty("firmness")
    private NamedAPIResource<BerryFirmness> firmness;

    /**
     * A list of references to each flavor a berry can have and the potency of each of those flavors in regard to this
     * berry.
     */
    @JsonProperty("flavors")
    private List<BerryFlavorMap> flavors;

    /**
     * Berries are actually items. This is a reference to the item specific data for this berry.
     */
    @FetchAs(Item.class)
    @JsonProperty("item")
    private NamedAPIResource<Item> item;

    /**
     * The type inherited by "Natural Gift" when used with this Berry.
     */
    @FetchAs(Type.class)
    @JsonProperty("natural_gift_type")
    private NamedAPIResource<Type> naturalGiftType;

    public Berry() {
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

    public int getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    public int getMaxHarvest() {
        return maxHarvest;
    }

    public void setMaxHarvest(int maxHarvest) {
        this.maxHarvest = maxHarvest;
    }

    public int getNaturalGiftPower() {
        return naturalGiftPower;
    }

    public void setNaturalGiftPower(int naturalGiftPower) {
        this.naturalGiftPower = naturalGiftPower;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSmoothness() {
        return smoothness;
    }

    public void setSmoothness(int smoothness) {
        this.smoothness = smoothness;
    }

    public int getSoilDryness() {
        return soilDryness;
    }

    public void setSoilDryness(int soilDryness) {
        this.soilDryness = soilDryness;
    }

    public NamedAPIResource<BerryFirmness> getFirmness() {
        return firmness;
    }

    public void setFirmness(NamedAPIResource<BerryFirmness> firmness) {
        this.firmness = firmness;
    }

    public List<BerryFlavorMap> getFlavors() {
        return flavors;
    }

    public void setFlavors(List<BerryFlavorMap> flavors) {
        this.flavors = flavors;
    }

    public NamedAPIResource<Item> getItem() {
        return item;
    }

    public void setItem(NamedAPIResource<Item> item) {
        this.item = item;
    }

    public NamedAPIResource<Type> getNaturalGiftType() {
        return naturalGiftType;
    }

    public void setNaturalGiftType(NamedAPIResource<Type> naturalGiftType) {
        this.naturalGiftType = naturalGiftType;
    }

    @Override
    public String toString() {
        return "Berry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", growthTime=" + growthTime +
                ", maxHarvest=" + maxHarvest +
                ", naturalGiftPower=" + naturalGiftPower +
                ", size=" + size +
                ", smoothness=" + smoothness +
                ", soilDryness=" + soilDryness +
                ", firmness=" + firmness +
                ", flavors=" + flavors +
                ", item=" + item +
                ", naturalGiftType=" + naturalGiftType +
                '}';
    }

    public static Future<Berry> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Berry.class, String.format("/berry/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Berry>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Berry>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Berry.class, String.format("/berry?limit=%s&offset=%s", limit, offset));
    }
}
