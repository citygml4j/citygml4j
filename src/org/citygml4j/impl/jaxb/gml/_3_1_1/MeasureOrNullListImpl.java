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

	public String getUom() {
		return measureOrNullList.getUom();
	}

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

	public void addValue(Double value) {
		measureOrNullList.getValue().add(value.toString());
	}

	public void setUom(String uom) {
		measureOrNullList.setUom(uom);
	}

	public void setValue(List<Double> value) {
		List<String> valueList = new ArrayList<String>();
		for (Double measure : value)
			valueList.add(measure.toString());

		measureOrNullList.unsetValue();
		measureOrNullList.getValue().addAll(valueList);
	}

	public boolean isSetUom() {
		return measureOrNullList.isSetUom();
	}

	public boolean isSetValue() {
		return measureOrNullList.isSetValue();
	}

	public void unsetUom() {
		measureOrNullList.setUom(null);
	}

	public void unsetValue() {
		measureOrNullList.unsetValue();
	}

}
