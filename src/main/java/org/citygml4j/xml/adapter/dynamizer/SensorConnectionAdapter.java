/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.dynamizer.SensorConnection;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.core.AbstractCityObjectReferenceAdapter;
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
    public SensorConnection createObject(QName name, Object parent) throws ObjectBuildException {
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
                    object.setSensorLocation(reader.getObjectUsingBuilder(AbstractCityObjectReferenceAdapter.class));
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
        if (object.getConnectionType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "connectionType"), object.getConnectionType(), CodeAdapter.class, namespaces);

        if (object.getObservationProperty() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "observationProperty").addTextContent(object.getObservationProperty()));

        if (object.getUom() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "uom").addTextContent(object.getUom()));

        if (object.getSensorID() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "sensorID").addTextContent(object.getSensorID()));

        if (object.getSensorName() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "sensorName").addTextContent(object.getSensorName()));

        if (object.getObservationID() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "observationID").addTextContent(object.getObservationID()));

        if (object.getDatastreamID() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "datastreamID").addTextContent(object.getDatastreamID()));

        if (object.getBaseURL() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "baseURL").addTextContent(object.getBaseURL()));

        if (object.getAuthType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "authType"), object.getAuthType(), CodeAdapter.class, namespaces);

        if (object.getMqttServer() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "mqttServer").addTextContent(object.getMqttServer()));

        if (object.getMqttTopic() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "mqttTopic").addTextContent(object.getMqttTopic()));

        if (object.getLinkToObservation() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "linkToObservation").addTextContent(object.getLinkToObservation()));

        if (object.getLinkToSensorDescription() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "linkToSensorDescription").addTextContent(object.getLinkToSensorDescription()));

        if (object.getSensorLocation() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "sensorLocation"), object.getSensorLocation(), AbstractCityObjectReferenceAdapter.class, namespaces);
    }
}
