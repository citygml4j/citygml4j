package org.citygml4j.adapter.xml.generics;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfGenericUnoccupiedSpace;
import org.citygml4j.model.generics.ADEPropertyOfGenericUnoccupiedSpace;
import org.citygml4j.model.generics.GenericUnoccupiedSpace;
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

@XMLElement(name = "GenericUnoccupiedSpace", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE)
public class GenericUnoccupiedSpaceAdapter extends AbstractUnoccupiedSpaceAdapter<GenericUnoccupiedSpace> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "AbstractGenericApplicationPropertyOfGenericUnoccupiedSpace");

    @Override
    public GenericUnoccupiedSpace createObject(QName name) throws ObjectBuildException {
        return new GenericUnoccupiedSpace();
    }

    @Override
    public void buildChildObject(GenericUnoccupiedSpace object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())
                && CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
            return;

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfGenericUnoccupiedSpace> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfGenericUnoccupiedSpace.class);
            if (builder != null)
                object.getADEPropertiesOfGenericUnoccupiedSpace().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfGenericUnoccupiedSpace().add(GenericADEPropertyOfGenericUnoccupiedSpace.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(GenericUnoccupiedSpace object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "GenericUnoccupiedSpace");
    }

    @Override
    public void writeChildElements(GenericUnoccupiedSpace object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, namespaces, writer);

        for (ADEPropertyOfGenericUnoccupiedSpace property : object.getADEPropertiesOfGenericUnoccupiedSpace())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
