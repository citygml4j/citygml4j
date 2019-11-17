package org.citygml4j.adapter.xml.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBuildingPart;
import org.citygml4j.model.building.ADEPropertyOfBuildingPart;
import org.citygml4j.model.building.BuildingPart;
import org.citygml4j.util.CityGMLConstants;
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
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "AbstractGenericApplicationPropertyOfBuildingPart");

    @Override
    public BuildingPart createObject(QName name) throws ObjectBuildException {
        return new BuildingPart();
    }

    @Override
    public void buildChildObject(BuildingPart object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(BuildingPart object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfBuildingPart.class, object.getADEPropertiesOfBuildingPart(),
                GenericADEPropertyOfBuildingPart::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(BuildingPart object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "BuildingPart");
    }

    @Override
    public void writeChildElements(BuildingPart object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfBuildingPart property : object.getADEPropertiesOfBuildingPart())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
