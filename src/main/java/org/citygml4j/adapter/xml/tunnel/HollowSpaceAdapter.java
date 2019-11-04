package org.citygml4j.adapter.xml.tunnel;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfacePropertyAdapter;
import org.citygml4j.adapter.xml.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfHollowSpace;
import org.citygml4j.model.core.AbstractThematicSurfaceProperty;
import org.citygml4j.model.tunnel.ADEPropertyOfHollowSpace;
import org.citygml4j.model.tunnel.HollowSpace;
import org.citygml4j.model.tunnel.TunnelFurnitureProperty;
import org.citygml4j.model.tunnel.TunnelInstallationProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
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
        @XMLElement(name = "HollowSpace", namespaceURI = CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE),
        @XMLElement(name = "HollowSpace", namespaceURI = CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE)
})
public class HollowSpaceAdapter extends AbstractUnoccupiedSpaceAdapter<HollowSpace> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "AbstractGenericApplicationPropertyOfHollowSpace"),
            new QName(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE, "_GenericApplicationPropertyOfHollowSpace")
    };

    @Override
    public HollowSpace createObject(QName name) throws ObjectBuildException {
        return new HollowSpace();
    }

    @Override
    public void buildChildObject(HollowSpace object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isTunnelNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "tunnelFurniture":
                case "interiorFurniture":
                    object.getTunnelFurniture().add(reader.getObjectUsingBuilder(TunnelFurniturePropertyAdapter.class));
                    return;
                case "tunnelInstallation":
                case "hollowSpaceInstallation":
                    object.getTunnelInstallations().add(reader.getObjectUsingBuilder(TunnelInstallationPropertyAdapter.class));
                    return;
                case "lod4Solid":
                    object.setLod3Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "boundedBy":
                    object.getBoundarySurfaces().add(reader.getObjectUsingBuilder(AbstractThematicSurfacePropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfHollowSpace> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfHollowSpace.class);
            if (builder != null)
                object.getADEPropertiesOfHollowSpace().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfHollowSpace().add(GenericADEPropertyOfHollowSpace.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(HollowSpace object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getTunnelNamespace(namespaces), "HollowSpace");
    }

    @Override
    public void writeChildElements(HollowSpace object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String tunnelNamespace = CityGMLSerializerHelper.getTunnelNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE.equals(tunnelNamespace);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, tunnelNamespace, namespaces, writer);

        if (!isCityGML3) {
            if (object.getLod3Solid() != null)
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getLod3MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            for (AbstractThematicSurfaceProperty property : object.getBoundarySurfaces())
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "boundedBy"), property, AbstractThematicSurfacePropertyAdapter.class, namespaces);
        }

        for (TunnelFurnitureProperty property : object.getTunnelFurniture())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, isCityGML3 ? "tunnelFurniture" : "interiorFurniture"), property, TunnelFurniturePropertyAdapter.class, namespaces);

        for (TunnelInstallationProperty property : object.getTunnelInstallations())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, isCityGML3 ? "tunnelInstallation" : "hollowSpaceInstallation"), property, TunnelInstallationPropertyAdapter.class, namespaces);

        for (ADEPropertyOfHollowSpace property : object.getADEPropertiesOfHollowSpace())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
