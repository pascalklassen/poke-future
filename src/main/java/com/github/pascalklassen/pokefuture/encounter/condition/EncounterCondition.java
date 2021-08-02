package com.github.pascalklassen.pokefuture.encounter.condition;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.encounter.condition.value.EncounterConditionValue;
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
 * Conditions which affect what pokemon might appear in the wild, e.g., day or night.
 *
 * GET https://pokeapi.co/api/v2/encounter-condition/{id or name}/
 */
@ResourceEntity
public final class EncounterCondition {

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
     * A list of possible values for this encounter condition.
     */
    @FetchAs(EncounterConditionValue.class)
    @JsonProperty("values")
    private List<NamedAPIResource<EncounterConditionValue>> values;

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

    public List<NamedAPIResource<EncounterConditionValue>> getValues() {
        return values;
    }

    public void setValues(List<NamedAPIResource<EncounterConditionValue>> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "EncounterCondition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", names=" + names +
                ", values=" + values +
                '}';
    }

    public static Future<EncounterCondition> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(EncounterCondition.class, String.format("/encounter-condition/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<EncounterCondition>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<EncounterCondition>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(EncounterCondition.class, String.format("/encounter-condition?limit=%s&offset=%s", limit, offset));
    }
}
