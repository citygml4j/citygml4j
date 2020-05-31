package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractUnoccupiedSpace;
import org.citygml4j.model.core.ADEOfAbstractUnoccupiedSpace;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
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

public abstract class AbstractUnoccupiedSpaceAdapter<T extends AbstractUnoccupiedSpace> extends AbstractPhysicalSpaceAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfAbstractUnoccupiedSpace".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfAbstractUnoccupiedSpace.class, object.getADEOfAbstractUnoccupiedSpace(), GenericADEOfAbstractUnoccupiedSpace::new, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace)) {
            for (ADEOfAbstractUnoccupiedSpace container : object.getADEOfAbstractUnoccupiedSpace())
                ADESerializerHelper.writeADEContainer(Element.of(coreNamespace, "adeOfAbstractUnoccupiedSpace"), container, namespaces, writer);
        }
    }
}
