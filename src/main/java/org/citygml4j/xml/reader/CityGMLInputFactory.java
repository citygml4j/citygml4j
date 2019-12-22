package org.citygml4j.xml.reader;

import org.citygml4j.CityGMLContext;
import org.citygml4j.xml.schema.CityGMLSchemaHandler;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xmlobjects.schema.SchemaHandlerException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;
import org.xmlobjects.util.Properties;

import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Path;

public class CityGMLInputFactory {
    public static final String FAIL_ON_MISSING_ADE_SCHEMA = "org.citygml4j.failOnMissingADESchema";

    private final CityGMLContext context;
    private final XMLReaderFactory factory;

    private TransformerPipeline transformer;

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

    public TransformerPipeline getTransformer() {
        return transformer;
    }

    public CityGMLInputFactory withTransformer(TransformerPipeline transformer) {
        this.transformer = transformer;
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
            validate();
            return createReader(factory.createReader(file));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(Path path) throws CityGMLReadException {
        try {
            validate();
            return createReader(factory.createReader(path));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(InputStream stream) throws CityGMLReadException {
        try {
            validate();
            return createReader(factory.createReader(stream));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(InputStream stream, String encoding) throws CityGMLReadException {
        try {
            validate();
            return createReader(factory.createReader(stream, encoding));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(String systemId, InputStream stream) throws CityGMLReadException {
        try {
            validate();
            return createReader(factory.createReader(systemId, stream));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(String systemId, InputStream stream, String encoding) throws CityGMLReadException {
        try {
            validate();
            return createReader(factory.createReader(systemId, stream, encoding));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(Reader reader) throws CityGMLReadException {
        try {
            validate();
            return createReader(factory.createReader(reader));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(String systemId, Reader reader) throws CityGMLReadException {
        try {
            validate();
            return createReader(factory.createReader(systemId, reader));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(Source source) throws CityGMLReadException {
        try {
            validate();
            return createReader(factory.createReader(source));
        } catch (SchemaHandlerException | XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public CityGMLReader createCityGMLReader(XMLStreamReader reader) throws CityGMLReadException {
        try {
            validate();
            return createReader(factory.createReader(reader));
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
            CityGMLReader reader = new CityGMLSimpleReader(xmlReader, factory);
            reader.transformer = transformer != null ? new TransformerPipeline(transformer) : null;

            return reader;
        } catch (TransformerConfigurationException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    private void validate() throws SchemaHandlerException {
        if (isCreateGenericADEContent() && getSchemaHandler() == null)
            factory.withSchemaHandler(context.getDefaultSchemaHandler());
    }
}
