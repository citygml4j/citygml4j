package org.citygml4j.impl.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolid;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolidProperty;

public class MultiSolidPropertyImpl extends GeometryPropertyImpl<MultiSolid> implements MultiSolidProperty {

	public MultiSolid getMultiSolid() {
		return super.getGeometry();
	}

	public boolean isSetMultiSolid() {
		return super.isSetGeometry();
	}

	public void setMultiSolid(MultiSolid multiSolid) {
		super.setGeometry(multiSolid);
	}

	public void unsetMultiSolid() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_SOLID_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiSolidPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiSolidProperty copy = (target == null) ? new MultiSolidPropertyImpl() : (MultiSolidProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
