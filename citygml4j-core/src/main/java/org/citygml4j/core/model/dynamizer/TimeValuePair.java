/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.model.core.AbstractAppearanceProperty;
import org.citygml4j.core.model.core.ImplicitGeometryProperty;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.temporal.TimePosition;

public class TimeValuePair extends GMLObject implements CityGMLObject {
    private TimePosition timestamp;
    private Integer intValue;
    private Double doubleValue;
    private String stringValue;
    private GeometryProperty<?> geometryValue;
    private String uriValue;
    private Boolean boolValue;
    private ImplicitGeometryProperty implicitGeometryValue;
    private AbstractAppearanceProperty appearanceValue;

    public TimeValuePair() {
    }

    public TimeValuePair(TimePosition timestamp) {
        setTimestamp(timestamp);
    }

    public TimeValuePair(TimePosition timestamp, TimeseriesValue valueType, Object value) {
        setTimestamp(timestamp);
        setValue(valueType, value);
    }

    public TimePosition getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(TimePosition timestamp) {
        clearValue();
        this.timestamp = asChild(timestamp);
    }

    public Integer getIntValue() {
        return intValue;
    }

    public boolean isSetIntValue() {
        return intValue != null;
    }

    public void setIntValue(Integer intValue) {
        clearValue();
        this.intValue = intValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public boolean isSetDoubleValue() {
        return doubleValue != null;
    }

    public void setDoubleValue(Double doubleValue) {
        clearValue();
        this.doubleValue = doubleValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public boolean isSetStringValue() {
        return stringValue != null;
    }

    public void setStringValue(String stringValue) {
        clearValue();
        this.stringValue = stringValue;
    }

    public GeometryProperty<?> getGeometryValue() {
        return geometryValue;
    }

    public boolean isSetGeometryValue() {
        return geometryValue != null;
    }

    public void setGeometryValue(GeometryProperty<?> geometryValue) {
        clearValue();
        this.geometryValue = asChild(geometryValue);
    }

    public String getUriValue() {
        return uriValue;
    }

    public boolean isSetUriValue() {
        return uriValue != null;
    }

    public void setUriValue(String uriValue) {
        clearValue();
        this.uriValue = uriValue;
    }

    public Boolean getBoolValue() {
        return boolValue;
    }

    public boolean isSetBoolValue() {
        return boolValue != null;
    }

    public void setBoolValue(Boolean boolValue) {
        clearValue();
        this.boolValue = boolValue;
    }

    public ImplicitGeometryProperty getImplicitGeometryValue() {
        return implicitGeometryValue;
    }

    public boolean isSetImplicitGeometryValue() {
        return implicitGeometryValue != null;
    }

    public void setImplicitGeometryValue(ImplicitGeometryProperty implicitGeometryValue) {
        clearValue();
        this.implicitGeometryValue = asChild(implicitGeometryValue);
    }

    public AbstractAppearanceProperty getAppearanceValue() {
        return appearanceValue;
    }

    public boolean isSetAppearanceValue() {
        return appearanceValue != null;
    }

    public void setAppearanceValue(AbstractAppearanceProperty appearanceValue) {
        clearValue();
        this.appearanceValue = asChild(appearanceValue);
    }

    public Object getValue(TimeseriesValue valueType) {
        return switch (valueType) {
            case INTEGER -> getIntValue();
            case DOUBLE -> getDoubleValue();
            case STRING -> getStringValue();
            case GEOMETRY -> getGeometryValue();
            case URI -> getUriValue();
            case BOOL -> getBoolValue();
            case IMPLICIT_GEOMETRY -> getImplicitGeometryValue();
            case APPEARANCE -> getAppearanceValue();
        };
    }

    public boolean isSetValue(TimeseriesValue valueType) {
        return switch (valueType) {
            case INTEGER -> isSetIntValue();
            case DOUBLE -> isSetDoubleValue();
            case STRING -> isSetStringValue();
            case GEOMETRY -> isSetGeometryValue();
            case URI -> isSetUriValue();
            case BOOL -> isSetBoolValue();
            case IMPLICIT_GEOMETRY -> isSetImplicitGeometryValue();
            case APPEARANCE -> isSetAppearanceValue();
        };
    }

    public void setValue(TimeseriesValue valueType, Object value) {
        if (value != null && valueType.getType().isAssignableFrom(value.getClass())) {
            switch (valueType) {
                case INTEGER:
                    setIntValue((Integer) value);
                    break;
                case DOUBLE:
                    setDoubleValue((Double) value);
                    break;
                case STRING:
                    setStringValue((String) value);
                    break;
                case GEOMETRY:
                    setGeometryValue((GeometryProperty<?>) value);
                    break;
                case URI:
                    setUriValue((String) value);
                    break;
                case BOOL:
                    setBoolValue((Boolean) value);
                    break;
                case IMPLICIT_GEOMETRY:
                    setImplicitGeometryValue((ImplicitGeometryProperty) value);
                    break;
                case APPEARANCE:
                    setAppearanceValue((AbstractAppearanceProperty) value);
                    break;
            }
        }
    }

    private void clearValue() {
        intValue = null;
        doubleValue = null;
        stringValue = null;
        geometryValue = null;
        uriValue = null;
        boolValue = null;
        implicitGeometryValue = null;
        appearanceValue = null;
    }
}
