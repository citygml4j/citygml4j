/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;

public class TabulatedFileTimeseries extends AbstractAtomicTimeseries {
    private String fileLocation;
    private Code fileType;
    private Code mimeType;
    private TimeseriesValue valueType;
    private Integer numberOfHeaderLines;
    private String fieldSeparator;
    private String decimalSymbol;
    private Integer idColumnNo;
    private String idColumnName;
    private String idValue;
    private Integer timeColumnNo;
    private String timeColumnName;
    private Integer valueColumnNo;
    private String valueColumnName;

    public TabulatedFileTimeseries() {
    }

    public TabulatedFileTimeseries(String observationProperty, String fileLocation, Code fileType, TimeseriesValue valueType, String fieldSeparator) {
        super(observationProperty);
        this.fileLocation = fileLocation;
        setFileType(fileType);
        this.valueType = valueType;
        this.fieldSeparator = fieldSeparator;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Code getFileType() {
        return fileType;
    }

    public void setFileType(Code fileType) {
        this.fileType = asChild(fileType);
    }

    public Code getMimeType() {
        return mimeType;
    }

    public void setMimeType(Code mimeType) {
        this.mimeType = asChild(mimeType);
    }

    public TimeseriesValue getValueType() {
        return valueType;
    }

    public void setValueType(TimeseriesValue valueType) {
        this.valueType = valueType;
    }

    public Integer getNumberOfHeaderLines() {
        return numberOfHeaderLines;
    }

    public void setNumberOfHeaderLines(Integer numberOfHeaderLines) {
        this.numberOfHeaderLines = numberOfHeaderLines;
    }

    public String getFieldSeparator() {
        return fieldSeparator;
    }

    public void setFieldSeparator(String fieldSeparator) {
        this.fieldSeparator = fieldSeparator;
    }

    public String getDecimalSymbol() {
        return decimalSymbol;
    }

    public void setDecimalSymbol(String decimalSymbol) {
        this.decimalSymbol = decimalSymbol;
    }

    public Integer getIdColumnNo() {
        return idColumnNo;
    }

    public void setIdColumnNo(Integer idColumnNo) {
        this.idColumnNo = idColumnNo;
    }

    public String getIdColumnName() {
        return idColumnName;
    }

    public void setIdColumnName(String idColumnName) {
        this.idColumnName = idColumnName;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

    public Integer getTimeColumnNo() {
        return timeColumnNo;
    }

    public void setTimeColumnNo(Integer timeColumnNo) {
        this.timeColumnNo = timeColumnNo;
    }

    public String getTimeColumnName() {
        return timeColumnName;
    }

    public void setTimeColumnName(String timeColumnName) {
        this.timeColumnName = timeColumnName;
    }

    public Integer getValueColumnNo() {
        return valueColumnNo;
    }

    public void setValueColumnNo(Integer valueColumnNo) {
        this.valueColumnNo = valueColumnNo;
    }

    public String getValueColumnName() {
        return valueColumnName;
    }

    public void setValueColumnName(String valueColumnName) {
        this.valueColumnName = valueColumnName;
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
