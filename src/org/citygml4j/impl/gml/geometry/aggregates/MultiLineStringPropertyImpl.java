package org.citygml4j.impl.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.MultiLineString;
import org.citygml4j.model.gml.geometry.aggregates.MultiLineStringProperty;

public class MultiLineStringPropertyImpl extends GeometryPropertyImpl<MultiLineString> implements MultiLineStringProperty {

	public MultiLineString getMultiLineString() {
		return super.getGeometry();
	}

	public boolean isSetMultiLineString() {
		return super.isSetGeometry();
	}

	public void setMultiLineString(MultiLineString multiLineString) {
		super.setGeometry(multiLineString);
	}

	public void unsetMultiLineString() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_LINE_STRING_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiLineStringPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiLineStringProperty copy = (target == null) ? new MultiLineStringPropertyImpl() : (MultiLineStringProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
