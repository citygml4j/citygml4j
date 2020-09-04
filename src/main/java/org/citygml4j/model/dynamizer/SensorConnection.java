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

package org.citygml4j.model.dynamizer;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;

public class SensorConnection extends GMLObject implements CityGMLObject {
    private Code connectionType;
    private String observationProperty;
    private String uom;
    private String sensorID;
    private String sensorName;
    private String observationID;
    private String datastreamID;
    private String baseURL;
    private Code authType;
    private String mqttServer;
    private String mqttTopic;
    private String linkToObservation;
    private String linkToSensorDescription;
    private AbstractCityObjectProperty sensorLocation;

    public SensorConnection() {
    }

    public SensorConnection(Code connectionType, String observationProperty) {
        setConnectionType(connectionType);
        this.observationProperty = observationProperty;
    }

    public Code getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(Code connectionType) {
        this.connectionType = asChild(connectionType);
    }

    public String getObservationProperty() {
        return observationProperty;
    }

    public void setObservationProperty(String observationProperty) {
        this.observationProperty = observationProperty;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getObservationID() {
        return observationID;
    }

    public void setObservationID(String observationID) {
        this.observationID = observationID;
    }

    public String getDatastreamID() {
        return datastreamID;
    }

    public void setDatastreamID(String datastreamID) {
        this.datastreamID = datastreamID;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public Code getAuthType() {
        return authType;
    }

    public void setAuthType(Code authType) {
        this.authType = asChild(authType);
    }

    public String getMqttServer() {
        return mqttServer;
    }

    public void setMqttServer(String mqttServer) {
        this.mqttServer = mqttServer;
    }

    public String getMqttTopic() {
        return mqttTopic;
    }

    public void setMqttTopic(String mqttTopic) {
        this.mqttTopic = mqttTopic;
    }

    public String getLinkToObservation() {
        return linkToObservation;
    }

    public void setLinkToObservation(String linkToObservation) {
        this.linkToObservation = linkToObservation;
    }

    public String getLinkToSensorDescription() {
        return linkToSensorDescription;
    }

    public void setLinkToSensorDescription(String linkToSensorDescription) {
        this.linkToSensorDescription = linkToSensorDescription;
    }

    public AbstractCityObjectProperty getSensorLocation() {
        return sensorLocation;
    }

    public void setSensorLocation(AbstractCityObjectProperty sensorLocation) {
        this.sensorLocation = asChild(sensorLocation);
    }
}
