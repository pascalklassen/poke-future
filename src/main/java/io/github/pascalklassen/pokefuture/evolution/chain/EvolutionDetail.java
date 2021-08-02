package io.github.pascalklassen.pokefuture.evolution.chain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.evolution.trigger.EvolutionTrigger;
import io.github.pascalklassen.pokefuture.item.Item;
import io.github.pascalklassen.pokefuture.location.Location;
import io.github.pascalklassen.pokefuture.move.Move;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.pokemon.type.Type;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;

public final class EvolutionDetail {

    /**
     * The item required to cause evolution this into Pokémon species.
     */
    @FetchAs(Item.class)
    @JsonProperty("item")
    private NamedAPIResource<Item> item;

    /**
     * The type of event that triggers evolution into this Pokémon species.
     */
    @FetchAs(EvolutionTrigger.class)
    @JsonProperty("trigger")
    private NamedAPIResource<EvolutionTrigger> trigger;

    /**
     * The id of the gender of the evolving Pokémon species must be in order to evolve into this Pokémon species.
     */
    @JsonProperty("gender")
    private int gender;

    /**
     * The item the evolving Pokémon species must be holding during the evolution trigger event to evolve into this
     * Pokémon species.
     */
    @FetchAs(Item.class)
    @JsonProperty("held_item")
    private NamedAPIResource<Item> heldItem;

    /**
     * The move that must be known by the evolving Pokémon species during the evolution trigger event in order to evolve
     * into this Pokémon species.
     */
    @FetchAs(Move.class)
    @JsonProperty("known_move")
    private NamedAPIResource<Move> knownMove;

    /**
     * The evolving Pokémon species must know a move with this type during the evolution trigger event in order to
     * evolve into this Pokémon species.
     */
    @FetchAs(Type.class)
    @JsonProperty("known_move_type")
    private NamedAPIResource<Type> knownMoveType;

    /**
     * The location the evolution must be triggered at.
     */
    @FetchAs(Location.class)
    @JsonProperty("location")
    private NamedAPIResource<Location> location;

    /**
     * The minimum required level of the evolving Pokémon species to evolve into this Pokémon species.
     */
    @JsonProperty("min_level")
    private int minLevel;

    /**
     * The minimum required level of happiness the evolving Pokémon species to evolve into this Pokémon species.
     */
    @JsonProperty("min_happiness")
    private int minHappiness;

    /**
     * The minimum required level of beauty the evolving Pokémon species to evolve into this Pokémon species.
     */
    @JsonProperty("min_beauty")
    private int minBeauty;

    /**
     * The minimum required level of affection the evolving Pokémon species to evolve into this Pokémon species.
     */
    @JsonProperty("min_affection")
    private int minAffection;

    /**
     * Whether or not it must be raining in the overworld to cause evolution this Pokémon species.
     */
    @JsonProperty("needs_overworld_rain")
    private boolean needsOverworldRain;

    /**
     * The Pokémon species that must be in the players party in order for the evolving Pokémon species to evolve into
     * this Pokémon species.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("party_species")
    private NamedAPIResource<PokemonSpecies> partySpecies;

    /**
     * The player must have a Pokémon of this type in their party during the evolution trigger event in order for the
     * evolving Pokémon species to evolve into this Pokémon species.
     */
    @FetchAs(Type.class)
    @JsonProperty("party_type")
    private NamedAPIResource<Type> partyType;

    /**
     * The required relation between the Pokémon's Attack and Defense stats. 1 means Attack > Defense. 0 means Attack =
     * Defense. -1 means Attack < Defense.
     */
    @JsonProperty("relative_physical_stats")
    private int relativePhysicalStats;

    /**
     * The required time of day. Day or night.
     */
    @JsonProperty("time_of_day")
    private String timeOfDay;

    /**
     * Pokémon species for which this one must be traded.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("trade_species")
    private NamedAPIResource<PokemonSpecies> tradeSpecies;

    /**
     * Whether or not the 3DS needs to be turned upside-down as this Pokémon levels up.
     */
    @JsonProperty("turn_upside_down")
    private boolean turnUpsideDown;

    public EvolutionDetail() {
    }

    public NamedAPIResource<Item> getItem() {
        return item;
    }

    public void setItem(NamedAPIResource<Item> item) {
        this.item = item;
    }

    public NamedAPIResource<EvolutionTrigger> getTrigger() {
        return trigger;
    }

    public void setTrigger(NamedAPIResource<EvolutionTrigger> trigger) {
        this.trigger = trigger;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public NamedAPIResource<Item> getHeldItem() {
        return heldItem;
    }

    public void setHeldItem(NamedAPIResource<Item> heldItem) {
        this.heldItem = heldItem;
    }

    public NamedAPIResource<Move> getKnownMove() {
        return knownMove;
    }

    public void setKnownMove(NamedAPIResource<Move> knownMove) {
        this.knownMove = knownMove;
    }

    public NamedAPIResource<Type> getKnownMoveType() {
        return knownMoveType;
    }

    public void setKnownMoveType(NamedAPIResource<Type> knownMoveType) {
        this.knownMoveType = knownMoveType;
    }

    public NamedAPIResource<Location> getLocation() {
        return location;
    }

    public void setLocation(NamedAPIResource<Location> location) {
        this.location = location;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMinHappiness() {
        return minHappiness;
    }

    public void setMinHappiness(int minHappiness) {
        this.minHappiness = minHappiness;
    }

    public int getMinBeauty() {
        return minBeauty;
    }

    public void setMinBeauty(int minBeauty) {
        this.minBeauty = minBeauty;
    }

    public int getMinAffection() {
        return minAffection;
    }

    public void setMinAffection(int minAffection) {
        this.minAffection = minAffection;
    }

    public boolean isNeedsOverworldRain() {
        return needsOverworldRain;
    }

    public void setNeedsOverworldRain(boolean needsOverworldRain) {
        this.needsOverworldRain = needsOverworldRain;
    }

    public NamedAPIResource<PokemonSpecies> getPartySpecies() {
        return partySpecies;
    }

    public void setPartySpecies(NamedAPIResource<PokemonSpecies> partySpecies) {
        this.partySpecies = partySpecies;
    }

    public NamedAPIResource<Type> getPartyType() {
        return partyType;
    }

    public void setPartyType(NamedAPIResource<Type> partyType) {
        this.partyType = partyType;
    }

    public int getRelativePhysicalStats() {
        return relativePhysicalStats;
    }

    public void setRelativePhysicalStats(int relativePhysicalStats) {
        this.relativePhysicalStats = relativePhysicalStats;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public NamedAPIResource<PokemonSpecies> getTradeSpecies() {
        return tradeSpecies;
    }

    public void setTradeSpecies(NamedAPIResource<PokemonSpecies> tradeSpecies) {
        this.tradeSpecies = tradeSpecies;
    }

    public boolean isTurnUpsideDown() {
        return turnUpsideDown;
    }

    public void setTurnUpsideDown(boolean turnUpsideDown) {
        this.turnUpsideDown = turnUpsideDown;
    }

    @Override
    public String toString() {
        return "EvolutionDetail{" +
                "item=" + item +
                ", trigger=" + trigger +
                ", gender=" + gender +
                ", heldItem=" + heldItem +
                ", knownMove=" + knownMove +
                ", knownMoveType=" + knownMoveType +
                ", location=" + location +
                ", minLevel=" + minLevel +
                ", minHappiness=" + minHappiness +
                ", minBeauty=" + minBeauty +
                ", minAffection=" + minAffection +
                ", needsOverworldRain=" + needsOverworldRain +
                ", partySpecies=" + partySpecies +
                ", partyType=" + partyType +
                ", relativePhysicalStats=" + relativePhysicalStats +
                ", timeOfDay='" + timeOfDay + '\'' +
                ", tradeSpecies=" + tradeSpecies +
                ", turnUpsideDown=" + turnUpsideDown +
                '}';
    }
}
