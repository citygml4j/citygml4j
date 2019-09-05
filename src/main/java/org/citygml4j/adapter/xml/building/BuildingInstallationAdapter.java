package org.citygml4j.adapter.xml.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.construction.AbstractInstallationAdapter;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfacePropertyAdapter;
import org.citygml4j.adapter.xml.core.ImplicitGeometryPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBuildingInstallation;
import org.citygml4j.model.building.ADEPropertyOfBuildingInstallation;
import org.citygml4j.model.building.BuildingInstallation;
import org.citygml4j.model.core.AbstractThematicSurfaceProperty;
import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
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
        @XMLElement(name = "BuildingInstallation", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE),
        @XMLElement(name = "BuildingInstallation", namespaceURI = CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE),
        @XMLElement(name = "BuildingInstallation", namespaceURI = CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE),
        @XMLElement(name = "IntBuildingInstallation", namespaceURI = CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE),
        @XMLElement(name = "IntBuildingInstallation", namespaceURI = CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE)
})
public class BuildingInstallationAdapter extends AbstractInstallationAdapter<BuildingInstallation> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "AbstractGenericApplicationPropertyOfBuildingInstallation"),
            new QName(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfBuildingInstallation"),
            new QName(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfBuildingInstallation"),
            new QName(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfIntBuildingInstallation"),
            new QName(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfIntBuildingInstallation"),
    };

    @Override
    public BuildingInstallation createObject(QName name) {
        BuildingInstallation object = new BuildingInstallation();
        if ("IntBuildingInstallation".equals(name.getLocalPart()))
            object.getLocalProperties().set(DeprecatedProperties.INT_BUILDING_INSTALLATION, true);

        return object;
    }

    @Override
    public void buildChildObject(BuildingInstallation object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLBuildingNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "lod2Geometry":
                    object.getLocalProperties().set(DeprecatedProperties.LOD2_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod3Geometry":
                    object.getLocalProperties().set(DeprecatedProperties.LOD3_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod4Geometry":
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod2ImplicitRepresentation":
                    object.getLocalProperties().set(DeprecatedProperties.LOD2_IMPLICIT_REPRESENTATION, reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "lod3ImplicitRepresentation":
                    object.getLocalProperties().set(DeprecatedProperties.LOD3_IMPLICIT_REPRESENTATION, reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "lod4ImplicitRepresentation":
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_IMPLICIT_REPRESENTATION, reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "boundedBy":
                    object.getBoundarySurfaces().add(reader.getObjectUsingBuilder(AbstractThematicSurfacePropertyAdapter.class));
                    return;
            }
        } else if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()) && "boundary".equals(name.getLocalPart())) {
            object.getBoundarySurfaces().add(reader.getObjectUsingBuilder(AbstractThematicSurfacePropertyAdapter.class));
            return;
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfBuildingInstallation> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfBuildingInstallation.class);
            if (builder != null)
                object.getADEPropertiesOfBuildingInstallation().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfBuildingInstallation().add(GenericADEPropertyOfBuildingInstallation.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BuildingInstallation object, Namespaces namespaces) {
        String buildingNamespace = CityGMLSerializerHelper.getBuildingNamespace(namespaces);
        return !CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(buildingNamespace)
                && object.getLocalProperties().getAndCompare(DeprecatedProperties.INT_BUILDING_INSTALLATION, true) ?
                Element.of(buildingNamespace, "IntBuildingInstallation") :
                Element.of(buildingNamespace, "BuildingInstallation");
    }

    @Override
    public void writeChildElements(BuildingInstallation object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String buildingNamespace = CityGMLSerializerHelper.getBuildingNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, buildingNamespace, namespaces, writer);

        if (!CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(buildingNamespace)) {
            boolean isInterior = object.getLocalProperties().getAndCompare(DeprecatedProperties.INT_BUILDING_INSTALLATION, true);

            if (!isInterior) {
                if (object.getLocalProperties().contains(DeprecatedProperties.LOD2_GEOMETRY)) {
                    GeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD2_GEOMETRY, GeometryProperty.class);
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod2Geometry"), property, GeometryPropertyAdapter.class, namespaces);
                }

                if (object.getLocalProperties().contains(DeprecatedProperties.LOD3_GEOMETRY)) {
                    GeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD3_GEOMETRY, GeometryProperty.class);
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3Geometry"), property, GeometryPropertyAdapter.class, namespaces);
                }
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_GEOMETRY)) {
                GeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            if (!isInterior) {
                if (object.getLocalProperties().contains(DeprecatedProperties.LOD2_IMPLICIT_REPRESENTATION)) {
                    ImplicitGeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD2_IMPLICIT_REPRESENTATION, ImplicitGeometryProperty.class);
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod2ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
                }

                if (object.getLocalProperties().contains(DeprecatedProperties.LOD3_IMPLICIT_REPRESENTATION)) {
                    ImplicitGeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD3_IMPLICIT_REPRESENTATION, ImplicitGeometryProperty.class);
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
                }
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_IMPLICIT_REPRESENTATION)) {
                ImplicitGeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_IMPLICIT_REPRESENTATION, ImplicitGeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
            }

            for (AbstractThematicSurfaceProperty property : object.getBoundarySurfaces())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "boundedBy"), property, AbstractThematicSurfacePropertyAdapter.class, namespaces);
        }

        for (ADEPropertyOfBuildingInstallation property : object.getADEPropertiesOfBuildingInstallation())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
