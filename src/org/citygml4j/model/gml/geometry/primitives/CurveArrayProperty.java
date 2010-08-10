package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

public interface CurveArrayProperty extends GeometryArrayProperty<AbstractCurve> {
	public List<AbstractCurve> getCurve();
	public boolean isSetCurve();
	
	public void addCurve(AbstractCurve abstractCurve);
	public void setCurve(List<AbstractCurve> abstractCurve);
	public void unsetCurve();
	public boolean unsetCurve(AbstractCurve abstractCurve);
}
