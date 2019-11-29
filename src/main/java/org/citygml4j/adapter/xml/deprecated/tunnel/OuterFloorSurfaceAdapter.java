package org.citygml4j.adapter.xml.deprecated.tunnel;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfOuterFloorSurface;
import org.citygml4j.model.construction.ADEPropertyOfOuterFloorSurface;
import org.citygml4j.model.construction.OuterFloorSurface;
import org.citygml4j.util.CityGMLConstants;
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

@XMLElement(name = "OuterFloorSurface", namespaceURI = CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE)
public class OuterFloorSurfaceAdapter extends AbstractBoundarySurfaceAdapter<OuterFloorSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE, "_GenericApplicationPropertyOfOuterFloorSurface");

    @Override
    public OuterFloorSurface createObject(QName name) throws ObjectBuildException {
        return new OuterFloorSurface();
    }

    @Override
    public void buildChildObject(OuterFloorSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(OuterFloorSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfOuterFloorSurface.class, object.getADEPropertiesOfOuterFloorSurface(),
                GenericADEPropertyOfOuterFloorSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(OuterFloorSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getTunnelNamespace(namespaces), "OuterFloorSurface");
    }

    @Override
    public void writeChildElements(OuterFloorSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfOuterFloorSurface<?> property : object.getADEPropertiesOfOuterFloorSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
