package org.citygml4j.adapter.xml.generics;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractLogicalSpaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfGenericLogicalSpace;
import org.citygml4j.model.generics.ADEPropertyOfGenericLogicalSpace;
import org.citygml4j.model.generics.GenericLogicalSpace;
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

@XMLElement(name = "GenericLogicalSpace", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE)
public class GenericLogicalSpaceAdapter extends AbstractLogicalSpaceAdapter<GenericLogicalSpace> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "AbstractGenericApplicationPropertyOfGenericLogicalSpace");

    @Override
    public GenericLogicalSpace createObject(QName name) throws ObjectBuildException {
        return new GenericLogicalSpace();
    }

    @Override
    public void buildChildObject(GenericLogicalSpace object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())
                && CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader)) {
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(GenericLogicalSpace object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfGenericLogicalSpace.class, object.getADEPropertiesOfGenericLogicalSpace(),
                GenericADEPropertyOfGenericLogicalSpace::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(GenericLogicalSpace object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "GenericLogicalSpace");
    }

    @Override
    public void writeChildElements(GenericLogicalSpace object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, namespaces, writer);

        for (ADEPropertyOfGenericLogicalSpace<?> property : object.getADEPropertiesOfGenericLogicalSpace())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
