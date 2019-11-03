package org.citygml4j.adapter.xml.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AddressPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBuildingUnit;
import org.citygml4j.model.building.ADEPropertyOfBuildingUnit;
import org.citygml4j.model.building.BuildingUnit;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
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
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfBuildingUnit> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfBuildingUnit.class);
            if (builder != null)
                object.getADEPropertiesOfBuildingUnit().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfBuildingUnit().add(GenericADEPropertyOfBuildingUnit.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BuildingUnit object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "BuildingUnit");
    }

    @Override
    public void writeChildElements(BuildingUnit object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (Reference reference : object.getStoreys())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "storey"), reference, ReferenceAdapter.class,namespaces);

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "address"), property, AddressPropertyAdapter.class,namespaces);

        for (ADEPropertyOfBuildingUnit property : object.getADEPropertiesOfBuildingUnit())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
