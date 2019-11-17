package org.citygml4j.adapter.xml.deprecated.bridge;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractCityObjectAdapter;
import org.citygml4j.adapter.xml.core.ImplicitGeometryPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractFillingSurface;
import org.citygml4j.model.construction.ADEPropertyOfAbstractFillingSurface;
import org.citygml4j.model.construction.AbstractFillingSurface;
import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
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

public abstract class AbstractOpeningAdapter<T extends AbstractFillingSurface> extends AbstractCityObjectAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfOpening");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBridgeNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod3ImplicitRepresentation":
                    object.getDeprecatedProperties().setLod3ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "lod4ImplicitRepresentation":
                    object.getDeprecatedProperties().setLod4ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractFillingSurface.class, object.getADEPropertiesOfAbstractFillingSurface(),
                GenericADEPropertyOfAbstractFillingSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().getLod3ImplicitRepresentation() != null) {
            ImplicitGeometryProperty property = object.getDeprecatedProperties().getLod3ImplicitRepresentation();
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().getLod4ImplicitRepresentation() != null) {
            ImplicitGeometryProperty property = object.getDeprecatedProperties().getLod4ImplicitRepresentation();
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
        }

        for (ADEPropertyOfAbstractFillingSurface property : object.getADEPropertiesOfAbstractFillingSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
