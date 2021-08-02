package com.github.pascalklassen.pokefuture;

import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RequestFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestFactory.class);

    private static WebClient client;

    public static void setClient(@NotNull WebClient newClient) {
        client = newClient;
    }

    public static HttpRequest<Buffer> newResourceRequest(@NotNull String uri) {
        return client.get(uri)
                .putHeader("accept", "application/json")
                .expect(ResponsePredicate.JSON)
                .expect(ResponsePredicate.SC_SUCCESS);
    }

    public static HttpRequest<Buffer> newRequest(@NotNull String uri) {
        return client.get(uri)
                .putHeader("accept", "application/json")
                .expect(ResponsePredicate.JSON)
                .expect(ResponsePredicate.SC_SUCCESS);
    }
}
