package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.AbstractRingProperty;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractRingPropertyImpl implements AbstractRingProperty {
	private AbstractRing _ring;
	private Object parent;

	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTRINGPROPERTY;
	}
	
	public AbstractRing getRing() {
		return _ring;
	}

	public boolean isSetRing() {
		return _ring != null;
	}

	public void setRing(AbstractRing abstractRing) {
		if (abstractRing != null)
			abstractRing.setParent(this);

		_ring = abstractRing;
	}

	public void unsetRing() {
		if (isSetRing())
			_ring.unsetParent();
		
		_ring = null;
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
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractRingProperty copy = (AbstractRingProperty)target;

		if (isSetRing()) {
			copy.setRing((AbstractRing)copyBuilder.copy(_ring));
			if (copy.getRing() == _ring)
				_ring.setParent(this);
		}

		copy.unsetParent();

		return copy;
	}

}
