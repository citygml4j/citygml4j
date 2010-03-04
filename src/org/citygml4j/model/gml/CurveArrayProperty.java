package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface CurveArrayProperty extends GML, Child, Copyable {
	public List<AbstractCurve> getCurve();
	public boolean isSetCurve();
	
	public void addCurve(AbstractCurve abstractCurve);
	public void setCurve(List<AbstractCurve> abstractCurve);
	public void unsetCurve();
	public boolean unsetCurve(AbstractCurve abstractCurve);
}
