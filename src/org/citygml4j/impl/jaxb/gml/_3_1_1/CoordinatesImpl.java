package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.CoordinatesType;
import org.citygml4j.model.gml.Coordinates;
import org.citygml4j.model.gml.GMLClass;

public class CoordinatesImpl extends GMLBaseImpl implements Coordinates {
	private CoordinatesType coordinatesType;

	public CoordinatesImpl() {
		coordinatesType = new CoordinatesType();
	}
	
	public CoordinatesImpl(CoordinatesType coordinatesType) {
		this.coordinatesType = coordinatesType;
	}

	@Override
	public CoordinatesType getJAXBObject() {
		return coordinatesType;
	}

	@Override
	public String getCs() {
		return coordinatesType.getCs();
	}

	@Override
	public String getDecimal() {
		return coordinatesType.getDecimal();
	}

	@Override
	public String getTs() {
		return coordinatesType.getTs();
	}

	@Override
	public String getValue() {
		return coordinatesType.getValue();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COORDINATES;
	}

	@Override
	public boolean isSetCs() {
		return coordinatesType.isSetCs();
	}

	@Override
	public boolean isSetDecimal() {
		return coordinatesType.isSetDecimal();
	}

	@Override
	public boolean isSetTs() {
		return coordinatesType.isSetTs();
	}

	@Override
	public boolean isSetValue() {
		return coordinatesType.isSetValue();
	}

	@Override
	public void setCs(String cs) {
		coordinatesType.setCs(cs);
	}

	@Override
	public void setDecimal(String decimal) {
		coordinatesType.setDecimal(decimal);
	}

	@Override
	public void setTs(String ts) {
		coordinatesType.setTs(ts);
	}

	@Override
	public void setValue(String value) {
		coordinatesType.setValue(value);
	}

	@Override
	public void unsetCs() {
		coordinatesType.setCs(null);
	}

	@Override
	public void unsetDecimal() {
		coordinatesType.setDecimal(null);
	}

	@Override
	public void unsetTs() {
		coordinatesType.setTs(null);
	}

	@Override
	public void unsetValue() {
		coordinatesType.setValue(null);
	}

}
