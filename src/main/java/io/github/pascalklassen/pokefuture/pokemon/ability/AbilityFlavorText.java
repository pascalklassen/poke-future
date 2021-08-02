package io.github.pascalklassen.pokefuture.pokemon.ability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.language.Language;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;

public final class AbilityFlavorText {

    /**
     * The localized name for an API resource in a specific language.
     */
    @JsonProperty("flavor_text")
    private String flavorText;

    /**
     * The language this text resource is in.
     */
    @FetchAs(Language.class)
    @JsonProperty("language")
    private NamedAPIResource<Language> language;

    /**
     * The version group that uses this flavor text.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_group")
    private NamedAPIResource<VersionGroup> versionGroup;

    public AbilityFlavorText() {
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public NamedAPIResource<Language> getLanguage() {
        return language;
    }

    public void setLanguage(NamedAPIResource<Language> language) {
        this.language = language;
    }

    public NamedAPIResource<VersionGroup> getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(NamedAPIResource<VersionGroup> versionGroup) {
        this.versionGroup = versionGroup;
    }

    @Override
    public String toString() {
        return "AbilityFlavorText{" +
                "flavorText='" + flavorText + '\'' +
                ", language=" + language +
                ", versionGroup=" + versionGroup +
                '}';
    }
}
