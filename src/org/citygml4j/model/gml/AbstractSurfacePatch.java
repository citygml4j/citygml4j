package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.geometry.BoundingBox;

public interface AbstractSurfacePatch extends GML, Child, Copyable {
	public BoundingBox calcBoundingBox();
}
