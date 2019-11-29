package org.citygml4j.adapter.xml.transportation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAuxiliaryTrafficSpace;
import org.citygml4j.model.transportation.ADEPropertyOfAuxiliaryTrafficSpace;
import org.citygml4j.model.transportation.AuxiliaryTrafficSpace;
import org.citygml4j.model.transportation.GranularityValue;
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

@XMLElement(name = "AuxiliaryTrafficSpace", namespaceURI = CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE)
public class AuxiliaryTrafficSpaceAdapter extends AbstractUnoccupiedSpaceAdapter<AuxiliaryTrafficSpace> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "AbstractGenericApplicationPropertyOfAuxiliaryTrafficSpace");

    @Override
    public AuxiliaryTrafficSpace createObject(QName name) throws ObjectBuildException {
        return new AuxiliaryTrafficSpace();
    }

    @Override
    public void buildChildObject(AuxiliaryTrafficSpace object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            if ("granularity".equals(name.getLocalPart())) {
                reader.getTextContent().ifPresent(v -> object.setGranularity(GranularityValue.fromValue(v)));
                return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(AuxiliaryTrafficSpace object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAuxiliaryTrafficSpace.class, object.getADEPropertiesOfAuxiliaryTrafficSpace(),
                GenericADEPropertyOfAuxiliaryTrafficSpace::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(AuxiliaryTrafficSpace object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "AuxiliaryTrafficSpace");
    }

    @Override
    public void writeChildElements(AuxiliaryTrafficSpace object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, namespaces, writer);

        writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "granularity").addTextContent(object.getGranularity().toValue()));

        for (ADEPropertyOfAuxiliaryTrafficSpace<?> property : object.getADEPropertiesOfAuxiliaryTrafficSpace())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
