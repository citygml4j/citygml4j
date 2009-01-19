package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.SpeedType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Speed;

public class SpeedImpl extends MeasureImpl implements Speed {
	private SpeedType speedType;
	
	public SpeedImpl() {
		this(new SpeedType());
	}
	
	public SpeedImpl(SpeedType speedType) {
		super(speedType);
		this.speedType = speedType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.SPEED;
	}

	@Override
	public SpeedType getJAXBObject() {
		return speedType;
	}
	
}
