package org.citygml4j.xml.adapter.generics;

import org.citygml4j.model.ade.generic.GenericADEOfGenericLogicalSpace;
import org.citygml4j.model.generics.ADEOfGenericLogicalSpace;
import org.citygml4j.model.generics.GenericLogicalSpace;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractLogicalSpaceAdapter;
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

@XMLElement(name = "GenericLogicalSpace", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE)
public class GenericLogicalSpaceAdapter extends AbstractLogicalSpaceAdapter<GenericLogicalSpace> {

    @Override
    public GenericLogicalSpace createObject(QName name, Object parent) throws ObjectBuildException {
        return new GenericLogicalSpace();
    }

    @Override
    public void buildChildObject(GenericLogicalSpace object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;
            else if ("adeOfGenericLogicalSpace".equals(name.getLocalPart())) {
                ADEBuilderHelper.addADEContainer(ADEOfGenericLogicalSpace.class, object.getADEOfGenericLogicalSpace(), GenericADEOfGenericLogicalSpace::of, reader);
                return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(GenericLogicalSpace object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "GenericLogicalSpace");
    }

    @Override
    public void writeChildElements(GenericLogicalSpace object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, namespaces, writer);

        for (ADEOfGenericLogicalSpace container : object.getADEOfGenericLogicalSpace())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "adeOfGenericLogicalSpace"), container, namespaces, writer);
    }
}
