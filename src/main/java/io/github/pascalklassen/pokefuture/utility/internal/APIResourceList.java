package io.github.pascalklassen.pokefuture.utility.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pascalklassen.pokefuture.PokemonService;
import io.github.pascalklassen.pokefuture.utility.common.APIResource;
import io.vertx.core.Future;

import java.util.List;

public final class APIResourceList<ResourceT> extends TypeClassHolder<ResourceT> {

    @JsonProperty("count")
    private int count;

    @JsonProperty("next")
    private String next;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    private List<APIResource<ResourceT>> results;

    public APIResourceList() {
    }

    public Future<APIResourceList<ResourceT>> fetchNext() {
        if (next == null) return Future.failedFuture("next is null");
        else return PokemonService.fetchResourceList(getTypeClass(), getNext(), true);
    }

    public Future<APIResourceList<ResourceT>> fetchPrevious() {
        if (previous == null) return Future.failedFuture("previous is null");
        else return PokemonService.fetchResourceList(getTypeClass(), getPrevious(), true);
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

    public List<APIResource<ResourceT>> getResults() {
        return results;
    }

    public void setResults(List<APIResource<ResourceT>> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "APIResourceList{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                ", fetchNext=" + fetchNext() +
                ", fetchPrevious=" + fetchPrevious() +
                ", typeClass=" + getTypeClass() +
                '}';
    }
}
