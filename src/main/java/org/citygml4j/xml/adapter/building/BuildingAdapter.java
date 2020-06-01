package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.ade.generic.GenericADEOfBuilding;
import org.citygml4j.model.building.ADEOfBuilding;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.building.BuildingPartProperty;
import org.citygml4j.util.CityGMLConstants;
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

@XMLElement(name = "Building", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class BuildingAdapter extends AbstractBuildingAdapter<Building> {

    @Override
    public Building createObject(QName name) throws ObjectBuildException {
        return new Building();
    }

    @Override
    public void buildChildObject(Building object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "buildingPart":
                    object.getBuildingParts().add(reader.getObjectUsingBuilder(BuildingPartPropertyAdapter.class));
                    return;
                case "adeOfBuilding":
                    ADEBuilderHelper.addADEContainer(ADEOfBuilding.class, object.getADEOfBuilding(), GenericADEOfBuilding::new, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Building object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "Building");
    }

    @Override
    public void writeChildElements(Building object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (BuildingPartProperty property : object.getBuildingParts())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingPart"), property, BuildingPartPropertyAdapter.class, namespaces);

        for (ADEOfBuilding container : object.getADEOfBuilding())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "adeOfBuilding"), container, namespaces, writer);
    }
}
