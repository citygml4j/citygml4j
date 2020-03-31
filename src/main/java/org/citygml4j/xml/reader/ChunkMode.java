package org.citygml4j.xml.reader;

import java.util.EnumSet;

public enum ChunkMode {
    NO_CHUNKING,
    CHUNK_BY_FEATURES,
    CHUNK_BY_CITY_MODEL_MEMBERS,
    CHUNK_BY_FEATURE_PROPERTIES;

    static final EnumSet<ChunkMode> CHUNK_BY_PROPERTIES = EnumSet.of(CHUNK_BY_CITY_MODEL_MEMBERS, CHUNK_BY_FEATURE_PROPERTIES);
}
