package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.model.gml.geometry.InlineGeometryProperty;

public interface AbstractRingProperty extends InlineGeometryProperty<AbstractRing> {
	public AbstractRing getRing();
	public boolean isSetRing();
	
	public void setRing(AbstractRing abstractRing);
	public void unsetRing();
}
