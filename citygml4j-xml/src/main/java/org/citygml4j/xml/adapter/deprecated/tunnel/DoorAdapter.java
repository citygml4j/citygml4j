/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.deprecated.tunnel;

import org.citygml4j.core.model.ade.generic.GenericADEOfDoorSurface;
import org.citygml4j.core.model.construction.ADEOfDoorSurface;
import org.citygml4j.core.model.construction.DoorSurface;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AddressPropertyAdapter;
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

@XMLElement(name = "Door", namespaceURI = CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE)
public class DoorAdapter extends AbstractOpeningAdapter<DoorSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE, "_GenericApplicationPropertyOfDoor");

    @Override
    public DoorSurface createObject(QName name, Object parent) throws ObjectBuildException {
        return new DoorSurface();
    }

    @Override
    public void buildChildObject(DoorSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isTunnelNamespace(name.getNamespaceURI()) && "address".equals(name.getLocalPart())) {
            object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(DoorSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfDoorSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(DoorSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getTunnelNamespace(namespaces), "Door");
    }

    @Override
    public void writeChildElements(DoorSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String tunnelNamespace = CityGMLSerializerHelper.getTunnelNamespace(namespaces);

        if (object.isSetAddresses()) {
            for (AddressProperty property : object.getAddresses())
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "address"), property, AddressPropertyAdapter.class, namespaces);
        }

        for (ADEOfDoorSurface property : object.getADEProperties(ADEOfDoorSurface.class))
            ADESerializerHelper.writeADEProperty(property, namespaces, writer);
    }
}
