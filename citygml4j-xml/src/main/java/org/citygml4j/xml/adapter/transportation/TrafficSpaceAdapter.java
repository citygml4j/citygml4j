/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.transportation;

import org.citygml4j.core.model.ade.generic.GenericADEOfTrafficSpace;
import org.citygml4j.core.model.core.OccupancyProperty;
import org.citygml4j.core.model.transportation.*;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.xml.adapter.core.OccupancyPropertyAdapter;
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

@XMLElement(name = "TrafficSpace", namespaceURI = CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE)
public class TrafficSpaceAdapter extends AbstractUnoccupiedSpaceAdapter<TrafficSpace> {

    @Override
    public TrafficSpace createObject(QName name, Object parent) throws ObjectBuildException {
        return new TrafficSpace();
    }

    @Override
    public void buildChildObject(TrafficSpace object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "granularity":
                    reader.getTextContent().ifPresent(v -> object.setGranularity(GranularityValue.fromValue(v)));
                    return;
                case "trafficDirection":
                    reader.getTextContent().ifPresent(v -> object.setTrafficDirection(TrafficDirectionValue.fromValue(v)));
                    return;
                case "occupancy":
                    object.getOccupancies().add(reader.getObjectUsingBuilder(OccupancyPropertyAdapter.class));
                    return;
                case "predecessor":
                    object.getPredecessors().add(reader.getObjectUsingBuilder(TrafficSpaceReferenceAdapter.class));
                    return;
                case "successor":
                    object.getSuccessors().add(reader.getObjectUsingBuilder(TrafficSpaceReferenceAdapter.class));
                    return;
                case "clearanceSpace":
                    object.getClearanceSpaces().add(reader.getObjectUsingBuilder(ClearanceSpacePropertyAdapter.class));
                    return;
                case "adeOfTrafficSpace":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfTrafficSpace::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(TrafficSpace object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "TrafficSpace");
    }

    @Override
    public void writeChildElements(TrafficSpace object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, namespaces, writer);

        if (object.getGranularity() != null) {
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "granularity").addTextContent(object.getGranularity().toValue()));
        }

        if (object.getTrafficDirection() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "trafficDirection").addTextContent(object.getTrafficDirection().toValue()));

        if (object.isSetOccupancies()) {
            for (OccupancyProperty property : object.getOccupancies())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "occupancy"), property, OccupancyPropertyAdapter.class, namespaces);
        }

        if (object.isSetPredecessors()) {
            for (TrafficSpaceReference reference : object.getPredecessors())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "predecessor"), reference, TrafficSpaceReferenceAdapter.class, namespaces);
        }

        if (object.isSetSuccessors()) {
            for (TrafficSpaceReference reference : object.getSuccessors())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "successor"), reference, TrafficSpaceReferenceAdapter.class, namespaces);
        }

        if (object.isSetClearanceSpaces()) {
            for (ClearanceSpaceProperty property : object.getClearanceSpaces())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "clearanceSpace"), property, ClearanceSpacePropertyAdapter.class, namespaces);
        }

        for (ADEOfTrafficSpace property : object.getADEProperties(ADEOfTrafficSpace.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "adeOfTrafficSpace"), property, namespaces, writer);
    }
}
