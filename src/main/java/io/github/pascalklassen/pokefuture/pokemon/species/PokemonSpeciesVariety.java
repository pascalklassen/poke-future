package io.github.pascalklassen.pokefuture.pokemon.species;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.Pokemon;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

@ResourceEntity
public final class PokemonSpeciesVariety {

    /**
     * Whether this variety is the default variety.
     */
    @JsonProperty("is_default")
    private boolean isDefault;

    /**
     * The Pokémon variety.
     */
    @FetchAs(Pokemon.class)
    @JsonProperty("pokemon")
    private NamedAPIResource<Pokemon> pokemon;

    public PokemonSpeciesVariety() {
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public NamedAPIResource<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(NamedAPIResource<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String toString() {
        return "PokemonSpeciesVariety{" +
                "isDefault=" + isDefault +
                ", pokemon=" + pokemon +
                '}';
    }
}
