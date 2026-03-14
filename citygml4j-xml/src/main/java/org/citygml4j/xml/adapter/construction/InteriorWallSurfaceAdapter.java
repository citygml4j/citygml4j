/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.construction;

import org.citygml4j.core.model.ade.generic.GenericADEOfInteriorWallSurface;
import org.citygml4j.core.model.construction.ADEOfInteriorWallSurface;
import org.citygml4j.core.model.construction.InteriorWallSurface;
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

@XMLElement(name = "InteriorWallSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class InteriorWallSurfaceAdapter extends AbstractConstructionSurfaceAdapter<InteriorWallSurface> {

    @Override
    public InteriorWallSurface createObject(QName name, Object parent) throws ObjectBuildException {
        return new InteriorWallSurface();
    }

    @Override
    public void buildChildObject(InteriorWallSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfInteriorWallSurface".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEProperty(object, GenericADEOfInteriorWallSurface::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(InteriorWallSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "InteriorWallSurface");
    }

    @Override
    public void writeChildElements(InteriorWallSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfInteriorWallSurface property : object.getADEProperties(ADEOfInteriorWallSurface.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfInteriorWallSurface"), property, namespaces, writer);
    }
}
