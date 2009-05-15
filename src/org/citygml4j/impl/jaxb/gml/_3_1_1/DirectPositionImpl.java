package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.DirectPositionType;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.GMLClass;

public class DirectPositionImpl extends GMLBaseImpl implements DirectPosition {
	private DirectPositionType directPositionType;

	public DirectPositionImpl() {
		directPositionType = new DirectPositionType();
	}

	public DirectPositionImpl(DirectPositionType directPositionType) {
		this.directPositionType = directPositionType;
	}

	@Override
	public DirectPositionType getJAXBObject() {
		return directPositionType;
	}

	public List<String> getAxisLabels() {
		return directPositionType.getAxisLabels();
	}

	public Integer getSrsDimension() {
		if (directPositionType.isSetSrsDimension())
			return new Integer(directPositionType.getSrsDimension().intValue());

		return null;
	}

	public String getSrsName() {
		return directPositionType.getSrsName();
	}

	public List<String> getUomLabels() {
		return directPositionType.getUomLabels();
	}

	public List<Double> getValue() {
		return directPositionType.getValue();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.DIRECTPOSITION;
	}

	public void setSrsDimension(Integer srsDimension) {
		directPositionType.setSrsDimension(new BigInteger(String.valueOf(srsDimension)));
	}

	public void setSrsName(String srsName) {
		directPositionType.setSrsName(srsName);
	}

	public void addAxisLabel(String axisLabel) {
		directPositionType.getAxisLabels().add(axisLabel);
	}

	public void addUomLabel(String uomLabel) {
		directPositionType.getUomLabels().add(uomLabel);
	}

	public void setAxisLabels(List<String> axisLabels) {
		directPositionType.unsetAxisLabels();
		directPositionType.getAxisLabels().addAll(axisLabels);
	}

	public void setUomLabels(List<String> uomLabels) {
		directPositionType.unsetUomLabels();
		directPositionType.getUomLabels().addAll(uomLabels);
	}

	public void setValue(List<Double> value) {
		directPositionType.unsetValue();
		directPositionType.getValue().addAll(value);
	}

	public List<Double> toList() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetValue()) {
			tmp.addAll(getValue());
			while (tmp.size() < 3)
				tmp.add(0.0);
		}

		if (tmp.size() != 0)
			return tmp.subList(0, 3);
		
		return null;
	}

	public List<Double> toList(boolean reverseOrder) {
		List<Double> points = toList();

		if (reverseOrder && points != null) {
			List<Double> reversed = new ArrayList<Double>();

			for (int i = points.size() - 3; i >= 0; i -=3)
				reversed.addAll(points.subList(i, i + 3));

			points = reversed;
		}

		return points;
	}

	public boolean isSetValue() {
		return directPositionType.isSetValue();
	}

	public void unsetValue() {
		directPositionType.unsetValue();
	}

	public boolean isSetSrsDimension() {
		return directPositionType.isSetSrsDimension();
	}

	public boolean isSetSrsName() {
		return directPositionType.isSetSrsName();
	}

	public void unsetSrsDimension() {
		directPositionType.setSrsDimension(null);
	}

	public void unsetSrsName() {
		directPositionType.setSrsName(null);
	}

	public boolean isSetAxisLabels() {
		return directPositionType.isSetAxisLabels();
	}

	public boolean isSetUomLabels() {
		return directPositionType.isSetUomLabels();
	}

	public void unsetAxisLabels() {
		directPositionType.unsetAxisLabels();
	}

	public void unsetUomLabels() {
		directPositionType.unsetUomLabels();
	}

	public boolean unsetAxisLabels(String axisLabel) {
		if (directPositionType.isSetAxisLabels())
			return directPositionType.getAxisLabels().remove(axisLabel);
		
		return false;
	}

	public boolean unsetUomLabels(String uomLabel) {
		if (directPositionType.isSetUomLabels())
			return directPositionType.getUomLabels().remove(uomLabel);
			
		return false;
	}
	
}
