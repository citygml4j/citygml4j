package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

public class MultiPoint extends AbstractGeometryObject {
	private final GeometryObjectType type = GeometryObjectType.MULTI_POINT;
	private List<Integer> geometry = new ArrayList<>();
	
	@Override
	public GeometryObjectType getType() {
		return type;
	}
	
	public void addPoint(int point) {
		geometry.add(point);
	}

	public List<Integer> getPoints() {
		return geometry;
	}

	public void setPoints(List<Integer> points) {
		if (points != null)
			geometry = points;
	}
	
}
