package org.citygml4j.xml.reader;

import org.citygml4j.xml.transform.TransformerPipeline;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import java.net.URI;

public abstract class AbstractCityGMLReader implements CityGMLReader {
    final XMLReader reader;

    CityGMLInputFilter filter;
    TransformerPipeline transformer;

    AbstractCityGMLReader(XMLReader reader) {
        this.reader = reader;
    }

    @Override
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
