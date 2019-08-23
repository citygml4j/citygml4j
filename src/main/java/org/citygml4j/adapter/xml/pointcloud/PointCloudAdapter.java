package org.citygml4j.adapter.xml.pointcloud;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfPointCloud;
import org.citygml4j.model.pointcloud.ADEPropertyOfPointCloud;
import org.citygml4j.model.pointcloud.PointCloud;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
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
public class PointCloudAdapter extends AbstractFeatureAdapter<PointCloud> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE, "AbstractGenericApplicationPropertyOfPointCloud");

    @Override
    public PointCloud createObject(QName name) {
        return new PointCloud();
    }

    @Override
    public void buildChildObject(PointCloud object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "mimeType":
                    object.setMimeType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "pointFile":
                    reader.getTextContent().ifPresent(object::setPointFile);
                    break;
                case "pointFileSrsName":
                    reader.getTextContent().ifPresent(object::setPointFileSrsName);
                    break;
                case "points":
                    object.setPoints(reader.getObjectUsingBuilder(MultiPointPropertyAdapter.class));
                    break;
            }
        } else if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            super.buildChildObject(object, name, attributes, reader);
        } else {
            ObjectBuilder<ADEPropertyOfPointCloud> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfPointCloud.class);
            if (builder != null)
                object.getADEPropertiesOfPointCloud().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfPointCloud().add(GenericADEPropertyOfPointCloud.of(reader.getDOMElement()));
        }
    }

    @Override
    public Element createElement(PointCloud object, Namespaces namespaces) {
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

        for (ADEPropertyOfPointCloud property : object.getADEPropertiesOfPointCloud())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
