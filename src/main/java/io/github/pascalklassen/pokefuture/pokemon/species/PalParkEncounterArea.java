package io.github.pascalklassen.pokefuture.pokemon.species;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.github.pascalklassen.pokefuture.location.area.palpark.PalParkArea;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

@ResourceEntity
public final class PalParkEncounterArea {

    /**
     * The base score given to the player when the referenced Pokémon is caught during a pal park run.
     */
    @JsonProperty("base_score")
    private int baseScore;

    /**
     * The base rate for encountering the referenced Pokémon in this pal park area.
     */
    @JsonProperty("rate")
    private int rate;

    /**
     * The pal park area where this encounter happens.
     */
    @FetchAs(PalParkArea.class)
    @JsonProperty("area")
    private NamedAPIResource<PalParkArea> area;

    public PalParkEncounterArea() {
    }

    public int getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(int baseScore) {
        this.baseScore = baseScore;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public NamedAPIResource<PalParkArea> getArea() {
        return area;
    }

    public void setArea(NamedAPIResource<PalParkArea> area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "PalParkEncounterArea{" +
                "baseScore=" + baseScore +
                ", rate=" + rate +
                ", area=" + area +
                '}';
    }
}
