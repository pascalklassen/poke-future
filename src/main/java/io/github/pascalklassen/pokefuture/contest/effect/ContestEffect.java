package io.github.pascalklassen.pokefuture.contest.effect;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.utility.common.Effect;
import io.github.pascalklassen.pokefuture.utility.common.FlavorText;
import io.github.pascalklassen.pokefuture.utility.internal.APIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Contest effects refer to the effects of moves when used in contests.
 *
 * GET https://pokeapi.co/api/v2/contest-effect/{id}/
 */
@ResourceEntity
public final class ContestEffect {

    /**
     * The identifier for this resource.
     */
    @JsonProperty("id")
    private int id;

    /**
     * The base number of hearts the user of this move gets.
     */
    @JsonProperty("appeal")
    private int appeal;

    /**
     * The base number of hearts the user's opponent loses.
     */
    @JsonProperty("jam")
    private int jam;

    /**
     * The result of this contest effect listed in different languages.
     */
    @JsonProperty("effect_entries")
    private List<Effect> effectEntries;

    /**
     * The flavor text of this contest effect listed in different languages.
     */
    @JsonProperty("flavor_text_entries")
    private List<FlavorText> flavorTextEntries;

    public ContestEffect() {
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

    public int getJam() {
        return jam;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    public List<Effect> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<Effect> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public List<FlavorText> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<FlavorText> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    @Override
    public String toString() {
        return "ContestEffect{" +
                "id=" + id +
                ", appeal=" + appeal +
                ", jam=" + jam +
                ", effectEntries=" + effectEntries +
                ", flavorTextEntries=" + flavorTextEntries +
                '}';
    }

    public static Future<ContestEffect> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(ContestEffect.class, String.format("/contest-effect/%s", nameOrId));
    }

    public static Future<APIResourceList<ContestEffect>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<APIResourceList<ContestEffect>> fetchList(int limit, int offset) {
        return PokemonService.fetchResourceList(ContestEffect.class, String.format("/contest-effect?limit=%s&offset=%s", limit, offset));
    }
}
