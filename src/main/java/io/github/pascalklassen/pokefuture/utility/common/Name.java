package io.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.github.pascalklassen.pokefuture.utility.language.Language;

@ResourceEntity
public final class Name {

    /**
     * The localized name for an API resource in a specific language.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The language this name is in.
     */
    @FetchAs(Language.class)
    @JsonProperty("language")
    private NamedAPIResource<Language> language;

    public Name() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NamedAPIResource<Language> getLanguage() {
        return language;
    }

    public void setLanguage(NamedAPIResource<Language> language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", language=" + language +
                '}';
    }
}
