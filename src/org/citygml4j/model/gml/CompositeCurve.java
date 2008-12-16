package org.citygml4j.model.gml;

import java.util.List;

public interface CompositeCurve extends AbstractCurve {
	public List<CurveProperty> getCurveMember();
	public boolean isSetCurveMember();
	
	public void addCurveMember(CurveProperty curveMember);
	public void setCurveMember(List<CurveProperty> curveMember);
	public void unsetCurveMember();
	public boolean unsetCurveMember(CurveProperty curveMember);
}
