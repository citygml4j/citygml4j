package org.citygml4j.model.gml;

import org.citygml4j.geometry.Point;

public interface AbstractSurfacePatch extends GMLBase {
	public void calcBoundingBox(Point min, Point max);
}
