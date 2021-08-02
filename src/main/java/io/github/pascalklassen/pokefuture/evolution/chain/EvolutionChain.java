package io.github.pascalklassen.pokefuture.evolution.chain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.item.Item;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.APIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

/**
 * Evolution chains are essentially family trees. They start with the lowest stage within a family and detail evolution
 * conditions for each as well as Pokémon they can evolve into up through the hierarchy.
 *
 * GET https://pokeapi.co/api/v2/evolution-chain/{id}/
 */
@ResourceEntity
public final class EvolutionChain {

    /**
     * The identifier for this resource.
     */
    @JsonProperty("id")
    private int id;

    /**
     * The item that a Pokémon would be holding when mating that would trigger the egg hatching a baby Pokémon rather
     * than a basic Pokémon.
     */
    @FetchAs(Item.class)
    @JsonProperty("baby_trigger_item")
    private NamedAPIResource<Item> babyTriggerItem;

    /**
     * The base chain link object. Each link contains evolution details for a Pokémon in the chain. Each link references
     * the next Pokémon in the natural evolution order.
     */
    @JsonProperty("chain")
    private ChainLink chain;

    public EvolutionChain() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NamedAPIResource<Item> getBabyTriggerItem() {
        return babyTriggerItem;
    }

    public void setBabyTriggerItem(NamedAPIResource<Item> babyTriggerItem) {
        this.babyTriggerItem = babyTriggerItem;
    }

    public ChainLink getChain() {
        return chain;
    }

    public void setChain(ChainLink chain) {
        this.chain = chain;
    }

    @Override
    public String toString() {
        return "EvolutionChain{" +
                "id=" + id +
                ", babyTriggerItem=" + babyTriggerItem +
                ", chain=" + chain +
                '}';
    }

    public static Future<EvolutionChain> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(EvolutionChain.class, String.format("/evolution-chain/%s", nameOrId));
    }

    public static Future<APIResourceList<EvolutionChain>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<APIResourceList<EvolutionChain>> fetchList(int limit, int offset) {
        return PokemonService.fetchResourceList(EvolutionChain.class, String.format("/evolution-chain?limit=%s&offset=%s", limit, offset));
    }

}
