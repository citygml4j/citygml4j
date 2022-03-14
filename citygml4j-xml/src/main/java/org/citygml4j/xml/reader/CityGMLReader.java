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

package org.citygml4j.xml.reader;

import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xmlobjects.gml.util.reference.ReferenceResolver;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import javax.xml.namespace.QName;
import java.net.URI;

public abstract class CityGMLReader implements AutoCloseable {
    final XMLReader reader;

    CityGMLInputFilter filter;
    TransformerPipeline transformer;
    ReferenceResolver resolver;

    CityGMLReader(XMLReader reader) {
        this.reader = reader;
    }

    public abstract boolean hasNext() throws CityGMLReadException;
    public abstract AbstractFeature next() throws CityGMLReadException;
    public abstract CityGMLChunk nextChunk() throws CityGMLReadException;

    public URI getBaseURI() {
        return reader.getBaseURI();
    }

    public QName getName() {
        try {
            return reader.getName();
        } catch (XMLReadException e) {
            return null;
        }
    }

    public boolean hasParentInfo() {
        return false;
    }

    public FeatureInfo getParentInfo() throws CityGMLReadException {
        return null;
    }

    @Override
    public void close() throws CityGMLReadException {
        try {
            reader.close();
        } catch (XMLReadException e) {
            throw new CityGMLReadException("Caused by:", e);
        }
    }
}
