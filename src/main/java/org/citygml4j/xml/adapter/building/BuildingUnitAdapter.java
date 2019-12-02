package org.citygml4j.xml.adapter.building;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AddressPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBuildingUnit;
import org.citygml4j.model.building.ADEPropertyOfBuildingUnit;
import org.citygml4j.model.building.BuildingUnit;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.ReferenceAdapter;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "BuildingUnit", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class BuildingUnitAdapter extends AbstractBuildingSubdivisionAdapter<BuildingUnit> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "AbstractGenericApplicationPropertyOfBuildingUnit");

    @Override
    public BuildingUnit createObject(QName name) throws ObjectBuildException {
        return new BuildingUnit();
    }

    @Override
    public void buildChildObject(BuildingUnit object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "storey":
                    object.getStoreys().add(reader.getObjectUsingBuilder(ReferenceAdapter.class));
                    return;
                case "address":
                    object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(BuildingUnit object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfBuildingUnit.class, object.getADEPropertiesOfBuildingUnit(),
                GenericADEPropertyOfBuildingUnit::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(BuildingUnit object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "BuildingUnit");
    }

    @Override
    public void writeChildElements(BuildingUnit object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (Reference reference : object.getStoreys())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "storey"), reference, ReferenceAdapter.class, namespaces);

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "address"), property, AddressPropertyAdapter.class, namespaces);

        for (ADEPropertyOfBuildingUnit<?> property : object.getADEPropertiesOfBuildingUnit())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
