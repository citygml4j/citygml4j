package org.citygml4j.impl.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.coverage.RectifiedGridDomain;
import org.citygml4j.model.gml.grids.RectifiedGrid;

public class RectifiedGridDomainImpl extends DomainSetImpl<RectifiedGrid> implements RectifiedGridDomain {

	public RectifiedGrid getRectifiedGrid() {
		return super.getGeometry();
	}

	public boolean isSetRectifiedGrid() {
		return super.isSetGeometry();
	}

	public void setRectifiedGrid(RectifiedGrid rectifiedGrid) {
		setObject(rectifiedGrid);
	}

	public void unsetRectifiedGrid() {
		super.unsetGeometry();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.RECTIFIED_GRID_DOMAIN;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RectifiedGridDomain copy = (target == null) ? new RectifiedGridDomainImpl() : (RectifiedGridDomain)target;
		return super.copyTo(copy, copyBuilder);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RectifiedGridDomainImpl(), copyBuilder);
	}

}
