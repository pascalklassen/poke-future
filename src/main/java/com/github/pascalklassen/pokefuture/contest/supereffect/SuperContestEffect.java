package com.github.pascalklassen.pokefuture.contest.supereffect;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.move.Move;
import com.github.pascalklassen.pokefuture.utility.internal.APIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.utility.common.FlavorText;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Super contest effects refer to the effects of moves when used in super contests.
 *
 * GET https://pokeapi.co/api/v2/super-contest-effect/{id}/
 */
@ResourceEntity
public final class SuperContestEffect {

    /**
     * The identifier for this resource.
     */
    @JsonProperty("id")
    private int id;

    /**
     * The level of appeal this super contest effect has.
     */
    @JsonProperty("appeal")
    private int appeal;

    /**
     * The flavor text of this super contest effect listed in different languages.
     */
    @JsonProperty("flavor_text_entries")
    private List<FlavorText> flavorTextEntries;

    /**
     * A list of moves that have the effect when used in super contests.
     */
    @FetchAs(Move.class)
    @JsonProperty("moves")
    private List<NamedAPIResource<Move>> moves;

    public SuperContestEffect() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppeal() {
        return appeal;
    }

    public void setAppeal(int appeal) {
        this.appeal = appeal;
    }

    public List<FlavorText> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<FlavorText> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public List<NamedAPIResource<Move>> getMoves() {
        return moves;
    }

    public void setMoves(List<NamedAPIResource<Move>> moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return "SuperContestEffect{" +
                "id=" + id +
                ", appeal=" + appeal +
                ", flavorTextEntries=" + flavorTextEntries +
                ", moves=" + moves +
                '}';
    }

    public static Future<SuperContestEffect> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(SuperContestEffect.class, String.format("/super-contest-effect/%s", nameOrId));
    }

    public static Future<APIResourceList<SuperContestEffect>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<APIResourceList<SuperContestEffect>> fetchList(int limit, int offset) {
        return PokemonService.fetchResourceList(SuperContestEffect.class, String.format("/super-contest-effect?limit=%s&offset=%s", limit, offset));
    }
}
