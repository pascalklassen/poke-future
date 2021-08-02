package io.github.pascalklassen.pokefuture.pokemon.nature;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.github.pascalklassen.pokefuture.move.battlestyle.MoveBattleStyle;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

@ResourceEntity
public final class MoveBattleStylePreference {

    /**
     * Chance of using the move, in percent, if HP is under one half.
     */
    @JsonProperty("low_hp_preference")
    private int lowHpPreference;

    /**
     * Chance of using the move, in percent, if HP is over one half.
     */
    @JsonProperty("high_hp_preference")
    private int highHpPreference;

    /**
     * The move battle style.
     */
    @FetchAs(MoveBattleStyle.class)
    @JsonProperty("move_battle_style")
    private NamedAPIResource<MoveBattleStyle> moveBattleStyle;

    public MoveBattleStylePreference() {
    }

    public int getLowHpPreference() {
        return lowHpPreference;
    }

    public void setLowHpPreference(int lowHpPreference) {
        this.lowHpPreference = lowHpPreference;
    }

    public int getHighHpPreference() {
        return highHpPreference;
    }

    public void setHighHpPreference(int highHpPreference) {
        this.highHpPreference = highHpPreference;
    }

    public NamedAPIResource<MoveBattleStyle> getMoveBattleStyle() {
        return moveBattleStyle;
    }

    public void setMoveBattleStyle(NamedAPIResource<MoveBattleStyle> moveBattleStyle) {
        this.moveBattleStyle = moveBattleStyle;
    }

    @Override
    public String toString() {
        return "MoveBattleStylePreference{" +
                "lowHpPreference=" + lowHpPreference +
                ", highHpPreference=" + highHpPreference +
                ", moveBattleStyle=" + moveBattleStyle +
                '}';
    }
}
