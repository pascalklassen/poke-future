package io.github.pascalklassen.pokefuture.utility.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.utility.common.NamedAPIResource;
import io.github.pascalklassen.pokefuture.utility.internal.annotation.ResourceEntity;
import io.vertx.core.Future;

import java.util.List;

@ResourceEntity
public final class NamedAPIResourceList<ResourceT> extends TypeClassHolder<ResourceT> {

    @JsonProperty("count")
    private int count;

    @JsonProperty("next")
    private String next;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    private List<NamedAPIResource<ResourceT>> results;

    public NamedAPIResourceList() {
    }

    public Future<NamedAPIResourceList<ResourceT>> fetchNext() {
        if (next == null) return Future.failedFuture("next is null");
        else return PokemonService.fetchNamedResourceList(getTypeClass(), getNext(), true);
    }

    public Future<NamedAPIResourceList<ResourceT>> fetchPrevious() {
        if (previous == null) return Future.failedFuture("previous is null");
        else return PokemonService.fetchNamedResourceList(getTypeClass(), getPrevious(), true);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<NamedAPIResource<ResourceT>> getResults() {
        return results;
    }

    public void setResults(List<NamedAPIResource<ResourceT>> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "NamedAPIResourceList{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
}
