package io.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.pokemon.form.PokemonForm;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.common.VersionGameIndex;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Pokémon are the creatures that inhabit the world of the Pokémon games. They can be caught using Pokéballs and trained
 * by battling with other Pokémon. Each Pokémon belongs to a specific species but may take on a variant which makes it
 * differ from other Pokémon of the same species, such as base stats, available abilities and typings. See Bulbapedia
 * for greater detail.
 *
 * GET https://pokeapi.co/api/v2/pokemon/{id or name}/
 */
@ResourceEntity
@JsonIgnoreProperties("past_types")
public final class Pokemon {

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
     * The base experience gained for defeating this Pokémon.
     */
    @JsonProperty("base_experience")
    private int baseExperience;

    /**
     * The height of this Pokémon in decimetres.
     */
    @JsonProperty("height")
    private int height;

    /**
     * Set for exactly one Pokémon used as the default for each species.
     */
    @JsonProperty("is_default")
    private boolean isDefault;

    /**
     * Order for sorting. Almost national order, except families are grouped together.
     */
    @JsonProperty("order")
    private int order;

    /**
     * The weight of this Pokémon in hectograms.
     */
    @JsonProperty("weight")
    private int weight;

    /**
     * A list of abilities this Pokémon could potentially have.
     */
    @JsonProperty("abilities")
    private List<PokemonAbility> abilities;

    /**
     * A list of forms this Pokémon can take on.
     */
    @FetchAs(PokemonForm.class)
    @JsonProperty("forms")
    private List<NamedAPIResource<PokemonForm>> forms;

    /**
     * A list of game indices relevent to Pokémon item by generation.
     */
    @JsonProperty("game_indices")
    private List<VersionGameIndex> gameIndices;

    /**
     * A list of items this Pokémon may be holding when encountered.
     */
    @JsonProperty("held_items")
    private List<PokemonHeldItem> heldItems;

    /**
     * A link to a list of location areas, as well as encounter details pertaining to specific versions.
     */
    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;

    /**
     * A list of moves along with learn methods and level details pertaining to specific version groups.
     */
    @JsonProperty("moves")
    private List<PokemonMove> moves;

    /**
     * A list of details showing types this pokémon had in previous generations.
     */
    @JsonProperty("past_types")
    private List<PokemonTypePast> pastTypes;

    /**
     * A set of sprites used to depict this Pokémon in the game. A visual representation of the various sprites can be
     * found at <a href="https://github.com/PokeAPI/sprites#sprites">PokeAPI/sprites</a>
     */
    @JsonProperty("sprites")
    private PokemonSprites sprites;

    /**
     * The species this Pokémon belongs to.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("species")
    private NamedAPIResource<PokemonSpecies> species;

    /**
     * A list of base stat values for this Pokémon.
     */
    @JsonProperty("stats")
    private List<PokemonStat> stats;

    /**
     * A list of details showing types this Pokémon has.
     */
    @JsonProperty("types")
    private List<PokemonType> types;

    public Pokemon() {
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

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<PokemonAbility> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<PokemonAbility> abilities) {
        this.abilities = abilities;
    }

    public List<NamedAPIResource<PokemonForm>> getForms() {
        return forms;
    }

    public void setForms(List<NamedAPIResource<PokemonForm>> forms) {
        this.forms = forms;
    }

    public List<VersionGameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<VersionGameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public List<PokemonHeldItem> getHeldItems() {
        return heldItems;
    }

    public void setHeldItems(List<PokemonHeldItem> heldItems) {
        this.heldItems = heldItems;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public List<PokemonMove> getMoves() {
        return moves;
    }

    public void setMoves(List<PokemonMove> moves) {
        this.moves = moves;
    }

    public List<PokemonTypePast> getPastTypes() {
        return pastTypes;
    }

    public void setPastTypes(List<PokemonTypePast> pastTypes) {
        this.pastTypes = pastTypes;
    }

    public PokemonSprites getSprites() {
        return sprites;
    }

    public void setSprites(PokemonSprites sprites) {
        this.sprites = sprites;
    }

    public NamedAPIResource<PokemonSpecies> getSpecies() {
        return species;
    }

    public void setSpecies(NamedAPIResource<PokemonSpecies> species) {
        this.species = species;
    }

    public List<PokemonStat> getStats() {
        return stats;
    }

    public void setStats(List<PokemonStat> stats) {
        this.stats = stats;
    }

    public List<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseExperience=" + baseExperience +
                ", height=" + height +
                ", isDefault=" + isDefault +
                ", order=" + order +
                ", weight=" + weight +
                ", abilities=" + abilities +
                ", forms=" + forms +
                ", gameIndices=" + gameIndices +
                ", heldItems=" + heldItems +
                ", locationAreaEncounters='" + locationAreaEncounters + '\'' +
                ", moves=" + moves +
                ", pastTypes=" + pastTypes +
                ", sprites=" + sprites +
                ", species=" + species +
                ", stats=" + stats +
                ", types=" + types +
                '}';
    }

    public static Future<Pokemon> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Pokemon.class, String.format("/pokemon/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Pokemon>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Pokemon>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Pokemon.class, String.format("/pokemon?limit=%s&offset=%s", limit, offset));
    }
}
