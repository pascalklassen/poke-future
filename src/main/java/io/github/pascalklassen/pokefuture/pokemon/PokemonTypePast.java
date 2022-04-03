package io.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.game.generation.Generation;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

import java.util.List;

@ResourceEntity
public final class PokemonTypePast {

    /**
     * The last generation in which the referenced pokémon had the listed types.
     */
    @FetchAs(Generation.class)
    @JsonProperty("generation")
    private NamedAPIResource<Generation> genertaion;

    /**
     * The types the referenced pokémon had up to and including the listed generation.
     */
    @JsonProperty("types")
    private List<PokemonType> types;

    public PokemonTypePast() {
    }

    public NamedAPIResource<Generation> getGenertaion() {
        return genertaion;
    }

    public void setGenertaion(NamedAPIResource<Generation> genertaion) {
        this.genertaion = genertaion;
    }

    public List<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "PokemonTypePast{" +
                "genertaion=" + genertaion +
                ", types=" + types +
                '}';
    }
}
