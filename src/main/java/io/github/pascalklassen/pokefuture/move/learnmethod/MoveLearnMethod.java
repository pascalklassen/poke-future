package io.github.pascalklassen.pokefuture.move.learnmethod;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.utility.common.Description;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Methods by which Pokémon can learn moves.
 *
 * GET https://pokeapi.co/api/v2/move-learn-method/{id or name}/
 */
@ResourceEntity
public final class MoveLearnMethod {

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
     * The description of this resource listed in different languages.
     */
    @JsonProperty("descriptions")
    private List<Description> descriptions;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A list of version groups where moves can be learned through this method.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_groups")
    private List<NamedAPIResource<VersionGroup>> versionGroups;

    public MoveLearnMethod() {
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

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<NamedAPIResource<VersionGroup>> getVersionGroups() {
        return versionGroups;
    }

    public void setVersionGroups(List<NamedAPIResource<VersionGroup>> versionGroups) {
        this.versionGroups = versionGroups;
    }

    @Override
    public String toString() {
        return "MoveLearnMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descriptions=" + descriptions +
                ", names=" + names +
                ", versionGroups=" + versionGroups +
                '}';
    }

    public static Future<MoveLearnMethod> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(MoveLearnMethod.class, String.format("/move-learn-method/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<MoveLearnMethod>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<MoveLearnMethod>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(MoveLearnMethod.class, String.format("/move-learn-method?limit=%s&offset=%s", limit, offset));
    }

}
