package com.github.pascalklassen.pokefuture.encounter.method;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.common.Name;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Methods by which the player might can encounter Pokémon in the wild, e.g., walking in tall grass. Check out
 * Bulbapedia for greater detail.
 *
 * GET https://pokeapi.co/api/v2/encounter-method/{id or name}/
 */
@ResourceEntity
public final class EncounterMethod {

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
     * A good value for sorting.
     */
    @JsonProperty("order")
    private int order;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    public EncounterMethod() {
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "EncounterMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", names=" + names +
                '}';
    }

    public static Future<EncounterMethod> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(EncounterMethod.class, String.format("/encounter-method/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<EncounterMethod>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<EncounterMethod>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(EncounterMethod.class, String.format("/encounter-method?limit=%s&offset=%s", limit, offset));
    }
}
