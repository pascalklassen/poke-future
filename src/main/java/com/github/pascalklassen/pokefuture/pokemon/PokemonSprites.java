package com.github.pascalklassen.pokefuture.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;

// TODO: PokemonSprites["other", "versions"] NOT DOCUMENTED ON https://pokeapi.co/docs/v2#pokemon
@ResourceEntity
@JsonIgnoreProperties({"other", "versions"})
public final class PokemonSprites {

    /**
     * The default depiction of this Pokémon from the front in battle.
     */
    @JsonProperty("front_default")
    private String frontDefault;

    /**
     * The shiny depiction of this Pokémon from the front in battle.
     */
    @JsonProperty("front_shiny")
    private String frontShiny;

    /**
     * The female depiction of this Pokémon from the front in battle.
     */
    @JsonProperty("front_female")
    private String frontFemale;

    /**
     * The shiny female depiction of this Pokémon from the front in battle.
     */
    @JsonProperty("front_shiny_female")
    private String frontShinyFemale;

    /**
     * The default depiction of this Pokémon from the back in battle.
     */
    @JsonProperty("back_default")
    private String backDefault;

    /**
     * The shiny depiction of this Pokémon from the back in battle.
     */
    @JsonProperty("back_shiny")
    private String backShiny;

    /**
     * The female depiction of this Pokémon from the back in battle.
     */
    @JsonProperty("back_female")
    private String backFemale;

    /**
     * The shiny female depiction of this Pokémon from the back in battle.
     */
    @JsonProperty("back_shiny_female")
    private String backShinyFemale;

    public PokemonSprites() {
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

    public String getFrontFemale() {
        return frontFemale;
    }

    public void setFrontFemale(String frontFemale) {
        this.frontFemale = frontFemale;
    }

    public String getFrontShinyFemale() {
        return frontShinyFemale;
    }

    public void setFrontShinyFemale(String frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }

    public String getBackFemale() {
        return backFemale;
    }

    public void setBackFemale(String backFemale) {
        this.backFemale = backFemale;
    }

    public String getBackShinyFemale() {
        return backShinyFemale;
    }

    public void setBackShinyFemale(String backShinyFemale) {
        this.backShinyFemale = backShinyFemale;
    }

    @Override
    public String toString() {
        return "PokemonSprites{" +
                "frontDefault='" + frontDefault + '\'' +
                ", frontShiny='" + frontShiny + '\'' +
                ", frontFemale='" + frontFemale + '\'' +
                ", frontShinyFemale='" + frontShinyFemale + '\'' +
                ", backDefault='" + backDefault + '\'' +
                ", backShiny='" + backShiny + '\'' +
                ", backFemale='" + backFemale + '\'' +
                ", backShinyFemale='" + backShinyFemale + '\'' +
                '}';
    }
}
