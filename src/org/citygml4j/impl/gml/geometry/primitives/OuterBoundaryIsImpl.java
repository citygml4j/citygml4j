package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.OuterBoundaryIs;

public class OuterBoundaryIsImpl extends AbstractRingPropertyImpl implements OuterBoundaryIs {
	
	public GMLClass getGMLClass() {
		return GMLClass.OUTER_BOUNDARY_IS;
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
