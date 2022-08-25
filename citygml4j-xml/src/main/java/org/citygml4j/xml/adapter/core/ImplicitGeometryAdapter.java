/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.core.AbstractAppearanceProperty;
import org.citygml4j.core.model.core.ImplicitGeometry;
import org.citygml4j.core.model.core.TransformationMatrix4x4;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractGMLAdapter;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.PointPropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "ImplicitGeometry", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE),
        @XMLElement(name = "ImplicitGeometry", namespaceURI = CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE),
        @XMLElement(name = "ImplicitGeometry", namespaceURI = CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE)
})
public class ImplicitGeometryAdapter extends AbstractGMLAdapter<ImplicitGeometry> {

    @Override
    public ImplicitGeometry createObject(QName name, Object parent) throws ObjectBuildException {
        return new ImplicitGeometry();
    }

    @Override
    public void buildChildObject(ImplicitGeometry object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCoreNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "transformationMatrix":
                    reader.getTextContent().ifDoubleList(v -> object.setTransformationMatrix(TransformationMatrix4x4.ofRowMajorList(v)));
                    break;
                case "mimeType":
                    object.setMimeType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "libraryObject":
                    reader.getTextContent().ifPresent(object::setLibraryObject);
                    break;
                case "referencePoint":
                    object.setReferencePoint(reader.getObjectUsingBuilder(PointPropertyAdapter.class));
                    break;
                case "relativeGeometry":
                case "relativeGMLGeometry":
                    object.setRelativeGeometry(reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    break;
                case "appearance":
                    object.getAppearances().add(reader.getObjectUsingBuilder(AbstractAppearancePropertyAdapter.class));
                    break;
            }
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(ImplicitGeometry object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getCoreNamespace(namespaces), "ImplicitGeometry");
    }

    @Override
    public void writeChildElements(ImplicitGeometry object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace)) {
            if (object.getTransformationMatrix() != null)
                writer.writeElement(Element.of(coreNamespace, "transformationMatrix").addTextContent(TextContent.ofDoubleList(object.getTransformationMatrix().toRowMajorList())));

            if (object.getMimeType() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "mimeType"), object.getMimeType(), CodeAdapter.class, namespaces);

            if (object.getLibraryObject() != null)
                writer.writeElement(Element.of(coreNamespace, "libraryObject").addTextContent(object.getLibraryObject()));

            if (object.getReferencePoint() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "referencePoint"), object.getReferencePoint(), PointPropertyAdapter.class, namespaces);

            if (object.getRelativeGeometry() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "relativeGeometry"), object.getRelativeGeometry(), GeometryPropertyAdapter.class, namespaces);

            if (object.isSetAppearances()) {
                for (AbstractAppearanceProperty member : object.getAppearances())
                    writer.writeElementUsingSerializer(Element.of(coreNamespace, "appearance"), member, AbstractAppearancePropertyAdapter.class, namespaces);
            }
        } else {
            if (object.getMimeType() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "mimeType"), object.getMimeType(), CodeAdapter.class, namespaces);

            if (object.getTransformationMatrix() != null)
                writer.writeElement(Element.of(coreNamespace, "transformationMatrix").addTextContent(TextContent.ofDoubleList(object.getTransformationMatrix().toRowMajorList())));

            if (object.getLibraryObject() != null)
                writer.writeElement(Element.of(coreNamespace, "libraryObject").addTextContent(object.getLibraryObject()));

            if (object.getRelativeGeometry() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "relativeGMLGeometry"), object.getRelativeGeometry(), GeometryPropertyAdapter.class, namespaces);

            if (object.getReferencePoint() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "referencePoint"), object.getReferencePoint(), PointPropertyAdapter.class, namespaces);
        }
    }
}
