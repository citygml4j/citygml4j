package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;

public class SolidPropertyImpl extends GeometryPropertyImpl<AbstractSolid> implements SolidProperty {
	
	public AbstractSolid getSolid() {
		return super.getGeometry();
	}

	public boolean isSetSolid() {
		return super.isSetGeometry();
	}

	public void setSolid(AbstractSolid abstractSolid) {
		super.setGeometry(abstractSolid);
	}

	public void unsetSolid() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.SOLID_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SolidPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SolidProperty copy = (target == null) ? new SolidPropertyImpl() : (SolidProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
