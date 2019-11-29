package org.citygml4j.adapter.xml.construction;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AddressPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfDoorSurface;
import org.citygml4j.model.construction.ADEPropertyOfDoorSurface;
import org.citygml4j.model.construction.DoorSurface;
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

@XMLElement(name = "DoorSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class DoorSurfaceAdapter extends AbstractFillingSurfaceAdapter<DoorSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "AbstractGenericApplicationPropertyOfDoorSurface");

    @Override
    public DoorSurface createObject(QName name) throws ObjectBuildException {
        return new DoorSurface();
    }

    @Override
    public void buildChildObject(DoorSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI()) && "address".equals(name.getLocalPart())) {
            object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(DoorSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfDoorSurface.class, object.getADEPropertiesOfDoorSurface(),
                GenericADEPropertyOfDoorSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(DoorSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "DoorSurface");
    }

    @Override
    public void writeChildElements(DoorSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "address"), property, AddressPropertyAdapter.class, namespaces);

        for (ADEPropertyOfDoorSurface<?> property : object.getADEPropertiesOfDoorSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
