package io.github.pascalklassen.pokefuture.pokemon.nature;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.stat.pokeathlon.PokeathlonStat;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

@ResourceEntity
public final class NatureStatChange {

    /**
     * The amount of change.
     */
    @JsonProperty("max_change")
    private int maxChange;

    /**
     * The stat being affected.
     */
    @FetchAs(PokeathlonStat.class)
    @JsonProperty("pokeathlon_stat")
    private NamedAPIResource<PokeathlonStat> pokeathlonStat;

    public NatureStatChange() {
    }

    public int getMaxChange() {
        return maxChange;
    }

    public void setMaxChange(int maxChange) {
        this.maxChange = maxChange;
    }

    public NamedAPIResource<PokeathlonStat> getPokeathlonStat() {
        return pokeathlonStat;
    }

    public void setPokeathlonStat(NamedAPIResource<PokeathlonStat> pokeathlonStat) {
        this.pokeathlonStat = pokeathlonStat;
    }

    @Override
    public String toString() {
        return "NatureStatChange{" +
                "maxChange=" + maxChange +
                ", pokeathlonStat=" + pokeathlonStat +
                '}';
    }
}
