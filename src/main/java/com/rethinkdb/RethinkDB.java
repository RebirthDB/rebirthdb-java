package com.rethinkdb;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rethinkdb.gen.model.TopLevel;
import com.rethinkdb.net.Connection;

public class RethinkDB extends TopLevel {
    /**
     * The Singleton to use to begin interacting with RethinkDB Driver
     */
    public static final RethinkDB r = new RethinkDB();

    private static ObjectMapper internalMapper;
    private static ObjectMapper pojoMapper;

    public synchronized static ObjectMapper getInternalMapper() {
        ObjectMapper mapper = internalMapper;
        if (mapper == null) {
            mapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            internalMapper = mapper;
        }
        return mapper;
    }

    public synchronized static void setInternalMapper(ObjectMapper mapper) {
        internalMapper = mapper;
    }

    public synchronized static ObjectMapper getPOJOMapper() {
        ObjectMapper mapper = pojoMapper;
        if (mapper == null) {
            mapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            pojoMapper = mapper;
        }
        return mapper;
    }

    public synchronized static void setPOJOMapper(ObjectMapper mapper) {
        pojoMapper = mapper;
    }

    public Connection.Builder connection() {
        return new Connection.Builder();
    }
}
