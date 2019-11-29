package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.ade.ADEPropertyBuilder;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractPointCloud;
import org.citygml4j.model.core.ADEPropertyOfAbstractPointCloud;
import org.citygml4j.model.core.AbstractPointCloud;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractPointCloudAdapter<T extends AbstractPointCloud> extends AbstractFeatureAdapter<T> implements ADEPropertyBuilder<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractPointCloud");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI()))
            super.buildChildObject(object, name, attributes, reader);
        else
            buildADEProperty(object, name, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractPointCloud.class, object.getADEPropertiesOfAbstractPointCloud(),
                GenericADEPropertyOfAbstractPointCloud::of, reader, substitutionGroup))
            object.getGenericProperties().add(GenericElement.of(reader.getDOMElement()));
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfAbstractPointCloud<?> property : object.getADEPropertiesOfAbstractPointCloud())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
