package org.citygml4j.adapter.xml.waterbody;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfWaterSurface;
import org.citygml4j.model.waterbody.ADEPropertyOfWaterSurface;
import org.citygml4j.model.waterbody.WaterSurface;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
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

@XMLElement(name = "WaterSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE)
public class WaterSurfaceAdapter extends AbstractWaterBoundarySurfaceAdapter<WaterSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "AbstractGenericApplicationPropertyOfWaterSurface");

    @Override
    public WaterSurface createObject(QName name) throws ObjectBuildException {
        return new WaterSurface();
    }

    @Override
    public void buildChildObject(WaterSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE.equals(name.getNamespaceURI()) && "waterLevel".equals(name.getLocalPart())) {
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
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfWaterSurface.class, object.getADEPropertiesOfWaterSurface(),
                GenericADEPropertyOfWaterSurface::of, reader, substitutionGroup))
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

        for (ADEPropertyOfWaterSurface<?> property : object.getADEPropertiesOfWaterSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
