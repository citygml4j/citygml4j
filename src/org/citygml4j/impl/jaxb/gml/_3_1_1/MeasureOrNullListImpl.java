package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.MeasureOrNullListType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MeasureOrNullList;

public class MeasureOrNullListImpl extends GMLBaseImpl implements MeasureOrNullList {
	private MeasureOrNullListType measureOrNullList;

	public MeasureOrNullListImpl() {
		measureOrNullList = new MeasureOrNullListType();
	}

	public MeasureOrNullListImpl(MeasureOrNullListType measureOrNullList) {
		this.measureOrNullList = measureOrNullList;
	}

	@Override
	public MeasureOrNullListType getJAXBObject() {
		return measureOrNullList;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MEASUREORNULLLIST;
	}

	@Override
	public String getUom() {
		return measureOrNullList.getUom();
	}

	@Override
	public List<Double> getValue() {
		List<Double> valueList = new ArrayList<Double>();

		for (String valueType : measureOrNullList.getValue()) {
			if (valueType != null && valueType.trim().length() > 0) {
				try {
					valueList.add(Double.parseDouble(valueType));
				} catch (NumberFormatException ex) {
					// nothing to do here
				}
			}
		}

		return valueList;
	}

	@Override
	public void addValue(Double value) {
		measureOrNullList.getValue().add(value.toString());
	}

	@Override
	public void setUom(String uom) {
		measureOrNullList.setUom(uom);
	}

	@Override
	public void setValue(List<Double> value) {
		List<String> valueList = new ArrayList<String>();
		for (Double measure : value)
			valueList.add(measure.toString());

		measureOrNullList.unsetValue();
		measureOrNullList.getValue().addAll(valueList);
	}

	@Override
	public boolean isSetUom() {
		return measureOrNullList.isSetUom();
	}

	@Override
	public boolean isSetValue() {
		return measureOrNullList.isSetValue();
	}

	@Override
	public void unsetUom() {
		measureOrNullList.setUom(null);
	}

	@Override
	public void unsetValue() {
		measureOrNullList.unsetValue();
	}

}
