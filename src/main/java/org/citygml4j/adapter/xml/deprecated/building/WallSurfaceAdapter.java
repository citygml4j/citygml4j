package org.citygml4j.adapter.xml.deprecated.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfWallSurface;
import org.citygml4j.model.construction.ADEPropertyOfWallSurface;
import org.citygml4j.model.construction.WallSurface;
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
        @XMLElement(name = "WallSurface", namespaceURI = CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE),
        @XMLElement(name = "WallSurface", namespaceURI = CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE)
})
public class WallSurfaceAdapter extends AbstractBoundarySurfaceAdapter<WallSurface> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfWallSurface"),
            new QName(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfWallSurface")
    };

    @Override
    public WallSurface createObject(QName name) throws ObjectBuildException {
        return new WallSurface();
    }

    @Override
    public void buildChildObject(WallSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(WallSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfWallSurface.class, object.getADEPropertiesOfWallSurface(),
                GenericADEPropertyOfWallSurface::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(WallSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getBuildingNamespace(namespaces), "WallSurface");
    }

    @Override
    public void writeChildElements(WallSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfWallSurface<?> property : object.getADEPropertiesOfWallSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
