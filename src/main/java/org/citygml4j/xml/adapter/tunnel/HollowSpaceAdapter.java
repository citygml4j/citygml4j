package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.model.ade.generic.GenericADEOfHollowSpace;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.tunnel.ADEOfHollowSpace;
import org.citygml4j.model.tunnel.HollowSpace;
import org.citygml4j.model.tunnel.TunnelFurnitureProperty;
import org.citygml4j.model.tunnel.TunnelInstallationProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.xml.adapter.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.xml.adapter.deprecated.tunnel.AbstractBoundarySurfacePropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
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
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE, "_GenericApplicationPropertyOfHollowSpace");

    @Override
    public HollowSpace createObject(QName name, Object parent) throws ObjectBuildException {
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
                    object.getDeprecatedProperties().setLod4Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().setLod4MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "boundedBy":
                    object.addBoundary(reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class));
                    return;
                case "adeOfHollowSpace":
                    ADEBuilderHelper.addADEContainer(ADEOfHollowSpace.class, object.getADEOfHollowSpace(), GenericADEOfHollowSpace::new, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(HollowSpace object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfHollowSpace.class, object.getADEOfHollowSpace(),
                GenericADEOfHollowSpace::new, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
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

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, tunnelNamespace, namespaces, writer);

        if (!isCityGML3) {
            if (object.getDeprecatedProperties().getLod4Solid() != null)
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4Solid"), object.getDeprecatedProperties().getLod4Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4MultiSurface"), object.getDeprecatedProperties().getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);
        }

        for (TunnelFurnitureProperty property : object.getTunnelFurniture())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, isCityGML3 ? "tunnelFurniture" : "interiorFurniture"), property, TunnelFurniturePropertyAdapter.class, namespaces);

        for (TunnelInstallationProperty property : object.getTunnelInstallations())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, isCityGML3 ? "tunnelInstallation" : "hollowSpaceInstallation"), property, TunnelInstallationPropertyAdapter.class, namespaces);

        for (ADEOfHollowSpace container : object.getADEOfHollowSpace())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(tunnelNamespace, "adeOfHollowSpace") : null, container, namespaces, writer);
    }
}
