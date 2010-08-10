package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;

public abstract class AbstractSolidImpl extends AbstractGeometricPrimitiveImpl implements AbstractSolid {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_SOLID;
	}
	
}
