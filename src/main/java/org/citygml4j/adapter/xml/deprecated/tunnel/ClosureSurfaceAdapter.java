package org.citygml4j.adapter.xml.deprecated.tunnel;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfClosureSurface;
import org.citygml4j.model.core.ADEPropertyOfClosureSurface;
import org.citygml4j.model.core.ClosureSurface;
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

@XMLElement(name = "ClosureSurface", namespaceURI = CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE)
public class ClosureSurfaceAdapter extends AbstractBoundarySurfaceAdapter<ClosureSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE, "_GenericApplicationPropertyOfClosureSurface");

    @Override
    public ClosureSurface createObject(QName name) throws ObjectBuildException {
        return new ClosureSurface();
    }

    @Override
    public void buildChildObject(ClosureSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(ClosureSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfClosureSurface.class, object.getADEPropertiesOfClosureSurface(),
                GenericADEPropertyOfClosureSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(ClosureSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getTunnelNamespace(namespaces), "ClosureSurface");
    }

    @Override
    public void writeChildElements(ClosureSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfClosureSurface property : object.getADEPropertiesOfClosureSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
