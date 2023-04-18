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

import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.common.LocalProperties;
import org.xmlobjects.gml.util.reference.ReferenceResolver;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;
import org.xmlobjects.util.xml.SAXBuffer;
import org.xmlobjects.util.xml.StAXStream2SAX;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import javax.xml.transform.sax.SAXResult;

public class CityGMLChunk {
    private final QName firstElement;
    private final XMLReaderFactory factory;
    private final CityGMLChunk parent;
    private final ReferenceResolver resolver;

    private FeatureInfo featureInfo;
    private SAXBuffer buffer;
    private StAXStream2SAX mapper;
    private QName lastElement;
    private int depth = 0;
    private LocalProperties localProperties;

    CityGMLChunk(QName firstElement, XMLReaderFactory factory, CityGMLChunk parent, ReferenceResolver resolver) {
        this.firstElement = lastElement = firstElement;
        this.factory = factory;
        this.parent = parent;
        this.resolver = resolver;

        buffer = new SAXBuffer().assumeMixedContent(false);
        mapper = new StAXStream2SAX(buffer);
    }

    CityGMLChunk(QName firstElement, XMLReaderFactory factory, ReferenceResolver resolver) {
        this(firstElement, factory, null, resolver);
    }

    boolean isComplete() {
        return depth == 0 && !buffer.isEmpty();
    }

    void bufferEvent(XMLStreamReader reader) throws SAXException {
        int eventType = reader.getEventType();

        if (buffer.isEmpty() && eventType != XMLStreamConstants.START_ELEMENT)
            throw new SAXException("A START_ELEMENT is expected as first element.");
        else if (isComplete() && (eventType == XMLStreamConstants.START_ELEMENT || eventType == XMLStreamConstants.END_ELEMENT))
            throw new SAXException("Chunk is complete and cannot buffer more events.");

        mapper.bridgeEvent(reader);
        switch (eventType) {
            case XMLStreamConstants.START_ELEMENT:
                lastElement = reader.getName();
                depth++;
                break;
            case XMLStreamConstants.END_ELEMENT:
                depth--;
                break;
        }
    }

    SAXBuffer getSAXBuffer() {
        return buffer;
    }

    public QName getFirstElement() {
        return firstElement;
    }

    public QName getLastElement() {
        return lastElement;
    }

    void removeTrailingCharacters() {
        buffer.removeTrailingCharacters();
    }

    public XMLStreamReader toXMLStreamReader(boolean release) {
        return buffer.toXMLStreamReader(release);
    }

    public void send(ContentHandler handler, boolean release) throws SAXException {
        buffer.send(handler, release);
    }

    public AbstractFeature build(boolean release) throws CityGMLReadException {
        try (XMLReader reader = factory.createReader(buffer.toXMLStreamReader(release))) {
            reader.nextTag();

            AbstractFeature feature = reader.getObject(AbstractFeature.class);
            if (feature != null && resolver != null)
                resolver.resolveReferences(feature);

            return feature;
        } catch (XMLReadException | ObjectBuildException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }

    public AbstractFeature build() throws CityGMLReadException {
        return build(true);
    }

    FeatureInfo getFeatureInfo() throws CityGMLReadException {
        if (featureInfo == null) {
            try {
                FeatureInfoBuffer buffer = new FeatureInfoBuffer();
                send(buffer, false);
                buffer.complete();

                try (XMLReader reader = factory.createReader(buffer.toXMLStreamReader(true))) {
                    reader.nextTag();
                    AbstractFeature feature = reader.getObject(AbstractFeature.class);
                    if (feature != null)
                        featureInfo = new FeatureInfo(firstElement, feature, parent);
                }
            } catch (SAXException | XMLReadException | ObjectBuildException e) {
                throw new CityGMLReadException("Caused by:", e);
            }
        }

        return featureInfo;
    }

    void transform(TransformerPipeline pipeline) throws TransformerException {
        try {
            SAXBuffer buffer = new TransformerBuffer().assumeMixedContent(false);
            pipeline.setResult(new SAXResult(buffer));

            pipeline.getRootHandler().startDocument();
            send(pipeline.getRootHandler(), true);
            pipeline.getRootHandler().endDocument();

            this.buffer = buffer;
            mapper = new StAXStream2SAX(buffer);
        } catch (SAXException e) {
            throw new TransformerException("Caused by:", e);
        } finally {
            pipeline.reset();
        }
    }

    public boolean hasLocalProperties() {
        return localProperties != null && !localProperties.isEmpty();
    }

    public LocalProperties getLocalProperties() {
        if (localProperties == null)
            localProperties = new LocalProperties();

        return localProperties;
    }

    public void setLocalProperties(LocalProperties localProperties) {
        this.localProperties = localProperties;
    }

    private static class TransformerBuffer extends SAXBuffer {

        @Override
        public void startDocument() {
        }

        @Override
        public void addEndDocument() {
        }
    }

    private static class FeatureInfoBuffer extends SAXBuffer {
        int depth = 0;
        boolean shouldBuffer = true;

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            if (shouldBuffer)
                super.startPrefixMapping(prefix, uri);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (depth == 1) {
                shouldBuffer = (CityGMLModules.isGMLNamespace(uri)
                        && ("description".equals(localName)
                        || "descriptionReference".equals(localName)
                        || "identifier".equals(localName)
                        || "name".equals(localName)
                        || "metaDataProperty".equals(localName)
                        || "boundedBy".equals(localName)))
                        || (CityGMLModules.isCityGMLNamespace(uri)
                        && ("engineeringCRS".equals(localName)
                        || "appearance".equals(localName)
                        || "appearanceMember".equals(localName)));
            }

            if (shouldBuffer)
                super.startElement(uri, localName, qName, attributes);

            depth++;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (shouldBuffer)
                super.endElement(uri, localName, qName);

            depth--;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (shouldBuffer)
                super.characters(ch, start, length);
        }

        void complete() {
            while (depth-- >= 0)
                addEndElement();
        }
    }
}
