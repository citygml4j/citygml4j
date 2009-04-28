package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Double> toList() {
		List<Double> tmp = new ArrayList<Double>();
		boolean isValid = false;

		if (isSetValue()) {
			String coordinates = getValue();
			String decimal = getDecimal();
			String cs = getCs();
			String ts = getTs();

			if (decimal == null || decimal.isEmpty())
				decimal = ".";

			if (cs == null || cs.isEmpty())
				cs = ",";

			if (ts == null || ts.isEmpty())
				ts = " ";

			isValid = true;
			decimal = prepareRegex(decimal);

			String[] tupels = coordinates.split(prepareRegex(ts));
			for (int i = 0; i < tupels.length && isValid ; ++i) {
				if (tupels[i] != null && !tupels[i].trim().isEmpty()) {				
					String[] coords = tupels[i].split(prepareRegex(cs));
					List<Double> point = new ArrayList<Double>();

					for (int j = 0; j < coords.length && isValid; ++j) {
						if (coords[j] != null && !coords[j].trim().isEmpty()) {
							coords[j] = coords[j].replaceAll(decimal, ".");

							try {
								double result = Double.parseDouble(coords[j]);
								point.add(result);
							} catch (NumberFormatException e) {
								isValid = false;
								break;
							}
						} else
							isValid = false;
					}

					if (isValid) {
						while (point.size() < 3)
							point.add(0.0);

						tmp.addAll(point.subList(0, 3));
					}
				}
			}
		}

		if (isValid && tmp.size() != 0)
			return tmp;

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

	private String prepareRegex(String input) {
		StringBuilder buffer = new StringBuilder();

		for (char c : input.toCharArray()) {
			if ("+()^$.{}[]|\\".indexOf(c) != -1)
				buffer.append('\\').append(c);
			else
				buffer.append(c);
		}

		return buffer.toString();
	}
}
