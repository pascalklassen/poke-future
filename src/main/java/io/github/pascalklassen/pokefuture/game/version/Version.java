package io.github.pascalklassen.pokefuture.game.version;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Versions of the games, e.g., Red, Blue or Yellow.
 *
 * GET https://pokeapi.co/api/v2/version/{id or name}/
 */
@ResourceEntity
public final class Version {

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
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * The version group this version belongs to.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_group")
    private NamedAPIResource<VersionGroup> versionGroup;

    public Version() {
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

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public NamedAPIResource<VersionGroup> getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(NamedAPIResource<VersionGroup> versionGroup) {
        this.versionGroup = versionGroup;
    }

    @Override
    public String toString() {
        return "Version{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", names=" + names +
                ", versionGroup=" + versionGroup +
                '}';
    }

    public static Future<Version> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Version.class, String.format("/version/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Version>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Version>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Version.class, String.format("/version?limit=%s&offset=%s", limit, offset));
    }

}
