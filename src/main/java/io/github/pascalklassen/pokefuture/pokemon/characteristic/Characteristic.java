package io.github.pascalklassen.pokefuture.pokemon.characteristic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.utility.common.Description;
import io.github.pascalklassen.pokefuture.utility.internal.APIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Characteristics indicate which stat contains a Pokémon's highest IV. A Pokémon's Characteristic is determined by the
 * remainder of its highest IV divided by 5 (gene_modulo). Check out
 * <a href="http://bulbapedia.bulbagarden.net/wiki/Characteristic">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/characteristic/{id}/
 */
// TODO: Characteristic["highest_stat"] NOT DOCUMENTED ON https://pokeapi.co/docs/v2#characteristics
@JsonIgnoreProperties("highest_stat")
@ResourceEntity
public final class Characteristic {

    /**
     * The identifier for this resource.
     */
    @JsonProperty("id")
    private int id;

    /**
     * The remainder of the highest stat/IV divided by 5.
     */
    @JsonProperty("gene_modulo")
    private int geneModulo;

    /**
     * The possible values of the highest stat that would result in a Pokémon recieving this characteristic when divided
     * by 5.
     */
    @JsonProperty("possible_values")
    private List<Integer> possibleValues;

    /**
     * The descriptions of this characteristic listed in different languages
     */
    @JsonProperty("descriptions")
    private List<Description> descriptions;

    public Characteristic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneModulo() {
        return geneModulo;
    }

    public void setGeneModulo(int geneModulo) {
        this.geneModulo = geneModulo;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    @Override
    public String toString() {
        return "Characteristic{" +
                "id=" + id +
                ", geneModulo=" + geneModulo +
                ", possibleValues=" + possibleValues +
                ", descriptions=" + descriptions +
                '}';
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public static Future<Characteristic> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Characteristic.class, String.format("/characteristic/%s", nameOrId));
    }

    public static Future<APIResourceList<Characteristic>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<APIResourceList<Characteristic>> fetchList(int limit, int offset) {
        return PokemonService.fetchResourceList(Characteristic.class, String.format("/characteristic?limit=%s&offset=%s", limit, offset));
    }
}
