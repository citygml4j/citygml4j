package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.PointRep;

public class PointRepImpl extends PointPropertyImpl implements PointRep {
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.POINTREP;
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
