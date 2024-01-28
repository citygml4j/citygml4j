/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.xml.adapter.construction;

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractConstruction;
import org.citygml4j.core.model.construction.*;
import org.citygml4j.core.model.core.OccupancyProperty;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractOccupiedSpaceAdapter;
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
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public abstract class AbstractConstructionAdapter<T extends AbstractConstruction> extends AbstractOccupiedSpaceAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "conditionOfConstruction":
                    reader.getTextContent().ifPresent(v -> object.setConditionOfConstruction(ConditionOfConstructionValue.fromValue(v)));
                    return;
                case "dateOfConstruction":
                    reader.getTextContent().ifDate(v -> object.setDateOfConstruction(v.toLocalDate()));
                    return;
                case "dateOfDemolition":
                    reader.getTextContent().ifDate(v -> object.setDateOfDemolition(v.toLocalDate()));
                    return;
                case "constructionEvent":
                    object.getConstructionEvents().add(reader.getObjectUsingBuilder(ConstructionEventPropertyAdapter.class));
                    return;
                case "elevation":
                    object.getElevations().add(reader.getObjectUsingBuilder(ElevationPropertyAdapter.class));
                    return;
                case "height":
                    object.getHeights().add(reader.getObjectUsingBuilder(HeightPropertyAdapter.class));
                    return;
                case "occupancy":
                    object.getOccupancies().add(reader.getObjectUsingBuilder(OccupancyPropertyAdapter.class));
                    return;
                case "adeOfAbstractConstruction":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfAbstractConstruction::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            if (object.getConditionOfConstruction() != null)
                writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "conditionOfConstruction").addTextContent(object.getConditionOfConstruction().toValue()));

            if (object.getDateOfConstruction() != null)
                writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "dateOfConstruction").addTextContent(TextContent.ofDate(OffsetDateTime.of(object.getDateOfConstruction(), LocalTime.MIN, ZoneOffset.UTC))));

            if (object.getDateOfDemolition() != null)
                writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "dateOfDemolition").addTextContent(TextContent.ofDate(OffsetDateTime.of(object.getDateOfDemolition(), LocalTime.MIN, ZoneOffset.UTC))));

            if (object.isSetConstructionEvents()) {
                for (ConstructionEventProperty property : object.getConstructionEvents())
                    writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "constructionEvent"), property, ConstructionEventPropertyAdapter.class, namespaces);
            }

            if (object.isSetElevations()) {
                for (ElevationProperty property : object.getElevations())
                    writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "elevation"), property, ElevationPropertyAdapter.class, namespaces);
            }

            if (object.isSetHeights()) {
                for (HeightProperty property : object.getHeights())
                    writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "height"), property, HeightPropertyAdapter.class, namespaces);
            }

            if (object.isSetOccupancies()) {
                for (OccupancyProperty property : object.getOccupancies())
                    writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "occupancy"), property, OccupancyPropertyAdapter.class, namespaces);
            }

            for (ADEOfAbstractConstruction property : object.getADEProperties(ADEOfAbstractConstruction.class))
                ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfAbstractConstruction"), property, namespaces, writer);
        }
    }
}
