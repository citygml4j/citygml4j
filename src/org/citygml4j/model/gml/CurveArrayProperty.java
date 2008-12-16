package org.citygml4j.model.gml;

import java.util.List;

public interface CurveArrayProperty extends GMLBase {
	public List<AbstractCurve> getCurve();
	public boolean isSetCurve();
	
	public void addCurve(AbstractCurve abstractCurve);
	public void setCurve(List<AbstractCurve> abstractCurve);
	public void unsetCurve();
	public boolean unsetCurve(AbstractCurve abstractCurve);
}
