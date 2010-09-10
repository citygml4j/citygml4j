package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.Exterior;

public class ExteriorImpl extends AbstractRingPropertyImpl implements Exterior {
	
	public GMLClass getGMLClass() {
		return GMLClass.EXTERIOR;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Exterior copy = (target == null) ? new ExteriorImpl() : (Exterior)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ExteriorImpl(), copyBuilder);
	}

}
