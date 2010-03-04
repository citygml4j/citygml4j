package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.CurveArrayProperty;
import org.citygml4j.model.gml.GMLClass;

public class CurveArrayPropertyImpl implements CurveArrayProperty {
	private List<AbstractCurve> curve;
	private Object parent;
	
	public void addCurve(AbstractCurve abstractCurve) {
		if (curve == null)
			curve = new ChildList<AbstractCurve>(this);
		
		curve.add(abstractCurve);
	}

	public List<AbstractCurve> getCurve() {
		if (curve == null)
			curve = new ChildList<AbstractCurve>(this);
		
		return curve;
	}

	public boolean isSetCurve() {
		return curve != null && !curve.isEmpty();
	}

	public void setCurve(List<AbstractCurve> abstractCurve) {
		curve = new ChildList<AbstractCurve>(this, abstractCurve);
	}

	public void unsetCurve() {
		if (isSetCurve())
			curve.clear();
		
		curve = null;
	}

	public boolean unsetCurve(AbstractCurve abstractCurve) {
		return isSetCurve() ? curve.remove(abstractCurve) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVEARRAYPROPERTY;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveArrayProperty copy = (target == null) ? new CurveArrayPropertyImpl() : (CurveArrayProperty)target;
		
		if (isSetCurve()) {
			for (AbstractCurve part : curve) {
				AbstractCurve copyPart = (AbstractCurve)copyBuilder.copy(part);
				copy.addCurve(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
