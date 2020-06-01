package org.citygml4j.xml.adapter.generics;

import org.citygml4j.model.ade.generic.GenericADEOfGenericThematicSurface;
import org.citygml4j.model.generics.ADEOfGenericThematicSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractThematicSurfaceAdapter;
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

@XMLElement(name = "GenericThematicSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE)
public class GenericThematicSurfaceAdapter extends AbstractThematicSurfaceAdapter<GenericThematicSurface> {

    @Override
    public GenericThematicSurface createObject(QName name) throws ObjectBuildException {
        return new GenericThematicSurface();
    }

    @Override
    public void buildChildObject(GenericThematicSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;
            else if ("adeOfGenericThematicSurface".equals(name.getLocalPart())) {
                ADEBuilderHelper.addADEContainer(ADEOfGenericThematicSurface.class, object.getADEOfGenericThematicSurface(), GenericADEOfGenericThematicSurface::new, reader);
                return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(GenericThematicSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "GenericThematicSurface");
    }

    @Override
    public void writeChildElements(GenericThematicSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, namespaces, writer);

        for (ADEOfGenericThematicSurface container : object.getADEOfGenericThematicSurface())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "adeOfGenericThematicSurface"), container, namespaces, writer);
    }
}
