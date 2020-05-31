package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractFillingElement;
import org.citygml4j.model.construction.ADEOfAbstractFillingElement;
import org.citygml4j.model.construction.AbstractFillingElement;
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

import javax.xml.namespace.QName;

public abstract class AbstractFillingElementAdapter<T extends AbstractFillingElement> extends AbstractOccupiedSpaceAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfAbstractFillingElement".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfAbstractFillingElement.class, object.getADEOfAbstractFillingElement(), GenericADEOfAbstractFillingElement::new, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            for (ADEOfAbstractFillingElement container : object.getADEOfAbstractFillingElement())
                ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfAbstractFillingElement"), container, namespaces, writer);
        }
    }
}
