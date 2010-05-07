package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.PointPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.PointRep;

public class PointRepImpl extends PointPropertyImpl implements PointRep {

	public PointRepImpl() {
		this(new PointPropertyType());
	}

	public PointRepImpl(PointPropertyType pointPropertyType) {
		super(pointPropertyType);
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.POINTREP;
	}
}
