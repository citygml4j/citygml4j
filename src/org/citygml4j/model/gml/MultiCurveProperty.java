package org.citygml4j.model.gml;

public interface MultiCurveProperty extends GMLBase, AssociationAttributeGroup {
	public MultiCurve getMultiCurve();
	public boolean isSetMultiCurve();
	
	public void setMultiCurve(MultiCurve multiCurve);
	public void unsetMultiCurve();
}
