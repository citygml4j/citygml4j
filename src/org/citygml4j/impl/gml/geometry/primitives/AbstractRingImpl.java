package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.impl.gml.geometry.AbstractGeometryImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractRing;

public abstract class AbstractRingImpl extends AbstractGeometryImpl implements AbstractRing {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_RING;
	}
	
}
