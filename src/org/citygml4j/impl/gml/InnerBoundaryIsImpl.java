package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.InnerBoundaryIs;

public class InnerBoundaryIsImpl extends AbstractRingPropertyImpl implements InnerBoundaryIs {

	public GMLClass getGMLClass() {
		return GMLClass.INNERBOUNDARYIS;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		InnerBoundaryIs copy = (target == null) ? new InnerBoundaryIsImpl() : (InnerBoundaryIs)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InnerBoundaryIsImpl(), copyBuilder);
	}

}
