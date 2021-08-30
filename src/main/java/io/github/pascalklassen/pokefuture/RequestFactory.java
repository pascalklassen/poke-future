package io.github.pascalklassen.pokefuture;

import com.google.common.base.Preconditions;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RequestFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestFactory.class);

    private static final WebClient client;

    static {
        Vertx vertx = Vertx.vertx();
        client = WebClient.create(
                vertx,
                new WebClientOptions()
                        .setUserAgent("FungalfTheGrey/0.1.0")
                        .setDefaultHost("pokeapi.co")
                        .setDefaultPort(443)
                        .setSsl(true)
                        .setKeepAlive(false)
        );
        Runtime.getRuntime().addShutdownHook(new Thread(client::close));
    }

    public static HttpRequest<Buffer> newResourceRequest(@NotNull String uri) {
        Preconditions.checkNotNull(uri);

        return client.get(uri)
                .putHeader("accept", "application/json")
                .expect(ResponsePredicate.JSON)
                .expect(ResponsePredicate.SC_SUCCESS);
    }

    public static HttpRequest<Buffer> newRequest(@NotNull String uri) {
        Preconditions.checkNotNull(uri);

        return client.get(uri)
                .putHeader("accept", "application/json")
                .expect(ResponsePredicate.JSON)
                .expect(ResponsePredicate.SC_SUCCESS);
    }
}
