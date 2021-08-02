package com.github.pascalklassen.pokefuture.move.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.move.Move;
import com.github.pascalklassen.pokefuture.utility.common.Description;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Very general categories that loosely group move effects.
 *
 * GET https://pokeapi.co/api/v2/move-category/{id or name}/
 */
@ResourceEntity
public final class MoveCategory {

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
     * A list of moves that fall into this category.
     */
    @FetchAs(Move.class)
    @JsonProperty("moves")
    private List<NamedAPIResource<Move>> moves;

    /**
     * The description of this resource listed in different languages.
     */
    @JsonProperty("descriptions")
    private List<Description> descriptions;

    public MoveCategory() {
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

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "MoveCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", moves=" + moves +
                ", descriptions=" + descriptions +
                '}';
    }

    public static Future<MoveCategory> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(MoveCategory.class, String.format("/move-category/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<MoveCategory>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<MoveCategory>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(MoveCategory.class, String.format("/move-category?limit=%s&offset=%s", limit, offset));
    }

}
