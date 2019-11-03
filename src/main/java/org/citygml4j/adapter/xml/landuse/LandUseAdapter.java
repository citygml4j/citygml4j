package org.citygml4j.adapter.xml.landuse;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfLandUse;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.landuse.ADEPropertyOfLandUse;
import org.citygml4j.model.landuse.LandUse;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
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
        @XMLElement(name = "LandUse", namespaceURI = CityGMLConstants.CITYGML_3_0_LANDUSE_NAMESPACE),
        @XMLElement(name = "LandUse", namespaceURI = CityGMLConstants.CITYGML_2_0_LANDUSE_NAMESPACE),
        @XMLElement(name = "LandUse", namespaceURI = CityGMLConstants.CITYGML_1_0_LANDUSE_NAMESPACE)
})
public class LandUseAdapter extends AbstractThematicSurfaceAdapter<LandUse> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_LANDUSE_NAMESPACE, "AbstractGenericApplicationPropertyOfLandUse"),
            new QName(CityGMLConstants.CITYGML_2_0_LANDUSE_NAMESPACE, "_GenericApplicationPropertyOfLandUse"),
            new QName(CityGMLConstants.CITYGML_1_0_LANDUSE_NAMESPACE, "_GenericApplicationPropertyOfLandUse"),
    };

    @Override
    public LandUse createObject(QName name) throws ObjectBuildException {
        return new LandUse();
    }

    @Override
    public void buildChildObject(LandUse object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLLandUseNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "lod0MultiSurface":
                    object.setLod0MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1MultiSurface":
                    object.setLod1MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod2MultiSurface":
                    object.setLod2MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfLandUse> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfLandUse.class);
            if (builder != null)
                object.getADEPropertiesOfLandUse().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfLandUse().add(GenericADEPropertyOfLandUse.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(LandUse object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getLandUseNamespace(namespaces), "LandUse");
    }

    @Override
    public void writeChildElements(LandUse object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String landUseNamespace = CityGMLSerializerHelper.getLandUseNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, landUseNamespace, namespaces, writer);

        if (!CityGMLConstants.CITYGML_3_0_LANDUSE_NAMESPACE.equals(landUseNamespace)) {
            if (object.getLod0MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(landUseNamespace, "lod0MultiSurface"), object.getLod0MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod1MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(landUseNamespace, "lod1MultiSurface"), object.getLod1MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod2MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(landUseNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod3MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(landUseNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE)) {
                MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, MultiSurfaceProperty.class);
                writer.writeElementUsingSerializer(Element.of(landUseNamespace, "lod4MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
            }
        }

        for (ADEPropertyOfLandUse property : object.getADEPropertiesOfLandUse())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
