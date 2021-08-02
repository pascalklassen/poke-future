package io.github.pascalklassen.pokefuture.move;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.move.ailment.MoveAilment;
import io.github.pascalklassen.pokefuture.move.category.MoveCategory;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public final class MoveMetaData {

    /**
     * The status ailment this move inflicts on its target.
     */
    @FetchAs(MoveAilment.class)
    @JsonProperty("ailment")
    private NamedAPIResource<MoveAilment> ailment;

    /**
     * The category of move this move falls under, e.g. damage or ailment.
     */
    @FetchAs(MoveCategory.class)
    @JsonProperty("category")
    private NamedAPIResource<MoveCategory> category;

    /**
     * The minimum number of times this move hits. Null if it always only hits once.
     */
    @JsonProperty("min_hits")
    private int minHits;

    /**
     * he maximum number of times this move hits. Null if it always only hits once.
     */
    @JsonProperty("max_hits")
    private int maxHits;

    /**
     * The minimum number of turns this move continues to take effect. Null if it always only lasts one turn.
     */
    @JsonProperty("min_turns")
    private int minTurns;

    /**
     * The maximum number of turns this move continues to take effect. Null if it always only lasts one turn.
     */
    @JsonProperty("max_turns")
    private int mayTurns;

    /**
     * HP drain (if positive) or Recoil damage (if negative), in percent of damage done.
     */
    @JsonProperty("drain")
    private int drain;

    /**
     * The amount of hp gained by the attacking Pokemon, in percent of it's maximum HP.
     */
    @JsonProperty("healing")
    private int healing;

    /**
     * Critical hit rate bonus.
     */
    @JsonProperty("crit_rate")
    private int crtiRate;

    /**
     * The likelihood this attack will cause an ailment.
     */
    @JsonProperty("ailment_chance")
    private int ailmentChance;

    /**
     * The likelihood this attack will cause the target Pokémon to flinch.
     */
    @JsonProperty("flinch_chance")
    private int flinchChance;

    /**
     * The likelihood this attack will cause a stat change in the target Pokémon.
     */
    @JsonProperty("stat_chance")
    private int statChance;

    public MoveMetaData() {
    }

    public NamedAPIResource<MoveAilment> getAilment() {
        return ailment;
    }

    public void setAilment(NamedAPIResource<MoveAilment> ailment) {
        this.ailment = ailment;
    }

    public NamedAPIResource<MoveCategory> getCategory() {
        return category;
    }

    public void setCategory(NamedAPIResource<MoveCategory> category) {
        this.category = category;
    }

    public int getMinHits() {
        return minHits;
    }

    public void setMinHits(int minHits) {
        this.minHits = minHits;
    }

    public int getMaxHits() {
        return maxHits;
    }

    public void setMaxHits(int maxHits) {
        this.maxHits = maxHits;
    }

    public int getMinTurns() {
        return minTurns;
    }

    public void setMinTurns(int minTurns) {
        this.minTurns = minTurns;
    }

    public int getMayTurns() {
        return mayTurns;
    }

    public void setMayTurns(int mayTurns) {
        this.mayTurns = mayTurns;
    }

    public int getDrain() {
        return drain;
    }

    public void setDrain(int drain) {
        this.drain = drain;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public int getCrtiRate() {
        return crtiRate;
    }

    public void setCrtiRate(int crtiRate) {
        this.crtiRate = crtiRate;
    }

    public int getAilmentChance() {
        return ailmentChance;
    }

    public void setAilmentChance(int ailmentChance) {
        this.ailmentChance = ailmentChance;
    }

    public int getFlinchChance() {
        return flinchChance;
    }

    public void setFlinchChance(int flinchChance) {
        this.flinchChance = flinchChance;
    }

    public int getStatChance() {
        return statChance;
    }

    public void setStatChance(int statChance) {
        this.statChance = statChance;
    }

    @Override
    public String toString() {
        return "MoveMetaData{" +
                "ailment=" + ailment +
                ", categroy=" + category +
                ", minHits=" + minHits +
                ", maxHits=" + maxHits +
                ", minTurns=" + minTurns +
                ", mayTurns=" + mayTurns +
                ", drain=" + drain +
                ", healing=" + healing +
                ", crtiRate=" + crtiRate +
                ", ailmentChance=" + ailmentChance +
                ", flinchChance=" + flinchChance +
                ", statChance=" + statChance +
                '}';
    }
}
