package org.citygml4j.impl.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.gml.coverage.RectifiedGridDomain;
import org.citygml4j.model.gml.feature.BoundingShape;

public class RectifiedGridCoverageImpl extends AbstractDiscreteCoverageImpl implements RectifiedGridCoverage {
	private RectifiedGridDomain rectifiedGridDomain;
	
	public RectifiedGridDomain getRectifiedGridDomain() {
		return rectifiedGridDomain;
	}

	public boolean isSetRectifiedGridDomain() {
		return rectifiedGridDomain != null;
	}

	public void setRectifiedGridDomain(RectifiedGridDomain rectifiedGridDomain) {
		if (rectifiedGridDomain != null)
			rectifiedGridDomain.setParent(this);
		
		this.rectifiedGridDomain = rectifiedGridDomain;
	}

	public void unsetRectifiedGridDomain() {
		if (isSetRectifiedGridDomain())
			rectifiedGridDomain.unsetParent();
		
		rectifiedGridDomain = null;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.RECTIFIED_GRID_COVERAGE;
	}
	
	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();
		
		if (isSetRectifiedGridDomain() && rectifiedGridDomain.isSetGeometry())
			calcBoundedBy(boundedBy, rectifiedGridDomain.getGeometry());
		
		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RectifiedGridCoverage copy = (target == null) ? new RectifiedGridCoverageImpl() : (RectifiedGridCoverage)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetRectifiedGridDomain()) {
			copy.setRectifiedGridDomain((RectifiedGridDomain)copyBuilder.copy(rectifiedGridDomain));
			if (copy.getRectifiedGridDomain() == rectifiedGridDomain)
				rectifiedGridDomain.setParent(this);
		}
		
		return copy;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RectifiedGridCoverageImpl(), copyBuilder);
	}

	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}

	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
