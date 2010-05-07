package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.LengthType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Length;

public class LengthImpl extends MeasureImpl implements Length {
	private LengthType length;

	public LengthImpl() {
		this(new LengthType());
	}

	public LengthImpl(LengthType length) {
		super(length);
		this.length = length;
	}

	@Override
	public LengthType getJAXBObject() {
		return length;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.LENGTH;
	}
}
