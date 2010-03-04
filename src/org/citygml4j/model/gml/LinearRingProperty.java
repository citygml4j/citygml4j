package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface LinearRingProperty extends GML, Child, Copyable {
	public LinearRing getLinearRing();
	public boolean isSetLinearRing();
	
	public void setLinearRing(LinearRing linearRing);
	public void unsetLinearRing();
}
