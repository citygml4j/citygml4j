package org.citygml4j.xml.reader;

import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import javax.xml.namespace.QName;
import java.net.URI;

public abstract class CityGMLReader implements AutoCloseable {
    final XMLReader reader;

    CityGMLInputFilter filter;
    TransformerPipeline transformer;

    CityGMLReader(XMLReader reader) {
        this.reader = reader;
    }

    public abstract boolean hasNext() throws CityGMLReadException;
    public abstract AbstractFeature next() throws CityGMLReadException;
    public abstract CityGMLChunk nextChunk() throws CityGMLReadException;

    public URI getBaseURI() {
        return reader.getBaseURI();
    }

    public QName getName() {
        try {
            return reader.getName();
        } catch (XMLReadException e) {
            return null;
        }
    }

    public boolean hasParentInfo() {
        return false;
    }

    public FeatureInfo getParentInfo() throws CityGMLReadException {
        return null;
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
