package io.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class NamedAPIResource<ResourceT> extends APIResource<ResourceT> {

    /**
     * The name of the referenced resource.
     */
    @JsonProperty("name")
    private String name;

    public NamedAPIResource() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamedAPIResource{" +
                "name='" + name + '\'' +
                ", url='" + getUrl() + '\'' +
                '}';
    }
}
