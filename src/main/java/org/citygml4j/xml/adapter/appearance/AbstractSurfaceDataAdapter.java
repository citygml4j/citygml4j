package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractSurfaceData;
import org.citygml4j.model.appearance.ADEOfAbstractSurfaceData;
import org.citygml4j.model.appearance.AbstractSurfaceData;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfSurfaceData"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfSurfaceData")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "isFront":
                    reader.getTextContent().ifBoolean(object::setIsFront);
                    return;
                case "adeOfAbstractSurfaceData":
                    ADEBuilderHelper.addADEContainer(ADEOfAbstractSurfaceData.class, object.getADEOfAbstractSurfaceData(), GenericADEOfAbstractSurfaceData::new, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfAbstractSurfaceData.class, object.getADEOfAbstractSurfaceData(),
                GenericADEOfAbstractSurfaceData::new, reader, substitutionGroups))
            object.getGenericProperties().add(GenericElement.of(reader.getDOMElement()));
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equalsIgnoreCase(appearanceNamespace);

        if (object.isSetIsFront())
            writer.writeElement(Element.of(appearanceNamespace, "isFront").addTextContent(TextContent.ofBoolean(object.getIsFront())));

        for (ADEOfAbstractSurfaceData container : object.getADEOfAbstractSurfaceData())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(appearanceNamespace, "adeOfAbstractSurfaceData") : null, container, namespaces, writer);
    }
}
