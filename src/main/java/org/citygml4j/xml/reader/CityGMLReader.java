package org.citygml4j.xml.reader;

import org.citygml4j.model.CityGMLObject;

import java.net.URI;

public interface CityGMLReader extends AutoCloseable {
    boolean hasNext() throws CityGMLReadException;
    CityGMLObject next() throws CityGMLReadException;
    CityGMLChunk nextChunk() throws CityGMLReadException;
    URI getBaseURI();

    @Override
    void close() throws CityGMLReadException;
}
