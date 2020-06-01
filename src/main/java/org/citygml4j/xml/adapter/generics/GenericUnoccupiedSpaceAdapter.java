package org.citygml4j.xml.adapter.generics;

import org.citygml4j.model.ade.generic.GenericADEOfGenericUnoccupiedSpace;
import org.citygml4j.model.generics.ADEOfGenericUnoccupiedSpace;
import org.citygml4j.model.generics.GenericUnoccupiedSpace;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractUnoccupiedSpaceAdapter;
import org.xmlobjects.annotation.XMLElement;
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

@XMLElement(name = "GenericUnoccupiedSpace", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE)
public class GenericUnoccupiedSpaceAdapter extends AbstractUnoccupiedSpaceAdapter<GenericUnoccupiedSpace> {

    @Override
    public GenericUnoccupiedSpace createObject(QName name) throws ObjectBuildException {
        return new GenericUnoccupiedSpace();
    }

    @Override
    public void buildChildObject(GenericUnoccupiedSpace object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;
            else if ("adeOfGenericUnoccupiedSpace".equals(name.getLocalPart())) {
                ADEBuilderHelper.addADEContainer(ADEOfGenericUnoccupiedSpace.class, object.getADEOfGenericUnoccupiedSpace(), GenericADEOfGenericUnoccupiedSpace::new, reader);
                return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(GenericUnoccupiedSpace object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "GenericUnoccupiedSpace");
    }

    @Override
    public void writeChildElements(GenericUnoccupiedSpace object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, namespaces, writer);

        for (ADEOfGenericUnoccupiedSpace container : object.getADEOfGenericUnoccupiedSpace())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "adeOfGenericUnoccupiedSpace"), container, namespaces, writer);
    }
}
