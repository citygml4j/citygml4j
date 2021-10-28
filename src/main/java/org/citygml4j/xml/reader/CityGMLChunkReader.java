/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.module.gml.GMLCoreModule;
import org.citygml4j.xml.module.gml.XLinkModule;
import org.xml.sax.SAXException;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.util.id.IdCreator;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class CityGMLChunkReader extends CityGMLReader {
    private final ChunkingOptions chunkingOptions;
    private final IdCreator idCreator;
    private final XMLReaderFactory factory;
    private final XMLStreamReader streamReader;
    private final Deque<CityGMLChunk> chunks;

    private CityGMLChunk current;
    private boolean hasNext = false;
    private int skipUntil = 0;

    public CityGMLChunkReader(XMLReader reader, ChunkingOptions chunkingOptions, IdCreator idCreator, XMLReaderFactory factory) {
        super(reader);
        this.chunkingOptions = chunkingOptions;
        this.idCreator = idCreator;
        this.factory = factory;

        streamReader = reader.getStreamReader();
        chunks = new ArrayDeque<>();
    }

    @Override
    public boolean hasNext() throws CityGMLReadException {
        if (!hasNext) {
            try {
                XMLObjects xmlObjects = reader.getXMLObjects();
                boolean initialize = false;

                while (streamReader.hasNext()) {
                    int eventType = streamReader.next();

                    if (skipUntil == 0 && eventType == XMLStreamConstants.START_ELEMENT) {
                        ObjectBuilder<AbstractFeature> builder = xmlObjects.getBuilder(reader.getName(), AbstractFeature.class);
                        if (builder != null && shouldChunk(reader.getName())) {
                            if (current == null)
                                current = new CityGMLChunk(reader.getName(), factory, resolver);
                            else {
                                chunks.push(current);
                                current = new CityGMLChunk(reader.getName(), factory, current, resolver);
                                initialize = true;
                            }
                        }
                    } else if (skipUntil > 0
                            && eventType == XMLStreamConstants.END_ELEMENT
                            && skipUntil == reader.getDepth() + 1)
                        skipUntil = 0;

                    if (current != null) {
                        current.bufferEvent(streamReader);

                        if (initialize) {
                            setXLink();
                            initialize = false;
                        } else if (current.isComplete()) {
                            if (filter != null && !filter.accept(current.getFirstElement()))
                                current = !chunks.isEmpty() ? chunks.pop() : null;
                            else {
                                hasNext = !chunks.isEmpty()
                                        || !chunkingOptions.isSkipCityModel()
                                        || !"CityModel".equals(current.getFirstElement().getLocalPart())
                                        || !CityGMLModules.isCityGMLNamespace(current.getFirstElement().getNamespaceURI());
                                break;
                            }
                        }
                    }
                }
            } catch (XMLReadException | XMLStreamException | SAXException e) {
                throw new CityGMLReadException("Caused by:", e);
            }
        }

        return hasNext;
    }

    @Override
    public AbstractFeature next() throws CityGMLReadException {
        if (hasNext()) {
            try {
                return nextChunk().build(true);
            } finally {
                hasNext = false;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public CityGMLChunk nextChunk() throws CityGMLReadException {
        if (hasNext()) {
            try {
                CityGMLChunk next = current;
                current = !chunks.isEmpty() ? chunks.pop() : null;

                if (transformer != null)
                    next.transform(transformer);

                return next;
            } catch (TransformerException e) {
                throw new CityGMLReadException("Caused by:", e);
            } finally {
                hasNext = false;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public boolean hasParentInfo() {
        try {
            return getParentInfo() != null;
        } catch (CityGMLReadException e) {
            return false;
        }
    }

    @Override
    public FeatureInfo getParentInfo() throws CityGMLReadException {
        return current != null ? current.getFeatureInfo() : null;
    }

    @Override
    public void close() throws CityGMLReadException {
        try {
            super.close();
        } finally {
            current = null;
            chunks.clear();
        }
    }

    private boolean shouldChunk(QName name) {
        if (current != null) {
            QName property = current.getLastElement();
            if (!chunkingOptions.isChunkByFeatures()
                    && !chunkingOptions.isChunkAtFeatureProperty(property.getNamespaceURI(), property.getLocalPart()))
                return false;

            if (chunkingOptions.isKeepInlineAppearance()
                    && name.getLocalPart().equals("Appearance")
                    && CityGMLModules.isCityGMLNamespace(name.getNamespaceURI())
                    && (!property.getLocalPart().equals("appearanceMember")
                    || !CityGMLModules.isCityGMLNamespace(property.getNamespaceURI()))) {
                skipUntil = reader.getDepth();
                return false;
            }
        }

        return !chunkingOptions.isExcludeFeatureFromChunking(name.getNamespaceURI(), name.getLocalPart());
    }

    private void setXLink() {
        String gmlId = null;
        for (int i = 0; i < streamReader.getAttributeCount(); i++) {
            if (streamReader.getAttributeLocalName(i).equals("id")) {
                gmlId = streamReader.getAttributeValue(i);
                break;
            }
        }

        if (gmlId == null) {
            gmlId = idCreator.createId();
            current.getSAXBuffer().addAttribute(GMLCoreModule.v3_1.getNamespaceURI(), "id", "gml:id", "CDATA", gmlId);
            current.getSAXBuffer().addAttribute(GMLCoreModule.v3_2.getNamespaceURI(), "id", "gml:id", "CDATA", gmlId);
        }

        chunks.getFirst().getSAXBuffer().removeTrailingCharacters();
        chunks.getFirst().getSAXBuffer().addAttribute(XLinkModule.v1_0.getNamespaceURI(), "href", "xlink:href", "CDATA", "#" + gmlId);
    }
}
