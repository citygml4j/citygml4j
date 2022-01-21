/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.pointcloud;

import org.citygml4j.model.ade.generic.GenericADEOfPointCloud;
import org.citygml4j.model.pointcloud.ADEOfPointCloud;
import org.citygml4j.model.pointcloud.PointCloud;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractPointCloudAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiPointPropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "PointCloud", namespaceURI = CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE)
public class PointCloudAdapter extends AbstractPointCloudAdapter<PointCloud> {

    @Override
    public PointCloud createObject(QName name, Object parent) throws ObjectBuildException {
        return new PointCloud();
    }

    @Override
    public void buildChildObject(PointCloud object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "mimeType":
                    object.setMimeType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "pointFile":
                    reader.getTextContent().ifPresent(object::setPointFile);
                    return;
                case "pointFileSrsName":
                    reader.getTextContent().ifPresent(object::setPointFileSrsName);
                    return;
                case "points":
                    object.setPoints(reader.getObjectUsingBuilder(MultiPointPropertyAdapter.class));
                    return;
                case "adeOfPointCloud":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfPointCloud::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(PointCloud object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE, "PointCloud");
    }

    @Override
    public void writeChildElements(PointCloud object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getMimeType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE, "mimeType"), object.getMimeType(), CodeAdapter.class, namespaces);

        if (object.getPointFile() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE, "pointFile").addTextContent(object.getPointFile()));

        if (object.getPointFileSrsName() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE, "pointFileSrsName").addTextContent(object.getPointFileSrsName()));

        if (object.getPoints() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE, "points"), object.getPoints(), MultiPointPropertyAdapter.class, namespaces);

        for (ADEOfPointCloud property : object.getADEProperties(ADEOfPointCloud.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE, "adeOfPointCloud"), property, namespaces, writer);
    }
}
