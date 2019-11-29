package org.citygml4j.adapter.xml.bridge;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.construction.AbstractFurnitureAdapter;
import org.citygml4j.adapter.xml.core.ImplicitGeometryPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBridgeFurniture;
import org.citygml4j.model.bridge.ADEPropertyOfBridgeFurniture;
import org.citygml4j.model.bridge.BridgeFurniture;
import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
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
        @XMLElement(name = "BridgeFurniture", namespaceURI = CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE),
        @XMLElement(name = "BridgeFurniture", namespaceURI = CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE)
})
public class BridgeFurnitureAdapter extends AbstractFurnitureAdapter<BridgeFurniture> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "AbstractGenericApplicationPropertyOfBridgeFurniture"),
            new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfBridgeFurniture")
    };

    @Override
    public BridgeFurniture createObject(QName name) throws ObjectBuildException {
        return new BridgeFurniture();
    }

    @Override
    public void buildChildObject(BridgeFurniture object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBridgeNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "lod4Geometry":
                    GeometryProperty<?> lod4Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 3, lod4Geometry))
                        object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod4ImplicitRepresentation":
                    object.setLod3ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(BridgeFurniture object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfBridgeFurniture.class, object.getADEPropertiesOfBridgeFurniture(),
                GenericADEPropertyOfBridgeFurniture::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(BridgeFurniture object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getBridgeNamespace(namespaces), "BridgeFurniture");
    }

    @Override
    public void writeChildElements(BridgeFurniture object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, bridgeNamespace, namespaces, writer);

        if (!CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(bridgeNamespace)) {
            if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_GEOMETRY)) {
                GeometryProperty<?> property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 3, "lod4Geometry", bridgeNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().getLod4ImplicitRepresentation() != null) {
                ImplicitGeometryProperty property = object.getDeprecatedProperties().getLod4ImplicitRepresentation();
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
            } else if (object.getLod3ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4ImplicitRepresentation"), object.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);
        }

        for (ADEPropertyOfBridgeFurniture<?> property : object.getADEPropertiesOfBridgeFurniture())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
