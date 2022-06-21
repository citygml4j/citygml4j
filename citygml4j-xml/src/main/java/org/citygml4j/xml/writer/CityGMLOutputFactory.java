/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.writer;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.converter.DefaultSimpleMultiPointConverter;
import org.citygml4j.xml.converter.DefaultSimplePolygonConverter;
import org.citygml4j.xml.converter.DefaultSimpleRectangleConverter;
import org.citygml4j.xml.converter.DefaultSimpleTriangleConverter;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xml.sax.ContentHandler;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriterFactory;
import org.xmlobjects.util.Properties;
import org.xmlobjects.util.xml.SAXWriter;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
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

    public CityGMLOutputFactory withCityGMLVersion(CityGMLVersion version) {
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

    public CityGMLOutputFactory withDefaultCompactEncodingConverters() {
        factory.withProperty(GMLConstants.SIMPLE_POLYGON_CONVERTER, new DefaultSimplePolygonConverter());
        factory.withProperty(GMLConstants.SIMPLE_RECTANGLE_CONVERTER, new DefaultSimpleRectangleConverter());
        factory.withProperty(GMLConstants.SIMPLE_TRIANGLE_CONVERTER, new DefaultSimpleTriangleConverter());
        factory.withProperty(GMLConstants.SIMPLE_MULTI_POINT_CONVERTER,new DefaultSimpleMultiPointConverter());
        return this;
    }

    public CityGMLWriter createCityGMLWriter(File file) throws CityGMLWriteException {
        return createCityGMLWriter(file, StandardCharsets.UTF_8.name());
    }

    public CityGMLWriter createCityGMLWriter(File file, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(file, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLWriter createCityGMLWriter(Path path) throws CityGMLWriteException {
        return createCityGMLWriter(path, StandardCharsets.UTF_8.name());
    }

    public CityGMLWriter createCityGMLWriter(Path path, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(path, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLWriter createCityGMLWriter(StreamResult result) throws CityGMLWriteException {
        return createCityGMLWriter(result, StandardCharsets.UTF_8.name());
    }

    public CityGMLWriter createCityGMLWriter(StreamResult result, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLWriter(factory.createWriter(result, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLWriter createCityGMLWriter(OutputStream stream) throws CityGMLWriteException {
        return createCityGMLWriter(stream, StandardCharsets.UTF_8.name());
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
        return createCityGMLChunkWriter(file, StandardCharsets.UTF_8.name());
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(File file, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(file, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(Path path) throws CityGMLWriteException {
        return createCityGMLChunkWriter(path, StandardCharsets.UTF_8.name());
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(Path path, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(path, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(StreamResult result) throws CityGMLWriteException {
        return createCityGMLChunkWriter(result, StandardCharsets.UTF_8.name());
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(StreamResult result, String encoding) throws CityGMLWriteException {
        try {
            return initialize(new CityGMLChunkWriter(factory.createWriter(result, encoding), version, factory));
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    public CityGMLChunkWriter createCityGMLChunkWriter(OutputStream stream) throws CityGMLWriteException {
        return createCityGMLChunkWriter(stream, StandardCharsets.UTF_8.name());
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
