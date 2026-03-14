/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.transportation;

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractTransportationSpace;
import org.citygml4j.core.model.core.OccupancyProperty;
import org.citygml4j.core.model.transportation.*;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.xml.adapter.core.OccupancyPropertyAdapter;
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

public abstract class AbstractTransportationSpaceAdapter<T extends AbstractTransportationSpace> extends AbstractUnoccupiedSpaceAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "trafficDirection":
                    reader.getTextContent().ifPresent(v -> object.setTrafficDirection(TrafficDirectionValue.fromValue(v)));
                    return;
                case "occupancy":
                    object.getOccupancies().add(reader.getObjectUsingBuilder(OccupancyPropertyAdapter.class));
                    return;
                case "trafficSpace":
                    object.getTrafficSpaces().add(reader.getObjectUsingBuilder(TrafficSpacePropertyAdapter.class));
                    return;
                case "auxiliaryTrafficSpace":
                    object.getAuxiliaryTrafficSpaces().add(reader.getObjectUsingBuilder(AuxiliaryTrafficSpacePropertyAdapter.class));
                    return;
                case "hole":
                    object.getHoles().add(reader.getObjectUsingBuilder(HolePropertyAdapter.class));
                    return;
                case "marking":
                    object.getMarkings().add(reader.getObjectUsingBuilder(MarkingPropertyAdapter.class));
                    return;
                case "adeOfAbstractTransportationSpace":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfAbstractTransportationSpace::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getTrafficDirection() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "trafficDirection").addTextContent(object.getTrafficDirection().toValue()));

        if (object.isSetOccupancies()) {
            for (OccupancyProperty property : object.getOccupancies())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "occupancy"), property, OccupancyPropertyAdapter.class, namespaces);
        }

        if (object.isSetTrafficSpaces()) {
            for (TrafficSpaceProperty property : object.getTrafficSpaces())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "trafficSpace"), property, TrafficSpacePropertyAdapter.class, namespaces);
        }

        if (object.isSetAuxiliaryTrafficSpaces()) {
            for (AuxiliaryTrafficSpaceProperty property : object.getAuxiliaryTrafficSpaces())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "auxiliaryTrafficSpace"), property, AuxiliaryTrafficSpacePropertyAdapter.class, namespaces);
        }

        if (object.isSetHoles()) {
            for (HoleProperty property : object.getHoles())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "hole"), property, HolePropertyAdapter.class, namespaces);
        }

        if (object.isSetMarkings()) {
            for (MarkingProperty property : object.getMarkings())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "marking"), property, MarkingPropertyAdapter.class, namespaces);
        }

        for (ADEOfAbstractTransportationSpace property : object.getADEProperties(ADEOfAbstractTransportationSpace.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "adeOfAbstractTransportationSpace"), property, namespaces, writer);
    }
}
