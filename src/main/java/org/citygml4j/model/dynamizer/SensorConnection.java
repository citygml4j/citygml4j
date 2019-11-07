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
    private AuthenticationValue authType;
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

    public AuthenticationValue getAuthType() {
        return authType;
    }

    public void setAuthType(AuthenticationValue authType) {
        this.authType = authType;
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
