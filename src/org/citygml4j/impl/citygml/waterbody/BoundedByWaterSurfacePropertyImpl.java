package org.citygml4j.impl.citygml.waterbody;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.AssociationImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBoundarySurface;
import org.citygml4j.model.module.citygml.WaterBodyModule;

public class BoundedByWaterSurfacePropertyImpl extends AssociationImpl<WaterBoundarySurface> implements BoundedByWaterSurfaceProperty {
	private WaterBodyModule module;
	
	public BoundedByWaterSurfacePropertyImpl() {
		
	}
	
	public BoundedByWaterSurfacePropertyImpl(WaterBodyModule module) {
		this.module = module;
	}
	
	public WaterBoundarySurface getWaterBoundarySurface() {
		return super.getObject();
	}

	public boolean isSetWaterBoundarySurface() {
		return super.isSetObject();
	}

	public void setWaterBoundarySurface(WaterBoundarySurface waterBoundarySurface) {
		super.setObject(waterBoundarySurface);
	}

	public void unsetWaterBoundarySurface() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BOUNDEDBYWATERSURFACEPROPERTY;
	}

	public final WaterBodyModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BoundedByWaterSurfacePropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BoundedByWaterSurfaceProperty copy = (target == null) ? new BoundedByWaterSurfacePropertyImpl() : (BoundedByWaterSurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
