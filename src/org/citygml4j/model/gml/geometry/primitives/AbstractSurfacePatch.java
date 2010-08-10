package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.base.Associable;

public interface AbstractSurfacePatch extends GML, Associable {
	public BoundingBox calcBoundingBox();
}
