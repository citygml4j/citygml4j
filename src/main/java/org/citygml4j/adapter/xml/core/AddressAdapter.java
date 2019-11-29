package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.ade.ADEPropertyBuilder;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAddress;
import org.citygml4j.model.core.ADEPropertyOfAddress;
import org.citygml4j.model.core.Address;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiPointPropertyAdapter;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Address", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE),
        @XMLElement(name = "Address", namespaceURI = CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE),
        @XMLElement(name = "Address", namespaceURI = CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE)
})
public class AddressAdapter extends AbstractFeatureAdapter<Address> implements ADEPropertyBuilder<Address> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "AbstractGenericApplicationPropertyOfAddress"),
            new QName(CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE, "_GenericApplicationPropertyOfAddress"),
            new QName(CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE, "_GenericApplicationPropertyOfAddress")
    };

    @Override
    public Address createObject(QName name) throws ObjectBuildException {
        return new Address();
    }

    @Override
    public void buildChildObject(Address object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCoreNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "xalAddress":
                    object.setXALAddress(reader.getObjectUsingBuilder(XALAddressPropertyAdapter.class));
                    break;
                case "multiPoint":
                    object.setMultiPoint(reader.getObjectUsingBuilder(MultiPointPropertyAdapter.class));
                    break;
            }
        } else if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI()))
            super.buildChildObject(object, name, attributes, reader);
        else
            buildADEProperty(object, name, reader);
    }

    @Override
    public void buildADEProperty(Address object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAddress.class, object.getADEPropertiesOfAddress(),
                GenericADEPropertyOfAddress::of, reader, substitutionGroups))
            object.getGenericProperties().add(GenericElement.of(reader.getDOMElement()));
    }

    @Override
    public Element createElement(Address object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getCoreNamespace(namespaces), "Address");
    }

    @Override
    public void writeChildElements(Address object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (object.getXALAddress() != null)
            writer.writeElementUsingSerializer(Element.of(coreNamespace, "xalAddress"), object.getXALAddress(), XALAddressPropertyAdapter.class, namespaces);

        if (object.getMultiPoint() != null)
            writer.writeElementUsingSerializer(Element.of(coreNamespace, "multiPoint"), object.getMultiPoint(), MultiPointPropertyAdapter.class, namespaces);

        for (ADEPropertyOfAddress<?> property : object.getADEPropertiesOfAddress())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
