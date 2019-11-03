package org.citygml4j.adapter.xml.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBuilding;
import org.citygml4j.model.building.ADEPropertyOfBuilding;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.building.BuildingPartProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
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
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "AbstractGenericApplicationPropertyOfBuilding");

    @Override
    public Building createObject(QName name) throws ObjectBuildException {
        return new Building();
    }

    @Override
    public void buildChildObject(Building object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI()) && "buildingPart".equals(name.getLocalPart())) {
            object.getBuildingParts().add(reader.getObjectUsingBuilder(BuildingPartPropertyAdapter.class));
            return;
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfBuilding> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfBuilding.class);
            if (builder != null)
                object.getADEPropertiesOfBuilding().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfBuilding().add(GenericADEPropertyOfBuilding.of(reader.getDOMElement()));
        } else
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

        for (ADEPropertyOfBuilding property : object.getADEPropertiesOfBuilding())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
