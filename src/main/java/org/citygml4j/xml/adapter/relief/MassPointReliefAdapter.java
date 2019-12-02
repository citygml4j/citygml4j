package org.citygml4j.xml.adapter.relief;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractPointCloudPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfMassPointRelief;
import org.citygml4j.model.relief.ADEPropertyOfMassPointRelief;
import org.citygml4j.model.relief.MassPointRelief;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
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

@XMLElements({
        @XMLElement(name = "MassPointRelief", namespaceURI = CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE),
        @XMLElement(name = "MassPointRelief", namespaceURI = CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE),
        @XMLElement(name = "MassPointRelief", namespaceURI = CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE)
})
public class MassPointReliefAdapter extends AbstractReliefComponentAdapter<MassPointRelief> {
    private final QName[] substitutionGroups = new QName[]{
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
        if (CityGMLBuilderHelper.isReliefNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "reliefPoints":
                    object.setReliefPoints(reader.getObjectUsingBuilder(MultiPointPropertyAdapter.class));
                    return;
                case "pointCloud":
                    object.setPointCloud(reader.getObjectUsingBuilder(AbstractPointCloudPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(MassPointRelief object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfMassPointRelief.class, object.getADEPropertiesOfMassPointRelief(),
                GenericADEPropertyOfMassPointRelief::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(MassPointRelief object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getReliefNamespace(namespaces), "MassPointRelief");
    }

    @Override
    public void writeChildElements(MassPointRelief object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String reliefNamespace = CityGMLSerializerHelper.getReliefNamespace(namespaces);

        if (object.getReliefPoints() != null)
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "reliefPoints"), object.getReliefPoints(), MultiPointPropertyAdapter.class, namespaces);

        if (object.getPointCloud() != null && CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE.equals(reliefNamespace))
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "pointCloud"), object.getPointCloud(), AbstractPointCloudPropertyAdapter.class, namespaces);

        for (ADEPropertyOfMassPointRelief<?> property : object.getADEPropertiesOfMassPointRelief())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
