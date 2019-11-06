package org.citygml4j.adapter.xml.tunnel;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.construction.AbstractFurnitureAdapter;
import org.citygml4j.adapter.xml.core.ImplicitGeometryPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfTunnelFurniture;
import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.tunnel.ADEPropertyOfTunnelFurniture;
import org.citygml4j.model.tunnel.TunnelFurniture;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
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
        @XMLElement(name = "TunnelFurniture", namespaceURI = CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE),
        @XMLElement(name = "TunnelFurniture", namespaceURI = CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE)
})
public class TunnelFurnitureAdapter extends AbstractFurnitureAdapter<TunnelFurniture> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "AbstractGenericApplicationPropertyOfTunnelFurniture"),
            new QName(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE, "_GenericApplicationPropertyOfTunnelFurniture")
    };

    @Override
    public TunnelFurniture createObject(QName name) throws ObjectBuildException {
        return new TunnelFurniture();
    }

    @Override
    public void buildChildObject(TunnelFurniture object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isTunnelNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "lod4Geometry":
                    GeometryProperty lod4Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 3, lod4Geometry))
                        object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod4ImplicitRepresentation":
                    object.setLod3ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfTunnelFurniture> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfTunnelFurniture.class);
            if (builder != null)
                object.getADEPropertiesOfTunnelFurniture().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfTunnelFurniture().add(GenericADEPropertyOfTunnelFurniture.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(TunnelFurniture object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getTunnelNamespace(namespaces), "TunnelFurniture");
    }

    @Override
    public void writeChildElements(TunnelFurniture object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String tunnelNamespace = CityGMLSerializerHelper.getTunnelNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, tunnelNamespace, namespaces, writer);

        if (!CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE.equals(tunnelNamespace)) {
            if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_GEOMETRY)) {
                GeometryProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 3, "lod4Geometry", tunnelNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().getLod4ImplicitRepresentation() != null) {
                ImplicitGeometryProperty property = object.getDeprecatedProperties().getLod4ImplicitRepresentation();
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
            } else if (object.getLod3ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4ImplicitRepresentation"), object.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);
        }

        for (ADEPropertyOfTunnelFurniture property : object.getADEPropertiesOfTunnelFurniture())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
