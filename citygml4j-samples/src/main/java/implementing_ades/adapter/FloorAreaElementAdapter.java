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

package implementing_ades.adapter;

import implementing_ades.model.FloorAreaElement;
import implementing_ades.module.TestADEModule;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.measures.AreaAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "floorArea", namespaceURI = TestADEModule.TESTADE_CITYGML_2_NAMESPACE)
public class FloorAreaElementAdapter implements ObjectBuilder<FloorAreaElement>, ObjectSerializer<FloorAreaElement> {

    @Override
    public FloorAreaElement createObject(QName name) throws ObjectBuildException {
        return new FloorAreaElement();
    }

    @Override
    public void initializeObject(FloorAreaElement object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        object.setValue(reader.getObjectUsingBuilder(AreaAdapter.class));
    }

    @Override
    public Element createElement(FloorAreaElement object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_CITYGML_2_NAMESPACE, "floorArea");
    }

    @Override
    public void initializeElement(Element element, FloorAreaElement object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getValue() != null)
            writer.getOrCreateSerializer(AreaAdapter.class).initializeElement(element, object.getValue(), namespaces, writer);
    }
}
