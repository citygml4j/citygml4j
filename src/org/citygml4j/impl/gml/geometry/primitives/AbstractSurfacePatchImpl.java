package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurfacePatch;

public abstract class AbstractSurfacePatchImpl implements AbstractSurfacePatch {

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractSurfacePatch copy = (AbstractSurfacePatch)target;

		copy.unsetParent();

		return copy;
	}
	
}
