package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.ade.generic.GenericADEOfStorey;
import org.citygml4j.model.building.ADEOfStorey;
import org.citygml4j.model.building.Storey;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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

@XMLElement(name = "Storey", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class StoreyAdapter extends AbstractBuildingSubdivisionAdapter<Storey> {

    @Override
    public Storey createObject(QName name) throws ObjectBuildException {
        return new Storey();
    }

    @Override
    public void buildChildObject(Storey object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "buildingUnit":
                    object.getBuildingUnits().add(reader.getObjectUsingBuilder(ReferenceAdapter.class));
                    return;
                case "adeOfStorey":
                    ADEBuilderHelper.addADEContainer(ADEOfStorey.class, object.getADEOfStorey(), GenericADEOfStorey::new, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Storey object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "Storey");
    }

    @Override
    public void writeChildElements(Storey object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (Reference reference : object.getBuildingUnits())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingUnit"), reference, ReferenceAdapter.class, namespaces);

        for (ADEOfStorey container : object.getADEOfStorey())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "adeOfStorey"), container, namespaces, writer);
    }
}
