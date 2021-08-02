package com.github.pascalklassen.pokefuture.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class ItemSprites {

    /**
     * The default depiction of this item.
     */
    @JsonProperty("default")
    private String defaultDepiction;

    public ItemSprites() {
    }

    public String getDefaultDepiction() {
        return defaultDepiction;
    }

    public void setDefaultDepiction(String defaultDepiction) {
        this.defaultDepiction = defaultDepiction;
    }

    @Override
    public String toString() {
        return "ItemSprites{" +
                "defaultDepiction='" + defaultDepiction + '\'' +
                '}';
    }
}
