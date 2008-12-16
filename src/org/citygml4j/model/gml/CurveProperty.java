package org.citygml4j.model.gml;

public interface CurveProperty extends GMLBase, AssociationAttributeGroup {
	public AbstractCurve getCurve();
	public boolean isSetCurve();
	
	public void setCurve(AbstractCurve curve);
	public void unsetCurve();
}
