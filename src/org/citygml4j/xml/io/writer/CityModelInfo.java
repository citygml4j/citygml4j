/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.xml.io.writer;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.DeepCopyBuilder;
import org.citygml4j.impl.citygml.core.CityModelImpl;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.base.MetaDataProperty;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.LocationProperty;
import org.citygml4j.xml.io.reader.ParentInfo;

public class CityModelInfo {
	private String id;
	private List<Code> name;
	private StringOrRef description;
	private List<MetaDataProperty> metaDataProperty;
	private BoundingShape boundedBy;
	private LocationProperty location;
	private List<ADEComponent> ade;
	private List<ADEComponent> genericADE;
		
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
			setGenericADEComponent((List<ADEComponent>)builder.copy(cityModel.getGenericApplicationPropertyOfCityModel()));
		
		if (cityModel.isSetGenericADEComponent())
			setGenericADEComponent((List<ADEComponent>)builder.copy(cityModel.getGenericADEComponent()));
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
	
	public void addGenericADEComponent(ADEComponent ade) {
		if (this.genericADE == null)
			this.genericADE = new ArrayList<ADEComponent>();
		
		this.genericADE.add(ade);
	}

	public boolean isSetGenericADEComponent() {
		return genericADE != null && !genericADE.isEmpty();
	}

	public void setGenericADEComponent(List<ADEComponent> ade) {
		this.genericADE = ade;
	}

	public void unsetGenericADEComponent() {
		genericADE = null;
	}

	public boolean unsetGenericADEComponent(ADEComponent ade) {
		return this.genericADE.remove(ade);
	}

	public List<ADEComponent> getGenericADEComponent() {
		if (genericADE == null)
			genericADE = new ArrayList<ADEComponent>();
		
		return genericADE;
	}
	
	public CityModel toCityModel() {
		CityModel cityModel = new CityModelImpl();
		
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
		
		if (isSetGenericADEComponent())
			cityModel.setGenericADEComponent(getGenericADEComponent());
		
		return cityModel;
	}
	
}
