package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.model.gml.geometry.InlineGeometryProperty;

public interface LinearRingProperty extends InlineGeometryProperty<LinearRing> {
	public LinearRing getLinearRing();
	public boolean isSetLinearRing();
	
	public void setLinearRing(LinearRing linearRing);
	public void unsetLinearRing();
}
