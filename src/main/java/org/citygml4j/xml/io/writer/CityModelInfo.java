/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.xml.io.writer;

import org.citygml4j.builder.copy.ShallowCopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.base.MetaDataProperty;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.LocationProperty;
import org.citygml4j.xml.io.reader.ParentInfo;

import java.util.ArrayList;
import java.util.List;

public class CityModelInfo {
    private final CityModel cityModel;

    public CityModelInfo(CityModel cityModel) {
        this.cityModel = cityModel;
    }

    public CityModelInfo(ParentInfo parentInfo) {
        this();
        if (parentInfo != null) {
            setId(parentInfo.getId());
            setName(parentInfo.getName());
            setDescription(parentInfo.getDescription());
            setMetaDataProperty(parentInfo.getMetaDataProperty());
            setBoundedBy(parentInfo.getBoundedBy());
            setLocation(parentInfo.getLocation());
        }
    }

    public CityModelInfo() {
        this(new CityModel());
    }

    public boolean isSetId() {
        return cityModel.isSetId();
    }

    public String getId() {
        return cityModel.getId();
    }

    public void setId(String id) {
        cityModel.setId(id);
    }

    public void unsetId() {
        cityModel.unsetId();
    }

    public boolean isSetName() {
        return cityModel.isSetName();
    }

    public List<Code> getName() {
        return cityModel.getName();
    }

    public void addName(Code name) {
        cityModel.addName(name);
    }

    public void setName(List<Code> name) {
        cityModel.setName(name);
    }

    public void unsetName() {
        cityModel.unsetName();
    }

    public boolean unsetName(Code name) {
        return cityModel.unsetName(name);
    }

    public boolean isSetDescription() {
        return cityModel.isSetDescription();
    }

    public StringOrRef getDescription() {
        return cityModel.getDescription();
    }

    public void setDescription(StringOrRef description) {
        cityModel.setDescription(description);
    }

    public void unsetDescription() {
        cityModel.unsetDescription();
    }

    public boolean isSetMetaDataProperty() {
        return cityModel.isSetMetaDataProperty();
    }

    public List<MetaDataProperty> getMetaDataProperty() {
        return cityModel.getMetaDataProperty();
    }

    public void addMetaDataProperty(MetaDataProperty metaDataProperty) {
        cityModel.addMetaDataProperty(metaDataProperty);
    }

    public void setMetaDataProperty(List<MetaDataProperty> metaDataProperty) {
        cityModel.setMetaDataProperty(metaDataProperty);
    }

    public void unsetMetaDataProperty() {
        cityModel.unsetMetaDataProperty();
    }

    public boolean unsetMetaDataProperty(MetaDataProperty metaDataProperty) {
        return cityModel.unsetMetaDataProperty(metaDataProperty);
    }

    public boolean isSetBoundedBy() {
        return cityModel.isSetBoundedBy();
    }

    public BoundingShape getBoundedBy() {
        return cityModel.getBoundedBy();
    }

    public void setBoundedBy(BoundingShape boundingBy) {
        cityModel.setBoundedBy(boundingBy);
    }

    public void unsetBoundedBy() {
        cityModel.unsetBoundedBy();
    }

    public boolean isSetLocation() {
        return cityModel.isSetLocation();
    }

    public LocationProperty getLocation() {
        return cityModel.getLocation();
    }

    public void setLocation(LocationProperty location) {
        cityModel.setLocation(location);
    }

    public void unsetLocation() {
        cityModel.unsetLocation();
    }

    public boolean isSetGenericApplicationPropertyOfCityModel() {
        return cityModel.isSetGenericApplicationPropertyOfCityModel();
    }

    public List<ADEComponent> getGenericApplicationPropertyOfCityModel() {
        return cityModel.getGenericApplicationPropertyOfCityModel();
    }

    public void addGenericApplicationPropertyOfCityModel(ADEComponent ade) {
        cityModel.addGenericApplicationPropertyOfCityModel(ade);
    }

    public void setGenericApplicationPropertyOfCityModel(List<ADEComponent> ade) {
        cityModel.setGenericApplicationPropertyOfCityModel(ade);
    }

    public void unsetGenericApplicationPropertyOfCityModel() {
        cityModel.unsetGenericApplicationPropertyOfCityModel();
    }

    public boolean unsetGenericApplicationPropertyOfCityModel(ADEComponent ade) {
        return cityModel.unsetGenericApplicationPropertyOfCityModel(ade);
    }

    public boolean isSetGenericADEElement() {
        return cityModel.isSetGenericADEElement();
    }

    public List<ADEGenericElement> getGenericADEElement() {
        return cityModel.getGenericADEElement();
    }

    public void addGenericADEElement(ADEGenericElement genericADEElement) {
        cityModel.addGenericADEElement(genericADEElement);
    }

    public void setGenericADEElement(List<ADEGenericElement> genericADEElement) {
        cityModel.setGenericADEElement(genericADEElement);
    }

    public void unsetGenericADEElement() {
        cityModel.unsetGenericADEElement();
    }

    public boolean unsetGenericADEElement(ADEGenericElement genericADEElement) {
        return cityModel.unsetGenericADEElement(genericADEElement);
    }

    public CityModel toCityModel() {
        CityModel cityModel = new CityModel();
        ShallowCopyBuilder builder = new ShallowCopyBuilder();

        if (isSetId())
            cityModel.setId(getId());

        if (isSetName())
            cityModel.setName(new ArrayList<>(getName()));

        if (isSetDescription())
            cityModel.setDescription((StringOrRef) getDescription().copy(builder));

        if (isSetMetaDataProperty())
            cityModel.setMetaDataProperty(new ArrayList<>(getMetaDataProperty()));

        if (isSetBoundedBy())
            cityModel.setBoundedBy((BoundingShape) getBoundedBy().copy(builder));

        if (isSetLocation())
            cityModel.setLocation((LocationProperty) getLocation().copy(builder));

        if (isSetGenericApplicationPropertyOfCityModel())
            cityModel.setGenericApplicationPropertyOfCityModel(new ArrayList<>(getGenericApplicationPropertyOfCityModel()));

        if (isSetGenericADEElement())
            cityModel.setGenericADEElement(new ArrayList<>(getGenericADEElement()));

        return cityModel;
    }

}
