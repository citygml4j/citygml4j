/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.ade.generic.GenericADEOfClosureSurface;
import org.citygml4j.core.model.core.ADEOfClosureSurface;
import org.citygml4j.core.model.core.ClosureSurface;
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

@XMLElement(name = "ClosureSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class ClosureSurfaceAdapter extends AbstractThematicSurfaceAdapter<ClosureSurface> {

    @Override
    public ClosureSurface createObject(QName name, Object parent) throws ObjectBuildException {
        return new ClosureSurface();
    }

    @Override
    public void buildChildObject(ClosureSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfClosureSurface".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEProperty(object, GenericADEOfClosureSurface::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(ClosureSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "ClosureSurface");
    }

    @Override
    public void writeChildElements(ClosureSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfClosureSurface property : object.getADEProperties(ADEOfClosureSurface.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "adeOfClosureSurface"), property, namespaces, writer);
    }
}
