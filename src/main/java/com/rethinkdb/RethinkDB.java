package com.rethinkdb;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rethinkdb.gen.model.TopLevel;
import com.rethinkdb.net.Connection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URI;

/**
 * Your entry point to interacting with RethinkDB.
 */
public class RethinkDB extends TopLevel {
    /**
     * The Singleton to use to begin interacting with RethinkDB Driver.
     */
    public static final RethinkDB r = new RethinkDB();
    /**
     * Jackson's {@link ObjectMapper} for handling {@link com.rethinkdb.net.Result}'s values.
     */
    private static ObjectMapper resultMapper;

    /**
     * Gets (or creates, if null) the {@link ObjectMapper} for handling {@link com.rethinkdb.net.Result}'s values.
     *
     * @return the {@link com.rethinkdb.net.Result}'s {@link ObjectMapper}.
     */
    public synchronized static @NotNull ObjectMapper getResultMapper() {
        ObjectMapper mapper = resultMapper;
        if (mapper == null) {
            mapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            resultMapper = mapper;
        }
        return mapper;
    }

    /**
     * Sets the {@link ObjectMapper} for handling {@link com.rethinkdb.net.Result}'s values.
     *
     * @param mapper an {@link ObjectMapper}, or null.
     */
    public synchronized static void setResultMapper(@Nullable ObjectMapper mapper) {
        resultMapper = mapper;
    }

    /**
     * Creates a new connection builder.
     *
     * @return a newly created {@link Connection.Builder}.
     */
    public @NotNull Connection.Builder connection() {
        return new Connection.Builder();
    }

    /**
     * Creates a new connection builder and configures it with a db-url.
     *
     * @param dburl the db-url to configure the builder.
     * @return a newly created {@link Connection.Builder}.
     */
    public @NotNull Connection.Builder connection(@NotNull String dburl) {
        return connection(URI.create(dburl));
    }

    /**
     * Creates a new connection builder and configures it with a db-url.
     *
     * @param uri the db-url to configure the builder.
     * @return a newly created {@link Connection.Builder}.
     */
    public @NotNull Connection.Builder connection(@NotNull URI uri) {
        return new Connection.Builder(uri);
    }

    /**
     * Copies a connection builder.
     *
     * @param b the original builder.
     * @return a copy of the {@link Connection.Builder}.
     */
    public @NotNull Connection.Builder connection(Connection.Builder b) {
        return new Connection.Builder(b);
    }

}
