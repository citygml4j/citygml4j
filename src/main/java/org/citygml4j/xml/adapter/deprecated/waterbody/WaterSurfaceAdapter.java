package org.citygml4j.xml.adapter.deprecated.waterbody;

import org.citygml4j.model.ade.generic.GenericADEOfWaterSurface;
import org.citygml4j.model.waterbody.ADEOfWaterSurface;
import org.citygml4j.model.waterbody.WaterSurface;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
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
        @XMLElement(name = "WaterSurface", namespaceURI = CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE),
        @XMLElement(name = "WaterSurface", namespaceURI = CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE)
})
public class WaterSurfaceAdapter extends AbstractWaterBoundarySurfaceAdapter<WaterSurface> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterSurface"),
            new QName(CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterSurface")
    };

    @Override
    public WaterSurface createObject(QName name, Object parent) throws ObjectBuildException {
        return new WaterSurface();
    }

    @Override
    public void buildChildObject(WaterSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isWaterBodyNamespace(name.getNamespaceURI()) && "waterLevel".equals(name.getLocalPart())) {
            object.setWaterLevel(reader.getObjectUsingBuilder(CodeAdapter.class));
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(WaterSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfWaterSurface.class, object.getADEOfWaterSurface(),
                GenericADEOfWaterSurface::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(WaterSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getWaterBodyNamespace(namespaces), "WaterSurface");
    }

    @Override
    public void writeChildElements(WaterSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getWaterLevel() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLSerializerHelper.getWaterBodyNamespace(namespaces), "waterLevel"), object.getWaterLevel(), CodeAdapter.class, namespaces);

        for (ADEOfWaterSurface container : object.getADEOfWaterSurface())
            ADESerializerHelper.writeADEProperty(container, namespaces, writer);
    }
}
