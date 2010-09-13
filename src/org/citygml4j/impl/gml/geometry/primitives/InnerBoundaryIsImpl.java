package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.InnerBoundaryIs;

public class InnerBoundaryIsImpl extends AbstractRingPropertyImpl implements InnerBoundaryIs {

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.INNER_BOUNDARY_IS;
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
