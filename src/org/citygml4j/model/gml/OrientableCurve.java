package org.citygml4j.model.gml;

public interface OrientableCurve extends AbstractCurve {
	public String getOrientation();
	public CurveProperty getBaseCurve();
	public boolean isSetOrientation();
	public boolean isSetBaseCurve();
	
	public void setOrientation(String orientation);
	public void setBaseCurve(CurveProperty baseCurve);
	public void unsetOrientation();
	public void unsetBaseCurve();
}
