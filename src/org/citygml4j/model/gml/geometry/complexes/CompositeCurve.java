package org.citygml4j.model.gml.geometry.complexes;

import java.util.List;

import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;

public interface CompositeCurve extends AbstractCurve {
	public List<CurveProperty> getCurveMember();
	public boolean isSetCurveMember();
	
	public void addCurveMember(CurveProperty curveMember);
	public void setCurveMember(List<CurveProperty> curveMember);
	public void unsetCurveMember();
	public boolean unsetCurveMember(CurveProperty curveMember);
}
