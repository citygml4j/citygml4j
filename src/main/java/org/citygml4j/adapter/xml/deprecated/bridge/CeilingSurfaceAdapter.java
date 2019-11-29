package org.citygml4j.adapter.xml.deprecated.bridge;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfCeilingSurface;
import org.citygml4j.model.construction.ADEPropertyOfCeilingSurface;
import org.citygml4j.model.construction.CeilingSurface;
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

@XMLElement(name = "CeilingSurface", namespaceURI = CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE)
public class CeilingSurfaceAdapter extends AbstractBoundarySurfaceAdapter<CeilingSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfCeilingSurface");

    @Override
    public CeilingSurface createObject(QName name) throws ObjectBuildException {
        return new CeilingSurface();
    }

    @Override
    public void buildChildObject(CeilingSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(CeilingSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfCeilingSurface.class, object.getADEPropertiesOfCeilingSurface(),
                GenericADEPropertyOfCeilingSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(CeilingSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getBridgeNamespace(namespaces), "CeilingSurface");
    }

    @Override
    public void writeChildElements(CeilingSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfCeilingSurface<?> property : object.getADEPropertiesOfCeilingSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
