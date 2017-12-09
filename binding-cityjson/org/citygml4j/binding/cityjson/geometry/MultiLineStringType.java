package org.citygml4j.binding.cityjson.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiLineStringType extends AbstractGeometryType {
	private final GeometryTypeName type = GeometryTypeName.MULTI_LINE_STRING;
	private List<List<Integer>> boundaries = new ArrayList<>();
	
	@Override
	public GeometryTypeName getType() {
		return type;
	}
	
	public void addLineString(List<Integer> lineString) {
		if (lineString != null && lineString.size() > 0)
			boundaries.add(lineString);
	}

	public List<List<Integer>> getLineStrings() {
		return boundaries;
	}

	public void setLineStrings(List<List<Integer>> lineStrings) {
		if (lineStrings != null)
			boundaries = lineStrings;
	}
	
	public void unsetLineStrings() {
		boundaries.clear();
	}
	
}
