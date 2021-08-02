package io.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class VerboseEffect extends Effect {

    /**
     * The localized effect text for an API resource in a specific language.
     */
    @JsonProperty("short_effect")
    private String shortEffect;

    public VerboseEffect() {
    }

    public String getShortEffect() {
        return shortEffect;
    }

    public void setShortEffect(String shortEffect) {
        this.shortEffect = shortEffect;
    }

    @Override
    public String toString() {
        return "VerboseEffect{" +
                "effect='" + getEffect() + '\'' +
                ", language=" + getLanguage() +
                ", shortEffect='" + shortEffect + '\'' +
                '}';
    }
}
