/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.adapter;

import implementing_ades.model.SolarRoofSurface;
import implementing_ades.module.TestADEModule;
import org.citygml4j.xml.adapter.construction.RoofSurfaceAdapter;
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

@XMLElement(name = "SolarRoofSurface", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
public class SolarRoofSurfaceAdapter extends CompositeObjectAdapter<SolarRoofSurface> {

    public SolarRoofSurfaceAdapter() {
        super(RoofSurfaceAdapter.class);
    }

    @Override
    public SolarRoofSurface createObject(QName name, Object parent) throws ObjectBuildException {
        return new SolarRoofSurface();
    }

    @Override
    public void buildChildObject(SolarRoofSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (TestADEModule.TESTADE_NAMESPACE.equals(name.getNamespaceURI())
                && "remark".equals(name.getLocalPart())) {
            reader.getTextContent().ifPresent(object::setRemark);
        } else {
            super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(SolarRoofSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_NAMESPACE, "SolarRoofSurface");
    }

    @Override
    public void writeChildElements(SolarRoofSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getRemark() != null) {
            writer.writeElement(Element.of(TestADEModule.TESTADE_NAMESPACE, "remark").addTextContent(object.getRemark()));
        }
    }
}
