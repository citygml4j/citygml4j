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
