package io.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.move.Move;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

@ResourceEntity
public final class PokemonMove {

    /**
     * The move the Pokémon can learn.
     */
    @FetchAs(Move.class)
    @JsonProperty("move")
    private NamedAPIResource<Move> move;

    /**
     * The details of the version in which the Pokémon can learn the move.
     */
    @JsonProperty("version_group_details")
    private List<PokemonMoveVersion> versionGroupDetails;

    public PokemonMove() {
    }

    public NamedAPIResource<Move> getMove() {
        return move;
    }

    public List<PokemonMoveVersion> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    public void setMove(NamedAPIResource<Move> move) {
        this.move = move;
    }

    public void setVersionGroupDetails(List<PokemonMoveVersion> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }

    @Override
    public String toString() {
        return "PokemonMove{" +
                "move=" + move +
                ", versionGroupDetails=" + versionGroupDetails +
                '}';
    }
}
