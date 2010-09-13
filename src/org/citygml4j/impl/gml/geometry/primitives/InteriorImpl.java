package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.Interior;

public class InteriorImpl extends AbstractRingPropertyImpl implements Interior {
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.INTERIOR;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Interior copy = (target == null) ? new InteriorImpl() : (Interior)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InteriorImpl(), copyBuilder);
	}

}
