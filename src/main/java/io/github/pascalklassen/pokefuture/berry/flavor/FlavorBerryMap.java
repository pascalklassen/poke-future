package io.github.pascalklassen.pokefuture.berry.flavor;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.berry.Berry;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

@ResourceEntity
public class FlavorBerryMap {

    /**
     * How powerful the referenced flavor is for this berry.
     */
    @JsonProperty("potency")
    private int potency;

    /**
     * The berry with the referenced flavor
     */
    @FetchAs(Berry.class)
    @JsonProperty("berry")
    private NamedAPIResource<Berry> berry;

    public FlavorBerryMap() {
    }

    public int getPotency() {
        return potency;
    }

    public void setPotency(int potency) {
        this.potency = potency;
    }

    public NamedAPIResource<Berry> getBerry() {
        return berry;
    }

    public void setBerry(NamedAPIResource<Berry> berry) {
        this.berry = berry;
    }

    @Override
    public String toString() {
        return "FlavorBerryMap{" +
                "potency=" + potency +
                ", berry=" + berry +
                '}';
    }
}
