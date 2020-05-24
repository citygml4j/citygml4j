package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractSurfaceData;
import org.citygml4j.model.appearance.ADEOfAbstractSurfaceData;
import org.citygml4j.model.appearance.AbstractSurfaceData;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractFeatureAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public abstract class AbstractSurfaceDataAdapter<T extends AbstractSurfaceData> extends AbstractFeatureAdapter<T> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractSurfaceData"),
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfSurfaceData"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfSurfaceData")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI()) && "isFront".equals(name.getLocalPart())) {
            reader.getTextContent().ifBoolean(object::setIsFront);
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEOfAbstractSurfaceData.class, object.getADEPropertiesOfAbstractSurfaceData(),
                GenericADEPropertyOfAbstractSurfaceData::of, reader, substitutionGroups))
            object.getGenericProperties().add(GenericElement.of(reader.getDOMElement()));
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.isSetIsFront())
            writer.writeElement(Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "isFront").addTextContent(TextContent.ofBoolean(object.getIsFront())));

        for (ADEOfAbstractSurfaceData<?> property : object.getADEPropertiesOfAbstractSurfaceData())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
