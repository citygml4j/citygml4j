/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
                return isSetIntValue();
            case DOUBLE:
                return isSetDoubleValue();
            case STRING:
                return isSetStringValue();
            case GEOMETRY:
                return isSetGeometryValue();
            case URI:
                return isSetUriValue();
            case BOOL:
                return isSetBoolValue();
            case IMPLICIT_GEOMETRY:
                return isSetImplicitGeometryValue();
            case APPEARANCE:
                return isSetAppearanceValue();
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
