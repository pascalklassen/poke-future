package io.github.pascalklassen.pokefuture.utility.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.machine.Machine;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public final class MachineVersionDetail {

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
    @JsonProperty("version_group")
    private NamedAPIResource<VersionGroup> versionGroup;

    public MachineVersionDetail() {
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
        return "MachineVersionDetail{" +
                "machine=" + machine +
                ", versionGroup=" + versionGroup +
                '}';
    }
}
