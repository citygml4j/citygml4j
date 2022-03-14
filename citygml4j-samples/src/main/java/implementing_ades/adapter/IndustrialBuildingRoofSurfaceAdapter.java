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

package implementing_ades.adapter;

import implementing_ades.model.IndustrialBuildingRoofSurface;
import implementing_ades.module.TestADEModule;
import org.citygml4j.xml.adapter.deprecated.building.RoofSurfaceAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.composite.CompositeObjectAdapter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "IndustrialBuildingRoofSurface", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
public class IndustrialBuildingRoofSurfaceAdapter extends CompositeObjectAdapter<IndustrialBuildingRoofSurface> {

    public IndustrialBuildingRoofSurfaceAdapter() {
        super(RoofSurfaceAdapter.class);
    }

    @Override
    public IndustrialBuildingRoofSurface createObject(QName name, Object parent) throws ObjectBuildException {
        return new IndustrialBuildingRoofSurface();
    }

    @Override
    public void buildChildObject(IndustrialBuildingRoofSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (TestADEModule.TESTADE_NAMESPACE.equals(name.getNamespaceURI())
                && "remark".equals(name.getLocalPart())) {
            reader.getTextContent().ifPresent(object::setRemark);
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(IndustrialBuildingRoofSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_NAMESPACE, "IndustrialBuildingRoofSurface");
    }

    @Override
    public void writeChildElements(IndustrialBuildingRoofSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getRemark() != null)
            writer.writeElement(Element.of(TestADEModule.TESTADE_NAMESPACE, "remark").addTextContent(object.getRemark()));
    }
}
