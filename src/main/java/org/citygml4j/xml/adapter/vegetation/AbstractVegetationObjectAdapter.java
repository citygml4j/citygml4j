package org.citygml4j.xml.adapter.vegetation;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractVegetationObject;
import org.citygml4j.model.vegetation.ADEOfAbstractVegetationObject;
import org.citygml4j.model.vegetation.AbstractVegetationObject;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractOccupiedSpaceAdapter;
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

public abstract class AbstractVegetationObjectAdapter<T extends AbstractVegetationObject> extends AbstractOccupiedSpaceAdapter<T> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE, "_GenericApplicationPropertyOfVegetationObject"),
            new QName(CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE, "_GenericApplicationPropertyOfVegetationObject")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfAbstractVegetationObject".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfAbstractVegetationObject.class, object.getADEOfAbstractVegetationObject(), GenericADEOfAbstractVegetationObject::of, reader);
        else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfAbstractVegetationObject.class, object.getADEOfAbstractVegetationObject(),
                GenericADEOfAbstractVegetationObject::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String vegetationNamespace = CityGMLSerializerHelper.getVegetationNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE.equals(vegetationNamespace);

        for (ADEOfAbstractVegetationObject container : object.getADEOfAbstractVegetationObject())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(vegetationNamespace, "adeOfAbstractVegetationObject") : null, container, namespaces, writer);
    }
}
