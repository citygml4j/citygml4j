package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface CurveProperty extends GeometryProperty<AbstractCurve> {
	public AbstractCurve getCurve();
	public boolean isSetCurve();
	
	public void setCurve(AbstractCurve curve);
	public void unsetCurve();
}
