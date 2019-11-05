package org.citygml4j.adapter.xml.relief;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfMassPointRelief;
import org.citygml4j.model.core.AbstractPointCloudProperty;
import org.citygml4j.model.pointcloud.PointCloud;
import org.citygml4j.model.relief.ADEPropertyOfMassPointRelief;
import org.citygml4j.model.relief.MassPointRelief;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiPointPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
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
        @XMLElement(name = "MassPointRelief", namespaceURI = CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE),
        @XMLElement(name = "MassPointRelief", namespaceURI = CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE),
        @XMLElement(name = "MassPointRelief", namespaceURI = CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE)
})
public class MassPointReliefAdapter extends AbstractReliefComponentAdapter<MassPointRelief> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE, "AbstractGenericApplicationPropertyOfMassPointRelief"),
            new QName(CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfMassPointRelief"),
            new QName(CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfMassPointRelief")
    };

    @Override
    public MassPointRelief createObject(QName name) throws ObjectBuildException {
        return new MassPointRelief();
    }

    @Override
    public void buildChildObject(MassPointRelief object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isReliefNamespace(name.getNamespaceURI()) && "reliefPoints".equals(name.getLocalPart())) {
            MultiPointProperty reliefPoints = reader.getObjectUsingBuilder(MultiPointPropertyAdapter.class);
            object.setPointCloud(new AbstractPointCloudProperty(new PointCloud(reliefPoints)));
            return;
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfMassPointRelief> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfMassPointRelief.class);
            if (builder != null)
                object.getADEPropertiesOfMassPointRelief().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfMassPointRelief().add(GenericADEPropertyOfMassPointRelief.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(MassPointRelief object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getReliefNamespace(namespaces), "MassPointRelief");
    }

    @Override
    public void writeChildElements(MassPointRelief object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String reliefNamespace = CityGMLSerializerHelper.getReliefNamespace(namespaces);

        if (!CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE.equals(reliefNamespace)
                && object.getPointCloud() != null
                && object.getPointCloud().getObject() instanceof PointCloud
                && ((PointCloud) object.getPointCloud().getObject()).getPoints() != null) {
            MultiPointProperty property = ((PointCloud) object.getPointCloud().getObject()).getPoints();
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "reliefPoints"), property, MultiPointPropertyAdapter.class, namespaces);
        }

        for (ADEPropertyOfMassPointRelief property : object.getADEPropertiesOfMassPointRelief())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
