package org.citygml4j.xml.adapter.waterbody;

import org.citygml4j.model.ade.generic.GenericADEOfWaterGroundSurface;
import org.citygml4j.model.waterbody.ADEOfWaterGroundSurface;
import org.citygml4j.model.waterbody.WaterGroundSurface;
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

@XMLElement(name = "WaterGroundSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE)
public class WaterGroundSurfaceAdapter extends AbstractWaterBoundarySurfaceAdapter<WaterGroundSurface> {

    @Override
    public WaterGroundSurface createObject(QName name, Object parent) throws ObjectBuildException {
        return new WaterGroundSurface();
    }

    @Override
    public void buildChildObject(WaterGroundSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfWaterGroundSurface".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfWaterGroundSurface.class, object.getADEOfWaterGroundSurface(), GenericADEOfWaterGroundSurface::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(WaterGroundSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "WaterGroundSurface");
    }

    @Override
    public void writeChildElements(WaterGroundSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfWaterGroundSurface container : object.getADEOfWaterGroundSurface())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "adeOfWaterGroundSurface"), container, namespaces, writer);
    }
}
