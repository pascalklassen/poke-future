package io.github.pascalklassen.pokefuture.pokemon.ability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.utility.common.Effect;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

public final class AbilityEffectChange {

    /**
     * The previous effect of this ability listed in different languages.
     */
    @JsonProperty("effect_entries")
    private List<Effect> effectEntries;

    /**
     * The version group in which the previous effect of this ability originated.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_group")
    private NamedAPIResource<VersionGroup> versionGroup;

    public AbilityEffectChange() {
    }

    public List<Effect> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<Effect> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public NamedAPIResource<VersionGroup> getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(NamedAPIResource<VersionGroup> versionGroup) {
        this.versionGroup = versionGroup;
    }

    @Override
    public String toString() {
        return "AbilityEffectChange{" +
                "effectEntries=" + effectEntries +
                ", versionGroup=" + versionGroup +
                '}';
    }
}
