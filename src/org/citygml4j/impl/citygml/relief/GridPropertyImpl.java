package org.citygml4j.impl.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.relief.GridProperty;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.module.citygml.ReliefModule;

public class GridPropertyImpl extends FeaturePropertyImpl<RectifiedGridCoverage> implements GridProperty {
	private ReliefModule module;
	
	public GridPropertyImpl() {
		
	}
	
	public GridPropertyImpl(ReliefModule module) {
		this.module = module;
	}
	
	public RectifiedGridCoverage getRectifiedGridCoverage() {
		return super.getObject();
	}

	public boolean isSetRectifiedGridCoverage() {
		return super.isSetObject();
	}

	public void setRectifiedGridCoverage(RectifiedGridCoverage rectifiedGridCoverage) {
		super.setObject(rectifiedGridCoverage);
	}

	public void unsetRectifiedGridCoverage() {
		super.unsetObject();
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GRID_PROPERTY;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GridProperty copy = (target == null) ? new GridPropertyImpl() : (GridProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GridPropertyImpl(), copyBuilder);
	}

}
