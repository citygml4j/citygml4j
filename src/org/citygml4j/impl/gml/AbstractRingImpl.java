package org.citygml4j.impl.gml;

import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractRingImpl extends AbstractGeometryImpl implements AbstractRing {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTRING;
	}
	
}
