package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.ade.generic.GenericADEOfBuildingConstructiveElement;
import org.citygml4j.model.building.ADEOfBuildingConstructiveElement;
import org.citygml4j.model.building.BuildingConstructiveElement;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.construction.AbstractConstructiveElementAdapter;
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

@XMLElement(name = "BuildingConstructiveElement", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class BuildingConstructiveElementAdapter extends AbstractConstructiveElementAdapter<BuildingConstructiveElement> {

    @Override
    public BuildingConstructiveElement createObject(QName name) throws ObjectBuildException {
        return new BuildingConstructiveElement();
    }

    @Override
    public void buildChildObject(BuildingConstructiveElement object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;
            else if ("adeOfBuildingConstructiveElement".equals(name.getLocalPart())) {
                ADEBuilderHelper.addADEContainer(ADEOfBuildingConstructiveElement.class, object.getADEOfBuildingConstructiveElement(), GenericADEOfBuildingConstructiveElement::new, reader);
                return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BuildingConstructiveElement object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "BuildingConstructiveElement");
    }

    @Override
    public void writeChildElements(BuildingConstructiveElement object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, namespaces, writer);

        for (ADEOfBuildingConstructiveElement container : object.getADEOfBuildingConstructiveElement())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "adeOfBuilding"), container, namespaces, writer);
    }
}
