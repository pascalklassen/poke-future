package io.github.pascalklassen.pokefuture.pokemon.growth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.pokemon.species.PokemonSpecies;
import io.github.pascalklassen.pokefuture.utility.common.Description;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Growth rates are the speed with which Pokémon gain levels through experience. Check out
 * <a href="https://bulbapedia.bulbagarden.net/wiki/Experience">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/growth-rate/{id or name}/
 */
@ResourceEntity
public final class GrowthRate {

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
     * The formula used to calculate the rate at which the Pokémon species gains level.
     */
    @JsonProperty("formula")
    private String formula;

    /**
     * The descriptions of this characteristic listed in different languages.
     */
    @JsonProperty("descriptions")
    private List<Description> descriptions;

    /**
     * A list of levels and the amount of experienced needed to atain them based on this growth rate.
     */
    @JsonProperty("levels")
    private List<GrowthRateExperienceLevel> levels;

    /**
     * A list of Pokémon species that gain levels at this growth rate.
     */
    @FetchAs(PokemonSpecies.class)
    @JsonProperty("pokemon_species")
    private List<NamedAPIResource<PokemonSpecies>> pokemonSpecies;

    public GrowthRate() {
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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public List<GrowthRateExperienceLevel> getLevels() {
        return levels;
    }

    public void setLevels(List<GrowthRateExperienceLevel> levels) {
        this.levels = levels;
    }

    public List<NamedAPIResource<PokemonSpecies>> getPokemonSpecies() {
        return pokemonSpecies;
    }

    public void setPokemonSpecies(List<NamedAPIResource<PokemonSpecies>> pokemonSpecies) {
        this.pokemonSpecies = pokemonSpecies;
    }

    @Override
    public String toString() {
        return "GrowthRate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", formula='" + formula + '\'' +
                ", descriptions=" + descriptions +
                ", levels=" + levels +
                ", pokemonSpecies=" + pokemonSpecies +
                '}';
    }

    public static Future<GrowthRate> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(GrowthRate.class, String.format("/growth-rate/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<GrowthRate>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<GrowthRate>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(GrowthRate.class, String.format("/growth-rate?limit=%s&offset=%s", limit, offset));
    }

}
