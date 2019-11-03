package org.citygml4j.adapter.xml.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfStorey;
import org.citygml4j.model.building.ADEPropertyOfStorey;
import org.citygml4j.model.building.Storey;
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

@XMLElement(name = "Storey", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class StoreyAdapter extends AbstractBuildingSubdivisionAdapter<Storey> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "AbstractGenericApplicationPropertyOfStorey");

    @Override
    public Storey createObject(QName name) throws ObjectBuildException {
        return new Storey();
    }

    @Override
    public void buildChildObject(Storey object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI()) && "buildingUnit".equals(name.getLocalPart())) {
            object.getBuildingUnits().add(reader.getObjectUsingBuilder(ReferenceAdapter.class));
            return;
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfStorey> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfStorey.class);
            if (builder != null)
                object.getADEPropertiesOfStorey().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfStorey().add(GenericADEPropertyOfStorey.of(reader.getDOMElement()));
        } else
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
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingUnit"), reference, ReferenceAdapter.class,namespaces);

        for (ADEPropertyOfStorey property : object.getADEPropertiesOfStorey())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
