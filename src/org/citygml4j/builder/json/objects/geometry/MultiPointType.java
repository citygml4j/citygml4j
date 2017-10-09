package org.citygml4j.builder.json.objects.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiPointType extends AbstractGeometryType {
	private final GeometryTypeName type = GeometryTypeName.MULTI_POINT;
	private List<Integer> geometry = new ArrayList<>();
	
	@Override
	public GeometryTypeName getType() {
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
