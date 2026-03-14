/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.building;

import org.citygml4j.core.model.ade.generic.GenericADEOfBuildingPart;
import org.citygml4j.core.model.building.ADEOfBuildingPart;
import org.citygml4j.core.model.building.BuildingPart;
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

@XMLElement(name = "BuildingPart", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class BuildingPartAdapter extends AbstractBuildingAdapter<BuildingPart> {

    @Override
    public BuildingPart createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingPart();
    }

    @Override
    public void buildChildObject(BuildingPart object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfBuildingPart".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEProperty(object, GenericADEOfBuildingPart::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BuildingPart object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "BuildingPart");
    }

    @Override
    public void writeChildElements(BuildingPart object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfBuildingPart property : object.getADEProperties(ADEOfBuildingPart.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "adeOfBuildingPart"), property, namespaces, writer);
    }
}
