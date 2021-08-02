package com.github.pascalklassen.pokefuture.move.ailment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.move.Move;
import com.github.pascalklassen.pokefuture.utility.common.Name;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Move Ailments are status conditions caused by moves used during battle. See
 * <a href="https://bulbapedia.bulbagarden.net/wiki/Status_condition">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/move-ailment/{id or name}/
 */
@ResourceEntity
public final class MoveAilment {

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
     * A list of moves that cause this ailment.
     */
    @FetchAs(Move.class)
    @JsonProperty("moves")
    private List<NamedAPIResource<Move>> moves;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    public MoveAilment() {
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
        return "MoveAilment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", moves=" + moves +
                ", names=" + names +
                '}';
    }

    public static Future<MoveAilment> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(MoveAilment.class, String.format("/move-ailment/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<MoveAilment>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<MoveAilment>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(MoveAilment.class, String.format("/move-ailment?limit=%s&offset=%s", limit, offset));
    }

}
