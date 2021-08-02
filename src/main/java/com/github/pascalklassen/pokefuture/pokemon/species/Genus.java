package com.github.pascalklassen.pokefuture.pokemon.species;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.github.pascalklassen.pokefuture.utility.language.Language;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

@ResourceEntity
public final class Genus {

    /**
     * The localized genus for the referenced Pokémon species
     */
    @JsonProperty("genus")
    private String genus;

    /**
     * The language this genus is in.
     */
    @FetchAs(Language.class)
    @JsonProperty("language")
    private NamedAPIResource<Language> language;

    public Genus() {
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public NamedAPIResource<Language> getLanguage() {
        return language;
    }

    public void setLanguage(NamedAPIResource<Language> language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Genus{" +
                "genus='" + genus + '\'' +
                ", language=" + language +
                '}';
    }
}
