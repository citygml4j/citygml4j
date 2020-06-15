package org.citygml4j.xml.adapter.deprecated.bridge;

import org.citygml4j.model.ade.generic.GenericADEOfCeilingSurface;
import org.citygml4j.model.construction.ADEOfCeilingSurface;
import org.citygml4j.model.construction.CeilingSurface;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
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

@XMLElement(name = "CeilingSurface", namespaceURI = CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE)
public class CeilingSurfaceAdapter extends AbstractBoundarySurfaceAdapter<CeilingSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfCeilingSurface");

    @Override
    public CeilingSurface createObject(QName name, Object parent) throws ObjectBuildException {
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
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfCeilingSurface.class, object.getADEOfCeilingSurface(),
                GenericADEOfCeilingSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(CeilingSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getBridgeNamespace(namespaces), "CeilingSurface");
    }

    @Override
    public void writeChildElements(CeilingSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfCeilingSurface container : object.getADEOfCeilingSurface())
            ADESerializerHelper.writeADEProperty(container, namespaces, writer);
    }
}
