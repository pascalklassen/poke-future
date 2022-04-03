package io.github.pascalklassen.pokefuture.pokemon.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.generation.Generation;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

@ResourceEntity
public final class TypeRelationsPast {

    /**
     * The last generation in which the referenced type had the listed damage relations.
     */
    @FetchAs(Generation.class)
    @JsonProperty("generation")
    private NamedAPIResource<Generation> generation;

    /**
     * The damage relations the referenced type had up to and including the listed generation.
     */
    @JsonProperty("damage_relations")
    private TypeRelations damageRelations;

    public TypeRelationsPast() {
    }

    public NamedAPIResource<Generation> getGeneration() {
        return generation;
    }

    public void setGeneration(NamedAPIResource<Generation> generation) {
        this.generation = generation;
    }

    public TypeRelations getDamageRelations() {
        return damageRelations;
    }

    public void setDamageRelations(TypeRelations damageRelations) {
        this.damageRelations = damageRelations;
    }

    @Override
    public String toString() {
        return "TypeRelationsPast{" +
                "generation=" + generation +
                ", damageRelations=" + damageRelations +
                '}';
    }
}
