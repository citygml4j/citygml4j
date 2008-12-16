package org.citygml4j.model.gml;

public interface CompositeCurveProperty extends GMLBase, AssociationAttributeGroup {
	public CompositeCurve getCompositeCurve();
	public boolean isSetCompositeCurve();
	
	public void setCompositeCurve(CompositeCurve compositeCurve);
	public void unsetCompositeCurve();
}
