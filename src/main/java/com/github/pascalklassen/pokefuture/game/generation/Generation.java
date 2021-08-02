package com.github.pascalklassen.pokefuture.game.generation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import com.github.pascalklassen.pokefuture.move.Move;
import com.github.pascalklassen.pokefuture.pokemon.ability.Ability;
import com.github.pascalklassen.pokefuture.pokemon.type.Type;
import com.github.pascalklassen.pokefuture.utility.common.Name;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.location.region.Region;
import com.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A generation is a grouping of the Pokémon games that separates them based on the Pokémon they include. In each
 * generation, a new set of Pokémon, Moves, Abilities and Types that did not exist in the previous generation are
 * released.
 *
 * GET https://pokeapi.co/api/v2/generation/{id or name}/
 */
@ResourceEntity
public final class Generation {

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
     * A list of abilities that were introduced in this generation.
     */
    @FetchAs(Ability.class)
    @JsonProperty("abilities")
    private List<NamedAPIResource<Ability>> abilities;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * The main region travelled in this generation.
     */
    @FetchAs(Region.class)
    @JsonProperty("main_region")
    private NamedAPIResource<Region> mainRegion;

    /**
     * A list of moves that were introduced in this generation.
     */
    @FetchAs(Move.class)
    @JsonProperty("moves")
    private List<NamedAPIResource<Move>> moves;

    /**
     * A list of Pokémon species that were introduced in this generation.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("pokemon_species")
    private List<NamedAPIResource<PokemonSpecies>> pokemonSpecies;

    /**
     * A list of types that were introduced in this generation.
     */
    @FetchAs(Type.class)
    @JsonProperty("types")
    private List<NamedAPIResource<Type>> types;

    /**
     * A list of version groups that were introduced in this generation.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_groups")
    private List<NamedAPIResource<VersionGroup>> versionGroups;

    public Generation() {
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

    public List<NamedAPIResource<Ability>> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<NamedAPIResource<Ability>> abilities) {
        this.abilities = abilities;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public NamedAPIResource<Region> getMainRegion() {
        return mainRegion;
    }

    public void setMainRegion(NamedAPIResource<Region> mainRegion) {
        this.mainRegion = mainRegion;
    }

    public List<NamedAPIResource<Move>> getMoves() {
        return moves;
    }

    public void setMoves(List<NamedAPIResource<Move>> moves) {
        this.moves = moves;
    }

    public List<NamedAPIResource<PokemonSpecies>> getPokemonSpecies() {
        return pokemonSpecies;
    }

    public void setPokemonSpecies(List<NamedAPIResource<PokemonSpecies>> pokemonSpecies) {
        this.pokemonSpecies = pokemonSpecies;
    }

    public List<NamedAPIResource<Type>> getTypes() {
        return types;
    }

    public void setTypes(List<NamedAPIResource<Type>> types) {
        this.types = types;
    }

    public List<NamedAPIResource<VersionGroup>> getVersionGroups() {
        return versionGroups;
    }

    public void setVersionGroups(List<NamedAPIResource<VersionGroup>> versionGroups) {
        this.versionGroups = versionGroups;
    }

    @Override
    public String toString() {
        return "Generation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abilities=" + abilities +
                ", names=" + names +
                ", mainRegion=" + mainRegion +
                ", moves=" + moves +
                ", pokemonSpecies=" + pokemonSpecies +
                ", types=" + types +
                ", versionGroups=" + versionGroups +
                '}';
    }

    public static Future<Generation> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Generation.class, String.format("/generation/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Generation>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Generation>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Generation.class, String.format("/generation?limit=%s&offset=%s", limit, offset));
    }
}
