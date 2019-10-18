package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.core.AbstractAppearanceProperty;
import org.citygml4j.model.core.ImplicitGeometry;
import org.citygml4j.model.core.TransformationMatrix4x4;
import org.citygml4j.util.CityGMLConstants;
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
    public ImplicitGeometry createObject(QName name) {
        return new ImplicitGeometry();
    }

    @Override
    public void buildChildObject(ImplicitGeometry object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLCoreNamespace(name.getNamespaceURI())) {
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
                case "relativeGMLGeometry":
                    object.setRelativeGMLGeometry(reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    break;
                case "appearance":
                    object.getAppearances().add(reader.getObjectUsingBuilder(AbstractAppearancePropertyAdapter.class));
                    break;
            }
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(ImplicitGeometry object, Namespaces namespaces) {
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

            if (object.getRelativeGMLGeometry() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "relativeGMLGeometry"), object.getRelativeGMLGeometry(), GeometryPropertyAdapter.class, namespaces);

            for (AbstractAppearanceProperty member : object.getAppearances())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "appearance"), member, AbstractAppearancePropertyAdapter.class, namespaces);
        } else {
            if (object.getMimeType() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "mimeType"), object.getMimeType(), CodeAdapter.class, namespaces);

            if (object.getTransformationMatrix() != null)
                writer.writeElement(Element.of(coreNamespace, "transformationMatrix").addTextContent(TextContent.ofDoubleList(object.getTransformationMatrix().toRowMajorList())));

            if (object.getLibraryObject() != null)
                writer.writeElement(Element.of(coreNamespace, "libraryObject").addTextContent(object.getLibraryObject()));

            if (object.getRelativeGMLGeometry() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "relativeGMLGeometry"), object.getRelativeGMLGeometry(), GeometryPropertyAdapter.class, namespaces);

            if (object.getReferencePoint() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "referencePoint"), object.getReferencePoint(), PointPropertyAdapter.class, namespaces);
        }
    }
}
