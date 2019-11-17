package org.citygml4j.adapter.xml.construction;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfOtherConstruction;
import org.citygml4j.model.construction.ADEPropertyOfOtherConstruction;
import org.citygml4j.model.construction.OtherConstruction;
import org.citygml4j.util.CityGMLConstants;
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

public class OtherConstructionAdapter extends AbstractConstructionAdapter<OtherConstruction> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "AbstractGenericApplicationPropertyOfOtherConstruction");

    @Override
    public OtherConstruction createObject(QName name) throws ObjectBuildException {
        return new OtherConstruction();
    }

    @Override
    public void buildChildObject(OtherConstruction object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI())
                && CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader)) {
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(OtherConstruction object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfOtherConstruction.class, object.getADEPropertiesOfOtherConstruction(),
                GenericADEPropertyOfOtherConstruction::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(OtherConstruction object, Namespaces namespaces) throws ObjectSerializeException {
        return null;
    }

    @Override
    public void writeChildElements(OtherConstruction object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, namespaces, writer);

        for (ADEPropertyOfOtherConstruction property : object.getADEPropertiesOfOtherConstruction())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
