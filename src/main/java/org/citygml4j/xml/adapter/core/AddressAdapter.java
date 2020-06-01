package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.ade.generic.GenericADEOfAddress;
import org.citygml4j.model.core.ADEOfAddress;
import org.citygml4j.model.core.Address;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiPointPropertyAdapter;
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
public class AddressAdapter extends AbstractFeatureAdapter<Address> {
    private final QName[] substitutionGroups = new QName[]{
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
                    return;
                case "multiPoint":
                    object.setMultiPoint(reader.getObjectUsingBuilder(MultiPointPropertyAdapter.class));
                    return;
                case "adeOfAddress":
                    ADEBuilderHelper.addADEContainer(ADEOfAddress.class, object.getADEOfAddress(), GenericADEOfAddress::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(Address object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfAddress.class, object.getADEOfAddress(),
                GenericADEOfAddress::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(Address object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getCoreNamespace(namespaces), "Address");
    }

    @Override
    public void writeChildElements(Address object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace);

        if (object.getXALAddress() != null)
            writer.writeElementUsingSerializer(Element.of(coreNamespace, "xalAddress"), object.getXALAddress(), XALAddressPropertyAdapter.class, namespaces);

        if (object.getMultiPoint() != null)
            writer.writeElementUsingSerializer(Element.of(coreNamespace, "multiPoint"), object.getMultiPoint(), MultiPointPropertyAdapter.class, namespaces);

        for (ADEOfAddress container : object.getADEOfAddress())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(coreNamespace, "adeOfAddress") : null, container, namespaces, writer);
    }
}
