package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.RectifiedGrid;
import org.citygml4j.model.gml.RectifiedGridDomain;

public class RectifiedGridDomainImpl extends DomainSetImpl implements RectifiedGridDomain {

	public RectifiedGrid getRectifiedGrid() {
		return (RectifiedGrid)super.getGeometry();
	}

	public boolean isSetRectifiedGrid() {
		return super.isSetGeometry();
	}

	public void setRectifiedGrid(RectifiedGrid rectifiedGrid) {
		setGeometry(rectifiedGrid);
	}

	public void unsetRectifiedGrid() {
		super.unsetGeometry();
	}

	@Override
	public void setGeometry(AbstractGeometry geometry) {
		if (geometry instanceof RectifiedGrid)
			super.setGeometry(geometry);
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.RECTIFIEDGRIDDOMAIN;
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
