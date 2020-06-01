package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractSpaceBoundary;
import org.citygml4j.model.core.ADEOfAbstractSpaceBoundary;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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

public abstract class AbstractSpaceBoundaryAdapter<T extends AbstractSpaceBoundary> extends AbstractCityObjectAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfAbstractSpaceBoundary".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfAbstractSpaceBoundary.class, object.getADEOfAbstractSpaceBoundary(), GenericADEOfAbstractSpaceBoundary::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace)) {
            for (ADEOfAbstractSpaceBoundary container : object.getADEOfAbstractSpaceBoundary())
                ADESerializerHelper.writeADEContainer(Element.of(coreNamespace, "adeOfAbstractSpaceBoundary"), container, namespaces, writer);
        }
    }
}
