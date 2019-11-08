package org.citygml4j.model.dynamizer;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.core.AbstractAppearanceProperty;
import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.temporal.TimePosition;

public class TimeValuePair extends GMLObject implements CityGMLObject {
    private TimePosition timestamp;
    private Integer intValue;
    private Double doubleValue;
    private String stringValue;
    private GeometryProperty geometryValue;
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

    public void setIntValue(Integer intValue) {
        clearValue();
        this.intValue = intValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        clearValue();
        this.doubleValue = doubleValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        clearValue();
        this.stringValue = stringValue;
    }

    public GeometryProperty getGeometryValue() {
        return geometryValue;
    }

    public void setGeometryValue(GeometryProperty geometryValue) {
        clearValue();
        this.geometryValue = asChild(geometryValue);
    }

    public String getUriValue() {
        return uriValue;
    }

    public void setUriValue(String uriValue) {
        clearValue();
        this.uriValue = uriValue;
    }

    public Boolean getBoolValue() {
        return boolValue;
    }

    public void setBoolValue(Boolean boolValue) {
        clearValue();
        this.boolValue = boolValue;
    }

    public ImplicitGeometryProperty getImplicitGeometryValue() {
        return implicitGeometryValue;
    }

    public void setImplicitGeometryValue(ImplicitGeometryProperty implicitGeometryValue) {
        clearValue();
        this.implicitGeometryValue = asChild(implicitGeometryValue);
    }

    public AbstractAppearanceProperty getAppearanceValue() {
        return appearanceValue;
    }

    public void setAppearanceValue(AbstractAppearanceProperty appearanceValue) {
        clearValue();
        this.appearanceValue = asChild(appearanceValue);
    }

    public Object getValue(TimeseriesValue valueType) {
        switch (valueType) {
            case INTEGER:
                return getIntValue();
            case DOUBLE:
                return getDoubleValue();
            case STRING:
                return getStringValue();
            case GEOMETRY:
                return getGeometryValue();
            case URI:
                return getUriValue();
            case BOOL:
                return getBoolValue();
            case IMPLICIT_GEOMETRY:
                return getImplicitGeometryValue();
            case APPEARANCE:
                return getAppearanceValue();
            default:
                return null;
        }
    }

    public boolean isSetValue(TimeseriesValue valueType) {
        switch (valueType) {
            case INTEGER:
                return intValue != null;
            case DOUBLE:
                return doubleValue != null;
            case STRING:
                return stringValue != null;
            case GEOMETRY:
                return geometryValue != null;
            case URI:
                return uriValue != null;
            case BOOL:
                return boolValue != null;
            case IMPLICIT_GEOMETRY:
                return implicitGeometryValue != null;
            case APPEARANCE:
                return appearanceValue != null;
            default:
                return false;
        }
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
                    setGeometryValue((GeometryProperty) value);
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
