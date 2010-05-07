package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.LineStringSegmentArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringSegmentType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LineStringSegment;
import org.citygml4j.model.gml.LineStringSegmentArrayProperty;

public class LineStringSegmentArrayPropertyImpl extends GMLBaseImpl implements LineStringSegmentArrayProperty {
	private LineStringSegmentArrayPropertyType propertyType;

	public LineStringSegmentArrayPropertyImpl() {
		propertyType = new LineStringSegmentArrayPropertyType();
	}

	public LineStringSegmentArrayPropertyImpl(LineStringSegmentArrayPropertyType propertyType) {
		this.propertyType = propertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.LINESTRINGSEGMENTARRAYPROPERTY;
	}

	@Override
	public LineStringSegmentArrayPropertyType getJAXBObject() {
		return propertyType;
	}

	public void addLineStringSegment(LineStringSegment lineStringSegment) {
		propertyType.getLineStringSegment().add(((LineStringSegmentImpl)lineStringSegment).getJAXBObject());
	}

	public List<LineStringSegment> getLineStringSegment() {
		List<LineStringSegment> segmentList = new ArrayList<LineStringSegment>();

		for (LineStringSegmentType segmentType : propertyType.getLineStringSegment())
			segmentList.add(new LineStringSegmentImpl(segmentType));

		return segmentList;
	}

	public void setLineStringSegment(List<LineStringSegment> lineStringSegment) {
		List<LineStringSegmentType> segmentTypeList = new ArrayList<LineStringSegmentType>();

		for (LineStringSegment segment : lineStringSegment)
			segmentTypeList.add(((LineStringSegmentImpl)segment).getJAXBObject());

		propertyType.unsetLineStringSegment();
		propertyType.getLineStringSegment().addAll(segmentTypeList);
	}

	public boolean isSetLineStringSegment() {
		return propertyType.isSetLineStringSegment();
	}

	public void unsetLineStringSegment() {
		propertyType.unsetLineStringSegment();
	}

	public boolean unsetLineStringSegment(LineStringSegment lineStringSegment) {
		if (propertyType.isSetLineStringSegment())
			return propertyType.getLineStringSegment().remove(((LineStringSegmentImpl)lineStringSegment).getJAXBObject());
		
		return false;
	}

}
