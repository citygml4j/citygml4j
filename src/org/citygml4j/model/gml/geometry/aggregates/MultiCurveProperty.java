package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface MultiCurveProperty extends GeometryProperty<MultiCurve> {
	public MultiCurve getMultiCurve();
	public boolean isSetMultiCurve();
	
	public void setMultiCurve(MultiCurve multiCurve);
	public void unsetMultiCurve();
}
