package org.citygml4j.binding.cityjson.geometry;

public interface GeometryWithSemantics {
	public boolean isSetSemantics();
	public AbstractSemanticsObject getSemantics();
	public void unsetSemantics();
}
