package io.github.pascalklassen.pokefuture.move;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.utility.language.Language;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public final class MoveFlavorText {

    /**
     * The localized flavor text for an api resource in a specific language.
     */
    @JsonProperty("flavor_text")
    private String flavorText;

    /**
     * The language this name is in.
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

    public MoveFlavorText() {
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
        return "MoveFlavorText{" +
                "flavorText='" + flavorText + '\'' +
                ", language=" + language +
                ", versionGroup=" + versionGroup +
                '}';
    }
}
