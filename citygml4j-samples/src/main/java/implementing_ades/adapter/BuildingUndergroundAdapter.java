/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.adapter;

import implementing_ades.model.BuildingUnderground;
import implementing_ades.model.BuildingUndergroundPartProperty;
import implementing_ades.module.TestADEModule;
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

@XMLElement(name = "BuildingUnderground", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
public class BuildingUndergroundAdapter extends AbstractBuildingUndergroundAdapter<BuildingUnderground> {

    @Override
    public BuildingUnderground createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingUnderground();
    }

    @Override
    public void buildChildObject(BuildingUnderground object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (TestADEModule.TESTADE_NAMESPACE.equals(name.getNamespaceURI())
                && "consistsOf".equals(name.getLocalPart())) {
            object.getConsistsOf().add(reader.getObjectUsingBuilder(BuildingUndergroundPartPropertyAdapter.class));
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BuildingUnderground object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_NAMESPACE, "BuildingUnderground");
    }

    @Override
    public void writeChildElements(BuildingUnderground object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.isSetConsistsOf()) {
            for (BuildingUndergroundPartProperty property : object.getConsistsOf()) {
                writer.writeElementUsingSerializer(Element.of(TestADEModule.TESTADE_NAMESPACE, "consistsOf"), property, BuildingUndergroundPartPropertyAdapter.class, namespaces);
            }
        }
    }
}
