package com.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.encounter.condition.value.EncounterConditionValue;
import com.github.pascalklassen.pokefuture.encounter.method.EncounterMethod;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

public final class Encounter {

    /**
     * The lowest level the Pokémon could be encountered at.
     */
    @JsonProperty("min_level")
    private int minLevel;

    /**
     * The highest level the Pokémon could be encountered at.
     */
    @JsonProperty("max_level")
    private int maxLevel;

    /**
     * A list of condition values that must be in effect for this encounter to occur.
     */
    @FetchAs(EncounterConditionValue.class)
    @JsonProperty("condition_values")
    private List<NamedAPIResource<EncounterConditionValue>> conditionValues;

    /**
     * Percent chance that this encounter will occur.
     */
    @JsonProperty("chance")
    private int chance;

    /**
     * The method by which this encounter happens.
     */
    @FetchAs(EncounterMethod.class)
    @JsonProperty("method")
    private NamedAPIResource<EncounterMethod> method;

    public Encounter() {
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public List<NamedAPIResource<EncounterConditionValue>> getConditionValues() {
        return conditionValues;
    }

    public void setConditionValues(List<NamedAPIResource<EncounterConditionValue>> conditionValues) {
        this.conditionValues = conditionValues;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public NamedAPIResource<EncounterMethod> getMethod() {
        return method;
    }

    public void setMethod(NamedAPIResource<EncounterMethod> method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Encounter{" +
                "minLevel=" + minLevel +
                ", maxLevel=" + maxLevel +
                ", conditionValues=" + conditionValues +
                ", chance=" + chance +
                ", method=" + method +
                '}';
    }
}
