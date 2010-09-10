package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.PointRep;

public class PointRepImpl extends PointPropertyImpl implements PointRep {
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.POINT_REP;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PointRepImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PointRep copy = (target == null) ? new PointRepImpl() : (PointRep)target;
		return super.copyTo(copy, copyBuilder);
	}

}
