package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.OuterBoundaryIs;

public class OuterBoundaryIsImpl extends AbstractRingPropertyImpl implements OuterBoundaryIs {
	
	public GMLClass getGMLClass() {
		return GMLClass.OUTERBOUNDARYIS;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OuterBoundaryIs copy = (target == null) ? new OuterBoundaryIsImpl() : (OuterBoundaryIs)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OuterBoundaryIsImpl(), copyBuilder);
	}

}
