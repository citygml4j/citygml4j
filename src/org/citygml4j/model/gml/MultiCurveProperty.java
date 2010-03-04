package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface MultiCurveProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public MultiCurve getMultiCurve();
	public boolean isSetMultiCurve();
	
	public void setMultiCurve(MultiCurve multiCurve);
	public void unsetMultiCurve();
}
