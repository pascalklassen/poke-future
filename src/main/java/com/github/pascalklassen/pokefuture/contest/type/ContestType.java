package com.github.pascalklassen.pokefuture.contest.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.berry.flavor.BerryFlavor;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Contest types are categories judges used to weigh a Pokémon's condition in Pokémon contests. Check out
 * <a href="https://bulbapedia.bulbagarden.net/wiki/Contest_condition">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/contest-type/{id or name}/
 */
@ResourceEntity
public final class ContestType {

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
     * The berry flavor that correlates with this contest type.
     */
    @FetchAs(BerryFlavor.class)
    @JsonProperty("berry_flavor")
    private NamedAPIResource<BerryFlavor> berryFlavor;

    /**
     * The name of this contest type listed in different languages.
     */
    @JsonProperty("names")
    private List<ContestName> contestName;

    public ContestType() {
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

    public NamedAPIResource<BerryFlavor> getBerryFlavor() {
        return berryFlavor;
    }

    public void setBerryFlavor(NamedAPIResource<BerryFlavor> berryFlavor) {
        this.berryFlavor = berryFlavor;
    }

    public List<ContestName> getContestName() {
        return contestName;
    }

    public void setContestName(List<ContestName> contestName) {
        this.contestName = contestName;
    }

    @Override
    public String toString() {
        return "ContestType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", berryFlavor=" + berryFlavor +
                ", contestName=" + contestName +
                '}';
    }

    public static Future<ContestType> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(ContestType.class, String.format("/contest-type/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<ContestType>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<ContestType>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(ContestType.class, String.format("/contest-type?limit=%s&offset=%s", limit, offset));
    }
}
