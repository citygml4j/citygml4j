package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.ade.generic.GenericADEPropertyOfDynamizer;
import org.citygml4j.model.dynamizer.ADEPropertyOfDynamizer;
import org.citygml4j.model.dynamizer.Dynamizer;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractDynamizerAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.temporal.TimePositionAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "Dynamizer", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class DynamizerAdapter extends AbstractDynamizerAdapter<Dynamizer> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "AbstractGenericApplicationPropertyOfDynamizer");

    @Override
    public Dynamizer createObject(QName name) throws ObjectBuildException {
        return new Dynamizer();
    }

    @Override
    public void buildChildObject(Dynamizer object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "attributeRef":
                    reader.getTextContent().ifPresent(object::setAttributeRef);
                    return;
                case "startTime":
                    object.setStartTime(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    return;
                case "endTime":
                    object.setEndTime(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    return;
                case "dynamicData":
                    object.setDynamicData(reader.getObjectUsingBuilder(AbstractTimeseriesPropertyAdapter.class));
                    return;
                case "sensorConnection":
                    object.setSensorConnection(reader.getObjectUsingBuilder(SensorConnectionPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(Dynamizer object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfDynamizer.class, object.getADEPropertiesOfDynamizer(),
                GenericADEPropertyOfDynamizer::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(Dynamizer object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "Dynamizer");
    }

    @Override
    public void writeChildElements(Dynamizer object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String dynamizerNamespace = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE;

        if (object.getAttributeRef() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "attributeRef").addTextContent(object.getAttributeRef()));

        if (object.getStartTime() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "startTime"), object.getStartTime(), TimePositionAdapter.class, namespaces);

        if (object.getEndTime() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "endTime"), object.getEndTime(), TimePositionAdapter.class, namespaces);

        if (object.getDynamicData() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "dynamicData"), object.getDynamicData(), AbstractTimeseriesPropertyAdapter.class, namespaces);

        if (object.getSensorConnection() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "sensorConnection"), object.getSensorConnection(), SensorConnectionPropertyAdapter.class, namespaces);

        for (ADEPropertyOfDynamizer<?> property : object.getADEPropertiesOfDynamizer())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
