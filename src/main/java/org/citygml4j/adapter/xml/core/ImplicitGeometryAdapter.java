package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfImplicitGeometry;
import org.citygml4j.model.core.ADEPropertyOfImplicitGeometry;
import org.citygml4j.model.core.ImplicitGeometry;
import org.citygml4j.model.core.TransformationMatrix4x4;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
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

@XMLElement(name = "ImplicitGeometry", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class ImplicitGeometryAdapter extends AbstractFeatureAdapter<ImplicitGeometry> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "AbstractGenericApplicationPropertyOfImplicitGeometry");

    @Override
    public ImplicitGeometry createObject(QName name) {
        return new ImplicitGeometry();
    }

    @Override
    public void buildChildObject(ImplicitGeometry object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
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
            }
        } else if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            super.buildChildObject(object, name, attributes, reader);
        } else {
            ObjectBuilder<ADEPropertyOfImplicitGeometry> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfImplicitGeometry.class);
            if (builder != null)
                object.getADEPropertiesOfImplicitGeometry().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfImplicitGeometry().add(GenericADEPropertyOfImplicitGeometry.of(reader.getDOMElement()));
        }
    }

    @Override
    public Element createElement(ImplicitGeometry object, Namespaces namespaces) {
        return Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "ImplicitGeometry");
    }

    @Override
    public void writeChildElements(ImplicitGeometry object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getTransformationMatrix() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "transformationMatrix").addTextContent(TextContent.ofDoubleList(object.getTransformationMatrix().toRowMajorList())));

        if (object.getMimeType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "mimeType"), object.getMimeType(), CodeAdapter.class, namespaces);

        if (object.getLibraryObject() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "libraryObject").addTextContent(object.getLibraryObject()));

        if (object.getReferencePoint() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "referencePoint"), object.getReferencePoint(), PointPropertyAdapter.class, namespaces);

        if (object.getRelativeGMLGeometry() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "relativeGMLGeometry"), object.getRelativeGMLGeometry(), GeometryPropertyAdapter.class, namespaces);

        for (ADEPropertyOfImplicitGeometry property : object.getADEPropertiesOfImplicitGeometry())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
