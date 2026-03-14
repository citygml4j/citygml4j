/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractPhysicalSpace;
import org.citygml4j.core.model.core.ADEOfAbstractPhysicalSpace;
import org.citygml4j.core.model.core.AbstractPhysicalSpace;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractPhysicalSpaceAdapter<T extends AbstractPhysicalSpace> extends AbstractSpaceAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "lod1TerrainIntersectionCurve":
                    object.setLod1TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod2TerrainIntersectionCurve":
                    object.setLod2TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod3TerrainIntersectionCurve":
                    object.setLod3TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "pointCloud":
                    object.setPointCloud(reader.getObjectUsingBuilder(AbstractPointCloudPropertyAdapter.class));
                    return;
                case "adeOfAbstractPhysicalSpace":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfAbstractPhysicalSpace::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace)) {
            if (object.getLod1TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod1TerrainIntersectionCurve"), object.getLod1TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod2TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod2TerrainIntersectionCurve"), object.getLod2TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod3TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod3TerrainIntersectionCurve"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getPointCloud() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "pointCloud"), object.getPointCloud(), AbstractPointCloudPropertyAdapter.class, namespaces);

            for (ADEOfAbstractPhysicalSpace property : object.getADEProperties(ADEOfAbstractPhysicalSpace.class))
                ADESerializerHelper.writeADEProperty(Element.of(coreNamespace, "adeOfAbstractPhysicalSpace"), property, namespaces, writer);
        }
    }
}
