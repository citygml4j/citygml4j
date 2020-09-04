/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.ade.generic.GenericADEOfBuildingInstallation;
import org.citygml4j.model.building.ADEOfBuildingInstallation;
import org.citygml4j.model.building.BuildingInstallation;
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
import org.citygml4j.xml.adapter.deprecated.building.AbstractBoundarySurfacePropertyAdapter;
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
        @XMLElement(name = "BuildingInstallation", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE),
        @XMLElement(name = "BuildingInstallation", namespaceURI = CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE),
        @XMLElement(name = "BuildingInstallation", namespaceURI = CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE),
        @XMLElement(name = "IntBuildingInstallation", namespaceURI = CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE),
        @XMLElement(name = "IntBuildingInstallation", namespaceURI = CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE)
})
public class BuildingInstallationAdapter extends AbstractInstallationAdapter<BuildingInstallation> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfBuildingInstallation"),
            new QName(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfBuildingInstallation"),
            new QName(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfIntBuildingInstallation"),
            new QName(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfIntBuildingInstallation")
    };

    @Override
    public BuildingInstallation createObject(QName name, Object parent) throws ObjectBuildException {
        BuildingInstallation object = new BuildingInstallation();
        if ("IntBuildingInstallation".equals(name.getLocalPart()))
            object.setRelationToConstruction(RelationToConstruction.INSIDE);
        else if (!CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI()))
            object.setRelationToConstruction(RelationToConstruction.OUTSIDE);

        return object;
    }

    @Override
    public void buildChildObject(BuildingInstallation object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBuildingNamespace(name.getNamespaceURI())) {
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
                case "adeOfBuildingInstallation":
                    ADEBuilderHelper.addADEContainer(ADEOfBuildingInstallation.class, object.getADEOfBuildingInstallation(), GenericADEOfBuildingInstallation::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(BuildingInstallation object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfBuildingInstallation.class, object.getADEOfBuildingInstallation(),
                GenericADEOfBuildingInstallation::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(BuildingInstallation object, Namespaces namespaces) throws ObjectSerializeException {
        String buildingNamespace = CityGMLSerializerHelper.getBuildingNamespace(namespaces);
        return !CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(buildingNamespace)
                && object.getRelationToConstruction() == RelationToConstruction.INSIDE ?
                Element.of(buildingNamespace, "IntBuildingInstallation") :
                Element.of(buildingNamespace, "BuildingInstallation");
    }

    @Override
    public void writeChildElements(BuildingInstallation object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String buildingNamespace = CityGMLSerializerHelper.getBuildingNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(buildingNamespace);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, buildingNamespace, namespaces, writer);

        if (!isCityGML3) {
            boolean isInterior = object.getRelationToConstruction() == RelationToConstruction.INSIDE;

            if (!isInterior) {
                if (object.getDeprecatedProperties().getLod2Geometry() != null)
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod2Geometry"), object.getDeprecatedProperties().getLod2Geometry(), GeometryPropertyAdapter.class, namespaces);
                else
                    CityGMLSerializerHelper.writeDefaultGeometry(object, 2, "lod2Geometry", buildingNamespace, namespaces, writer);

                if (object.getDeprecatedProperties().getLod3Geometry() != null)
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3Geometry"), object.getDeprecatedProperties().getLod3Geometry(), GeometryPropertyAdapter.class, namespaces);
                else
                    CityGMLSerializerHelper.writeDefaultGeometry(object, 3, "lod3Geometry", buildingNamespace, namespaces, writer);
            }

            if (object.getDeprecatedProperties().getLod4Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4Geometry"), object.getDeprecatedProperties().getLod4Geometry(), GeometryPropertyAdapter.class, namespaces);

            if (!isInterior) {
                if (object.getLod2ImplicitRepresentation() != null)
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod2ImplicitRepresentation"), object.getLod2ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

                if (object.getLod3ImplicitRepresentation() != null)
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3ImplicitRepresentation"), object.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);
            }

            if (object.getDeprecatedProperties().getLod4ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4ImplicitRepresentation"), object.getDeprecatedProperties().getLod4ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);
        }

        for (ADEOfBuildingInstallation container : object.getADEOfBuildingInstallation())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(buildingNamespace, "adeOfBuildingFurniture") : null, container, namespaces, writer);
    }
}
