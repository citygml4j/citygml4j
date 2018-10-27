/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.builder.copy.DeepCopyBuilder;
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
	
	@SuppressWarnings("unchecked")
	public CityModelInfo(CityModel cityModel) {
		if (cityModel == null)
			throw new IllegalArgumentException("cityModel may not be null.");
		
		DeepCopyBuilder builder = new DeepCopyBuilder();
		
		if (cityModel.isSetId())
			setId(cityModel.getId());
		
		if (cityModel.isSetName())
			setName((List<Code>)builder.copy(cityModel.getName()));
		
		if (cityModel.isSetDescription())
			setDescription((StringOrRef)builder.copy(cityModel.getDescription()));
		
		if (cityModel.isSetMetaDataProperty())
			setMetaDataProperty((List<MetaDataProperty>)builder.copy(cityModel.getMetaDataProperty()));
		
		if (cityModel.isSetBoundedBy())
			setBoundedBy((BoundingShape)builder.copy(cityModel.getBoundedBy()));
		
		if (cityModel.isSetLocation())
			setLocation((LocationProperty)builder.copy(cityModel.getLocation()));
		
		if (cityModel.isSetGenericApplicationPropertyOfCityModel())
			setGenericApplicationPropertyOfCityModel((List<ADEComponent>)builder.copy(cityModel.getGenericApplicationPropertyOfCityModel()));
		
		if (cityModel.isSetGenericADEElement())
			setGenericADEElement((List<ADEGenericElement>)builder.copy(cityModel.getGenericADEElement()));
	}
	
	public CityModelInfo(ParentInfo parentInfo) {
		if (parentInfo == null)
			throw new IllegalArgumentException("parentInfo may not be null.");
		
		id = parentInfo.getId();
		name = parentInfo.getName();
		description = parentInfo.getDescription();
		metaDataProperty = parentInfo.getMetaDataProperty();
		boundedBy = parentInfo.getBoundedBy();
		location = parentInfo.getLocation();
	}
	
	public boolean isSetId() {
		return id != null;
	}

	public String getId() {
		return id;
	}

	public boolean isSetName() {
		return name != null && !name.isEmpty();
	}

	public List<Code> getName() {
		if (name == null)
			name = new ArrayList<Code>();
		
		return name;
	}

	public boolean isSetDescription() {
		return description != null;
	}

	public StringOrRef getDescription() {
		return description;
	}

	public boolean isSetMetaDataProperty() {
		return metaDataProperty != null && !metaDataProperty.isEmpty();
	}

	public List<MetaDataProperty> getMetaDataProperty() {
		if (metaDataProperty == null)
			metaDataProperty = new ArrayList<MetaDataProperty>();
		
		return metaDataProperty;
	}

	public boolean isSetBoundedBy() {
		return boundedBy != null;
	}

	public BoundingShape getBoundedBy() {
		return boundedBy;
	}

	public boolean isSetLocation() {
		return location != null;
	}

	public LocationProperty getLocation() {
		return location;
	}
	
	public void setBoundedBy(BoundingShape boundingBy) {
		this.boundedBy = boundingBy;
	}
	
	public void setLocation(LocationProperty location) {
		this.location = location;
	}
	
	public void unsetBoundedBy() {
		boundedBy = null;
	}
	
	public void unsetLocation() {
		location = null;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void unsetId() {
		id = null;
	}

	public void addMetaDataProperty(MetaDataProperty metaDataProperty) {
		if (this.metaDataProperty == null)
			this.metaDataProperty = new ArrayList<MetaDataProperty>();
		
		this.metaDataProperty.add(metaDataProperty);
	}

	public void addName(Code name) {
		if (this.name == null)
			this.name = new ArrayList<Code>();
		
		this.name.add(name);
	}

	public void setDescription(StringOrRef description) {
		this.description = description;
	}

	public void setMetaDataProperty(List<MetaDataProperty> metaDataProperty) {
		this.metaDataProperty = metaDataProperty;
	}

	public void setName(List<Code> name) {
		this.name = name;
	}

	public void unsetDescription() {
		description = null;
	}

	public void unsetMetaDataProperty() {
		metaDataProperty = null;
	}

	public boolean unsetMetaDataProperty(MetaDataProperty metaDataProperty) {
		return this.metaDataProperty.remove(metaDataProperty);
	}

	public void unsetName() {
		name = null;
	}

	public boolean unsetName(Code name) {
		return this.name.remove(name);
	}

	public void addGenericApplicationPropertyOfCityModel(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ArrayList<ADEComponent>();
		
		this.ade.add(ade);
	}

	public boolean isSetGenericApplicationPropertyOfCityModel() {
		return ade != null && !ade.isEmpty();
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

	public List<ADEComponent> getGenericApplicationPropertyOfCityModel() {
		if (ade == null)
			ade = new ArrayList<ADEComponent>();
		
		return ade;
	}
	
	public void addGenericADEElement(ADEGenericElement genericADEElement) {
		if (this.genericADEElement == null)
			this.genericADEElement = new ArrayList<ADEGenericElement>();
		
		this.genericADEElement.add(genericADEElement);
	}

	public boolean isSetGenericADEElement() {
		return genericADEElement != null && !genericADEElement.isEmpty();
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

	public List<ADEGenericElement> getGenericADEElement() {
		if (genericADEElement == null)
			genericADEElement = new ArrayList<ADEGenericElement>();
		
		return genericADEElement;
	}
	
	public CityModel toCityModel() {
		CityModel cityModel = new CityModel();
		
		if (isSetId())
			cityModel.setId(getId());

		if (isSetName())
			cityModel.setName(getName());

		if (isSetDescription())
			cityModel.setDescription(getDescription());

		if (isSetMetaDataProperty())
			cityModel.setMetaDataProperty(getMetaDataProperty());

		if (isSetBoundedBy())
			cityModel.setBoundedBy(getBoundedBy());

		if (isSetLocation())
			cityModel.setLocation(getLocation());
		
		if (isSetGenericApplicationPropertyOfCityModel())
			cityModel.setGenericApplicationPropertyOfCityModel(getGenericApplicationPropertyOfCityModel());
		
		if (isSetGenericADEElement())
			cityModel.setGenericADEElement(getGenericADEElement());
		
		return cityModel;
	}
	
}
