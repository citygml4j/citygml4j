package org.citygml4j.xml.reader;

import org.citygml4j.CityGMLContext;
import org.citygml4j.util.DefaultIdCreator;
import org.citygml4j.util.IdCreator;
import org.citygml4j.xml.schema.CityGMLSchemaHandler;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xmlobjects.schema.SchemaHandlerException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CityGMLInputFactory {
    public static final String FAIL_ON_MISSING_ADE_SCHEMA = "org.citygml4j.failOnMissingADESchema";

    private final CityGMLContext context;
    private final XMLReaderFactory factory;

    private ChunkMode chunkMode = ChunkMode.NO_CHUNKING;
    private boolean keepInlineAppearance = true;
    private Set<QName> excludes = new HashSet<>();
    private Set<QName> properties = new HashSet<>();
    private TransformerPipeline transformer;
    private IdCreator idCreator;

    public CityGMLInputFactory(CityGMLContext context) throws CityGMLReadException {
        this.context = context;

        try {
            factory = XMLReaderFactory.newInstance(context.getXMLObjects());
        } catch (XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLSchemaHandler getSchemaHandler() {
        return (CityGMLSchemaHandler) factory.getSchemaHandler();
    }

    public CityGMLInputFactory withSchemaHandler(CityGMLSchemaHandler schemaHandler) {
        factory.withSchemaHandler(schemaHandler);
        return this;
    }

    public boolean isCreateGenericADEContent() {
        return factory.isCreateDOMAsFallback();
    }

    public CityGMLInputFactory createGenericADEContent(boolean createGenericADEContent) {
        factory.createDOMAsFallback(createGenericADEContent);
        return this;
    }

    public boolean isFailOnMissingADESchema() {
        return factory.getProperties().getAndCompare(FAIL_ON_MISSING_ADE_SCHEMA, true);
    }

    public CityGMLInputFactory failOnMissingADESchema(boolean failOnMissingADESchema) {
        factory.withProperty(FAIL_ON_MISSING_ADE_SCHEMA, failOnMissingADESchema);
        return this;
    }

    public ChunkMode getChunkMode() {
        return chunkMode;
    }

    public CityGMLInputFactory useChunkMode(ChunkMode chunkMode) {
        this.chunkMode = Objects.requireNonNull(chunkMode, "The chunk mode must not be null.");
        return this;
    }

    public boolean isKeepInlineAppearance() {
        return keepInlineAppearance;
    }

    public CityGMLInputFactory keepInlineAppearance(boolean keepInlineAppearance) {
        this.keepInlineAppearance = keepInlineAppearance;
        return this;
    }

    public Set<QName> getExlcudesFromChunking() {
        return excludes;
    }

    public CityGMLInputFactory excludeFromChunking(QName name) {
        excludes.add(name);
        return this;
    }

    public CityGMLInputFactory excludeFromChunking(String namespaceURI, String localPart) {
        return excludeFromChunking(new QName(namespaceURI, localPart));
    }

    public Set<QName> getPropertiesForChunking() {
        return properties;
    }

    public CityGMLInputFactory chunkAtProperty(QName name) {
        properties.add(name);
        return this;
    }

    public CityGMLInputFactory chunkAtProperty(String namespaceURI, String localPart) {
        return chunkAtProperty(new QName(namespaceURI, localPart));
    }

    public TransformerPipeline getTransformer() {
        return transformer;
    }

    public CityGMLInputFactory withTransformer(TransformerPipeline transformer) {
        this.transformer = transformer;
        return this;
    }

    public IdCreator getIdCreator() {
        return idCreator;
    }

    public CityGMLInputFactory withIdCreator(IdCreator idCreator) {
        this.idCreator = idCreator;
        return this;
    }

    public XMLReporter getReporter() {
        return factory.getReporter();
    }

    public CityGMLInputFactory withReporter(XMLReporter reporter) {
        factory.withReporter(reporter);
        return this;
    }

    public XMLResolver getResolver() {
        return factory.getResolver();
    }

    public CityGMLInputFactory withResolver(XMLResolver resolver) {
        factory.withResolver(resolver);
        return this;
    }

    public Properties getProperties() {
        return factory.getProperties();
    }

    public CityGMLInputFactory withProperty(String name, Object value) {
        factory.withProperty(name, value);
        return this;
    }

    public CityGMLReader createCityGMLReader(File file) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(file));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(Path path) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(path));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(InputStream stream) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(stream));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(InputStream stream, String encoding) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(stream, encoding));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(String systemId, InputStream stream) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(systemId, stream));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(String systemId, InputStream stream, String encoding) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(systemId, stream, encoding));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(Reader reader) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(reader));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(String systemId, Reader reader) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(systemId, reader));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(Source source) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(source));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(XMLStreamReader reader) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(reader));
        } catch (SchemaHandlerException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createFilteredCityGMLReader(CityGMLReader reader, CityGMLInputFilter filter) {
        reader.filter = filter;
        return reader;
    }

    private CityGMLReader createReader(XMLReader xmlReader) throws CityGMLReadException {
        try {
            CityGMLReader reader;
            if (chunkMode == ChunkMode.NO_CHUNKING)
                reader = new CityGMLSimpleReader(xmlReader, factory);
            else {
                reader = new CityGMLChunkReader(xmlReader, chunkMode, factory)
                        .keepInlineAppearance(keepInlineAppearance)
                        .excludeFromChunking(excludes)
                        .chunkAtProperties(properties)
                        .withIdCreator(idCreator);
            }

            reader.transformer = transformer != null ? new TransformerPipeline(transformer) : null;

            return reader;
        } catch (TransformerConfigurationException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    private CityGMLInputFactory validate() throws SchemaHandlerException {
        if (isCreateGenericADEContent() && getSchemaHandler() == null)
            factory.withSchemaHandler(context.getDefaultSchemaHandler());

        if (chunkMode != ChunkMode.NO_CHUNKING && idCreator == null)
            idCreator = DefaultIdCreator.newInstance();

        return this;
    }
}
