package com.github.pascalklassen.pokefuture.berry.firmness;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.github.pascalklassen.pokefuture.PokemonService;
import com.github.pascalklassen.pokefuture.berry.Berry;
import com.github.pascalklassen.pokefuture.utility.common.Name;
import com.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import com.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import com.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Berries can be soft or hard. Check out
 * <a href="http://bulbapedia.bulbagarden.net/wiki/Category:Berries_by_firmness">Bulbapedia</a> for greater detail.
 *
 * GET https://pokeapi.co/api/v2/berry-firmness/{id or name}/
 */
@ResourceEntity
public final class BerryFirmness {

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
     * A list of the berries with this firmness.
     */
    @FetchAs(Berry.class)
    @JsonProperty("berries")
    private List<NamedAPIResource<Berry>> berries;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    public BerryFirmness() {
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

    public List<NamedAPIResource<Berry>> getBerries() {
        return berries;
    }

    public void setBerries(List<NamedAPIResource<Berry>> berries) {
        this.berries = berries;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "BerryFirmness{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", berries=" + berries +
                ", names=" + names +
                '}';
    }

    public static Future<BerryFirmness> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(BerryFirmness.class, String.format("/berry-firmness/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<BerryFirmness>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<BerryFirmness>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(BerryFirmness.class, String.format("/berry-firmness?limit=%s&offset=%s", limit, offset));
    }

}
