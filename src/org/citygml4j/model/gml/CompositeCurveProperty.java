package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface CompositeCurveProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public CompositeCurve getCompositeCurve();
	public boolean isSetCompositeCurve();
	
	public void setCompositeCurve(CompositeCurve compositeCurve);
	public void unsetCompositeCurve();
}
