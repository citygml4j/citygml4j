package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface AbstractRingProperty extends GML, Child, Copyable {
	public AbstractRing getRing();
	public boolean isSetRing();
	
	public void setRing(AbstractRing abstractRing);
	public void unsetRing();
}
