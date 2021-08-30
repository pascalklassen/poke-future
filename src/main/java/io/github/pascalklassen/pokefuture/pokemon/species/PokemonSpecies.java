package io.github.pascalklassen.pokefuture.pokemon.species;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.game.generation.Generation;
import io.github.pascalklassen.pokefuture.pokemon.color.PokemonColor;
import io.github.pascalklassen.pokefuture.pokemon.egg.EggGroup;
import io.github.pascalklassen.pokefuture.pokemon.growth.GrowthRate;
import io.github.pascalklassen.pokefuture.pokemon.habitat.PokemonHabitat;
import io.github.pascalklassen.pokefuture.pokemon.shape.PokemonShape;
import io.github.pascalklassen.pokefuture.utility.common.*;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.evolution.chain.EvolutionChain;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A Pokémon Species forms the basis for at least one Pokémon. Attributes of a Pokémon species are shared across all
 * varieties of Pokémon within the species. A good example is Wormadam; Wormadam is the species which can be found in
 * three different varieties, Wormadam-Trash, Wormadam-Sandy and Wormadam-Plant.
 *
 * https://pokeapi.co/api/v2/pokemon-species/{id or name}/
 */
// TODO: Generation["pokemon_species"] NOT DOCUMENTED ON https://pokeapi.co/docs/v2#generations
@ResourceEntity
public final class PokemonSpecies {

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
     * The order in which species should be sorted. Based on National Dex order, except families are grouped together
     * and sorted by stage.
     */
    @JsonProperty("order")
    private int order;

    /**
     * The chance of this Pokémon being female, in eighths; or -1 for genderless.
     */
    @JsonProperty("gender_rate")
    private int genderRate;

    /**
     * The base capture rate; up to 255. The higher the number, the easier the catch.
     */
    @JsonProperty("capture_rate")
    private int captureRate;

    /**
     * The happiness when caught by a normal Pokéball; up to 255. The higher the number, the happier the Pokémon.
     */
    @JsonProperty("base_happiness")
    private int baseHappiness;

    /**
     * Whether this is a baby Pokémon.
     */
    @JsonProperty("is_baby")
    private boolean isBaby;

    /**
     * Whether this is a legendary Pokémon.
     */
    @JsonProperty("is_legendary")
    private boolean isLegendary;

    /**
     * Whether this is a mythical Pokémon.
     */
    @JsonProperty("is_mythical")
    private boolean isMythical;

    /**
     * Initial hatch counter: one must walk 255 × (hatch_counter + 1) steps before this Pokémon's egg hatches, unless
     * utilizing bonuses like Flame Body's.
     */
    @JsonProperty("hatch_counter")
    private int hatchCounter;

    /**
     * Whether this Pokémon has visual gender differences.
     */
    @JsonProperty("has_gender_differences")
    private boolean hasGenderDifferences;

    /**
     * Whether this Pokémon has multiple forms and can switch between them.
     */
    @JsonProperty("forms_switchable")
    private boolean formsSwitchable;

    /**
     * The rate at which this Pokémon species gains levels.
     */
    @FetchAs(GrowthRate.class)
    @JsonProperty("growth_rate")
    private NamedAPIResource<GrowthRate> growthRate;

    /**
     * A list of Pokedexes and the indexes reserved within them for this Pokémon species.
     */
    @JsonProperty("pokedex_numbers")
    private List<PokemonSpeciesDexEntry> pokedexNumbers;

    /**
     * A list of egg groups this Pokémon species is a member of.
     */
    @FetchAs(EggGroup.class)
    @JsonProperty("egg_groups")
    private List<NamedAPIResource<EggGroup>> eggGroups;

    /**
     * The color of this Pokémon for Pokédex search.
     */
    @FetchAs(PokemonColor.class)
    @JsonProperty("color")
    private NamedAPIResource<PokemonColor> color;

    /**
     * The shape of this Pokémon for Pokédex search.
     */
    @FetchAs(PokemonShape.class)
    @JsonProperty("shape")
    private NamedAPIResource<PokemonShape> shape;

    /**
     * The Pokémon species that evolves into this Pokemon_species.
     */
    @JsonProperty("evolves_from_species")
    @FetchAs(PokemonSpecies.class)
    private NamedAPIResource<PokemonSpecies> evolvesFromSpecies;

    /**
     * The evolution chain this Pokémon species is a member of.
     */
    @FetchAs(EvolutionChain.class)
    @JsonProperty("evolution_chain")
    private APIResource<EvolutionChain> evolutionChain;

    /**
     * The habitat this Pokémon species can be encountered in.
     */
    @FetchAs(PokemonHabitat.class)
    @JsonProperty("habitat")
    private NamedAPIResource<PokemonHabitat> habitat;

    /**
     * The generation this Pokémon species was introduced in.
     */
    @FetchAs(Generation.class)
    @JsonProperty("generation")
    private NamedAPIResource<Generation> generation;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A list of encounters that can be had with this Pokémon species in pal park.
     */
    @JsonProperty("pal_park_encounters")
    private List<PalParkEncounterArea> palParkEncounters;

    /**
     * A list of flavor text entries for this Pokémon species.
     */
    @JsonProperty("flavor_text_entries")
    private List<FlavorText> flavorTextEntries;

    /**
     * Descriptions of different forms Pokémon take on within the Pokémon species.
     */
    @JsonProperty("form_descriptions")
    private List<Description> formDescriptions;

    /**
     * The genus of this Pokémon species listed in multiple languages.
     */
    @JsonProperty("genera")
    private List<Genus> genera;

    /**
     * A list of the Pokémon that exist within this Pokémon species.
     */
    @JsonProperty("varieties")
    private List<PokemonSpeciesVariety> varieties;

    public PokemonSpecies() {
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getGenderRate() {
        return genderRate;
    }

    public void setGenderRate(int genderRate) {
        this.genderRate = genderRate;
    }

    public int getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    public int getBaseHappiness() {
        return baseHappiness;
    }

    public void setBaseHappiness(int baseHappiness) {
        this.baseHappiness = baseHappiness;
    }

    public boolean isBaby() {
        return isBaby;
    }

    public void setBaby(boolean baby) {
        isBaby = baby;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public void setLegendary(boolean legendary) {
        isLegendary = legendary;
    }

    public boolean isMythical() {
        return isMythical;
    }

    public void setMythical(boolean mythical) {
        isMythical = mythical;
    }

    public int getHatchCounter() {
        return hatchCounter;
    }

    public void setHatchCounter(int hatchCounter) {
        this.hatchCounter = hatchCounter;
    }

    public boolean isHasGenderDifferences() {
        return hasGenderDifferences;
    }

    public void setHasGenderDifferences(boolean hasGenderDifferences) {
        this.hasGenderDifferences = hasGenderDifferences;
    }

    public boolean isFormsSwitchable() {
        return formsSwitchable;
    }

    public void setFormsSwitchable(boolean formsSwitchable) {
        this.formsSwitchable = formsSwitchable;
    }

    public NamedAPIResource<GrowthRate> getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(NamedAPIResource<GrowthRate> growthRate) {
        this.growthRate = growthRate;
    }

    public List<PokemonSpeciesDexEntry> getPokedexNumbers() {
        return pokedexNumbers;
    }

    public void setPokedexNumbers(List<PokemonSpeciesDexEntry> pokedexNumbers) {
        this.pokedexNumbers = pokedexNumbers;
    }

    public List<NamedAPIResource<EggGroup>> getEggGroups() {
        return eggGroups;
    }

    public void setEggGroups(List<NamedAPIResource<EggGroup>> eggGroups) {
        this.eggGroups = eggGroups;
    }

    public NamedAPIResource<PokemonColor> getColor() {
        return color;
    }

    public void setColor(NamedAPIResource<PokemonColor> color) {
        this.color = color;
    }

    public NamedAPIResource<PokemonShape> getShape() {
        return shape;
    }

    public void setShape(NamedAPIResource<PokemonShape> shape) {
        this.shape = shape;
    }

    public NamedAPIResource<PokemonSpecies> getEvolvesFromSpecies() {
        return evolvesFromSpecies;
    }

    public void setEvolvesFromSpecies(NamedAPIResource<PokemonSpecies> evolvesFromSpecies) {
        this.evolvesFromSpecies = evolvesFromSpecies;
    }

    public APIResource<EvolutionChain> getEvolutionChain() {
        return evolutionChain;
    }

    public void setEvolutionChain(APIResource<EvolutionChain> evolutionChain) {
        this.evolutionChain = evolutionChain;
    }

    public NamedAPIResource<PokemonHabitat> getHabitat() {
        return habitat;
    }

    public void setHabitat(NamedAPIResource<PokemonHabitat> habitat) {
        this.habitat = habitat;
    }

    public NamedAPIResource<Generation> getGeneration() {
        return generation;
    }

    public void setGeneration(NamedAPIResource<Generation> generation) {
        this.generation = generation;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<PalParkEncounterArea> getPalParkEncounters() {
        return palParkEncounters;
    }

    public void setPalParkEncounters(List<PalParkEncounterArea> palParkEncounters) {
        this.palParkEncounters = palParkEncounters;
    }

    public List<FlavorText> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<FlavorText> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public List<Description> getFormDescriptions() {
        return formDescriptions;
    }

    public void setFormDescriptions(List<Description> formDescriptions) {
        this.formDescriptions = formDescriptions;
    }

    public List<Genus> getGenera() {
        return genera;
    }

    public void setGenera(List<Genus> genera) {
        this.genera = genera;
    }

    public List<PokemonSpeciesVariety> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<PokemonSpeciesVariety> varieties) {
        this.varieties = varieties;
    }

    @Override
    public String toString() {
        return "PokemonSpecies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", genderRate=" + genderRate +
                ", captureRate=" + captureRate +
                ", baseHappiness=" + baseHappiness +
                ", isBaby=" + isBaby +
                ", isLegendary=" + isLegendary +
                ", isMythical=" + isMythical +
                ", hatchCounter=" + hatchCounter +
                ", hasGenderDifferences=" + hasGenderDifferences +
                ", formsSwitchable=" + formsSwitchable +
                ", growthRate=" + growthRate +
                ", pokedexNumbers=" + pokedexNumbers +
                ", eggGroups=" + eggGroups +
                ", color=" + color +
                ", shape=" + shape +
                ", evolvesFromSpecies=" + evolvesFromSpecies +
                ", evolutionChain=" + evolutionChain +
                ", habitat=" + habitat +
                ", generation=" + generation +
                ", names=" + names +
                ", palParkEncounters=" + palParkEncounters +
                ", flavorTextEntries=" + flavorTextEntries +
                ", formDescriptions=" + formDescriptions +
                ", genera=" + genera +
                ", varieties=" + varieties +
                '}';
    }

    public static Future<PokemonSpecies> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(PokemonSpecies.class, String.format("/pokemon-species/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<PokemonSpecies>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<PokemonSpecies>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(PokemonSpecies.class, String.format("/pokemon-species?limit=%s&offset=%s", limit, offset));
    }
}
