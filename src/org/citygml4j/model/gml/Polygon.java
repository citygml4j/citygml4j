package org.citygml4j.model.gml;

import java.util.List;

public interface Polygon extends AbstractSurface {
	public AbstractRingProperty getExterior();
	public List<AbstractRingProperty> getInterior();
	public boolean isSetExterior();
	public boolean isSetInterior();

	public void setExterior(AbstractRingProperty abstractRingProperty);
	public void setInterior(List<AbstractRingProperty> abstractRingProperty);
	public void addInterior(AbstractRingProperty abstractRingProperty);
	public void unsetExterior();
	public void unsetInterior();
	public boolean unsetInterior(AbstractRingProperty abstractRingProperty);
}
