package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractConstructiveElement;
import org.citygml4j.model.construction.ADEOfAbstractConstructiveElement;
import org.citygml4j.model.construction.AbstractConstructiveElement;
import org.citygml4j.model.construction.AbstractFillingElementProperty;
import org.citygml4j.util.CityGMLConstants;
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
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public abstract class AbstractConstructiveElementAdapter<T extends AbstractConstructiveElement> extends AbstractOccupiedSpaceAdapter<T> {

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
                case "adeOfAbstractConstructiveElement":
                    ADEBuilderHelper.addADEContainer(ADEOfAbstractConstructiveElement.class, object.getADEOfAbstractConstructiveElement(), GenericADEOfAbstractConstructiveElement::new, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            if (object.isSetIsStructuralElement())
                writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "isStructuralElement").addTextContent(TextContent.ofBoolean(object.getIsStructuralElement())));

            for (AbstractFillingElementProperty property : object.getFillings())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "filling"), property, AbstractFillingElementPropertyAdapter.class, namespaces);

            for (ADEOfAbstractConstructiveElement container : object.getADEOfAbstractConstructiveElement())
                ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfAbstractConstructiveElement"), container, namespaces, writer);
        }
    }
}
