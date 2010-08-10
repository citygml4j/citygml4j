package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LineStringProperty;

public class LineStringPropertyImpl extends GeometryPropertyImpl<LineString> implements LineStringProperty {

	public GMLClass getGMLClass() {
		return GMLClass.LINE_STRING_PROPERTY;
	}

	public LineString getLineString() {
		return super.getGeometry();
	}

	public boolean isSetLineString() {
		return super.isSetGeometry();
	}

	public void setLineString(LineString lineString) {
		super.setGeometry(lineString);
	}

	public void unsetLineString() {
		super.unsetGeometry();
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LineStringProperty copy = (target == null) ? new LineStringPropertyImpl() : (LineStringProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LineStringPropertyImpl(), copyBuilder);
	}
	
}
