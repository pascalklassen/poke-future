package com.github.pascalklassen.pokefuture.pokemon.shape;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import com.github.pascalklassen.pokefuture.utility.language.Language;

@ResourceEntity
public final class AwesomeName {

    /**
     * The localized "scientific" name for an API resource in a specific language.
     */
    @JsonProperty("awesome_name")
    private String awesomeName;

    /**
     * The language this "scientific" name is in.
     */
    @FetchAs(Language.class)
    @JsonProperty("language")
    private NamedAPIResource<Language> language;

    public AwesomeName() {
    }

    public String getAwesomeName() {
        return awesomeName;
    }

    public void setAwesomeName(String awesomeName) {
        this.awesomeName = awesomeName;
    }

    public NamedAPIResource<Language> getLanguage() {
        return language;
    }

    public void setLanguage(NamedAPIResource<Language> language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "AwesomeName{" +
                "awesomeName='" + awesomeName + '\'' +
                ", language=" + language +
                '}';
    }
}
