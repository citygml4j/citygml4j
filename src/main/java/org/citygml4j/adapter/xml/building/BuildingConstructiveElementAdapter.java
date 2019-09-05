package org.citygml4j.adapter.xml.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.construction.AbstractConstructiveElementAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBuildingConstructiveElement;
import org.citygml4j.model.building.ADEPropertyOfBuildingConstructiveElement;
import org.citygml4j.model.building.BuildingConstructiveElement;
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

@XMLElement(name = "BuildingConstructiveElement", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class BuildingConstructiveElementAdapter extends AbstractConstructiveElementAdapter<BuildingConstructiveElement> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "AbstractGenericApplicationPropertyOfBuildingConstructiveElement");

    @Override
    public BuildingConstructiveElement createObject(QName name) {
        return new BuildingConstructiveElement();
    }

    @Override
    public void buildChildObject(BuildingConstructiveElement object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())
                && CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
            return;

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfBuildingConstructiveElement> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfBuildingConstructiveElement.class);
            if (builder != null)
                object.getADEPropertiesOfBuildingConstructiveElement().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfBuildingConstructiveElement().add(GenericADEPropertyOfBuildingConstructiveElement.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BuildingConstructiveElement object, Namespaces namespaces) {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "BuildingConstructiveElement");
    }

    @Override
    public void writeChildElements(BuildingConstructiveElement object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, namespaces, writer);

        for (ADEPropertyOfBuildingConstructiveElement property : object.getADEPropertiesOfBuildingConstructiveElement())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
