package org.citygml4j.binding.json.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiPointType extends AbstractGeometryType {
	private final GeometryTypeName type = GeometryTypeName.MULTI_POINT;
	private List<Integer> boundaries = new ArrayList<>();
	
	@Override
	public GeometryTypeName getType() {
		return type;
	}
	
	public void addPoint(int point) {
		boundaries.add(point);
	}
	
	public void addPoints(List<Integer> points) {
		boundaries.addAll(points);
	}

	public List<Integer> getPoints() {
		return boundaries;
	}

	public void setPoints(List<Integer> points) {
		if (points != null)
			boundaries = points;
	}
	
}
