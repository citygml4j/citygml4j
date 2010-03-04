package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Speed;

public class SpeedImpl extends MeasureImpl implements Speed {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.SPEED;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SpeedImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Speed copy = (target == null) ? new SpeedImpl() : (Speed)target;
		return super.copyTo(copy, copyBuilder);
	}
	
}
