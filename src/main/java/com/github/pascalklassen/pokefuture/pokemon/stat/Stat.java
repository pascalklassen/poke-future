package com.github.pascalklassen.pokefuture.pokemon.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.common.Name;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.move.damageclass.MoveDamageClass;
import com.github.pascalklassen.pokefuture.pokemon.characteristic.Characteristic;
import com.github.pascalklassen.pokefuture.utility.common.APIResource;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Stats determine certain aspects of battles. Each Pokémon has a value for each stat which grows as they gain levels
 * and can be altered momentarily by effects in battles.
 *
 * GET https://pokeapi.co/api/v2/stat/{id or name}/
 */
@ResourceEntity
public final class Stat {

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
     * ID the games use for this stat.
     */
    @JsonProperty("game_index")
    private int gameIndex;

    /**
     * Whether this stat only exists within a battle.
     */
    @JsonProperty("is_battle_only")
    private boolean isBattleOnly;

    /**
     * A detail of moves which affect this stat positively or negatively.
     */
    @JsonProperty("affecting_moves")
    private MoveStatAffectSets affectingMoves;

    /**
     * A detail of natures which affect this stat positively or negatively.
     */
    @JsonProperty("affecting_natures")
    private NatureStatAffectSets affectingNatures;

    /**
     * A list of characteristics that are set on a Pokémon when its highest base stat is this stat.
     */
    @FetchAs(Characteristic.class)
    @JsonProperty("characteristics")
    private List<APIResource<Characteristic>> characteristics;

    /**
     * The class of damage this stat is directly related to.
     */
    @FetchAs(MoveDamageClass.class)
    @JsonProperty("move_damage_class")
    private NamedAPIResource<MoveDamageClass> moveDamageClass;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    public Stat() {
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

    public int getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public boolean isBattleOnly() {
        return isBattleOnly;
    }

    public void setBattleOnly(boolean battleOnly) {
        isBattleOnly = battleOnly;
    }

    public MoveStatAffectSets getAffectingMoves() {
        return affectingMoves;
    }

    public void setAffectingMoves(MoveStatAffectSets affectingMoves) {
        this.affectingMoves = affectingMoves;
    }

    public NatureStatAffectSets getAffectingNatures() {
        return affectingNatures;
    }

    public void setAffectingNatures(NatureStatAffectSets affectingNatures) {
        this.affectingNatures = affectingNatures;
    }

    public List<APIResource<Characteristic>> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<APIResource<Characteristic>> characteristics) {
        this.characteristics = characteristics;
    }

    public NamedAPIResource<MoveDamageClass> getMoveDamageClass() {
        return moveDamageClass;
    }

    public void setMoveDamageClass(NamedAPIResource<MoveDamageClass> moveDamageClass) {
        this.moveDamageClass = moveDamageClass;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gameIndex=" + gameIndex +
                ", isBattleOnly=" + isBattleOnly +
                ", affectingMoves=" + affectingMoves +
                ", affectingNatures=" + affectingNatures +
                ", characteristics=" + characteristics +
                ", moveDamageClass=" + moveDamageClass +
                ", names=" + names +
                '}';
    }

    public static Future<Stat> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Stat.class, String.format("/stat/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Stat>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Stat>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Stat.class, String.format("/stat?limit=%s&offset=%s", limit, offset));
    }

}
