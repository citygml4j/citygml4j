/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.transportation;

import org.citygml4j.core.model.ade.generic.GenericADEOfRoad;
import org.citygml4j.core.model.transportation.ADEOfRoad;
import org.citygml4j.core.model.transportation.IntersectionProperty;
import org.citygml4j.core.model.transportation.Road;
import org.citygml4j.core.model.transportation.SectionProperty;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
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

@XMLElement(name = "Road", namespaceURI = CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE)
public class RoadAdapter extends AbstractTransportationSpaceAdapter<Road> {

    @Override
    public Road createObject(QName name, Object parent) throws ObjectBuildException {
        return new Road();
    }

    @Override
    public void buildChildObject(Road object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "section":
                    object.getSections().add(reader.getObjectUsingBuilder(SectionPropertyAdapter.class));
                    return;
                case "intersection":
                    object.getIntersections().add(reader.getObjectUsingBuilder(IntersectionPropertyAdapter.class));
                    return;
                case "adeOfRoad":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfRoad::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Road object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "Road");
    }

    @Override
    public void writeChildElements(Road object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, namespaces, writer);

        if (object.isSetSections()) {
            for (SectionProperty property : object.getSections())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "section"), property, SectionPropertyAdapter.class, namespaces);
        }

        if (object.isSetIntersections()) {
            for (IntersectionProperty property : object.getIntersections())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "intersection"), property, IntersectionPropertyAdapter.class, namespaces);
        }

        for (ADEOfRoad property : object.getADEProperties(ADEOfRoad.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "adeOfRoad"), property, namespaces, writer);
    }
}
