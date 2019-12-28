package org.citygml4j.xml.writer;

import org.citygml4j.CityGMLContext;
import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriterFactory;
import org.xmlobjects.util.Properties;

import javax.xml.transform.TransformerConfigurationException;
import java.io.File;
import java.util.Objects;

public class CityGMLOutputFactory {
    private final XMLWriterFactory factory;

    private CityGMLVersion version;
    private TransformerPipeline transformer;

    public CityGMLOutputFactory(CityGMLVersion version, CityGMLContext context) {
        this.version = version;
        factory = XMLWriterFactory.newInstance(context.getXMLObjects());
    }

    public CityGMLVersion getVersion() {
        return version;
    }

    public CityGMLOutputFactory useCityGMLVersion(CityGMLVersion version) {
        this.version = Objects.requireNonNull(version, "The CityGML version must not be null.");
        return this;
    }

    public Properties getProperties() {
        return factory.getProperties();
    }

    public CityGMLOutputFactory withProperty(String name, Object value) {
        factory.withProperty(name, value);
        return this;
    }

    public TransformerPipeline getTransformer() {
        return transformer;
    }

    public CityGMLOutputFactory withTransformer(TransformerPipeline transformer) {
        this.transformer = transformer;
        return this;
    }

    public CityGMLWriter createCityGMLWriter(File file) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(file), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    private <T extends AbstractCityGMLWriter<?>> T initialize(T writer) throws CityGMLWriteException {
        try {
            writer.transformer = transformer != null ? new TransformerPipeline(transformer) : null;
            return writer;
        } catch (TransformerConfigurationException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }
}
