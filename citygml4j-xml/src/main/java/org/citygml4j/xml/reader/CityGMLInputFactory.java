/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.xml.reader;

import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.schema.CityGMLSchemaHandler;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xmlobjects.gml.util.id.DefaultIdCreator;
import org.xmlobjects.gml.util.id.IdCreator;
import org.xmlobjects.gml.util.reference.ReferenceResolver;
import org.xmlobjects.schema.SchemaHandlerException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;
import org.xmlobjects.util.Properties;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Path;
import java.util.Objects;

public class CityGMLInputFactory {
    public static final String FAIL_ON_MISSING_ADE_SCHEMA = "org.citygml4j.failOnMissingADESchema";

    private final CityGMLContext context;
    private final XMLReaderFactory factory;

    private ChunkOptions chunkOptions;
    private TransformerPipeline transformer;
    private ReferenceResolver resolver;
    private IdCreator idCreator;

    public CityGMLInputFactory(CityGMLContext context, XMLInputFactory factory) throws CityGMLReadException {
        this.context = Objects.requireNonNull(context, "CityGML context must not be null.");

        try {
            this.factory = XMLReaderFactory.newInstance(context.getXMLObjects(), factory);
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

    public ChunkOptions getChunkOptions() {
        return chunkOptions;
    }

    public CityGMLInputFactory withChunking(ChunkOptions chunkOptions) {
        this.chunkOptions = chunkOptions;
        return this;
    }

    public CityGMLInputFactory withChunking() {
        return withChunking(ChunkOptions.defaults());
    }

    public TransformerPipeline getTransformer() {
        return transformer;
    }

    public CityGMLInputFactory withTransformer(TransformerPipeline transformer) {
        this.transformer = transformer;
        return this;
    }

    public ReferenceResolver getReferenceResolver() {
        return resolver;
    }

    public CityGMLInputFactory withReferenceResolver(ReferenceResolver resolver) {
        this.resolver = resolver;
        return this;
    }

    public IdCreator getIdCreator() {
        return idCreator;
    }

    public CityGMLInputFactory withIdCreator(IdCreator idCreator) {
        this.idCreator = idCreator;
        return this;
    }

    public XMLReporter getXMLReporter() {
        return factory.getXMLReporter();
    }

    public CityGMLInputFactory withXMLReporter(XMLReporter reporter) {
        factory.withXMLReporter(reporter);
        return this;
    }

    public XMLResolver getXMLResolver() {
        return factory.getXMLResolver();
    }

    public CityGMLInputFactory withXMLResolver(XMLResolver resolver) {
        factory.withXMLResolver(resolver);
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

    public CityGMLReader createCityGMLReader(File file, String encoding) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(file, encoding));
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

    public CityGMLReader createCityGMLReader(Path path, String encoding) throws CityGMLReadException {
        try {
            return validate().createReader(factory.createReader(path, encoding));
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
            CityGMLReader reader = chunkOptions == null ?
                    new CityGMLSimpleReader(xmlReader, factory) :
                    new CityGMLChunkReader(xmlReader, chunkOptions, idCreator, factory, context);

            reader.transformer = transformer != null ? new TransformerPipeline(transformer) : null;
            reader.resolver = resolver;

            return reader;
        } catch (TransformerConfigurationException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    private CityGMLInputFactory validate() throws SchemaHandlerException {
        if (isCreateGenericADEContent() && getSchemaHandler() == null)
            factory.withSchemaHandler(context.getDefaultSchemaHandler());

        if (chunkOptions != null && idCreator == null)
            idCreator = DefaultIdCreator.getInstance();

        return this;
    }
}
