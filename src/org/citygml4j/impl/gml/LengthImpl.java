package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Length;

public class LengthImpl extends MeasureImpl implements Length {
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.LENGTH;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LengthImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Length copy = (target == null) ? new LengthImpl() : (Length)target;
		return super.copyTo(copy, copyBuilder);
	}
	
}
