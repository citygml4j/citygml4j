package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.ade.generic.GenericADEOfFloorSurface;
import org.citygml4j.model.construction.ADEOfFloorSurface;
import org.citygml4j.model.construction.FloorSurface;
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

@XMLElement(name = "FloorSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class FloorSurfaceAdapter extends AbstractConstructionSurfaceAdapter<FloorSurface> {

    @Override
    public FloorSurface createObject(QName name) throws ObjectBuildException {
        return new FloorSurface();
    }

    @Override
    public void buildChildObject(FloorSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfFloorSurface".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfFloorSurface.class, object.getADEOfFloorSurface(), GenericADEOfFloorSurface::new, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(FloorSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "FloorSurface");
    }

    @Override
    public void writeChildElements(FloorSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfFloorSurface container : object.getADEOfFloorSurface())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfFloorSurface"), container, namespaces, writer);
    }
}
