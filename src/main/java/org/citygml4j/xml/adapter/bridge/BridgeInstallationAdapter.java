package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.ade.generic.GenericADEOfBridgeInstallation;
import org.citygml4j.model.bridge.ADEOfBridgeInstallation;
import org.citygml4j.model.bridge.BridgeInstallation;
import org.citygml4j.model.construction.RelationToConstruction;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.construction.AbstractInstallationAdapter;
import org.citygml4j.xml.adapter.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.xml.adapter.core.ImplicitGeometryPropertyAdapter;
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
        @XMLElement(name = "BridgeInstallation", namespaceURI = CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE),
        @XMLElement(name = "BridgeInstallation", namespaceURI = CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE),
        @XMLElement(name = "IntBridgeInstallation", namespaceURI = CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE)
})
public class BridgeInstallationAdapter extends AbstractInstallationAdapter<BridgeInstallation> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfBridgeInstallation"),
            new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfIntBridgeInstallation")
    };

    @Override
    public BridgeInstallation createObject(QName name) throws ObjectBuildException {
        BridgeInstallation object = new BridgeInstallation();
        if ("IntBridgeInstallation".equals(name.getLocalPart()))
            object.setRelationToConstruction(RelationToConstruction.INSIDE);
        else if (CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE.equals(name.getNamespaceURI()))
            object.setRelationToConstruction(RelationToConstruction.OUTSIDE);

        return object;
    }

    @Override
    public void buildChildObject(BridgeInstallation object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBridgeNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "lod2Geometry":
                    GeometryProperty<?> lod2Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 2, lod2Geometry))
                        object.getDeprecatedProperties().setLod2Geometry(lod2Geometry);
                    return;
                case "lod3Geometry":
                    GeometryProperty<?> lod3Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 3, lod3Geometry))
                        object.getDeprecatedProperties().setLod3Geometry(lod3Geometry);
                    return;
                case "lod4Geometry":
                    object.getDeprecatedProperties().setLod4Geometry(reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod2ImplicitRepresentation":
                    object.setLod2ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "lod3ImplicitRepresentation":
                    object.setLod3ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "lod4ImplicitRepresentation":
                    object.getDeprecatedProperties().setLod4ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "boundedBy":
                    object.addBoundary(reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class));
                    return;
                case "adeOfBridgeInstallation":
                    ADEBuilderHelper.addADEContainer(ADEOfBridgeInstallation.class, object.getADEOfBridgeInstallation(), GenericADEOfBridgeInstallation::new, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(BridgeInstallation object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfBridgeInstallation.class, object.getADEOfBridgeInstallation(),
                GenericADEOfBridgeInstallation::new, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(BridgeInstallation object, Namespaces namespaces) throws ObjectSerializeException {
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);
        return !CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(bridgeNamespace)
                && object.getRelationToConstruction() == RelationToConstruction.INSIDE ?
                Element.of(bridgeNamespace, "IntBridgeInstallation") :
                Element.of(bridgeNamespace, "BridgeInstallation");
    }

    @Override
    public void writeChildElements(BridgeInstallation object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(bridgeNamespace);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, bridgeNamespace, namespaces, writer);

        if (!isCityGML3) {
            boolean isInterior = object.getRelationToConstruction() == RelationToConstruction.INSIDE;

            if (!isInterior) {
                if (object.getDeprecatedProperties().getLod2Geometry() != null)
                    writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2Geometry"), object.getDeprecatedProperties().getLod2Geometry(), GeometryPropertyAdapter.class, namespaces);
                else
                    CityGMLSerializerHelper.serializeDefaultGeometry(object, 2, "lod2Geometry", bridgeNamespace, namespaces, writer);

                if (object.getDeprecatedProperties().getLod3Geometry() != null)
                    writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3Geometry"), object.getDeprecatedProperties().getLod3Geometry(), GeometryPropertyAdapter.class, namespaces);
                else
                    CityGMLSerializerHelper.serializeDefaultGeometry(object, 3, "lod3Geometry", bridgeNamespace, namespaces, writer);
            }

            if (object.getDeprecatedProperties().getLod4Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4Geometry"), object.getDeprecatedProperties().getLod4Geometry(), GeometryPropertyAdapter.class, namespaces);

            if (!isInterior) {
                if (object.getLod2ImplicitRepresentation() != null)
                    writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2ImplicitRepresentation"), object.getLod2ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

                if (object.getLod3ImplicitRepresentation() != null)
                    writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3ImplicitRepresentation"), object.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);
            }

            if (object.getDeprecatedProperties().getLod4ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4ImplicitRepresentation"), object.getDeprecatedProperties().getLod4ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "boundedBy"), property, AbstractSpaceBoundaryPropertyAdapter.class, namespaces);
        }

        for (ADEOfBridgeInstallation container : object.getADEOfBridgeInstallation())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(bridgeNamespace, "adeOfBridgeInstallation") : null, container, namespaces, writer);
    }
}
