package org.citygml4j.adapter.xml.vegetation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractVegetationObject;
import org.citygml4j.model.vegetation.ADEPropertyOfAbstractVegetationObject;
import org.citygml4j.model.vegetation.AbstractVegetationObject;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractVegetationObjectAdapter<T extends AbstractVegetationObject> extends AbstractOccupiedSpaceAdapter<T> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractVegetationObject"),
            new QName(CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE, "_GenericApplicationPropertyOfVegetationObject"),
            new QName(CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE, "_GenericApplicationPropertyOfVegetationObject")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractVegetationObject.class, object.getADEPropertiesOfAbstractVegetationObject(),
                GenericADEPropertyOfAbstractVegetationObject::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfAbstractVegetationObject<?> property : object.getADEPropertiesOfAbstractVegetationObject())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
