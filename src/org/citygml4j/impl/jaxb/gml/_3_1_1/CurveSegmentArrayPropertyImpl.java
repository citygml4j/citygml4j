package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractCurveSegmentType;
import org.citygml4j.jaxb.gml._3_1_1.CurveSegmentArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringSegmentType;
import org.citygml4j.model.gml.AbstractCurveSegment;
import org.citygml4j.model.gml.CurveSegmentArrayProperty;
import org.citygml4j.model.gml.GMLClass;

public class CurveSegmentArrayPropertyImpl extends GMLBaseImpl implements CurveSegmentArrayProperty {
	private CurveSegmentArrayPropertyType propertyType;

	public CurveSegmentArrayPropertyImpl() {
		propertyType = new CurveSegmentArrayPropertyType();
	}

	public CurveSegmentArrayPropertyImpl(CurveSegmentArrayPropertyType propertytType) {
		this.propertyType = propertytType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.CURVESEGMENTARRAYPROPERTY;
	}

	@Override
	public CurveSegmentArrayPropertyType getJAXBObject() {
		return propertyType;
	}

	@Override
	public void addCurveSegment(AbstractCurveSegment curveSegment) {
		JAXBElement<? extends AbstractCurveSegmentType> elem = null;

		switch (curveSegment.getGMLClass()) {
		case LINESTRINGSEGMENT:
			elem = ObjectFactory.GML.createLineStringSegment(((LineStringSegmentImpl)curveSegment).getJAXBObject());
			break;
		}

		if (elem != null)
			propertyType.get_CurveSegment().add(elem);
	}

	@Override
	public List<AbstractCurveSegment> getCurveSegment() {
		List<AbstractCurveSegment> segmentList = new ArrayList<AbstractCurveSegment>();

		for (JAXBElement<? extends AbstractCurveSegmentType> segmentElem : propertyType.get_CurveSegment()) {
			if (segmentElem.getValue() != null && segmentElem.getValue() instanceof LineStringSegmentType)
				segmentList.add(new LineStringSegmentImpl((LineStringSegmentType)segmentElem.getValue()));
		}

		return segmentList;
	}

	@Override
	public void setCurveSegment(List<AbstractCurveSegment> curveSegment) {
		List<JAXBElement<? extends AbstractCurveSegmentType>> segmentTypeList = new ArrayList<JAXBElement<? extends AbstractCurveSegmentType>>();

		for (AbstractCurveSegment segment : curveSegment) {
			JAXBElement<? extends AbstractCurveSegmentType> elem = null;

			switch (segment.getGMLClass()) {
			case LINESTRINGSEGMENT:
				elem = ObjectFactory.GML.createLineStringSegment(((LineStringSegmentImpl)curveSegment).getJAXBObject());
				break;
			}

			if (elem != null)
				segmentTypeList.add(elem);
		}

		propertyType.unset_CurveSegment();
		propertyType.get_CurveSegment().addAll(segmentTypeList);
	}

	@Override
	public boolean isSetCurveSegment() {
		return propertyType.isSet_CurveSegment();
	}

	@Override
	public void unsetCurveSegment() {
		propertyType.unset_CurveSegment();
	}

	@Override
	public boolean unsetCurveSegment(AbstractCurveSegment curveSegment) {
		if (propertyType.isSet_CurveSegment())
			return propertyType.get_CurveSegment().remove(((AbstractCurveSegmentImpl)curveSegment).getJAXBObject());
		
		return false;
	}

}
