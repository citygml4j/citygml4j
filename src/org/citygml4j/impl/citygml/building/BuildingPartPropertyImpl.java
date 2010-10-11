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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingPartPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BuildingPartProperty copy = (target == null) ? new BuildingPartPropertyImpl() : (BuildingPartProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
