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

package implementing_ades.adapter;

import implementing_ades.model.OtherConstruction;
import implementing_ades.module.TestADEModule;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.xml.adapter.deprecated.building.AbstractBoundarySurfacePropertyAdapter;
import org.citygml4j.xml.adapter.deprecated.core.AbstractSiteAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "OtherConstruction", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
public class OtherConstructionAdapter extends AbstractSiteAdapter<OtherConstruction> {

    @Override
    public OtherConstruction createObject(QName name, Object parent) throws ObjectBuildException {
        return new OtherConstruction();
    }

    @Override
    public void buildChildObject(OtherConstruction object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (TestADEModule.TESTADE_NAMESPACE.equals(name.getNamespaceURI())
                && "boundedBy".equals(name.getLocalPart())) {
            object.addBoundary(reader.getObjectUsingBuilder(AbstractBoundarySurfacePropertyAdapter.class));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(OtherConstruction object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_NAMESPACE, "OtherConstruction");
    }

    @Override
    public void writeChildElements(OtherConstruction object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
            writer.writeElementUsingSerializer(Element.of(TestADEModule.TESTADE_NAMESPACE, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);
    }
}
