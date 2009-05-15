package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.MultiPolygonType;
import org.citygml4j.jaxb.gml._3_1_1.PolygonPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiPolygon;
import org.citygml4j.model.gml.Polygon;
import org.citygml4j.model.gml.PolygonProperty;

public class MultiPolygonImpl extends AbstractGeometricAggregateImpl implements	MultiPolygon {
	private MultiPolygonType multiPolygonType;

	public MultiPolygonImpl() {
		this(new MultiPolygonType());
	}

	public MultiPolygonImpl(MultiPolygonType multiPolygonType) {
		super(multiPolygonType);
		this.multiPolygonType = multiPolygonType;
	}

	@Override
	public MultiPolygonType getJAXBObject() {
		return multiPolygonType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTIPOLYGON;
	}

	public List<PolygonProperty> getPolygonMember() {
		List<PolygonProperty> polygonPropertyList = new ArrayList<PolygonProperty>();

		for (PolygonPropertyType polygonPropertyType : multiPolygonType.getPolygonMember())
			polygonPropertyList.add(new PolygonPropertyImpl(polygonPropertyType));

		return polygonPropertyList;
	}

	public void calcBoundingBox(Point min, Point max) {
		if (isSetPolygonMember()) {
			for (PolygonProperty polygonProperty : getPolygonMember()) {
				Polygon polygon = polygonProperty.getPolygon();
				if (polygon != null)
					polygon.calcBoundingBox(min, max);
			}
		}
	}

	public void addPolygonMember(PolygonProperty polygonMember) {
		multiPolygonType.getPolygonMember().add(((PolygonPropertyImpl)polygonMember).getJAXBObject());
	}

	public boolean isSetPolygonMember() {
		return multiPolygonType.isSetPolygonMember();
	}

	public void setPolygonMember(List<PolygonProperty> polygonMember) {
		List<PolygonPropertyType> polygonPropertyList = new ArrayList<PolygonPropertyType>();

		for (PolygonProperty polygon : polygonMember) 
			polygonPropertyList.add(((PolygonPropertyImpl)polygon).getJAXBObject());

		multiPolygonType.unsetPolygonMember();
		multiPolygonType.getPolygonMember().addAll(polygonPropertyList);
	}

	public void unsetPolygonMember() {
		multiPolygonType.unsetPolygonMember();
	}

	public boolean unsetPolygonMember(PolygonProperty polygonMember) {
		if (multiPolygonType.isSetPolygonMember())
			return multiPolygonType.getPolygonMember().remove(((PolygonPropertyImpl)polygonMember).getJAXBObject());
		
		return false;
	}

}
