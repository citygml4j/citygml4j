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

package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.ade.generic.GenericADEOfBridgeConstructiveElement;
import org.citygml4j.model.bridge.ADEOfBridgeConstructiveElement;
import org.citygml4j.model.bridge.BridgeConstructiveElement;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.construction.AbstractConstructiveElementAdapter;
import org.citygml4j.xml.adapter.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.xml.adapter.core.ImplicitGeometryPropertyAdapter;
import org.citygml4j.xml.adapter.deprecated.bridge.AbstractBoundarySurfacePropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
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
        @XMLElement(name = "BridgeConstructiveElement", namespaceURI = CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE),
        @XMLElement(name = "BridgeConstructionElement", namespaceURI = CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE)
})
public class BridgeConstructiveElementAdapter extends AbstractConstructiveElementAdapter<BridgeConstructiveElement> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfBridgeConstructionElement");

    @Override
    public BridgeConstructiveElement createObject(QName name, Object parent) throws ObjectBuildException {
        return new BridgeConstructiveElement();
    }

    @Override
    public void buildChildObject(BridgeConstructiveElement object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBridgeNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
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
                case "lod1TerrainIntersection":
                    object.setLod1TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod2TerrainIntersection":
                    object.setLod2TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod3TerrainIntersection":
                    object.setLod3TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod4TerrainIntersection":
                    object.getDeprecatedProperties().setLod4TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
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
                case "boundedBy":
                    object.addBoundary(reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class));
                    return;
                case "adeOfBridgeConstructiveElement":
                    ADEBuilderHelper.addADEContainer(ADEOfBridgeConstructiveElement.class, object.getADEOfBridgeConstructiveElement(), GenericADEOfBridgeConstructiveElement::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(BridgeConstructiveElement object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfBridgeConstructiveElement.class, object.getADEOfBridgeConstructiveElement(),
                GenericADEOfBridgeConstructiveElement::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(BridgeConstructiveElement object, Namespaces namespaces) throws ObjectSerializeException {
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);
        return CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(bridgeNamespace) ?
                Element.of(bridgeNamespace, "BridgeConstructiveElement") :
                Element.of(bridgeNamespace, "BridgeConstructionElement");
    }

    @Override
    public void writeChildElements(BridgeConstructiveElement object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(bridgeNamespace);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, bridgeNamespace, namespaces, writer);

        if (!isCityGML3) {
            if (object.getDeprecatedProperties().getLod1Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod1Geometry"), object.getDeprecatedProperties().getLod1Geometry(), GeometryPropertyAdapter.class, namespaces);
            else
                CityGMLSerializerHelper.writeDefaultGeometry(object, 1, "lod1Geometry", bridgeNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().getLod2Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2Geometry"), object.getDeprecatedProperties().getLod2Geometry(), GeometryPropertyAdapter.class, namespaces);
            else
                CityGMLSerializerHelper.writeDefaultGeometry(object, 2, "lod2Geometry", bridgeNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().getLod3Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3Geometry"), object.getDeprecatedProperties().getLod3Geometry(), GeometryPropertyAdapter.class, namespaces);
            else
                CityGMLSerializerHelper.writeDefaultGeometry(object, 3, "lod3Geometry", bridgeNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().getLod4Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4Geometry"), object.getDeprecatedProperties().getLod4Geometry(), GeometryPropertyAdapter.class, namespaces);

            if (object.getLod1TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod1TerrainIntersection"), object.getLod1TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod2TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2TerrainIntersection"), object.getLod2TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod3TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4TerrainIntersection"), object.getDeprecatedProperties().getLod4TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod1ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod1ImplicitRepresentation"), object.getLod1ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod2ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2ImplicitRepresentation"), object.getLod2ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod3ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3ImplicitRepresentation"), object.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4ImplicitRepresentation"), object.getDeprecatedProperties().getLod4ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);
        }

        for (ADEOfBridgeConstructiveElement container : object.getADEOfBridgeConstructiveElement())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(bridgeNamespace, "adeOfBridgeConstructiveElement") : null, container, namespaces, writer);
    }
}
