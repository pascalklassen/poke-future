package io.github.pascalklassen.pokefuture.move.damageclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.move.Move;
import io.github.pascalklassen.pokefuture.utility.common.Description;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Damage classes moves can have, e.g. physical, special, or non-damaging.
 *
 * GET https://pokeapi.co/api/v2/move-damage-class/{id or name}/
 */
@ResourceEntity
public final class MoveDamageClass {

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
     * A list of moves that fall into this damage class.
     */
    @FetchAs(Move.class)
    @JsonProperty("moves")
    private List<NamedAPIResource<Move>> moves;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    public MoveDamageClass() {
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
        return "MoveDamageClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descriptions=" + descriptions +
                ", moves=" + moves +
                ", names=" + names +
                '}';
    }

    public static Future<MoveDamageClass> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(MoveDamageClass.class, String.format("/move-damage-class/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<MoveDamageClass>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<MoveDamageClass>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(MoveDamageClass.class, String.format("/move-damage-class?limit=%s&offset=%s", limit, offset));
    }

}
