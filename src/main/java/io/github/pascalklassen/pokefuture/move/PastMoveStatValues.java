package io.github.pascalklassen.pokefuture.move;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.pokemon.type.Type;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.common.VerboseEffect;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

public final class PastMoveStatValues {

    /**
     * The percent value of how likely this move is to be successful.
     */
    @JsonProperty("accuracy")
    private int accuracy;

    /**
     * The percent value of how likely it is this moves effect will take effect.
     */
    @JsonProperty("effect_chance")
    private int effectChance;

    /**
     * The base power of this move with a value of 0 if it does not have a base power.
     */
    @JsonProperty("power")
    private int power;

    /**
     * Power points. The number of times this move can be used.
     */
    @JsonProperty("pp")
    private int powerPoints;

    /**
     * The effect of this move listed in different languages.
     */
    @JsonProperty("effect_entries")
    private List<VerboseEffect> effectEntries;

    /**
     * The elemental type of this move.
     */
    @FetchAs(Type.class)
    @JsonProperty("type")
    private NamedAPIResource<Type> type;

    /**
     * The elemental type of this move.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_group")
    private NamedAPIResource<VersionGroup> versionGroup;

    public PastMoveStatValues() {
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getEffectChance() {
        return effectChance;
    }

    public void setEffectChance(int effectChance) {
        this.effectChance = effectChance;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPowerPoints() {
        return powerPoints;
    }

    public void setPowerPoints(int powerPoints) {
        this.powerPoints = powerPoints;
    }

    public List<VerboseEffect> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<VerboseEffect> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public NamedAPIResource<Type> getType() {
        return type;
    }

    public void setType(NamedAPIResource<Type> type) {
        this.type = type;
    }

    public NamedAPIResource<VersionGroup> getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(NamedAPIResource<VersionGroup> versionGroup) {
        this.versionGroup = versionGroup;
    }

    @Override
    public String toString() {
        return "PastMoveStatValues{" +
                "accuracy=" + accuracy +
                ", effectChance=" + effectChance +
                ", power=" + power +
                ", powerPoints=" + powerPoints +
                ", effectEntries=" + effectEntries +
                ", type=" + type +
                ", versionGroup=" + versionGroup +
                '}';
    }
}
