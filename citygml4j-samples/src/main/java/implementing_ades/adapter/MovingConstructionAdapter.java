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

import implementing_ades.model.MovingConstruction;
import implementing_ades.model.SolarRoofSurfaceProperty;
import implementing_ades.module.TestADEModule;
import org.citygml4j.xml.adapter.construction.OtherConstructionAdapter;
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

@XMLElement(name = "MovingConstruction", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
public class MovingConstructionAdapter extends CompositeObjectAdapter<MovingConstruction> {

    public MovingConstructionAdapter() {
        super(OtherConstructionAdapter.class);
    }

    @Override
    public MovingConstruction createObject(QName name, Object parent) throws ObjectBuildException {
        return new MovingConstruction();
    }

    @Override
    public void buildChildObject(MovingConstruction object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (TestADEModule.TESTADE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "remark":
                    reader.getTextContent().ifPresent(object::setRemark);
                    break;
                case "coveredBy":
                    object.getCoveredBy().add(reader.getObjectUsingBuilder(SolarRoofSurfacePropertyAdapter.class));
                    break;
            }
        } else {
            super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(MovingConstruction object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_NAMESPACE, "MovingConstruction");
    }

    @Override
    public void writeChildElements(MovingConstruction object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getRemark() != null) {
            writer.writeElement(Element.of(TestADEModule.TESTADE_NAMESPACE, "remark").addTextContent(object.getRemark()));
        }

        if (object.isSetCoveredBy()) {
            for (SolarRoofSurfaceProperty property : object.getCoveredBy()) {
                writer.writeElementUsingSerializer(Element.of(TestADEModule.TESTADE_NAMESPACE, "coveredBy"), property, SolarRoofSurfacePropertyAdapter.class, namespaces);
            }
        }
    }
}
