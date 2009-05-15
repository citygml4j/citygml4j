package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.DirectPositionListType;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.GMLClass;

public class DirectPositionListImpl extends GMLBaseImpl implements	DirectPositionList {
	private DirectPositionListType directPositionListType;

	public DirectPositionListImpl() {
		directPositionListType = new DirectPositionListType();
	}

	public DirectPositionListImpl(DirectPositionListType directPositionListType) {
		this.directPositionListType = directPositionListType;
	}

	@Override
	public DirectPositionListType getJAXBObject() {
		return directPositionListType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.DIRECTPOSITIONLIST;
	}

	public Integer getCount() {
		if (directPositionListType.isSetCount())
			return new Integer(directPositionListType.getCount().intValue());

		return null;
	}

	public List<Double> getValue() {
		return directPositionListType.getValue();
	}

	public List<String> getAxisLabels() {
		return directPositionListType.getAxisLabels();
	}

	public Integer getSrsDimension() {
		if (directPositionListType.isSetSrsDimension())
			return new Integer(directPositionListType.getSrsDimension().intValue());

		return null;
	}

	public String getSrsName() {
		return directPositionListType.getSrsName();
	}

	public List<String> getUomLabels() {
		return directPositionListType.getUomLabels();
	}

	public void setSrsDimension(Integer srsDimension) {
		directPositionListType.setSrsDimension(new BigInteger(String.valueOf(srsDimension)));
	}

	public void setSrsName(String srsName) {
		directPositionListType.setSrsName(srsName);
	}

	public void addValue(Double value) {
		directPositionListType.getValue().add(value);
	}

	public void setCount(Integer count) {
		directPositionListType.setCount(new BigInteger(count.toString()));
	}

	public void setValue(List<Double> value) {
		directPositionListType.unsetValue();
		directPositionListType.getValue().addAll(value);
	}

	public void addAxisLabel(String axisLabel) {
		directPositionListType.getAxisLabels().add(axisLabel);
	}

	public void addUomLabel(String uomLabel) {
		directPositionListType.getUomLabels().add(uomLabel);
	}

	public void setAxisLabels(List<String> axisLabels) {
		directPositionListType.unsetAxisLabels();
		directPositionListType.getAxisLabels().addAll(axisLabels);
	}

	public void setUomLabels(List<String> uomLabels) {
		directPositionListType.unsetUomLabels();
		directPositionListType.getUomLabels().addAll(uomLabels);
	}

	public List<Double> toList() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetValue()) {
			tmp.addAll(getValue());
			
			int dim = (getSrsDimension() != null && getSrsDimension() == 2) ? 2 : 3;
			while (tmp.size() % dim != 0)
				tmp.add(0.0);

			if (dim == 2) {
				List<Double> newPoints = new ArrayList<Double>();

				// ok, what we do is adding 0.0
				for (int i = 0; i < tmp.size(); i += 2) {
					newPoints.addAll(tmp.subList(i, i + 2));
					newPoints.add(0.0);
				}

				tmp = newPoints;
			}
		}

		if (tmp.size() != 0)
			return tmp;
		
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

	public boolean isSetCount() {
		return directPositionListType.isSetCount();
	}

	public boolean isSetValue() {
		return directPositionListType.isSetValue();
	}

	public void unsetCount() {
		directPositionListType.setCount(null);
	}

	public void unsetValue() {
		directPositionListType.unsetValue();
	}

	public boolean isSetSrsDimension() {
		return directPositionListType.isSetSrsDimension();
	}

	public boolean isSetSrsName() {
		return directPositionListType.isSetSrsName();
	}

	public void unsetSrsDimension() {
		directPositionListType.setSrsDimension(null);
	}

	public void unsetSrsName() {
		directPositionListType.setSrsName(null);
	}

	public boolean isSetAxisLabels() {
		return directPositionListType.isSetAxisLabels();
	}

	public boolean isSetUomLabels() {
		return directPositionListType.isSetUomLabels();
	}

	public void unsetAxisLabels() {
		directPositionListType.unsetAxisLabels();
	}

	public void unsetUomLabels() {
		directPositionListType.unsetUomLabels();
	}
	
	public boolean unsetAxisLabels(String axisLabel) {
		if (directPositionListType.isSetAxisLabels())
			return directPositionListType.getAxisLabels().remove(axisLabel);
		
		return false;
	}

	public boolean unsetUomLabels(String uomLabel) {
		if (directPositionListType.isSetUomLabels())
			return directPositionListType.getUomLabels().remove(uomLabel);
			
		return false;
	}
	
}
