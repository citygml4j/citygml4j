package org.citygml4j.adapter.xml.construction;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AddressPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfDoor;
import org.citygml4j.model.construction.ADEPropertyOfDoor;
import org.citygml4j.model.construction.Door;
import org.citygml4j.model.core.AddressProperty;
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

@XMLElement(name = "Door", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class DoorAdapter extends AbstractFillingElementAdapter<Door> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "AbstractGenericApplicationPropertyOfDoor");

    @Override
    public Door createObject(QName name) throws ObjectBuildException {
        return new Door();
    }

    @Override
    public void buildChildObject(Door object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;
            else if ("address".equals(name.getLocalPart())) {
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
    public void buildADEProperty(Door object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfDoor.class, object.getADEPropertiesOfDoor(),
                GenericADEPropertyOfDoor::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(Door object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "Door");
    }

    @Override
    public void writeChildElements(Door object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, namespaces, writer);

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "address"), property, AddressPropertyAdapter.class, namespaces);

        for (ADEPropertyOfDoor property : object.getADEPropertiesOfDoor())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
