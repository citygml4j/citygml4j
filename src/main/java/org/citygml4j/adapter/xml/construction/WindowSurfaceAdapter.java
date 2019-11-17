package org.citygml4j.adapter.xml.construction;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfWindowSurface;
import org.citygml4j.model.construction.ADEPropertyOfWindowSurface;
import org.citygml4j.model.construction.WindowSurface;
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

@XMLElement(name = "WindowSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class WindowSurfaceAdapter extends AbstractFillingSurfaceAdapter<WindowSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "AbstractGenericApplicationPropertyOfWindowSurface");

    @Override
    public WindowSurface createObject(QName name) throws ObjectBuildException {
        return new WindowSurface();
    }

    @Override
    public void buildChildObject(WindowSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(WindowSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfWindowSurface.class, object.getADEPropertiesOfWindowSurface(),
                GenericADEPropertyOfWindowSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(WindowSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "WindowSurface");
    }

    @Override
    public void writeChildElements(WindowSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfWindowSurface property : object.getADEPropertiesOfWindowSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
