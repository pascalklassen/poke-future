package io.github.pascalklassen.pokefuture.pokemon.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

@ResourceEntity
public final class TypeRelations {

    /**
     * A list of types this type has no effect on.
     */
    @FetchAs(Type.class)
    @JsonProperty("no_damage_to")
    private List<NamedAPIResource<Type>> noDamageTo;

    /**
     * A list of types this type is not very effective against.
     */
    @FetchAs(Type.class)
    @JsonProperty("half_damage_to")
    private List<NamedAPIResource<Type>> halfDamageTo;

    /**
     * A list of types this type is very effect against.
     */
    @FetchAs(Type.class)
    @JsonProperty("double_damage_to")
    private List<NamedAPIResource<Type>> doubleDamageTo;

    /**
     * A list of types that have no effect on this type.
     */
    @FetchAs(Type.class)
    @JsonProperty("no_damage_from")
    private List<NamedAPIResource<Type>> noDamageFrom;

    /**
     * A list of types that are not very effective against this type.
     */
    @FetchAs(Type.class)
    @JsonProperty("half_damage_from")
    private List<NamedAPIResource<Type>> halfDamageFrom;

    /**
     * A list of types that are very effective against this type.
     */
    @FetchAs(Type.class)
    @JsonProperty("double_damage_from")
    private List<NamedAPIResource<Type>> doubleDamageFrom;

    public TypeRelations() {
    }

    public List<NamedAPIResource<Type>> getNoDamageTo() {
        return noDamageTo;
    }

    public void setNoDamageTo(List<NamedAPIResource<Type>> noDamageTo) {
        this.noDamageTo = noDamageTo;
    }

    public List<NamedAPIResource<Type>> getHalfDamageTo() {
        return halfDamageTo;
    }

    public void setHalfDamageTo(List<NamedAPIResource<Type>> halfDamageTo) {
        this.halfDamageTo = halfDamageTo;
    }

    public List<NamedAPIResource<Type>> getDoubleDamageTo() {
        return doubleDamageTo;
    }

    public void setDoubleDamageTo(List<NamedAPIResource<Type>> doubleDamageTo) {
        this.doubleDamageTo = doubleDamageTo;
    }

    public List<NamedAPIResource<Type>> getNoDamageFrom() {
        return noDamageFrom;
    }

    public void setNoDamageFrom(List<NamedAPIResource<Type>> noDamageFrom) {
        this.noDamageFrom = noDamageFrom;
    }

    public List<NamedAPIResource<Type>> getHalfDamageFrom() {
        return halfDamageFrom;
    }

    public void setHalfDamageFrom(List<NamedAPIResource<Type>> halfDamageFrom) {
        this.halfDamageFrom = halfDamageFrom;
    }

    public List<NamedAPIResource<Type>> getDoubleDamageFrom() {
        return doubleDamageFrom;
    }

    public void setDoubleDamageFrom(List<NamedAPIResource<Type>> doubleDamageFrom) {
        this.doubleDamageFrom = doubleDamageFrom;
    }

    @Override
    public String toString() {
        return "TypeRelations{" +
                "noDamageTo=" + noDamageTo +
                ", halfDamageTo=" + halfDamageTo +
                ", doubleDamageTo=" + doubleDamageTo +
                ", noDamageFrom=" + noDamageFrom +
                ", halfDamageFrom=" + halfDamageFrom +
                ", doubleDamageFrom=" + doubleDamageFrom +
                '}';
    }
}
