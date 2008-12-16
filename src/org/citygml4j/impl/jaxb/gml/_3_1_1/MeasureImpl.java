package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.MeasureType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Measure;

public class MeasureImpl extends GMLBaseImpl implements Measure {
	private MeasureType measure;
	
	public MeasureImpl() {
		measure = new MeasureType();
	}

	public MeasureImpl(MeasureType measure) {
		this.measure = measure;
	}

	@Override
	public MeasureType getJAXBObject() {
		return measure;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MEASURE;
	}

	@Override
	public String getUom() {
		return measure.getUom();
	}

	@Override
	public Double getValue() {
		return new Double(measure.getValue());
	}

	@Override
	public void setUom(String uom) {
		measure.setUom(uom);
	}

	@Override
	public void setValue(Double value) {
		measure.setValue(value);
	}

	@Override
	public boolean isSetUom() {
		return measure.isSetUom();
	}

	@Override
	public boolean isSetValue() {
		return measure.isSetValue();
	}

	@Override
	public void unsetUom() {
		measure.setUom(null);
	}
	
}
