package org.citygml4j.adapter.xml.construction;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractConstructiveElement;
import org.citygml4j.model.construction.ADEPropertyOfAbstractConstructiveElement;
import org.citygml4j.model.construction.AbstractConstructiveElement;
import org.citygml4j.model.construction.AbstractFillingElementProperty;
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
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public abstract class AbstractConstructiveElementAdapter<T extends AbstractConstructiveElement> extends AbstractOccupiedSpaceAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractConstructiveElement");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (name.getNamespaceURI().equals(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            switch (name.getLocalPart()) {
                case "isStructuralElement":
                    reader.getTextContent().ifBoolean(object::setIsStructuralElement);
                    return;
                case "filling":
                    object.getFillings().add(reader.getObjectUsingBuilder(AbstractFillingElementPropertyAdapter.class));
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
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractConstructiveElement.class, object.getADEPropertiesOfAbstractConstructiveElement(),
                GenericADEPropertyOfAbstractConstructiveElement::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            if (object.isSetIsStructuralElement())
                writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "isStructuralElement").addTextContent(TextContent.ofBoolean(object.getIsStructuralElement())));

            for (AbstractFillingElementProperty property : object.getFillings())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "filling"), property, AbstractFillingElementPropertyAdapter.class, namespaces);

            for (ADEPropertyOfAbstractConstructiveElement property : object.getADEPropertiesOfAbstractConstructiveElement())
                CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
        }
    }
}
