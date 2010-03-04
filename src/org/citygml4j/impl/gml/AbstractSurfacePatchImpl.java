package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.AbstractSurfacePatch;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractSurfacePatchImpl implements AbstractSurfacePatch {

	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTSURFACEPATCH;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractSurfacePatch copy = (AbstractSurfacePatch)target;

		copy.unsetParent();

		return copy;
	}
	
}
