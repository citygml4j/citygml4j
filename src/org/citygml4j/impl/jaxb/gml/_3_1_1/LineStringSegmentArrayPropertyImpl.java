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

	@Override
	public void addLineStringSegment(LineStringSegment lineStringSegment) {
		propertyType.getLineStringSegment().add(((LineStringSegmentImpl)lineStringSegment).getJAXBObject());
	}

	@Override
	public List<LineStringSegment> getLineStringSegment() {
		List<LineStringSegment> segmentList = new ArrayList<LineStringSegment>();

		for (LineStringSegmentType segmentType : propertyType.getLineStringSegment())
			segmentList.add(new LineStringSegmentImpl(segmentType));

		return segmentList;
	}

	@Override
	public void setLineStringSegment(List<LineStringSegment> lineStringSegment) {
		List<LineStringSegmentType> segmentTypeList = new ArrayList<LineStringSegmentType>();

		for (LineStringSegment segment : lineStringSegment)
			segmentTypeList.add(((LineStringSegmentImpl)segment).getJAXBObject());

		propertyType.unsetLineStringSegment();
		propertyType.getLineStringSegment().addAll(segmentTypeList);
	}

	@Override
	public boolean isSetLineStringSegment() {
		return propertyType.isSetLineStringSegment();
	}

	@Override
	public void unsetLineStringSegment() {
		propertyType.unsetLineStringSegment();
	}

	@Override
	public boolean unsetLineStringSegment(LineStringSegment lineStringSegment) {
		if (propertyType.isSetLineStringSegment())
			return propertyType.getLineStringSegment().remove(((LineStringSegmentImpl)lineStringSegment).getJAXBObject());
		
		return false;
	}

}
