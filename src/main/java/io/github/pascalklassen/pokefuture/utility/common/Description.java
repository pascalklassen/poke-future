package io.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.github.pascalklassen.pokefuture.utility.language.Language;

@ResourceEntity
public final class Description {

    /**
     * The localized description for an API resource in a specific language.
     */
    @JsonProperty("description")
    private String description;

    /**
     * The language this name is in.
     */
    @FetchAs(Language.class)
    @JsonProperty("language")
    private NamedAPIResource<Language> language;

    public Description() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NamedAPIResource<Language> getLanguage() {
        return language;
    }

    public void setLanguage(NamedAPIResource<Language> language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Description{" +
                "description='" + description + '\'' +
                ", language=" + language +
                '}';
    }
}
