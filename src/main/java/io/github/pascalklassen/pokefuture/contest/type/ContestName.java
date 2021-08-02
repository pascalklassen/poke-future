package io.github.pascalklassen.pokefuture.contest.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.language.Language;

public final class ContestName {

    /**
     * The name for this contest.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The color associated with this contest's name.
     */
    @JsonProperty("color")
    private String color;

    /**
     * The language that this name is in.
     */
    @FetchAs(Language.class)
    @JsonProperty("language")
    private NamedAPIResource<Language> language;

    public ContestName() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public NamedAPIResource<Language> getLanguage() {
        return language;
    }

    public void setLanguage(NamedAPIResource<Language> language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "ContestName{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", language=" + language +
                '}';
    }
}
