/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.vegetation;

import org.citygml4j.core.model.ade.generic.GenericADEOfSolitaryVegetationObject;
import org.citygml4j.core.model.deprecated.vegetation.DeprecatedPropertiesOfSolitaryVegetationObject;
import org.citygml4j.core.model.vegetation.ADEOfSolitaryVegetationObject;
import org.citygml4j.core.model.vegetation.SolitaryVegetationObject;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.ImplicitGeometryPropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.adapter.measures.LengthAdapter;
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
        @XMLElement(name = "SolitaryVegetationObject", namespaceURI = CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE),
        @XMLElement(name = "SolitaryVegetationObject", namespaceURI = CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE),
        @XMLElement(name = "SolitaryVegetationObject", namespaceURI = CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE)
})
public class SolitaryVegetationObjectAdapter extends AbstractVegetationObjectAdapter<SolitaryVegetationObject> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE, "_GenericApplicationPropertyOfSolitaryVegetationObject"),
            new QName(CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE, "_GenericApplicationPropertyOfSolitaryVegetationObject")
    };

    @Override
    public SolitaryVegetationObject createObject(QName name, Object parent) throws ObjectBuildException {
        return new SolitaryVegetationObject();
    }

    @Override
    public void buildChildObject(SolitaryVegetationObject object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isVegetationNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "species":
                    object.setSpecies(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "height":
                    object.setHeight(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "trunkDiameter":
                    object.setTrunkDiameter(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "crownDiameter":
                    object.setCrownDiameter(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "rootBallDiameter":
                    object.setRootBallDiameter(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "maxRootBallDepth":
                    object.setMaxRootBallDepth(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "lod1Geometry":
                    GeometryProperty<?> lod1Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 1, lod1Geometry))
                        object.getDeprecatedProperties().setLod1Geometry(lod1Geometry);
                    return;
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
                case "lod1ImplicitRepresentation":
                    object.setLod1ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
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
                case "adeOfSolitaryVegetationObject":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfSolitaryVegetationObject::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(SolitaryVegetationObject object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfSolitaryVegetationObject::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(SolitaryVegetationObject object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getVegetationNamespace(namespaces), "SolitaryVegetationObject");
    }

    @Override
    public void writeChildElements(SolitaryVegetationObject object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String vegetationNamespace = CityGMLSerializerHelper.getVegetationNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE.equals(vegetationNamespace);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, vegetationNamespace, namespaces, writer);

        if (object.getSpecies() != null)
            writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "species"), object.getSpecies(), CodeAdapter.class, namespaces);

        if (object.getHeight() != null)
            writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "height"), object.getHeight(), LengthAdapter.class, namespaces);

        if (object.getTrunkDiameter() != null)
            writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "trunkDiameter"), object.getTrunkDiameter(), LengthAdapter.class, namespaces);

        if (object.getCrownDiameter() != null)
            writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "crownDiameter"), object.getCrownDiameter(), LengthAdapter.class, namespaces);

        if (isCityGML3) {
            if (object.getRootBallDiameter() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "rootBallDiameter"), object.getRootBallDiameter(), LengthAdapter.class, namespaces);

            if (object.getMaxRootBallDepth() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "maxRootBallDepth"), object.getMaxRootBallDepth(), LengthAdapter.class, namespaces);
        }

        if (!isCityGML3) {
            DeprecatedPropertiesOfSolitaryVegetationObject properties = object.hasDeprecatedProperties() ?
                    object.getDeprecatedProperties() :
                    null;

            if (properties != null && properties.getLod1Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod1Geometry"), properties.getLod1Geometry(), GeometryPropertyAdapter.class, namespaces);
            else
                CityGMLSerializerHelper.writeDefaultGeometry(object, 1, "lod1Geometry", vegetationNamespace, namespaces, writer);

            if (properties != null && properties.getLod2Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod2Geometry"), properties.getLod2Geometry(), GeometryPropertyAdapter.class, namespaces);
            else
                CityGMLSerializerHelper.writeDefaultGeometry(object, 2, "lod2Geometry", vegetationNamespace, namespaces, writer);

            if (properties != null && properties.getLod3Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod3Geometry"), properties.getLod3Geometry(), GeometryPropertyAdapter.class, namespaces);
            else
                CityGMLSerializerHelper.writeDefaultGeometry(object, 3, "lod3Geometry", vegetationNamespace, namespaces, writer);

            if (properties != null && properties.getLod4Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod4Geometry"), properties.getLod4Geometry(), GeometryPropertyAdapter.class, namespaces);

            if (object.getLod1ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod1ImplicitRepresentation"), object.getLod1ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod2ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod2ImplicitRepresentation"), object.getLod2ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod3ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod3ImplicitRepresentation"), object.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (properties != null && properties.getLod4ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod4ImplicitRepresentation"), properties.getLod4ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);
        }

        for (ADEOfSolitaryVegetationObject property : object.getADEProperties(ADEOfSolitaryVegetationObject.class))
            ADESerializerHelper.writeADEProperty(isCityGML3 ? Element.of(vegetationNamespace, "adeOfSolitaryVegetationObject") : null, property, namespaces, writer);
    }
}
