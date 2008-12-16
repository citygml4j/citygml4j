package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.CoordType;
import org.citygml4j.jaxb.gml._3_1_1.DirectPositionType;
import org.citygml4j.jaxb.gml._3_1_1.EnvelopeType;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.Coordinates;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.Envelope;
import org.citygml4j.model.gml.GMLClass;

public class EnvelopeImpl extends GMLBaseImpl implements Envelope {
	private EnvelopeType envelopeType;

	public EnvelopeImpl() {
		envelopeType = new EnvelopeType();
	}

	public EnvelopeImpl(EnvelopeType envelopeType) {
		this.envelopeType = envelopeType;
	}

	@Override
	public EnvelopeType getJAXBObject() {
		return envelopeType;
	}

	@Override
	public List<String> getAxisLabels() {
		return envelopeType.getAxisLabels();
	}

	@Override
	public List<Coord> getCoord() {
		List<Coord> coordList = new ArrayList<Coord>();
		List<CoordType> coordTypeList = envelopeType.getCoord();

		for (CoordType coordType : coordTypeList)
			coordList.add(new CoordImpl(coordType));

		return coordList;
	}

	@Override
	public DirectPosition getLowerCorner() {
		if (envelopeType.isSetLowerCorner())
			return new DirectPositionImpl(envelopeType.getLowerCorner());

		return null;
	}

	@Override
	public Coordinates getCoordinates() {
		if (envelopeType.isSetCoordinates())
			return new CoordinatesImpl(envelopeType.getCoordinates());

		return null;
	}

	@Override
	public List<DirectPosition> getPos() {
		List<DirectPosition> directPositionList = new ArrayList<DirectPosition>();
		List<DirectPositionType> directPositionTypeList = envelopeType.getPos();

		for (DirectPositionType directPositionType : directPositionTypeList)
			directPositionList.add(new DirectPositionImpl(directPositionType));

		return directPositionList;
	}

	@Override
	public Integer getSrsDimension() {
		if (envelopeType.isSetSrsDimension())
			return new Integer(envelopeType.getSrsDimension().intValue());

		return null;
	}

	@Override
	public String getSrsName() {
		return envelopeType.getSrsName();
	}

	@Override
	public List<String> getUomLabels() {
		return envelopeType.getUomLabels();
	}

	@Override
	public DirectPosition getUpperCorner() {
		if (envelopeType.isSetUpperCorner())
			return new DirectPositionImpl(envelopeType.getUpperCorner());

		return null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ENVELOPE;
	}

	// Setters
	@Override
	public void setLowerCorner(Point lowerCorner) {
		DirectPositionType lowerCornerType = envelopeType.getLowerCorner();

		if (lowerCornerType == null) {
			lowerCornerType = new DirectPositionType();
			envelopeType.setLowerCorner(lowerCornerType);
		}

		lowerCornerType.unsetValue();
		lowerCornerType.getValue().add(lowerCorner.getX());
		lowerCornerType.getValue().add(lowerCorner.getY());
		lowerCornerType.getValue().add(lowerCorner.getZ());
	}

	@Override
	public void setUpperCorner(Point upperCorner) {
		DirectPositionType upperCornerType = envelopeType.getUpperCorner();

		if (upperCornerType == null) {
			upperCornerType = new DirectPositionType();
			envelopeType.setUpperCorner(upperCornerType);
		}

		upperCornerType.unsetValue();
		upperCornerType.getValue().add(upperCorner.getX());
		upperCornerType.getValue().add(upperCorner.getY());
		upperCornerType.getValue().add(upperCorner.getZ());
	}

	@Override
	public void calcLowerCorner(Point lowerCorner) {
		DirectPositionType lowerCornerType = envelopeType.getLowerCorner();

		if (lowerCornerType == null) {
			setLowerCorner(lowerCorner);
			return;
		}

		List<Double> lowerCornerList = lowerCornerType.getValue();
		while (lowerCornerList.size() < 3)
			lowerCornerList.add(Double.MAX_VALUE);

		if (lowerCornerList.get(0) > lowerCorner.getX())
			lowerCornerList.set(0, lowerCorner.getX());
		if (lowerCornerList.get(1) > lowerCorner.getY())
			lowerCornerList.set(1, lowerCorner.getY());
		if (lowerCornerList.get(2) > lowerCorner.getZ())
			lowerCornerList.set(2, lowerCorner.getZ());
	}

	@Override
	public void calcUpperCorner(Point upperCorner) {
		DirectPositionType upperCornerType = envelopeType.getUpperCorner();

		if (upperCornerType == null) {
			setUpperCorner(upperCorner);
			return;
		}

		List<Double> upperCornerList = upperCornerType.getValue();
		while (upperCornerList.size() < 3)
			upperCornerList.add(-Double.MAX_VALUE);

		if (upperCornerList.get(0) < upperCorner.getX())
			upperCornerList.set(0, upperCorner.getX());
		if (upperCornerList.get(1) < upperCorner.getY())
			upperCornerList.set(1, upperCorner.getY());
		if (upperCornerList.get(2) < upperCorner.getZ())
			upperCornerList.set(2, upperCorner.getZ());
	}

	@Override
	public void setSrsDimension(Integer srsDimension) {
		envelopeType.setSrsDimension(new BigInteger(String.valueOf(srsDimension)));
	}

	@Override
	public void setSrsName(String srsName) {
		envelopeType.setSrsName(srsName);
	}

	@Override
	public void addAxisLabel(String axisLabel) {
		envelopeType.getAxisLabels().add(axisLabel);
	}

	@Override
	public void addUomLabel(String uomLabel) {
		envelopeType.getUomLabels().add(uomLabel);
	}

	@Override
	public void setAxisLabels(List<String> axisLabels) {
		envelopeType.unsetAxisLabels();
		envelopeType.getAxisLabels().addAll(axisLabels);
	}

	@Override
	public void setUomLabels(List<String> uomLabels) {
		envelopeType.unsetUomLabels();
		envelopeType.getUomLabels().addAll(uomLabels);
	}

	@Override
	public void unsetPos() {
		envelopeType.unsetPos();
	}

	@Override
	public void unsetCoord() {
		envelopeType.unsetCoord();
	}

	@Override
	public void unsetCoordinates() {
		envelopeType.setCoordinates(null);
	}

	@Override
	public boolean isSetCoord() {
		return envelopeType.isSetCoord();
	}

	@Override
	public boolean isSetCoordinates() {
		return envelopeType.isSetCoordinates();
	}

	@Override
	public boolean isSetLowerCorner() {
		return envelopeType.isSetLowerCorner();
	}

	@Override
	public boolean isSetPos() {
		return envelopeType.isSetPos();
	}

	@Override
	public boolean isSetUpperCorner() {
		return envelopeType.isSetUpperCorner();
	}

	@Override
	public void unsetLowerCorner() {
		envelopeType.setLowerCorner(null);
	}

	@Override
	public void unsetUpperCorner() {
		envelopeType.setUpperCorner(null);
	}

	@Override
	public boolean isSetSrsDimension() {
		return envelopeType.isSetSrsDimension();
	}

	@Override
	public boolean isSetSrsName() {
		return envelopeType.isSetSrsName();
	}

	@Override
	public void unsetSrsDimension() {
		envelopeType.setSrsDimension(null);
	}

	@Override
	public void unsetSrsName() {
		envelopeType.setSrsName(null);
	}

	@Override
	public boolean isSetAxisLabels() {
		return envelopeType.isSetAxisLabels();
	}

	@Override
	public boolean isSetUomLabels() {
		return envelopeType.isSetUomLabels();
	}

	@Override
	public void unsetAxisLabels() {
		envelopeType.unsetAxisLabels();
	}

	@Override
	public void unsetUomLabels() {
		envelopeType.unsetUomLabels();
	}

	@Override
	public boolean unsetAxisLabels(String axisLabel) {
		if (envelopeType.isSetAxisLabels())
			return envelopeType.getAxisLabels().remove(axisLabel);
		
		return false;
	}

	@Override
	public boolean unsetUomLabels(String uomLabel) {
		if (envelopeType.isSetUomLabels())
			return envelopeType.getUomLabels().remove(uomLabel);
			
		return false;
	}
	
}
