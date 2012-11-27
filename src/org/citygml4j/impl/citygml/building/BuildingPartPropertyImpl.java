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
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.BuildingPartProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.BuildingModule;

public class BuildingPartPropertyImpl extends FeaturePropertyImpl<BuildingPart> implements BuildingPartProperty {
	private BuildingModule module;
	
	public BuildingPartPropertyImpl() {
		
	}
	
	public BuildingPartPropertyImpl(BuildingModule module) {
		this.module = module;
	}
	
	public BuildingPart getBuildingPart() {
		return super.getObject();
	}

	public boolean isSetBuildingPart() {
		return super.isSetObject();
	}

	public void setBuildingPart(BuildingPart buildingPart) {
		super.setObject(buildingPart);
	}

	public void unsetBuildingPart() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDING_PART_PROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<BuildingPart> getAssociableClass() {
		return BuildingPart.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingPartPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BuildingPartProperty copy = (target == null) ? new BuildingPartPropertyImpl() : (BuildingPartProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
