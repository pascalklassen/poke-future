package io.github.pascalklassen.pokefuture.utility.language;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Languages for translations of API resource information.
 *
 * https://pokeapi.co/api/v2/language/{id or name}/
 */
@ResourceEntity
public final class Language {

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
     * Whether or not the games are published in this language.
     */
    @JsonProperty("official")
    private boolean official;

    /**
     * The two-letter code of the country where this language is spoken. Note that it is not unique.
     */
    @JsonProperty("iso639")
    private String iso639;

    /**
     * The two-letter code of the language. Note that it is not unique.
     */
    @JsonProperty("iso3166")
    private String iso3166;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    List<Name> names;

    public Language() {
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

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public String getIso639() {
        return iso639;
    }

    public void setIso639(String iso639) {
        this.iso639 = iso639;
    }

    public String getIso3166() {
        return iso3166;
    }

    public void setIso3166(String iso3166) {
        this.iso3166 = iso3166;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", official=" + official +
                ", iso639='" + iso639 + '\'' +
                ", iso3166='" + iso3166 + '\'' +
                ", names=" + names +
                '}';
    }

    public static Future<Language> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Language.class, String.format("/language/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Language>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Language>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Language.class, String.format("/language?limit=%s&offset=%s", limit, offset));
    }

}
