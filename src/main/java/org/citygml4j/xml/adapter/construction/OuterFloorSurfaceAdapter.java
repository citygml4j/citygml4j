package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.ade.generic.GenericADEOfOuterFloorSurface;
import org.citygml4j.model.construction.ADEOfOuterFloorSurface;
import org.citygml4j.model.construction.OuterFloorSurface;
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

@XMLElement(name = "OuterFloorSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class OuterFloorSurfaceAdapter extends AbstractConstructionSurfaceAdapter<OuterFloorSurface> {

    @Override
    public OuterFloorSurface createObject(QName name) throws ObjectBuildException {
        return new OuterFloorSurface();
    }

    @Override
    public void buildChildObject(OuterFloorSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfOuterFloorSurface".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfOuterFloorSurface.class, object.getADEOfOuterFloorSurface(), GenericADEOfOuterFloorSurface::new, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(OuterFloorSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "OuterFloorSurface");
    }

    @Override
    public void writeChildElements(OuterFloorSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfOuterFloorSurface container : object.getADEOfOuterFloorSurface())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfOuterFloorSurface"), container, namespaces, writer);
    }
}
