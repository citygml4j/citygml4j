package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.AbstractDiscreteCoverage;
import org.citygml4j.model.gml.CoverageFunction;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractDiscreteCoverageImpl extends AbstractCoverageImpl implements AbstractDiscreteCoverage {
	private CoverageFunction coverageFunction;	

	public CoverageFunction getCoverageFunction() {
		return coverageFunction;
	}

	public boolean isSetCoverageFunction() {
		return coverageFunction != null;
	}

	public void setCoverageFunction(CoverageFunction coverageFunction) {
		if (coverageFunction != null)
			coverageFunction.setParent(this);
		
		this.coverageFunction = coverageFunction;
	}

	public void unsetCoverageFunction() {
		if (isSetCoverageFunction())
			coverageFunction.unsetParent();
		
		coverageFunction = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTDISCRETECOVERAGE;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractDiscreteCoverage copy = (AbstractDiscreteCoverage)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetCoverageFunction()) {
			copy.setCoverageFunction((CoverageFunction)copyBuilder.copy(coverageFunction));
			if (copy.getCoverageFunction() == coverageFunction)
				coverageFunction.setParent(this);
		}
		
		return copy;
	}

}
