package io.github.pascalklassen.pokefuture.move.target;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.move.Move;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.utility.common.Description;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Targets moves can be directed at during battle. Targets can be Pokémon, environments or even other moves.
 *
 * GET https://pokeapi.co/api/v2/move-target/{id or name}/
 */
@ResourceEntity
public final class MoveTarget {

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
     * A list of moves that that are directed at this target.
     */
    @FetchAs(Move.class)
    @JsonProperty("moves")
    private List<NamedAPIResource<Move>> moves;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    public MoveTarget() {
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

    public List<NamedAPIResource<Move>> getMoves() {
        return moves;
    }

    public void setMoves(List<NamedAPIResource<Move>> moves) {
        this.moves = moves;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "MoveTarget{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descriptions=" + descriptions +
                ", moves=" + moves +
                ", names=" + names +
                '}';
    }

    public static Future<MoveTarget> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(MoveTarget.class, String.format("/move-target/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<MoveTarget>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<MoveTarget>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(MoveTarget.class, String.format("/move-target?limit=%s&offset=%s", limit, offset));
    }

}
