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

package org.citygml4j.xml.writer;

import org.citygml4j.model.core.*;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.model.deprecated.LocationProperty;
import org.xmlobjects.gml.model.deprecated.MetaDataProperty;
import org.xmlobjects.gml.model.deprecated.StringOrRef;
import org.xmlobjects.gml.model.feature.BoundingShape;

import java.time.OffsetDateTime;
import java.util.List;

public class CityModelInfo {
    private final CityModel cityModel;

    CityModelInfo(CityModel cityModel) {
        this.cityModel = cityModel;
    }

    CityModelInfo() {
        this(new CityModel());
    }

    CityModel getCityModel() {
        return cityModel;
    }

    public String getId() {
        return cityModel.getId();
    }

    public void setId(String id) {
        cityModel.setId(id);
    }

    public List<MetaDataProperty<?>> getMetaDataProperties() {
        return cityModel.getMetaDataProperties();
    }

    public void setMetaDataProperties(List<MetaDataProperty<?>> metaDataProperties) {
        cityModel.setMetaDataProperties(metaDataProperties);
    }

    public StringOrRef getDescription() {
        return cityModel.getDescription();
    }

    public void setDescription(StringOrRef description) {
        cityModel.setDescription(description);
    }

    public Reference getDescriptionReference() {
        return cityModel.getDescriptionReference();
    }

    public void setDescriptionReference(Reference descriptionReference) {
        cityModel.setDescriptionReference(descriptionReference);
    }

    public CodeWithAuthority getIdentifier() {
        return cityModel.getIdentifier();
    }

    public void setIdentifier(CodeWithAuthority identifier) {
        cityModel.setIdentifier(identifier);
    }

    public List<Code> getNames() {
        return cityModel.getNames();
    }

    public void setNames(List<Code> names) {
        cityModel.setNames(names);
    }

    public BoundingShape getBoundedBy() {
        return cityModel.getBoundedBy();
    }

    public void setBoundedBy(BoundingShape boundedBy) {
        cityModel.setBoundedBy(boundedBy);
    }

    public LocationProperty getLocation() {
        return cityModel.getLocation();
    }

    public void setLocation(LocationProperty location) {
        cityModel.setLocation(location);
    }

    public List<ADEOfAbstractFeature> getADEOfAbstractFeature() {
        return cityModel.getADEOfAbstractFeature();
    }

    public void setADEOfAbstractFeature(List<ADEOfAbstractFeature> adeOfAbstractFeature) {
        cityModel.setADEOfAbstractFeature(adeOfAbstractFeature);
    }

    public OffsetDateTime getCreationDate() {
        return cityModel.getCreationDate();
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        cityModel.setCreationDate(creationDate);
    }

    public OffsetDateTime getTerminationDate() {
        return cityModel.getTerminationDate();
    }

    public void setTerminationDate(OffsetDateTime terminationDate) {
        cityModel.setTerminationDate(terminationDate);
    }

    public OffsetDateTime getValidFrom() {
        return cityModel.getValidFrom();
    }

    public void setValidFrom(OffsetDateTime validFrom) {
        cityModel.setValidFrom(validFrom);
    }

    public OffsetDateTime getValidTo() {
        return cityModel.getValidTo();
    }

    public void setValidTo(OffsetDateTime validTo) {
        cityModel.setValidTo(validTo);
    }

    public List<ADEOfAbstractFeatureWithLifespan> getADEOfAbstractFeatureWithLifespan() {
        return cityModel.getADEOfAbstractFeatureWithLifespan();
    }

    public void setADEOfAbstractFeatureWithLifespan(List<ADEOfAbstractFeatureWithLifespan> adeOfAbstractFeatureWithLifespan) {
        cityModel.setADEOfAbstractFeatureWithLifespan(adeOfAbstractFeatureWithLifespan);
    }

    public EngineeringCRSProperty getEngineeringCRS() {
        return cityModel.getEngineeringCRS();
    }

    public void setEngineeringCRS(EngineeringCRSProperty engineeringCRS) {
        cityModel.setEngineeringCRS(engineeringCRS);
    }

    public List<ADEOfCityModel> getADEOfCityModel() {
        return cityModel.getADEOfCityModel();
    }

    public void setADEOfCityModel(List<ADEOfCityModel> adeOfCityModel) {
        cityModel.setADEOfCityModel(adeOfCityModel);
    }
}
