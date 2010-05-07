package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.CoordType;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.GMLClass;

public class CoordImpl extends GMLBaseImpl implements Coord {
	private CoordType coordType;

	public CoordImpl() {
		coordType = new CoordType();
	}

	public CoordImpl(CoordType coordType) {
		this.coordType = coordType;
	}

	@Override
	public CoordType getJAXBObject() {
		return coordType;
	}

	public Double getX() {
		if (coordType.isSetX())
			return new Double(coordType.getX().doubleValue());

		return null;
	}

	public Double getY() {
		if (coordType.isSetY())
			return new Double(coordType.getY().doubleValue());

		return null;
	}

	public Double getZ() {
		if (coordType.isSetZ())
			return new Double(coordType.getZ().doubleValue());

		return null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COORD;
	}

	public List<Double> toList() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetX() && isSetY()) {
			tmp.add(getX());
			tmp.add(getY());
			tmp.add(isSetZ() ? getZ() : 0.0);
		}

		if (tmp.size() != 0)
			return tmp;

		return null;
	}

	public boolean isSetX() {
		return coordType.isSetX();
	}

	public boolean isSetY() {
		return coordType.isSetY();
	}

	public boolean isSetZ() {
		return coordType.isSetZ();
	}

	public void setX(Double x) {
		coordType.setX(new BigDecimal(x));
	}

	public void setY(Double y) {
		coordType.setY(new BigDecimal(y));
	}

	public void setZ(Double z) {
		coordType.setZ(new BigDecimal(z));
	}

	public void unsetX() {
		coordType.setX(null);
	}

	public void unsetY() {
		coordType.setY(null);
	}

	public void unsetZ() {
		coordType.setZ(null);
	}

}
