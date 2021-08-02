package io.github.pascalklassen.pokefuture.evolution.chain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

import java.util.List;

public final class ChainLink {

    /**
     * Whether or not this link is for a baby Pokémon. This would only ever be true on the base link.
     */
    @JsonProperty("is_baby")
    private boolean isBaby;

    /**
     * The Pokémon species at this point in the evolution chain.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("species")
    private NamedAPIResource<PokemonSpecies> species;

    /**
     * All details regarding the specific details of the referenced Pokémon species evolution.
     */
    @JsonProperty("evolution_details")
    private List<EvolutionDetail> evolutionDetails;

    /**
     * A List of chain objects.
     */
    @JsonProperty("evolves_to")
    private List<ChainLink> evolvesTo;

    public ChainLink() {
    }

    public boolean isBaby() {
        return isBaby;
    }

    public void setBaby(boolean baby) {
        isBaby = baby;
    }

    public NamedAPIResource<PokemonSpecies> getSpecies() {
        return species;
    }

    public void setSpecies(NamedAPIResource<PokemonSpecies> species) {
        this.species = species;
    }

    public List<EvolutionDetail> getEvolutionDetails() {
        return evolutionDetails;
    }

    public void setEvolutionDetails(List<EvolutionDetail> evolutionDetails) {
        this.evolutionDetails = evolutionDetails;
    }

    public List<ChainLink> getEvolvesTo() {
        return evolvesTo;
    }

    public void setEvolvesTo(List<ChainLink> evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

    @Override
    public String toString() {
        return "ChainLink{" +
                "isBaby=" + isBaby +
                ", species=" + species +
                ", evolutionDetails=" + evolutionDetails +
                ", evolvesTo=" + evolvesTo +
                ", baby=" + isBaby() +
                '}';
    }
}
