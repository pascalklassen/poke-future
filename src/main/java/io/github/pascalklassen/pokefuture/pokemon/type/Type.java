package io.github.pascalklassen.pokefuture.pokemon.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.move.Move;
import com.google.common.base.Preconditions;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.game.generation.Generation;
import io.github.pascalklassen.pokefuture.move.damageclass.MoveDamageClass;
import io.github.pascalklassen.pokefuture.utility.common.GenerationGameIndex;
import io.github.pascalklassen.pokefuture.utility.common.Name;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.NamedAPIResourceList;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.FetchAs;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Types are properties for Pokémon and their moves. Each type has three properties: which types of Pokémon it is super
 * effective against, which types of Pokémon it is not very effective against, and which types of Pokémon it is
 * completely ineffective against.
 *
 * GET https://pokeapi.co/api/v2/type/{id or name}/
 */
@ResourceEntity
public final class Type {

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
     * A detail of how effective this type is toward others and vice versa.
     */
    @JsonProperty("damage_relations")
    private TypeRelations damageRelations;

    /**
     * A list of game indices relevent to this item by generation.
     */
    @JsonProperty("game_indices")
    private List<GenerationGameIndex> gameIndices;

    /**
     * The generation this type was introduced in.
     */
    @FetchAs(Generation.class)
    @JsonProperty("generation")
    private NamedAPIResource<Generation> generation;

    /**
     * The class of damage inflicted by this type.
     */
    @FetchAs(MoveDamageClass.class)
    @JsonProperty("move_damage_class")
    private NamedAPIResource<MoveDamageClass> moveDamageClass;

    /**
     * The name of this resource listed in different languages.
     */
    @JsonProperty("names")
    private List<Name> names;

    /**
     * A list of details of Pokémon that have this type.
     */
    @JsonProperty("pokemon")
    private List<TypePokemon> pokemons;

    /**
     * A list of moves that have this type.
     */
    @FetchAs(Move.class)
    @JsonProperty("moves")
    private List<NamedAPIResource<Move>> moves;

    public Type() {
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

    public TypeRelations getDamageRelations() {
        return damageRelations;
    }

    public void setDamageRelations(TypeRelations damageRelations) {
        this.damageRelations = damageRelations;
    }

    public List<GenerationGameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GenerationGameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public NamedAPIResource<Generation> getGeneration() {
        return generation;
    }

    public void setGeneration(NamedAPIResource<Generation> generation) {
        this.generation = generation;
    }

    public NamedAPIResource<MoveDamageClass> getMoveDamageClass() {
        return moveDamageClass;
    }

    public void setMoveDamageClass(NamedAPIResource<MoveDamageClass> moveDamageClass) {
        this.moveDamageClass = moveDamageClass;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<TypePokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<TypePokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<NamedAPIResource<Move>> getMoves() {
        return moves;
    }

    public void setMoves(List<NamedAPIResource<Move>> moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damageRelations=" + damageRelations +
                ", gameIndices=" + gameIndices +
                ", generation=" + generation +
                ", moveDamageClass=" + moveDamageClass +
                ", names=" + names +
                ", pokemons=" + pokemons +
                ", moves=" + moves +
                '}';
    }

    public static Future<Type> fetch(@NotNull String nameOrId) {
        Preconditions.checkNotNull(nameOrId);
        return PokemonService.fetchAs(Type.class, String.format("/type/%s", nameOrId));
    }

    public static Future<NamedAPIResourceList<Type>> fetchList() {
        return fetchList(100, 0);
    }

    public static Future<NamedAPIResourceList<Type>> fetchList(int limit, int offset) {
        return PokemonService.fetchNamedResourceList(Type.class, String.format("/type?limit=%s&offset=%s", limit, offset));
    }
}
