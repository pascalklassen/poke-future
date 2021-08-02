package io.github.pascalklassen.pokefuture.pokemon.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.game.versiongroup.VersionGroup;
import io.github.pascalklassen.pokefuture.pokemon.Pokemon;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Some Pokémon may appear in one of multiple, visually different forms. These differences are purely cosmetic. For
 * variations within a Pokémon species, which do differ in more than just visuals, the 'Pokémon' entity is used to
 * represent such a variety.
 *
 * GET https://pokeapi.co/api/v2/pokemon-form/{id or name}/
 */
// TODO: PokemonForm["types"] NOT DOCUMENTED ON https://pokeapi.co/docs/v2#pokemon-forms
@ResourceEntity
@JsonIgnoreProperties("types")
public final class PokemonForm {

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
     * The order in which forms should be sorted within all forms. Multiple forms may have equal order, in which case
     * they should fall back on sorting by name.
     */
    @JsonProperty("order")
    private int order;

    /**
     * The order in which forms should be sorted within a species' forms.
     */
    @JsonProperty("form_order")
    private int formOrder;

    /**
     * True for exactly one form used as the default for each Pokémon.
     */
    @JsonProperty("is_default")
    private boolean isDefault;

    /**
     * Whether or not this form can only happen during battle.
     */
    @JsonProperty("is_battle_only")
    private boolean isBattleOnly;

    /**
     * Whether or not this form requires mega evolution.
     */
    @JsonProperty("is_mega")
    private boolean isMega;

    /**
     * The name of this form.
     */
    @JsonProperty("form_name")
    private String formName;

    /**
     * The Pokémon that can take on this form.
     */
    @FetchAs(Pokemon.class)
    @JsonProperty("pokemon")
    private NamedAPIResource<Pokemon> pokemon;

    /**
     * A set of sprites used to depict this Pokémon form in the game.
     */
    @JsonProperty("sprites")
    private PokemonFormSprites sprites;

    /**
     * The version group this Pokémon form was introduced in.
     */
    @FetchAs(VersionGroup.class)
    @JsonProperty("version_group")
    private NamedAPIResource<VersionGroup> versionGroup;

    /**
     * The form specific full name of this Pokémon form, or empty if the form does not have a specific name.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * The form specific form name of this Pokémon form, or empty if the form does not have a specific name.
     */
    @JsonProperty("form_names")
    private List<Name> formNames;

    public PokemonForm() {
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getFormOrder() {
        return formOrder;
    }

    public void setFormOrder(int formOrder) {
        this.formOrder = formOrder;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isBattleOnly() {
        return isBattleOnly;
    }

    public void setBattleOnly(boolean battleOnly) {
        isBattleOnly = battleOnly;
    }

    public boolean isMega() {
        return isMega;
    }

    public void setMega(boolean mega) {
        isMega = mega;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public NamedAPIResource<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(NamedAPIResource<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public PokemonFormSprites getSprites() {
        return sprites;
    }

    public void setSprites(PokemonFormSprites sprites) {
        this.sprites = sprites;
    }

    public NamedAPIResource<VersionGroup> getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(NamedAPIResource<VersionGroup> versionGroup) {
        this.versionGroup = versionGroup;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<Name> getFormNames() {
        return formNames;
    }

    public void setFormNames(List<Name> formNames) {
        this.formNames = formNames;
    }

    @Override
    public String toString() {
        return "PokemonForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", formOrder=" + formOrder +
                ", isDefault=" + isDefault +
                ", isBattleOnly=" + isBattleOnly +
                ", isMega=" + isMega +
                ", formName='" + formName + '\'' +
                ", pokemon=" + pokemon +
                ", sprites=" + sprites +
                ", versionGroup=" + versionGroup +
                ", names=" + names +
                ", formNames=" + formNames +
                '}';
    }

    public static Future<PokemonForm> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(PokemonForm.class, String.format("/pokemon-form/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<PokemonForm>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<PokemonForm>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(PokemonForm.class, String.format("/pokemon-form?limit=%s&offset=%s", limit, offset));
    }
}
