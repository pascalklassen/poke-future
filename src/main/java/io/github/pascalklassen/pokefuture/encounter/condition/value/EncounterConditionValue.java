package io.github.pascalklassen.pokefuture.encounter.condition.value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.encounter.condition.EncounterCondition;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Encounter condition values are the various states that an encounter condition can have, i.e., time of day can be
 * either day or night.
 *
 * GET https://pokeapi.co/api/v2/encounter-condition-value/{id or name}/
 */
@ResourceEntity
public final class EncounterConditionValue {

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
     * The condition this encounter condition value pertains to.
     */
    @FetchAs(EncounterCondition.class)
    @JsonProperty("condition")
    private NamedAPIResource<EncounterCondition> condition;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    public EncounterConditionValue() {
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

    public NamedAPIResource<EncounterCondition> getCondition() {
        return condition;
    }

    public void setCondition(NamedAPIResource<EncounterCondition> condition) {
        this.condition = condition;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "EncounterConditionValue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", condition=" + condition +
                ", names=" + names +
                '}';
    }

    public static Future<EncounterConditionValue> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(EncounterConditionValue.class, String.format("/encounter-condition-value/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<EncounterConditionValue>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<EncounterConditionValue>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(EncounterConditionValue.class, String.format("/encounter-condition-value?limit=%s&offset=%s", limit, offset));
    }
}
