package org.citygml4j.impl.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.AssociationImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class SurfaceDataPropertyImpl extends AssociationImpl<AbstractSurfaceData> implements SurfaceDataProperty {
	private AppearanceModule module;
	
	public SurfaceDataPropertyImpl() {
		
	}
	
	public SurfaceDataPropertyImpl(AppearanceModule module) {
		this.module = module;
	}
	
	public AbstractSurfaceData getSurfaceData() {
		return super.getObject();
	}

	public boolean isSetSurfaceData() {
		return super.isSetObject();
	}

	public void setSurfaceData(AbstractSurfaceData surfaceData) {
		super.setObject(surfaceData);
	}
	
	public void unsetSurfaceData() {
		super.unsetObject();
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.SURFACEDATAPROPERTY;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfaceDataPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfaceDataProperty copy = (target == null) ? new SurfaceDataPropertyImpl() : (SurfaceDataProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
