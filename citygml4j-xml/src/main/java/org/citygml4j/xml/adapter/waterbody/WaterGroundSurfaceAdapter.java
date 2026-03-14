/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.waterbody;

import org.citygml4j.core.model.ade.generic.GenericADEOfWaterGroundSurface;
import org.citygml4j.core.model.waterbody.ADEOfWaterGroundSurface;
import org.citygml4j.core.model.waterbody.WaterGroundSurface;
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

@XMLElement(name = "WaterGroundSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE)
public class WaterGroundSurfaceAdapter extends AbstractWaterBoundarySurfaceAdapter<WaterGroundSurface> {

    @Override
    public WaterGroundSurface createObject(QName name, Object parent) throws ObjectBuildException {
        return new WaterGroundSurface();
    }

    @Override
    public void buildChildObject(WaterGroundSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfWaterGroundSurface".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEProperty(object, GenericADEOfWaterGroundSurface::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(WaterGroundSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "WaterGroundSurface");
    }

    @Override
    public void writeChildElements(WaterGroundSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfWaterGroundSurface property : object.getADEProperties(ADEOfWaterGroundSurface.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "adeOfWaterGroundSurface"), property, namespaces, writer);
    }
}
