package org.citygml4j.impl.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.BuildingModule;

public class IntBuildingInstallationPropertyImpl extends FeaturePropertyImpl<IntBuildingInstallation> implements IntBuildingInstallationProperty {
	private BuildingModule module;
	
	public IntBuildingInstallationPropertyImpl() {
		
	}
	
	public IntBuildingInstallationPropertyImpl(BuildingModule module) {
		this.module = module;
	}
	
	public IntBuildingInstallation getIntBuildingInstallation() {
		return super.getObject();
	}

	public boolean isSetIntBuildingInstallation() {
		return super.isSetObject();
	}

	public void setIntBuildingInstallation(IntBuildingInstallation intBuildingInstallation) {
		super.setObject(intBuildingInstallation);
	}

	public void unsetIntBuildingInstallation() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INT_BUILDING_INSTALLATION_PROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntBuildingInstallationPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntBuildingInstallationProperty copy = (target == null) ? new IntBuildingInstallationPropertyImpl() : (IntBuildingInstallationProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
