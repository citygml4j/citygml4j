package org.citygml4j.xml.writer;

import org.citygml4j.CityGMLContext;
import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xml.sax.ContentHandler;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriterFactory;
import org.xmlobjects.util.Properties;
import org.xmlobjects.util.xml.SAXWriter;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Path;
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

    public CityGMLOutputFactory withProperty(Object value) {
        factory.withProperty(value);
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

    public CityGMLWriter createCityGMLWriter(File file, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(file, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLWriter createCityGMLWriter(Path path) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(path), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLWriter createCityGMLWriter(Path path, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(path, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLWriter createCityGMLWriter(StreamResult result) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(result), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLWriter createCityGMLWriter(StreamResult result, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(result, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLWriter createCityGMLWriter(OutputStream stream) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(stream), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLWriter createCityGMLWriter(OutputStream stream, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(stream, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLWriter createCityGMLWriter(Writer writer) throws CityGMLWriteException {
        return initialize(new CityGMLWriter(factory.createWriter(writer), version, factory));
    }

    public CityGMLWriter createCityGMLWriter(SAXWriter writer) throws CityGMLWriteException {
        return initialize(new CityGMLWriter(factory.createWriter(writer), version, factory));
    }

    public CityGMLWriter createCityGMLWriter(ContentHandler writer) throws CityGMLWriteException {
        return initialize(new CityGMLWriter(factory.createWriter(writer), version, factory));
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(File file) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(file), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(File file, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(file, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(Path path) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(path), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(Path path, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(path, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(StreamResult result) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(result), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(StreamResult result, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(result, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(OutputStream stream) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(stream), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(OutputStream stream, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(stream, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(Writer writer) throws CityGMLWriteException {
        return initialize(new CityGMLChunkWriter(factory.createWriter(writer), version, factory));
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(SAXWriter writer) throws CityGMLWriteException {
        return initialize(new CityGMLChunkWriter(factory.createWriter(writer), version, factory));
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(ContentHandler writer) throws CityGMLWriteException {
        return initialize(new CityGMLChunkWriter(factory.createWriter(writer), version, factory));
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
