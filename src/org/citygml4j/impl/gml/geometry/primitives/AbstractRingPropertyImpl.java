package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.impl.gml.geometry.InlineGeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractRing;
import org.citygml4j.model.gml.geometry.primitives.AbstractRingProperty;

public abstract class AbstractRingPropertyImpl extends InlineGeometryPropertyImpl<AbstractRing> implements AbstractRingProperty {

	public AbstractRing getRing() {
		return super.getGeometry();
	}

	public boolean isSetRing() {
		return super.isSetGeometry();
	}

	public void setRing(AbstractRing abstractRing) {
		super.setGeometry(abstractRing);
	}

	public void unsetRing() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_RING_PROPERTY;
	}

}
