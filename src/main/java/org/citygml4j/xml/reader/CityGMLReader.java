package org.citygml4j.xml.reader;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import java.net.URI;

public abstract class CityGMLReader implements AutoCloseable {
    final XMLReader reader;

    CityGMLInputFilter filter;
    TransformerPipeline transformer;

    CityGMLReader(XMLReader reader) {
        this.reader = reader;
    }

    public abstract boolean hasNext() throws CityGMLReadException;
    public abstract CityGMLObject next() throws CityGMLReadException;
    public abstract CityGMLChunk nextChunk() throws CityGMLReadException;

    public URI getBaseURI() {
        return reader.getBaseURI();
    }

    @Override
    public void close() throws CityGMLReadException {
        try {
            reader.close();
        } catch (XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }
}
