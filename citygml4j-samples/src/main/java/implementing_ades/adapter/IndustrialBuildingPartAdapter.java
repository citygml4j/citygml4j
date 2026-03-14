/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.adapter;

import implementing_ades.model.IndustrialBuildingPart;
import implementing_ades.module.TestADEModule;
import org.citygml4j.xml.adapter.building.BuildingPartAdapter;
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

@XMLElement(name = "IndustrialBuildingPart", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
public class IndustrialBuildingPartAdapter extends CompositeObjectAdapter<IndustrialBuildingPart> {

    public IndustrialBuildingPartAdapter() {
        super(BuildingPartAdapter.class);
    }

    @Override
    public IndustrialBuildingPart createObject(QName name, Object parent) throws ObjectBuildException {
        return new IndustrialBuildingPart();
    }

    @Override
    public void buildChildObject(IndustrialBuildingPart object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (TestADEModule.TESTADE_NAMESPACE.equals(name.getNamespaceURI())
                && "remark".equals(name.getLocalPart())) {
            reader.getTextContent().ifPresent(object::setRemark);
        } else {
            super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(IndustrialBuildingPart object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_NAMESPACE, "IndustrialBuildingPart");
    }

    @Override
    public void writeChildElements(IndustrialBuildingPart object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getRemark() != null) {
            writer.writeElement(Element.of(TestADEModule.TESTADE_NAMESPACE, "remark").addTextContent(object.getRemark()));
        }
    }
}
