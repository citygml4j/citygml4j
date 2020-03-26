package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractFeature;
import org.citygml4j.model.core.ADEPropertyOfAbstractFeature;
import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEPropertyBuilder;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractFeatureAdapter<T extends AbstractFeature> extends org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter<T> implements ADEPropertyBuilder<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractFeature");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI()))
            super.buildChildObject(object, name, attributes, reader);
        else
            buildADEProperty(object, name, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractFeature.class, object.getADEPropertiesOfAbstractFeature(),
                GenericADEPropertyOfAbstractFeature::of, reader, substitutionGroup))
            object.getGenericProperties().add(GenericElement.of(reader.getDOMElement()));
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace)) {
            for (ADEPropertyOfAbstractFeature<?> property : object.getADEPropertiesOfAbstractFeature())
                CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
        }
    }
}
