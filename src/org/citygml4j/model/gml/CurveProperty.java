package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface CurveProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public AbstractCurve getCurve();
	public boolean isSetCurve();
	
	public void setCurve(AbstractCurve curve);
	public void unsetCurve();
}
