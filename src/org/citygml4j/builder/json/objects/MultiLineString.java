package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

public class MultiLineString extends AbstractGeometryObject {
	private final GeometryObjectType type = GeometryObjectType.MULTI_LINE_STRING;
	private List<List<Integer>> geometry = new ArrayList<>();
	
	@Override
	public GeometryObjectType getType() {
		return type;
	}
	
	public void addLineString(List<Integer> lineString) {
		if (lineString != null && lineString.size() > 0)
			geometry.add(lineString);
	}

	public List<List<Integer>> getLineStrings() {
		return geometry;
	}

	public void setLineStrings(List<List<Integer>> lineStrings) {
		if (lineStrings != null)
			geometry = lineStrings;
	}
	
}
