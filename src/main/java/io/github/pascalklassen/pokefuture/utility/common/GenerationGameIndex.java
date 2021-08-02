package io.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.machine.Machine;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

@ResourceEntity
@JsonIgnoreProperties({"game_index", "generation"})
public final class GenerationGameIndex {

    /**
     * The machine that teaches a move from an item.
     */
    @FetchAs(Machine.class)
    @JsonProperty("machine")
    private APIResource<Machine> machine;

    /**
     * The version group of this specific machine.
     */
    @FetchAs(VersionGroup.class)
    private NamedAPIResource<VersionGroup> versionGroup;

    public GenerationGameIndex() {
    }

    public APIResource<Machine> getMachine() {
        return machine;
    }

    public void setMachine(APIResource<Machine> machine) {
        this.machine = machine;
    }

    public NamedAPIResource<VersionGroup> getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(NamedAPIResource<VersionGroup> versionGroup) {
        this.versionGroup = versionGroup;
    }

    @Override
    public String toString() {
        return "GenerationGameIndex{" +
                "machine=" + machine +
                ", versionGroup=" + versionGroup +
                '}';
    }
}
