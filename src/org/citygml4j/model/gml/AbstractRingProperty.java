package org.citygml4j.model.gml;

public interface AbstractRingProperty extends GMLBase {
	public AbstractRing getRing();
	public boolean isSetRing();
	
	public void setRing(AbstractRing abstractRing);
	public void unsetRing();
}
