package io.github.pascalklassen.pokefuture.pokemon.growth;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class GrowthRateExperienceLevel {

    /**
     * The level gained.
     */
    @JsonProperty("level")
    private int level;

    /**
     * The amount of experience required to reach the referenced level.
     */
    @JsonProperty("experience")
    private int experience;

    public GrowthRateExperienceLevel() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "GrowthRateExperienceLevel{" +
                "level=" + level +
                ", experience=" + experience +
                '}';
    }
}
