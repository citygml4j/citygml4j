package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.LineStringPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiLineStringType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LineString;
import org.citygml4j.model.gml.LineStringProperty;
import org.citygml4j.model.gml.MultiLineString;

public class MultiLineStringImpl extends AbstractGeometricAggregateImpl	implements MultiLineString {
	private MultiLineStringType multiLineStringType;

	public MultiLineStringImpl() {
		this(new MultiLineStringType());
	}

	public MultiLineStringImpl(MultiLineStringType multiLineStringType) {
		super(multiLineStringType);
		this.multiLineStringType = multiLineStringType;
	}

	@Override
	public MultiLineStringType getJAXBObject() {
		return multiLineStringType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTILINESTRING;
	}

	public List<LineStringProperty> getLineStringMember() {
		List<LineStringProperty> lineStringPropertyList = new ArrayList<LineStringProperty>();

		for (LineStringPropertyType lineStringPropertyType : multiLineStringType.getLineStringMember())
			lineStringPropertyList.add(new LineStringPropertyImpl(lineStringPropertyType));

		return lineStringPropertyList;
	}

	public void calcBoundingBox(Point min, Point max) {
		if (isSetLineStringMember()) {
			for (LineStringProperty lineStringProperty : getLineStringMember()) {
				LineString lineString = lineStringProperty.getLineString();
				if (lineString != null)
					lineString.calcBoundingBox(min, max);
			}
		}
	}

	public void addLineStringMember(LineStringProperty lineStringMember) {
		multiLineStringType.getLineStringMember().add(((LineStringPropertyImpl)lineStringMember).getJAXBObject());
	}

	public boolean isSetLineStringMember() {
		return multiLineStringType.isSetLineStringMember();
	}

	public void setLineStringMember(List<LineStringProperty> lineStringMember) {
		List<LineStringPropertyType> propertyTypeList = new ArrayList<LineStringPropertyType>();

		for (LineStringProperty lineString : lineStringMember)
			propertyTypeList.add(((LineStringPropertyImpl)lineString).getJAXBObject());

		multiLineStringType.unsetLineStringMember();
		multiLineStringType.getLineStringMember().addAll(propertyTypeList);
	}

	public void unsetLineStringMember() {
		multiLineStringType.unsetLineStringMember();
	}

	public boolean unsetLineStringMember(LineStringProperty lineStringMember) {
		if (multiLineStringType.isSetLineStringMember())
			return multiLineStringType.getLineStringMember().remove(((LineStringPropertyImpl)lineStringMember).getJAXBObject());
		
		return false;
	}

}
