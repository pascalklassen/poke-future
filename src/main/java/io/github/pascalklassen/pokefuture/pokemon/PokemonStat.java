package io.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.pokemon.stat.Stat;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

@ResourceEntity
public final class PokemonStat {

    /**
     * The stat the Pokémon has.
     */
    @FetchAs(Stat.class)
    @JsonProperty("stat")
    private NamedAPIResource<Stat> stat;

    /**
     * The effort points (EV) the Pokémon has in the stat.
     */
    @JsonProperty("effort")
    private int effort;

    /**
     * The base value of the stat.
     */
    @JsonProperty("base_stat")
    private int baseStat;

    public PokemonStat() {
    }

    public NamedAPIResource<Stat> getStat() {
        return stat;
    }

    public int getEffort() {
        return effort;
    }

    public int getBaseStat() {
        return baseStat;
    }

    public void setStat(NamedAPIResource<Stat> stat) {
        this.stat = stat;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    @Override
    public String toString() {
        return "PokemonStat{" +
                "stat=" + stat +
                ", effort=" + effort +
                ", baseStat=" + baseStat +
                '}';
    }
}
