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

package org.citygml4j.xml.writer;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.core.AbstractFeature;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.stream.XMLWriterFactory;

import javax.xml.transform.sax.SAXResult;

public class CityGMLWriter extends AbstractCityGMLWriter<CityGMLWriter> {
    private volatile boolean isValid = true;

    public CityGMLWriter(XMLWriter writer, CityGMLVersion version, XMLWriterFactory factory) {
        super(writer, version, factory);
    }

    public void write(AbstractFeature feature) throws CityGMLWriteException {
        if (!isValid)
            throw new CityGMLWriteException("CityGMLWriter cannot be used to write more than one feature.");

        try {
            XMLWriter writer;
            if (transformer != null) {
                writer = factory.createWriter(transformer.getRootHandler());
                transformer.setResult(new SAXResult(this.writer.getContentHandler()));
            } else
                writer = this.writer;

            writer.writeStartDocument();
            writer.writeObject(feature, namespaces);
            writer.writeEndDocument();
        } catch (ObjectSerializeException | XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        } finally {
            isValid = false;
        }
    }
}
