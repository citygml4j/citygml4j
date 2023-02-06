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

import com.sun.xml.xsom.XSAttributeDecl;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchemaSet;
import org.citygml4j.core.ade.ADERegistry;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.CityGMLADELoader;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.module.gml.GMLCoreModule;
import org.citygml4j.xml.module.gml.XLinkModule;
import org.xml.sax.SAXException;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.util.id.IdCreator;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaWalker;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import java.util.*;

public class CityGMLChunkReader extends CityGMLReader {
    private final ChunkOptions chunkOptions;
    private final IdCreator idCreator;
    private final XMLReaderFactory factory;
    private final CityGMLContext context;
    private final XMLStreamReader streamReader;

    private final Deque<CityGMLChunk> chunks = new ArrayDeque<>();
    private final Deque<QName> features = new ArrayDeque<>();
    private final Map<QName, Map<QName, Boolean>> properties = new HashMap<>();
    private final Set<String> adeNamespaces;

    private CityGMLChunk current;
    private boolean hasNext = false;
    private int skipUntil = 0;

    public CityGMLChunkReader(XMLReader reader, ChunkOptions chunkOptions, IdCreator idCreator, XMLReaderFactory factory, CityGMLContext context) {
        super(reader);
        this.chunkOptions = chunkOptions;
        this.idCreator = idCreator;
        this.factory = factory;
        this.context = context;

        streamReader = reader.getStreamReader();
        adeNamespaces = ADERegistry.getInstance().getADELoader(CityGMLADELoader.class).getADENamespaces();
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
                        if (builder != null) {
                            if (current == null) {
                                current = new CityGMLChunk(reader.getName(), factory, resolver);
                            } else if (shouldChunk(reader.getName())) {
                                chunks.push(current);
                                current = new CityGMLChunk(reader.getName(), factory, current, resolver);
                                initialize = true;
                            }

                            features.push(reader.getName());
                        }
                    } else if (eventType == XMLStreamConstants.END_ELEMENT) {
                        if (skipUntil > 0 && skipUntil == reader.getDepth() + 1) {
                            skipUntil = 0;
                        }

                        if (!features.isEmpty() && features.peek().equals(reader.getName())) {
                            features.pop();
                        }
                    }

                    if (current != null) {
                        current.bufferEvent(streamReader);

                        if (initialize) {
                            setXLink();
                            initialize = false;
                        } else if (current.isComplete()) {
                            if (filter != null && !filter.accept(current.getFirstElement())) {
                                current = !chunks.isEmpty() ? chunks.pop() : null;
                            } else {
                                hasNext = !chunks.isEmpty()
                                        || !chunkOptions.isSkipCityModel()
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
            return nextChunk().build(true);
        }

        throw new NoSuchElementException();
    }

    @Override
    public CityGMLChunk nextChunk() throws CityGMLReadException {
        if (hasNext()) {
            try {
                CityGMLChunk next = current;
                current = !chunks.isEmpty() ? chunks.pop() : null;

                if (transformer != null) {
                    next.transform(transformer);
                }

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
        if (hasNext) {
            return !chunks.isEmpty() ? chunks.peek().getFeatureInfo() : null;
        } else {
            return current != null ? current.getFeatureInfo() : null;
        }
    }

    @Override
    public void close() throws CityGMLReadException {
        try {
            super.close();
        } finally {
            current = null;
            chunks.clear();
            features.clear();
            properties.clear();
            adeNamespaces.clear();
        }
    }

    private boolean shouldChunk(QName feature) throws CityGMLReadException {
        QName property = current.getLastElement();
        if (!chunkOptions.shouldChunk(property)) {
            return false;
        }

        if (chunkOptions.isKeepInlineAppearance()
                && feature.getLocalPart().equals("Appearance")
                && CityGMLModules.isCityGMLNamespace(feature.getNamespaceURI())
                && (!property.getLocalPart().equals("appearanceMember")
                || !CityGMLModules.isCityGMLNamespace(property.getNamespaceURI()))) {
            skipUntil = reader.getDepth();
            return false;
        }

        if (adeNamespaces.contains(property.getNamespaceURI())) {
            try {
                if (!properties.computeIfAbsent(features.peek(), v -> new HashMap<>())
                        .computeIfAbsent(property, v -> hasXLink(property, features.peek()))) {
                    return false;
                }
            } catch (Throwable e) {
                throw new CityGMLReadException("Failed to parse XML schema definition of ADE " + property + ".", e);
            }
        }

        return !chunkOptions.isExcludeFeature(feature);
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

    private boolean hasXLink(QName property, QName feature) {
        try {
            SchemaHandler schemaHandler = factory.getSchemaHandler() != null ?
                    factory.getSchemaHandler() :
                    context.getDefaultSchemaHandler();

            XSElementDecl propertyDecl = null;

            // first, check if the property is declared locally inside the feature
            if (adeNamespaces.contains(feature.getNamespaceURI())) {
                XSSchemaSet schemas = schemaHandler.getSchemaSet(feature.getNamespaceURI());
                if (schemas != null) {
                    XSElementDecl featureDecl = schemas.getElementDecl(feature.getNamespaceURI(), feature.getLocalPart());
                    if (featureDecl != null) {
                        XSElementDecl[] localPropertyDecl = new XSElementDecl[1];
                        featureDecl.getType().visit(new SchemaWalker() {
                            @Override
                            public void elementDecl(XSElementDecl decl) {
                                if (decl.getName().equals(property.getLocalPart())
                                        && decl.getTargetNamespace().equals(property.getNamespaceURI())) {
                                    localPropertyDecl[0] = decl;
                                    setShouldWalk(false);
                                }
                            }
                        });

                        propertyDecl = localPropertyDecl[0];
                    }
                }
            }

            // second, check if the property is declared globally
            if (propertyDecl == null) {
                XSSchemaSet schemas = schemaHandler.getSchemaSet(property.getNamespaceURI());
                if (schemas != null) {
                    propertyDecl = schemas.getElementDecl(property.getNamespaceURI(), property.getLocalPart());
                }
            }

            if (propertyDecl != null) {
                boolean[] hasXLink = new boolean[1];
                propertyDecl.getType().visit(new SchemaWalker() {
                    @Override
                    public void attributeDecl(XSAttributeDecl decl) {
                        if (decl.getName().equals("href")
                                && XLinkModule.v1_0.getNamespaceURI().equals(decl.getTargetNamespace())) {
                            hasXLink[0] = true;
                            setShouldWalk(false);
                        }
                    }

                    @Override
                    public void elementDecl(XSElementDecl decl) {
                        // skip nested elements
                    }
                });

                return hasXLink[0];
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
