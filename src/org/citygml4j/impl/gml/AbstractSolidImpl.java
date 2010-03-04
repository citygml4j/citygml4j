package org.citygml4j.impl.gml;

import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractSolidImpl extends AbstractGeometricPrimitiveImpl implements AbstractSolid {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTSOLID;
	}
	
}
