package io.github.pascalklassen.pokefuture.pokemon.nature;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.berry.flavor.BerryFlavor;
import io.github.pascalklassen.pokefuture.pokemon.stat.Stat;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Natures influence how a Pokémon's stats grow. See
 * <a href="http://bulbapedia.bulbagarden.net/wiki/Nature">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/nature/{id or name}/
 */
@ResourceEntity
public final class Nature {

    /**
     * The identifier for this resource.
     */
    @JsonProperty("id")
    private int id;

    /**
     * The name for this resource.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The stat decreased by 10% in Pokémon with this nature.
     */
    @FetchAs(Stat.class)
    @JsonProperty("decreased_stat")
    private NamedAPIResource<Stat> decreasedStat;

    /**
     * The stat increased by 10% in Pokémon with this nature
     */
    @FetchAs(Stat.class)
    @JsonProperty("increased_stat")
    private NamedAPIResource<Stat> increasedStat;

    /**
     * The flavor hated by Pokémon with this nature.
     */
    @FetchAs(BerryFlavor.class)
    @JsonProperty("hates_flavor")
    private NamedAPIResource<BerryFlavor> hatesFlavor;

    /**
     * The flavor liked by Pokémon with this nature.
     */
    @FetchAs(BerryFlavor.class)
    @JsonProperty("likes_flavor")
    private NamedAPIResource<BerryFlavor> likesFlavor;

    /**
     * A list of Pokéathlon stats this nature effects and how much it effects them.
     */
    @JsonProperty("pokeathlon_stat_changes")
    private List<NatureStatChange> pokeathlonStatChanges;

    /**
     * A list of battle styles and how likely a Pokémon with this nature is to use them in the Battle Palace or Battle
     * Tent.
     */
    @JsonProperty("move_battle_style_preferences")
    private List<MoveBattleStylePreference> moveBattleStylePreferences;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    public Nature() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NamedAPIResource<Stat> getDecreasedStat() {
        return decreasedStat;
    }

    public void setDecreasedStat(NamedAPIResource<Stat> decreasedStat) {
        this.decreasedStat = decreasedStat;
    }

    public NamedAPIResource<Stat> getIncreasedStat() {
        return increasedStat;
    }

    public void setIncreasedStat(NamedAPIResource<Stat> increasedStat) {
        this.increasedStat = increasedStat;
    }

    public NamedAPIResource<BerryFlavor> getHatesFlavor() {
        return hatesFlavor;
    }

    public void setHatesFlavor(NamedAPIResource<BerryFlavor> hatesFlavor) {
        this.hatesFlavor = hatesFlavor;
    }

    public NamedAPIResource<BerryFlavor> getLikesFlavor() {
        return likesFlavor;
    }

    public void setLikesFlavor(NamedAPIResource<BerryFlavor> likesFlavor) {
        this.likesFlavor = likesFlavor;
    }

    public List<NatureStatChange> getPokeathlonStatChanges() {
        return pokeathlonStatChanges;
    }

    public void setPokeathlonStatChanges(List<NatureStatChange> pokeathlonStatChanges) {
        this.pokeathlonStatChanges = pokeathlonStatChanges;
    }

    public List<MoveBattleStylePreference> getMoveBattleStylePreferences() {
        return moveBattleStylePreferences;
    }

    public void setMoveBattleStylePreferences(List<MoveBattleStylePreference> moveBattleStylePreferences) {
        this.moveBattleStylePreferences = moveBattleStylePreferences;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Nature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", decreasedStat=" + decreasedStat +
                ", increasedStat=" + increasedStat +
                ", hatesFlavor=" + hatesFlavor +
                ", likesFlavor=" + likesFlavor +
                ", pokeathlonStatChanges=" + pokeathlonStatChanges +
                ", moveBattleStylePreferences=" + moveBattleStylePreferences +
                ", names=" + names +
                '}';
    }

    public static Future<Nature> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Nature.class, String.format("/nature/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Nature>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Nature>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Nature.class, String.format("/nature?limit=%s&offset=%s", limit, offset));
    }
}
