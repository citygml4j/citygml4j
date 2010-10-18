/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
package org.citygml4j.impl.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.InteriorFurnitureProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.BuildingModule;

public class InteriorFurniturePropertyImpl extends FeaturePropertyImpl<BuildingFurniture> implements InteriorFurnitureProperty {
	private BuildingModule module;
	
	public InteriorFurniturePropertyImpl() {
		
	}
	
	public InteriorFurniturePropertyImpl(BuildingModule module) {
		this.module = module;
	}
	
	public BuildingFurniture getBuildingFurniture() {
		return super.getObject();
	}

	public boolean isSetBuildingFurniture() {
		return super.isSetObject();
	}

	public void setBuildingFurniture(BuildingFurniture buildingFurniture) {
		super.setObject(buildingFurniture);
	}

	public void unsetBuildingFurniture() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIOR_FURNITURE_PROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InteriorFurniturePropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		InteriorFurnitureProperty copy = (target == null) ? new InteriorFurniturePropertyImpl() : (InteriorFurnitureProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
