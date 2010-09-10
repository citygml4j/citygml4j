package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryArrayPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.SolidArrayProperty;

public class SolidArrayPropertyImpl extends GeometryArrayPropertyImpl<AbstractSolid> implements SolidArrayProperty {

	public void addSolid(AbstractSolid abstractSolid) {
		super.addGeometry(abstractSolid);
	}

	public List<AbstractSolid> getSolid() {
		return super.getGeometry();
	}

	public boolean isSetSolid() {
		return super.isSetGeometry();
	}

	public void setSolid(List<AbstractSolid> abstractSolid) {
		super.setGeometry(abstractSolid);
	}

	public void unsetSolid() {
		super.unsetGeometry();
	}

	public boolean unsetSolid(AbstractSolid abstractSolid) {
		return super.unsetGeometry(abstractSolid);
	}

	public GMLClass getGMLClass() {
		return GMLClass.SOLID_ARRAY_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SolidArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SolidArrayProperty copy = (target == null) ? new SolidArrayPropertyImpl() : (SolidArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
