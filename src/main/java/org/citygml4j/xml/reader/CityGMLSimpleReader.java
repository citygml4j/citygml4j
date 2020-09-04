/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.core.AbstractFeature;
import org.xml.sax.SAXException;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.stream.EventType;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import java.util.NoSuchElementException;

public class CityGMLSimpleReader extends CityGMLReader {
    private final XMLReaderFactory factory;

    private boolean hasNext = false;

    public CityGMLSimpleReader(XMLReader reader, XMLReaderFactory factory) {
        super(reader);
        this.factory = factory;
    }

    @Override
    public boolean hasNext() throws CityGMLReadException {
        if (!hasNext) {
            try {
                XMLObjects xmlObjects = reader.getXMLObjects();
                while (reader.hasNext()) {
                    if (reader.nextTag() == EventType.START_ELEMENT) {
                        QName name = reader.getName();
                        if (filter == null || filter.accept(name)) {
                            ObjectBuilder<AbstractFeature> builder = xmlObjects.getBuilder(name, AbstractFeature.class);
                            if (builder != null && CityGMLObject.class.isAssignableFrom(xmlObjects.getObjectType(name.getNamespaceURI(), builder))) {
                                hasNext = true;
                                break;
                            }
                        } else {
                            int skipUntil = reader.getDepth() - 1;
                            while (reader.getDepth() != skipUntil)
                                reader.nextTag();
                        }
                    }
                }
            } catch (XMLReadException e) {
                throw new CityGMLReadException("Caused by:", e);
            }
        }

        return hasNext;
    }

    @Override
    public AbstractFeature next() throws CityGMLReadException {
        if (hasNext()) {
            try {
                AbstractFeature feature;
                if (transformer == null) {
                    feature = reader.getObject(AbstractFeature.class);
                    if (feature != null && resolver != null)
                        resolver.resolveReferences(feature);
                } else
                    feature = nextChunk().build(true);

                return feature;
            } catch (ObjectBuildException | XMLReadException e) {
                throw new CityGMLReadException("Caused by:", e);
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
                XMLStreamReader reader = this.reader.getStreamReader();
                CityGMLChunk chunk = new CityGMLChunk(reader.getName(), factory, resolver);

                do {
                    chunk.bufferEvent(reader);
                    if (chunk.isComplete())
                        break;
                } while (reader.hasNext() && reader.next() >= 0);

                if (transformer != null)
                    chunk.transform(transformer);

                return chunk;
            } catch (XMLStreamException | SAXException | TransformerException e) {
                throw new CityGMLReadException("Caused by:", e);
            } finally {
                hasNext = false;
            }
        }

        throw new NoSuchElementException();
    }
}
