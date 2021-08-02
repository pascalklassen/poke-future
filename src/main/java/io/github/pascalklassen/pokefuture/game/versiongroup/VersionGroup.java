package io.github.pascalklassen.pokefuture.game.versiongroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.game.generation.Generation;
import io.github.pascalklassen.pokefuture.game.pokedex.Pokedex;
import io.github.pascalklassen.pokefuture.game.version.Version;
import io.github.pascalklassen.pokefuture.location.region.Region;
import io.github.pascalklassen.pokefuture.move.learnmethod.MoveLearnMethod;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Version groups categorize highly similar versions of the games.
 *
 * GET https://pokeapi.co/api/v2/version-group/{id or name}/
 */
@ResourceEntity
public final class VersionGroup {

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
     * Order for sorting. Almost by date of release, except similar versions are grouped together.
     */
    @JsonProperty("order")
    private int order;

    /**
     * The generation this version was introduced in.
     */
    @FetchAs(Generation.class)
    @JsonProperty("generation")
    private NamedAPIResource<Generation> generation;

    /**
     * A list of methods in which Pokémon can learn moves in this version group.
     */
    @FetchAs(MoveLearnMethod.class)
    @JsonProperty("move_learn_methods")
    private List<NamedAPIResource<MoveLearnMethod>> moveLearnMethods;

    /**
     * A list of Pokédexes introduces in this version group.
     */
    @FetchAs(Pokedex.class)
    @JsonProperty("pokedexes")
    private List<NamedAPIResource<Pokedex>> pokedexes;

    /**
     * A list of regions that can be visited in this version group.
     */
    @FetchAs(Region.class)
    @JsonProperty("regions")
    private List<NamedAPIResource<Region>> regions;

    /**
     * The versions this version group owns.
     */
    @FetchAs(Version.class)
    @JsonProperty("versions")
    private List<NamedAPIResource<Version>> versions;

    public VersionGroup() {
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

    public NamedAPIResource<Generation> getGeneration() {
        return generation;
    }

    public void setGeneration(NamedAPIResource<Generation> generation) {
        this.generation = generation;
    }

    public List<NamedAPIResource<MoveLearnMethod>> getMoveLearnMethods() {
        return moveLearnMethods;
    }

    public void setMoveLearnMethods(List<NamedAPIResource<MoveLearnMethod>> moveLearnMethods) {
        this.moveLearnMethods = moveLearnMethods;
    }

    public List<NamedAPIResource<Pokedex>> getPokedexes() {
        return pokedexes;
    }

    public void setPokedexes(List<NamedAPIResource<Pokedex>> pokedexes) {
        this.pokedexes = pokedexes;
    }

    public List<NamedAPIResource<Region>> getRegions() {
        return regions;
    }

    public void setRegions(List<NamedAPIResource<Region>> regions) {
        this.regions = regions;
    }

    public List<NamedAPIResource<Version>> getVersions() {
        return versions;
    }

    public void setVersions(List<NamedAPIResource<Version>> versions) {
        this.versions = versions;
    }

    @Override
    public String toString() {
        return "VersionGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", generation=" + generation +
                ", moveLearnMethods=" + moveLearnMethods +
                ", pokedexes=" + pokedexes +
                ", regions=" + regions +
                ", versions=" + versions +
                '}';
    }

    public static Future<VersionGroup> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(VersionGroup.class, String.format("/version-group/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<VersionGroup>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<VersionGroup>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(VersionGroup.class, String.format("/version-group?limit=%s&offset=%s", limit, offset));
    }
}
