package io.github.pascalklassen.pokefuture.machine;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.move.Move;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.item.Item;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

/**
 * Machines are the representation of items that teach moves to Pokémon. They vary from version to version, so it is not
 * certain that one specific TM or HM corresponds to a single Machine.
 *
 * GET https://pokeapi.co/api/v2/machine/{id}/
 */
public final class Machine {

    /**
     * The identifier for this resource.
     */
    @JsonProperty("id")
    private int id;

    /**
     * The TM or HM item that corresponds to this machine.
     */
    @FetchAs(Item.class)
    @JsonProperty("item")
    private NamedAPIResource<Item> item;

    /**
     * The move that is taught by this machine.
     */
    @FetchAs(Move.class)
    @JsonProperty("move")
    private NamedAPIResource<Move> move;

    /**
     * The version group that this machine applies to.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_group")
    private NamedAPIResource<VersionGroup> versionGroup;

    public Machine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NamedAPIResource<Item> getItem() {
        return item;
    }

    public void setItem(NamedAPIResource<Item> item) {
        this.item = item;
    }

    public NamedAPIResource<Move> getMove() {
        return move;
    }

    public void setMove(NamedAPIResource<Move> move) {
        this.move = move;
    }

    public NamedAPIResource<VersionGroup> getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(NamedAPIResource<VersionGroup> versionGroup) {
        this.versionGroup = versionGroup;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", item=" + item +
                ", move=" + move +
                ", versionGroup=" + versionGroup +
                '}';
    }
}
