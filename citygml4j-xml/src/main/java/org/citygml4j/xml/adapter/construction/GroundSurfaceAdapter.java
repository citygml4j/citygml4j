/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.construction;

import org.citygml4j.core.model.ade.generic.GenericADEOfGroundSurface;
import org.citygml4j.core.model.construction.ADEOfGroundSurface;
import org.citygml4j.core.model.construction.GroundSurface;
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

@XMLElement(name = "GroundSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class GroundSurfaceAdapter extends AbstractConstructionSurfaceAdapter<GroundSurface> {

    @Override
    public GroundSurface createObject(QName name, Object parent) throws ObjectBuildException {
        return new GroundSurface();
    }

    @Override
    public void buildChildObject(GroundSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfGroundSurface".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEProperty(object, GenericADEOfGroundSurface::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(GroundSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "GroundSurface");
    }

    @Override
    public void writeChildElements(GroundSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfGroundSurface property : object.getADEProperties(ADEOfGroundSurface.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfGroundSurface"), property, namespaces, writer);
    }
}
