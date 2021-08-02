package com.github.pascalklassen.pokefuture.move;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.common.*;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.contest.effect.ContestEffect;
import com.github.pascalklassen.pokefuture.contest.supereffect.SuperContestEffect;
import com.github.pascalklassen.pokefuture.contest.type.ContestType;
import com.github.pascalklassen.pokefuture.game.generation.Generation;
import com.github.pascalklassen.pokefuture.move.damageclass.MoveDamageClass;
import com.github.pascalklassen.pokefuture.move.target.MoveTarget;
import com.github.pascalklassen.pokefuture.pokemon.ability.AbilityEffectChange;
import com.github.pascalklassen.pokefuture.pokemon.type.Type;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Moves are the skills of Pokémon in battle. In battle, a Pokémon uses one move each turn. Some moves (including those
 * learned by Hidden Machine) can be used outside of battle as well, usually for the purpose of removing obstacles or
 * exploring new areas.
 *
 * GET https://pokeapi.co/api/v2/move/{id or name}/
 */
// TODO: Move["learned_by_pokemon"] NOT DOCUMENTED ON https://pokeapi.co/docs/v2#moves
@JsonIgnoreProperties("learned_by_pokemon")
@ResourceEntity
public final class Move {

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
     * The percent value of how likely this move is to be successful.
     */
    @JsonProperty("accuracy")
    private int accuracy;

    /**
     * The percent value of how likely it is this moves effect will happen.
     */
    @JsonProperty("effect_chance")
    private int effectChance;

    /**
     * Power points. The number of times this move can be used.
     */
    @JsonProperty("pp")
    private int powerPoints;

    /**
     * A value between -8 and 8. Sets the order in which moves are executed during battle. See
     * <a href="https://bulbapedia.bulbagarden.net/wiki/Priority">Bulbapedia</a> for greater detail.
     */
    @JsonProperty("priority")
    private int priority;

    /**
     * The base power of this move with a value of 0 if it does not have a base power.
     */
    @JsonProperty("power")
    private int power;

    /**
     * A detail of normal and super contest combos that require this move.
     */
    @JsonProperty("contest_combos")
    private ContestComboSets contestCombos;

    /**
     * The type of appeal this move gives a Pokémon when used in a contest.
     */
    @FetchAs(ContestType.class)
    @JsonProperty("contest_type")
    private NamedAPIResource<ContestType> contestType;

    /**
     * The effect the move has when used in a contest.
     */
    @FetchAs(ContestEffect.class)
    @JsonProperty("contest_effect")
    private APIResource<ContestEffect> contestEffect;

    /**
     * The type of damage the move inflicts on the target, e.g. physical.
     */
    @FetchAs(MoveDamageClass.class)
    @JsonProperty("damage_class")
    private NamedAPIResource<MoveDamageClass> damageClass;

    /**
     * The effect of this move listed in different languages.
     */
    @JsonProperty("effect_entries")
    private List<VerboseEffect> effectEntries;

    /**
     * The list of previous effects this move has had across version groups of the games.
     */
    @JsonProperty("effect_changes")
    private List<AbilityEffectChange> effectChanges;

    /**
     * The flavor text of this move listed in different languages.
     */
    @JsonProperty("flavor_text_entries")
    private List<MoveFlavorText> flavorTextEntries;

    /**
     * The generation in which this move was introduced.
     */
    @FetchAs(Generation.class)
    @JsonProperty("generation")
    private NamedAPIResource<Generation> generation;

    /**
     * A list of the machines that teach this move.
     */
    @JsonProperty("machines")
    private List<MachineVersionDetail> machines;

    /**
     * Metadata about this move
     */
    @JsonProperty("meta")
    private MoveMetaData meta;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A list of move resource value changes across version groups of the game.
     */
    @JsonProperty("past_values")
    private List<PastMoveStatValues> pastValues;

    /**
     * A list of stats this moves effects and how much it effects them.
     */
    @JsonProperty("stat_changes")
    private List<MoveStatChange> statChanges;

    /**
     * The effect the move has when used in a super contest.
     */
    @FetchAs(SuperContestEffect.class)
    @JsonProperty("super_contest_effect")
    private APIResource<SuperContestEffect> superContestEffect;

    /**
     * The type of target that will receive the effects of the attack.
     */
    @FetchAs(MoveTarget.class)
    @JsonProperty("target")
    private NamedAPIResource<MoveTarget> target;

    /**
     * The elemental type of this move.
     */
    @FetchAs(Type.class)
    @JsonProperty("type")
    private NamedAPIResource<Type> type;

    public Move() {
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

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getEffectChance() {
        return effectChance;
    }

    public void setEffectChance(int effectChance) {
        this.effectChance = effectChance;
    }

    public int getPowerPoints() {
        return powerPoints;
    }

    public void setPowerPoints(int powerPoints) {
        this.powerPoints = powerPoints;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public ContestComboSets getContestCombos() {
        return contestCombos;
    }

    public void setContestCombos(ContestComboSets contestCombos) {
        this.contestCombos = contestCombos;
    }

    public NamedAPIResource<ContestType> getContestType() {
        return contestType;
    }

    public void setContestType(NamedAPIResource<ContestType> contestType) {
        this.contestType = contestType;
    }

    public APIResource<ContestEffect> getContestEffect() {
        return contestEffect;
    }

    public void setContestEffect(APIResource<ContestEffect> contestEffect) {
        this.contestEffect = contestEffect;
    }

    public NamedAPIResource<MoveDamageClass> getDamageClass() {
        return damageClass;
    }

    public void setDamageClass(NamedAPIResource<MoveDamageClass> damageClass) {
        this.damageClass = damageClass;
    }

    public List<VerboseEffect> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<VerboseEffect> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public List<AbilityEffectChange> getEffectChanges() {
        return effectChanges;
    }

    public void setEffectChanges(List<AbilityEffectChange> effectChanges) {
        this.effectChanges = effectChanges;
    }

    public List<MoveFlavorText> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<MoveFlavorText> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public NamedAPIResource<Generation> getGeneration() {
        return generation;
    }

    public void setGeneration(NamedAPIResource<Generation> generation) {
        this.generation = generation;
    }

    public List<MachineVersionDetail> getMachines() {
        return machines;
    }

    public void setMachines(List<MachineVersionDetail> machines) {
        this.machines = machines;
    }

    public MoveMetaData getMeta() {
        return meta;
    }

    public void setMeta(MoveMetaData meta) {
        this.meta = meta;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<PastMoveStatValues> getPastValues() {
        return pastValues;
    }

    public void setPastValues(List<PastMoveStatValues> pastValues) {
        this.pastValues = pastValues;
    }

    public List<MoveStatChange> getStatChanges() {
        return statChanges;
    }

    public void setStatChanges(List<MoveStatChange> statChanges) {
        this.statChanges = statChanges;
    }

    public APIResource<SuperContestEffect> getSuperContestEffect() {
        return superContestEffect;
    }

    public void setSuperContestEffect(APIResource<SuperContestEffect> superContestEffect) {
        this.superContestEffect = superContestEffect;
    }

    public NamedAPIResource<MoveTarget> getTarget() {
        return target;
    }

    public void setTarget(NamedAPIResource<MoveTarget> target) {
        this.target = target;
    }

    public NamedAPIResource<Type> getType() {
        return type;
    }

    public void setType(NamedAPIResource<Type> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Move{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accuracy=" + accuracy +
                ", effectChance=" + effectChance +
                ", powerPoints=" + powerPoints +
                ", priority=" + priority +
                ", power=" + power +
                ", contestCombos=" + contestCombos +
                ", contestType=" + contestType +
                ", contestEffect=" + contestEffect +
                ", damageClass=" + damageClass +
                ", effectEntries=" + effectEntries +
                ", effectChanges=" + effectChanges +
                ", flavorTextEntries=" + flavorTextEntries +
                ", generation=" + generation +
                ", machines=" + machines +
                ", meta=" + meta +
                ", names=" + names +
                ", pastValues=" + pastValues +
                ", statChanges=" + statChanges +
                ", superContestEffect=" + superContestEffect +
                ", target=" + target +
                ", type=" + type +
                '}';
    }

    public static Future<Move> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Move.class, String.format("/move/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Move>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Move>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Move.class, String.format("/move?limit=%s&offset=%s", limit, offset));
    }

}
