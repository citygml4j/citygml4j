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
	private String id;
	private List<Code> name;
	private StringOrRef description;
	private List<MetaDataProperty> metaDataProperty;
	private BoundingShape boundedBy;
	private LocationProperty location;
	private List<ADEComponent> ade;
	private List<ADEGenericElement> genericADEElement;
		
	public CityModelInfo() {
	}
	
	public CityModelInfo(CityModel cityModel) {
		if (cityModel != null) {
			id = cityModel.getId();
			name = cityModel.getName();
			description = cityModel.getDescription();
			metaDataProperty = cityModel.getMetaDataProperty();
			boundedBy = cityModel.getBoundedBy();
			location = cityModel.getLocation();
			ade = cityModel.getGenericApplicationPropertyOfCityModel();
			genericADEElement = cityModel.getGenericADEElement();
		}
	}
	
	public CityModelInfo(ParentInfo parentInfo) {
		if (parentInfo != null) {
			id = parentInfo.getId();
			name = parentInfo.getName();
			description = parentInfo.getDescription();
			metaDataProperty = parentInfo.getMetaDataProperty();
			boundedBy = parentInfo.getBoundedBy();
			location = parentInfo.getLocation();
		}
	}
	
	public boolean isSetId() {
		return id != null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void unsetId() {
		id = null;
	}

	public boolean isSetName() {
		return name != null && !name.isEmpty();
	}

	public List<Code> getName() {
		if (name == null)
			name = new ArrayList<>();

		return name;
	}

	public void addName(Code name) {
		getName().add(name);
	}

	public void setName(List<Code> name) {
		this.name = name;
	}

	public void unsetName() {
		name = null;
	}

	public boolean unsetName(Code name) {
		return this.name.remove(name);
	}

	public boolean isSetDescription() {
		return description != null;
	}

	public StringOrRef getDescription() {
		return description;
	}

	public void setDescription(StringOrRef description) {
		this.description = description;
	}

	public void unsetDescription() {
		description = null;
	}

	public boolean isSetMetaDataProperty() {
		return metaDataProperty != null && !metaDataProperty.isEmpty();
	}

	public List<MetaDataProperty> getMetaDataProperty() {
		if (metaDataProperty == null)
			metaDataProperty = new ArrayList<>();

		return metaDataProperty;
	}

	public void addMetaDataProperty(MetaDataProperty metaDataProperty) {
		getMetaDataProperty().add(metaDataProperty);
	}

	public void setMetaDataProperty(List<MetaDataProperty> metaDataProperty) {
		this.metaDataProperty = metaDataProperty;
	}

	public void unsetMetaDataProperty() {
		metaDataProperty = null;
	}

	public boolean unsetMetaDataProperty(MetaDataProperty metaDataProperty) {
		return this.metaDataProperty.remove(metaDataProperty);
	}

	public boolean isSetBoundedBy() {
		return boundedBy != null;
	}

	public BoundingShape getBoundedBy() {
		return boundedBy;
	}

	public void setBoundedBy(BoundingShape boundingBy) {
		this.boundedBy = boundingBy;
	}

	public void unsetBoundedBy() {
		boundedBy = null;
	}

	public boolean isSetLocation() {
		return location != null;
	}

	public LocationProperty getLocation() {
		return location;
	}

	public void setLocation(LocationProperty location) {
		this.location = location;
	}
	
	public void unsetLocation() {
		location = null;
	}

	public boolean isSetGenericApplicationPropertyOfCityModel() {
		return ade != null && !ade.isEmpty();
	}

	public List<ADEComponent> getGenericApplicationPropertyOfCityModel() {
		if (ade == null)
			ade = new ArrayList<>();

		return ade;
	}

	public void addGenericApplicationPropertyOfCityModel(ADEComponent ade) {
		getGenericApplicationPropertyOfCityModel().add(ade);
	}

	public void setGenericApplicationPropertyOfCityModel(List<ADEComponent> ade) {
		this.ade = ade;
	}

	public void unsetGenericApplicationPropertyOfCityModel() {
		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfCityModel(ADEComponent ade) {
		return this.ade.remove(ade);
	}

	public boolean isSetGenericADEElement() {
		return genericADEElement != null && !genericADEElement.isEmpty();
	}

	public List<ADEGenericElement> getGenericADEElement() {
		if (genericADEElement == null)
			genericADEElement = new ArrayList<>();

		return genericADEElement;
	}

	public void addGenericADEElement(ADEGenericElement genericADEElement) {
		getGenericADEElement().add(genericADEElement);
	}

	public void setGenericADEElement(List<ADEGenericElement> genericADEElement) {
		this.genericADEElement = genericADEElement;
	}

	public void unsetGenericADEElement() {
		genericADEElement = null;
	}

	public boolean unsetGenericADEElement(ADEGenericElement genericADEElement) {
		return this.genericADEElement.remove(genericADEElement);
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
