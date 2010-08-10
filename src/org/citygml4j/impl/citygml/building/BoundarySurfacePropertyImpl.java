package org.citygml4j.impl.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.module.citygml.BuildingModule;

public class BoundarySurfacePropertyImpl extends FeaturePropertyImpl<AbstractBoundarySurface> implements BoundarySurfaceProperty {
	private BuildingModule module;
	
	public BoundarySurfacePropertyImpl() {
		
	}
	
	public BoundarySurfacePropertyImpl(BuildingModule module) {
		this.module = module;
	}
	
	public AbstractBoundarySurface getBoundarySurface() {
		return super.getObject();
	}

	public boolean isSetBoundarySurface() {
		return super.isSetObject();
	}

	public void setBoundarySurface(AbstractBoundarySurface boundarySurface) {
		super.setObject(boundarySurface);
	}

	public void unsetBoundarySurface() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BOUNDARY_SURFACE_PROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BoundarySurfacePropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BoundarySurfaceProperty copy = (target == null) ? new BoundarySurfacePropertyImpl() : (BoundarySurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
