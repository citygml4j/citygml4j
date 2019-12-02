package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.model.appearance.AbstractTextureParameterization;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractTextureParameterizationAdapter<T extends AbstractTextureParameterization> implements ObjectBuilder<T>, ObjectSerializer<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(name.getNamespaceURI())) {
            attributes.getValue(GMLConstants.GML_3_1_NAMESPACE, "id").ifPresent(v -> object.getLocalProperties().set(DeprecatedProperties.GML_ID, v));
            attributes.getValue(GMLConstants.GML_3_2_NAMESPACE, "id").ifPresent(v -> object.getLocalProperties().set(DeprecatedProperties.GML_ID, v));
        }
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (!namespaces.contains(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE))
            element.addAttribute(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "id", object.getLocalProperties().get(DeprecatedProperties.GML_ID, String.class));
    }
}
