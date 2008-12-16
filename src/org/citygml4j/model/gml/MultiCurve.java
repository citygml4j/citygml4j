package org.citygml4j.model.gml;

import java.util.List;

public interface MultiCurve extends AbstractGeometricAggregate {
	public List<CurveProperty> getCurveMember();
	public CurveArrayProperty getCurveMembers();
	public boolean isSetCurveMember();
	public boolean isSetCurveMembers();
	
	public void addCurveMember(CurveProperty curveMember);
	public void setCurveMember(List<CurveProperty> curveMember);
	public void setCurveMembers(CurveArrayProperty curveMembers);
	public void unsetCurveMember();
	public boolean unsetCurveMember(CurveProperty curveMember);
	public void unsetCurveMembers();
}
