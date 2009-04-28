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

	@Override
	public List<String> getAxisLabels() {
		return directPositionType.getAxisLabels();
	}

	@Override
	public Integer getSrsDimension() {
		if (directPositionType.isSetSrsDimension())
			return new Integer(directPositionType.getSrsDimension().intValue());

		return null;
	}

	@Override
	public String getSrsName() {
		return directPositionType.getSrsName();
	}

	@Override
	public List<String> getUomLabels() {
		return directPositionType.getUomLabels();
	}

	@Override
	public List<Double> getValue() {
		return directPositionType.getValue();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.DIRECTPOSITION;
	}

	@Override
	public void setSrsDimension(Integer srsDimension) {
		directPositionType.setSrsDimension(new BigInteger(String.valueOf(srsDimension)));
	}

	@Override
	public void setSrsName(String srsName) {
		directPositionType.setSrsName(srsName);
	}

	@Override
	public void addAxisLabel(String axisLabel) {
		directPositionType.getAxisLabels().add(axisLabel);
	}

	@Override
	public void addUomLabel(String uomLabel) {
		directPositionType.getUomLabels().add(uomLabel);
	}

	@Override
	public void setAxisLabels(List<String> axisLabels) {
		directPositionType.unsetAxisLabels();
		directPositionType.getAxisLabels().addAll(axisLabels);
	}

	@Override
	public void setUomLabels(List<String> uomLabels) {
		directPositionType.unsetUomLabels();
		directPositionType.getUomLabels().addAll(uomLabels);
	}

	@Override
	public void setValue(List<Double> value) {
		directPositionType.unsetValue();
		directPositionType.getValue().addAll(value);
	}

	@Override
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

	@Override
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

	@Override
	public boolean isSetValue() {
		return directPositionType.isSetValue();
	}

	@Override
	public void unsetValue() {
		directPositionType.unsetValue();
	}

	@Override
	public boolean isSetSrsDimension() {
		return directPositionType.isSetSrsDimension();
	}

	@Override
	public boolean isSetSrsName() {
		return directPositionType.isSetSrsName();
	}

	@Override
	public void unsetSrsDimension() {
		directPositionType.setSrsDimension(null);
	}

	@Override
	public void unsetSrsName() {
		directPositionType.setSrsName(null);
	}

	@Override
	public boolean isSetAxisLabels() {
		return directPositionType.isSetAxisLabels();
	}

	@Override
	public boolean isSetUomLabels() {
		return directPositionType.isSetUomLabels();
	}

	@Override
	public void unsetAxisLabels() {
		directPositionType.unsetAxisLabels();
	}

	@Override
	public void unsetUomLabels() {
		directPositionType.unsetUomLabels();
	}

	@Override
	public boolean unsetAxisLabels(String axisLabel) {
		if (directPositionType.isSetAxisLabels())
			return directPositionType.getAxisLabels().remove(axisLabel);
		
		return false;
	}

	@Override
	public boolean unsetUomLabels(String uomLabel) {
		if (directPositionType.isSetUomLabels())
			return directPositionType.getUomLabels().remove(uomLabel);
			
		return false;
	}
	
}
