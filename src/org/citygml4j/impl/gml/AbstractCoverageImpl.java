package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.AbstractCoverage;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.RangeSet;

public abstract class AbstractCoverageImpl extends AbstractFeatureImpl implements AbstractCoverage {
	private RangeSet rangeSet;
	private Integer dimension;
	
	public RangeSet getRangeSet() {
		return rangeSet;
	}
	
	public Integer getDimension() {
		return dimension;
	}

	public boolean isSetRangeSet() {
		return rangeSet != null;
	}
	
	public boolean isSetDimension() {
		return dimension != null;
	}
	
	public void setRangeSet(RangeSet rangeSet) {
		if (rangeSet != null)
			rangeSet.setParent(this);
		
		this.rangeSet = rangeSet;
	}

	public void setDimension(Integer dimension) {
		if (dimension > 0)
			this.dimension = dimension;
	}
	
	public void unsetRangeSet() {
		if (isSetRangeSet())
			rangeSet.unsetParent();
		
		rangeSet = null;
	}

	public void unsetDimension() {
		dimension = null;
	}
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTCOVERAGE;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractCoverage copy = (AbstractCoverage)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetRangeSet()) {
			copy.setRangeSet((RangeSet)copyBuilder.copy(rangeSet));
			if (copy.getRangeSet() == rangeSet)
				rangeSet.setParent(this);
		}
		
		if (isSetDimension())
			copy.setDimension((Integer)copyBuilder.copy(dimension));
		
		return copy;
	}
	
}
