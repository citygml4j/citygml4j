/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.construction;

import org.citygml4j.core.model.ade.generic.GenericADEOfOuterCeilingSurface;
import org.citygml4j.core.model.construction.ADEOfOuterCeilingSurface;
import org.citygml4j.core.model.construction.OuterCeilingSurface;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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

@XMLElement(name = "OuterCeilingSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class OuterCeilingSurfaceAdapter extends AbstractConstructionSurfaceAdapter<OuterCeilingSurface> {

    @Override
    public OuterCeilingSurface createObject(QName name, Object parent) throws ObjectBuildException {
        return new OuterCeilingSurface();
    }

    @Override
    public void buildChildObject(OuterCeilingSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfOuterCeilingSurface".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEProperty(object, GenericADEOfOuterCeilingSurface::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(OuterCeilingSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "OuterCeilingSurface");
    }

    @Override
    public void writeChildElements(OuterCeilingSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfOuterCeilingSurface property : object.getADEProperties(ADEOfOuterCeilingSurface.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfOuterCeilingSurface"), property, namespaces, writer);
    }
}
