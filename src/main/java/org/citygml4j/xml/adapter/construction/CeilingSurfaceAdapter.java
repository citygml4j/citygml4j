package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.ade.generic.GenericADEOfCeilingSurface;
import org.citygml4j.model.construction.ADEOfCeilingSurface;
import org.citygml4j.model.construction.CeilingSurface;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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

@XMLElement(name = "CeilingSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class CeilingSurfaceAdapter extends AbstractConstructionSurfaceAdapter<CeilingSurface> {

    @Override
    public CeilingSurface createObject(QName name) throws ObjectBuildException {
        return new CeilingSurface();
    }

    @Override
    public void buildChildObject(CeilingSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfCeilingSurface".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfCeilingSurface.class, object.getADEOfCeilingSurface(), GenericADEOfCeilingSurface::new, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CeilingSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "CeilingSurface");
    }

    @Override
    public void writeChildElements(CeilingSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfCeilingSurface container : object.getADEOfCeilingSurface())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfCeilingSurface"), container, namespaces, writer);
    }
}
