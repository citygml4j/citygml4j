package org.citygml4j.xml.adapter.deprecated.waterbody;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfWaterGroundSurface;
import org.citygml4j.model.waterbody.ADEPropertyOfWaterGroundSurface;
import org.citygml4j.model.waterbody.WaterGroundSurface;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
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

@XMLElements({
        @XMLElement(name = "WaterGroundSurface", namespaceURI = CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE),
        @XMLElement(name = "WaterGroundSurface", namespaceURI = CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE)
})
public class WaterGroundSurfaceAdapter extends AbstractWaterBoundarySurfaceAdapter<WaterGroundSurface> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterGroundSurface"),
            new QName(CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterGroundSurface")
    };

    @Override
    public WaterGroundSurface createObject(QName name) throws ObjectBuildException {
        return new WaterGroundSurface();
    }

    @Override
    public void buildChildObject(WaterGroundSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(WaterGroundSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfWaterGroundSurface.class, object.getADEPropertiesOfWaterGroundSurface(),
                GenericADEPropertyOfWaterGroundSurface::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(WaterGroundSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getWaterBodyNamespace(namespaces), "WaterGroundSurface");
    }

    @Override
    public void writeChildElements(WaterGroundSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfWaterGroundSurface<?> property : object.getADEPropertiesOfWaterGroundSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
