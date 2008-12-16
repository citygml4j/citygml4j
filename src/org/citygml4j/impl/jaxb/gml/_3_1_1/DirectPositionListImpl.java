package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.DirectPositionListType;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.GMLClass;

public class DirectPositionListImpl extends GMLBaseImpl implements	DirectPositionList {
	private DirectPositionListType directPositionListType;
	private List<Double> pointList;

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

	@Override
	public Integer getCount() {
		if (directPositionListType.isSetCount())
			return new Integer(directPositionListType.getCount().intValue());

		return null;
	}

	@Override
	public List<Double> getValue() {
		return directPositionListType.getValue();
	}

	@Override
	public List<String> getAxisLabels() {
		return directPositionListType.getAxisLabels();
	}

	@Override
	public Integer getSrsDimension() {
		if (directPositionListType.isSetSrsDimension())
			return new Integer(directPositionListType.getSrsDimension().intValue());

		return null;
	}

	@Override
	public String getSrsName() {
		return directPositionListType.getSrsName();
	}

	@Override
	public List<String> getUomLabels() {
		return directPositionListType.getUomLabels();
	}

	@Override
	public void setSrsDimension(Integer srsDimension) {
		directPositionListType.setSrsDimension(new BigInteger(String.valueOf(srsDimension)));
	}

	@Override
	public void setSrsName(String srsName) {
		directPositionListType.setSrsName(srsName);
	}

	@Override
	public void addValue(Double value) {
		directPositionListType.getValue().add(value);
	}

	@Override
	public void setCount(Integer count) {
		directPositionListType.setCount(new BigInteger(count.toString()));
	}

	@Override
	public void setValue(List<Double> value) {
		directPositionListType.unsetValue();
		directPositionListType.getValue().addAll(value);
	}

	@Override
	public void addAxisLabel(String axisLabel) {
		directPositionListType.getAxisLabels().add(axisLabel);
	}

	@Override
	public void addUomLabel(String uomLabel) {
		directPositionListType.getUomLabels().add(uomLabel);
	}

	@Override
	public void setAxisLabels(List<String> axisLabels) {
		directPositionListType.unsetAxisLabels();
		directPositionListType.getAxisLabels().addAll(axisLabels);
	}

	@Override
	public void setUomLabels(List<String> uomLabels) {
		directPositionListType.unsetUomLabels();
		directPositionListType.getUomLabels().addAll(uomLabels);
	}

	@Override
	public List<Double> toList() {
		if (pointList == null)
			generatePointList();

		return pointList;
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

	private void generatePointList() {
		if (pointList != null)
			return;

		List<Double> tmp = new ArrayList<Double>();

		if (isSetValue()) {
			List<Double> points = new ArrayList<Double>(getValue());

			int dim = (getSrsDimension() != null && getSrsDimension() == 2) ? 2 : 3;
			while (points.size() % dim != 0)
				points.add(0.0);

			if (dim == 2) {
				List<Double> newPoints = new ArrayList<Double>();

				// ok, what we do is adding 0.0
				for (int i = 0; i < points.size(); i += 2) {
					newPoints.addAll(points.subList(i, i + 2));
					newPoints.add(0.0);
				}

				points = newPoints;
			}

			tmp.addAll(points);
		}

		if (tmp.size() != 0)
			pointList = tmp;
	}

	@Override
	public boolean isSetCount() {
		return directPositionListType.isSetCount();
	}

	@Override
	public boolean isSetValue() {
		return directPositionListType.isSetValue();
	}

	@Override
	public void unsetCount() {
		directPositionListType.setCount(null);
	}

	@Override
	public void unsetValue() {
		directPositionListType.unsetValue();
	}

	@Override
	public boolean isSetSrsDimension() {
		return directPositionListType.isSetSrsDimension();
	}

	@Override
	public boolean isSetSrsName() {
		return directPositionListType.isSetSrsName();
	}

	@Override
	public void unsetSrsDimension() {
		directPositionListType.setSrsDimension(null);
	}

	@Override
	public void unsetSrsName() {
		directPositionListType.setSrsName(null);
	}

	@Override
	public boolean isSetAxisLabels() {
		return directPositionListType.isSetAxisLabels();
	}

	@Override
	public boolean isSetUomLabels() {
		return directPositionListType.isSetUomLabels();
	}

	@Override
	public void unsetAxisLabels() {
		directPositionListType.unsetAxisLabels();
	}

	@Override
	public void unsetUomLabels() {
		directPositionListType.unsetUomLabels();
	}
	
	@Override
	public boolean unsetAxisLabels(String axisLabel) {
		if (directPositionListType.isSetAxisLabels())
			return directPositionListType.getAxisLabels().remove(axisLabel);
		
		return false;
	}

	@Override
	public boolean unsetUomLabels(String uomLabel) {
		if (directPositionListType.isSetUomLabels())
			return directPositionListType.getUomLabels().remove(uomLabel);
			
		return false;
	}
	
}
