package org.citygml4j.adapter.xml.deprecated.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfInteriorWallSurface;
import org.citygml4j.model.construction.ADEPropertyOfInteriorWallSurface;
import org.citygml4j.model.construction.InteriorWallSurface;
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
        @XMLElement(name = "InteriorWallSurface", namespaceURI = CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE),
        @XMLElement(name = "InteriorWallSurface", namespaceURI = CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE)
})
public class InteriorWallSurfaceAdapter extends AbstractBoundarySurfaceAdapter<InteriorWallSurface> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfInteriorWallSurface"),
            new QName(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfInteriorWallSurface")
    };

    @Override
    public InteriorWallSurface createObject(QName name) throws ObjectBuildException {
        return new InteriorWallSurface();
    }

    @Override
    public void buildChildObject(InteriorWallSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(InteriorWallSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfInteriorWallSurface.class, object.getADEPropertiesOfInteriorWallSurface(),
                GenericADEPropertyOfInteriorWallSurface::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(InteriorWallSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getBuildingNamespace(namespaces), "InteriorWallSurface");
    }

    @Override
    public void writeChildElements(InteriorWallSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfInteriorWallSurface<?> property : object.getADEPropertiesOfInteriorWallSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
