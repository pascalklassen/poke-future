package io.github.pascalklassen.pokefuture.pokemon.ability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.game.generation.Generation;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.common.VerboseEffect;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Abilities provide passive effects for Pokémon in battle or in the overworld. Pokémon have multiple possible abilities
 * but can have only one ability at a time. Check out
 * <a href="http://bulbapedia.bulbagarden.net/wiki/Ability">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/ability/{id or name}/
 */
@ResourceEntity
public final class Ability {

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
     * Whether or not this ability originated in the main series of the video games.
     */
    @JsonProperty("is_main_series")
    private boolean isMainSeries;

    /**
     * The generation this ability originated in.
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
     * The effect of this ability listed in different languages.
     */
    @JsonProperty("effect_entries")
    private List<VerboseEffect> effectEntries;

    /**
     * The list of previous effects this ability has had across version groups.
     */
    @JsonProperty("effect_changes")
    private List<AbilityEffectChange> effectChanges;

    /**
     * The flavor text of this ability listed in different languages.
     */
    @JsonProperty("flavor_text_entries")
    private List<AbilityFlavorText> flavorTextEntries;

    /**
     * A list of Pokémon that could potentially have this ability.
     */
    @JsonProperty("pokemon")
    private List<AbilityPokemon> pokemon;

    public Ability() {
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

    public boolean isMainSeries() {
        return isMainSeries;
    }

    public void setMainSeries(boolean mainSeries) {
        isMainSeries = mainSeries;
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

    public List<VerboseEffect> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<VerboseEffect> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public List<AbilityEffectChange> getEffectChanges() {
        return effectChanges;
    }

    public void setEffectChanges(List<AbilityEffectChange> effectChanges) {
        this.effectChanges = effectChanges;
    }

    public List<AbilityFlavorText> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<AbilityFlavorText> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public List<AbilityPokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<AbilityPokemon> pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isMainSeries=" + isMainSeries +
                ", generation=" + generation +
                ", names=" + names +
                ", effectEntries=" + effectEntries +
                ", effectChanges=" + effectChanges +
                ", flavorTextEntries=" + flavorTextEntries +
                ", pokemon=" + pokemon +
                '}';
    }

    public static Future<Ability> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Ability.class, String.format("/ability/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Ability>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Ability>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Ability.class, String.format("/ability?limit=%s&offset=%s", limit, offset));
    }
}
