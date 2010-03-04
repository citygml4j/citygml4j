package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.gml.LinearRingProperty;

public class LinearRingPropertyImpl implements LinearRingProperty {
	private LinearRing linearRing;
	private Object parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.LINEARRINGPROPERTY;
	}

	public LinearRing getLinearRing() {
		return linearRing;
	}

	public boolean isSetLinearRing() {
		return linearRing != null;
	}

	public void setLinearRing(LinearRing linearRing) {
		if (linearRing != null)
			linearRing.setParent(this);
		
		this.linearRing = linearRing;
	}

	public void unsetLinearRing() {
		if (isSetLinearRing())
			linearRing.unsetParent();
		
		linearRing = null;
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

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LinearRingProperty copy = (target == null) ? new LinearRingPropertyImpl() : (LinearRingProperty)target;
		
		if (isSetLinearRing()) {
			copy.setLinearRing((LinearRing)copyBuilder.copy(linearRing));
			if (copy.getLinearRing() == linearRing)
				linearRing.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LinearRingPropertyImpl(), copyBuilder);
	}
	
}
