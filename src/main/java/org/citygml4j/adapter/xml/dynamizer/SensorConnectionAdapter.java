package org.citygml4j.adapter.xml.dynamizer;

import org.citygml4j.adapter.xml.core.AbstractCityObjectPropertyAdapter;
import org.citygml4j.model.dynamizer.SensorConnection;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "SensorConnection", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class SensorConnectionAdapter implements ObjectBuilder<SensorConnection>, ObjectSerializer<SensorConnection> {

    @Override
    public SensorConnection createObject(QName name) throws ObjectBuildException {
        return new SensorConnection();
    }

    @Override
    public void buildChildObject(SensorConnection object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "connectionType":
                    object.setConnectionType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "observationProperty":
                    reader.getTextContent().ifPresent(object::setObservationProperty);
                    break;
                case "uom":
                    reader.getTextContent().ifPresent(object::setUom);
                    break;
                case "sensorID":
                    reader.getTextContent().ifPresent(object::setSensorID);
                    break;
                case "sensorName":
                    reader.getTextContent().ifPresent(object::setSensorName);
                    break;
                case "observationID":
                    reader.getTextContent().ifPresent(object::setObservationID);
                    break;
                case "datastreamID":
                    reader.getTextContent().ifPresent(object::setDatastreamID);
                    break;
                case "baseURL":
                    reader.getTextContent().ifPresent(object::setBaseURL);
                    break;
                case "authType":
                    object.setAuthType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "mqttServer":
                    reader.getTextContent().ifPresent(object::setMqttServer);
                    break;
                case "mqttTopic":
                    reader.getTextContent().ifPresent(object::setMqttTopic);
                    break;
                case "linkToObservation":
                    reader.getTextContent().ifPresent(object::setLinkToObservation);
                    break;
                case "linkToSensorDescription":
                    reader.getTextContent().ifPresent(object::setLinkToSensorDescription);
                    break;
                case "sensorLocation":
                    object.setSensorLocation(reader.getObjectUsingBuilder(AbstractCityObjectPropertyAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(SensorConnection object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "SensorConnection");
    }

    @Override
    public void writeChildElements(SensorConnection object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String dynamizerNamespace = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE;

        if (object.getConnectionType() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "connectionType"), object.getConnectionType(), CodeAdapter.class, namespaces);

        if (object.getObservationProperty() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "observationProperty").addTextContent(object.getObservationProperty()));

        if (object.getUom() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "uom").addTextContent(object.getUom()));

        if (object.getSensorID() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "sensorID").addTextContent(object.getSensorID()));

        if (object.getSensorName() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "sensorName").addTextContent(object.getSensorName()));

        if (object.getObservationID() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "observationID").addTextContent(object.getObservationID()));

        if (object.getDatastreamID() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "datastreamID").addTextContent(object.getDatastreamID()));

        if (object.getBaseURL() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "baseURL").addTextContent(object.getBaseURL()));

        if (object.getAuthType() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "authType"), object.getAuthType(), CodeAdapter.class, namespaces);

        if (object.getMqttServer() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "mqttServer").addTextContent(object.getMqttServer()));

        if (object.getMqttTopic() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "mqttTopic").addTextContent(object.getMqttTopic()));

        if (object.getLinkToObservation() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "linkToObservation").addTextContent(object.getLinkToObservation()));

        if (object.getLinkToSensorDescription() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "linkToSensorDescription").addTextContent(object.getLinkToSensorDescription()));

        if (object.getSensorLocation() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "sensorLocation"), object.getSensorLocation(), AbstractCityObjectPropertyAdapter.class, namespaces);
    }
}
