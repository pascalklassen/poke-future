package com.github.pascalklassen.pokefuture.berry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.berry.flavor.BerryFlavor;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;

public final class BerryFlavorMap {

    /**
     * How powerful the referenced flavor is for this berry.
     */
    @JsonProperty("potency")
    private int potency;

    /**
     * The referenced berry flavor.
     */
    @FetchAs(BerryFlavor.class)
    @JsonProperty("flavor")
    private NamedAPIResource<BerryFlavor> flavor;

    public BerryFlavorMap() {
    }

    public int getPotency() {
        return potency;
    }

    public void setPotency(int potency) {
        this.potency = potency;
    }

    public NamedAPIResource<BerryFlavor> getFlavor() {
        return flavor;
    }

    public void setFlavor(NamedAPIResource<BerryFlavor> flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "BerryFlavorMap{" +
                "potency=" + potency +
                ", flavor=" + flavor +
                '}';
    }
}
