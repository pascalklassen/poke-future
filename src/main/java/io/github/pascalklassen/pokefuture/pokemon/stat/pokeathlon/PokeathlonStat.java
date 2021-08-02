package io.github.pascalklassen.pokefuture.pokemon.stat.pokeathlon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Pokeathlon Stats are different attributes of a Pokémon's performance in Pokéathlons. In Pokéathlons, competitions
 * happen on different courses; one for each of the different Pokéathlon stats. See
 * <a href="http://bulbapedia.bulbagarden.net/wiki/Pok%C3%A9athlon">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/pokeathlon-stat/{id or name}/
 */
@ResourceEntity
public final class PokeathlonStat {

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
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A detail of natures which affect this Pokéathlon stat positively or negatively.
     */
    @JsonProperty("affecting_natures")
    private NaturePokeathlonStatAffectSets affectingNatures;

    public PokeathlonStat() {
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

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public NaturePokeathlonStatAffectSets getAffectingNatures() {
        return affectingNatures;
    }

    public void setAffectingNatures(NaturePokeathlonStatAffectSets affectingNatures) {
        this.affectingNatures = affectingNatures;
    }

    @Override
    public String toString() {
        return "PokeathlonStat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", names=" + names +
                ", affectingNatures=" + affectingNatures +
                '}';
    }

    public static Future<PokeathlonStat> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(PokeathlonStat.class, String.format("/pokeathlon-stat/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<PokeathlonStat>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<PokeathlonStat>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(PokeathlonStat.class, String.format("/pokeathlon-stat?limit=%s&offset=%s", limit, offset));
    }

}
