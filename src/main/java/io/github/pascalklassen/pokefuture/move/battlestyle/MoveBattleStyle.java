package io.github.pascalklassen.pokefuture.move.battlestyle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Styles of moves when used in the Battle Palace. See
 * <a href="http://bulbapedia.bulbagarden.net/wiki/Battle_Frontier_(Generation_III)">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/move-battle-style/{id or name}/
 */
@ResourceEntity
public final class MoveBattleStyle {

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

    public MoveBattleStyle() {
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

    @Override
    public String toString() {
        return "MoveBattleStyle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", names=" + names +
                '}';
    }

    public static Future<MoveBattleStyle> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(MoveBattleStyle.class, String.format("/move-battle-style/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<MoveBattleStyle>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<MoveBattleStyle>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(MoveBattleStyle.class, String.format("/move-battle-style?limit=%s&offset=%s", limit, offset));
    }

}
