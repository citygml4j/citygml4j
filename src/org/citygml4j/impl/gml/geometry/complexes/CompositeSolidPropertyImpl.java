package org.citygml4j.impl.gml.geometry.complexes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.complexes.CompositeSolid;
import org.citygml4j.model.gml.geometry.complexes.CompositeSolidProperty;

public class CompositeSolidPropertyImpl extends GeometryPropertyImpl<CompositeSolid> implements CompositeSolidProperty {

	public CompositeSolid getCompositeSolid() {
		return super.getGeometry();
	}

	public boolean isSetCompositeSolid() {
		return super.isSetGeometry();
	}

	public void setCompositeSolid(CompositeSolid compositeSolid) {
		super.setGeometry(compositeSolid);
	}

	public void unsetCompositeSolid() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_SOLID_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeSolidPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeSolidProperty copy = (target == null) ? new CompositeSolidPropertyImpl() : (CompositeSolidProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
