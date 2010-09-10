package org.citygml4j.model.gml.geometry.aggregates;

import java.util.List;

import org.citygml4j.model.gml.geometry.primitives.CurveArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;

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
