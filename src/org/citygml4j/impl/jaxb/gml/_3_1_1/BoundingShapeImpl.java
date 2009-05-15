package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Point;
import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.BoundingShapeType;
import org.citygml4j.jaxb.gml._3_1_1.EnvelopeType;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.Envelope;
import org.citygml4j.model.gml.GMLClass;

public class BoundingShapeImpl extends GMLBaseImpl implements BoundingShape {
	private BoundingShapeType boundingShapeType;

	public BoundingShapeImpl() {
		boundingShapeType = new BoundingShapeType();
	}

	public BoundingShapeImpl(BoundingShapeType boundingShapeType) {
		this.boundingShapeType = boundingShapeType;
	}

	@Override
	public BoundingShapeType getJAXBObject() {
		return boundingShapeType;
	}

	public Envelope getEnvelope() {
		if (boundingShapeType.isSetEnvelope()) {
			JAXBElement<? extends EnvelopeType> envelopeElem = boundingShapeType.getEnvelope();
			if (envelopeElem.getValue() != null)
				return new EnvelopeImpl(envelopeElem.getValue());
		}

		return null;
	}

	public String getNull() {
		if (boundingShapeType.isSetNull()) {
			List<String> _nullList = boundingShapeType.getNull();
			StringBuilder string = new StringBuilder();

			int i = 1;
			for (String object : _nullList) {
				if (object != null)
					string.append(object.toString());

				if (i < _nullList.size())
					string.append(" ");

				i++;
			}

			return string.toString();
		}

		return null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.BOUNDINGSHAPE;
	}

	public void setEnvelope(Envelope envelope) {
		EnvelopeType envelopeType = ((EnvelopeImpl)envelope).getJAXBObject();
		boundingShapeType.setEnvelope(ObjectFactory.GML.createEnvelope(envelopeType));
	}

	public void setNull(String _null) {
		boundingShapeType.unsetNull();
		boundingShapeType.getNull().add(_null);
	}

	public boolean convertEnvelope() {
		Envelope envelope = getEnvelope();
		if (envelope == null)
			return false;

		// we immediately return if lowerCorner and upperCorner are already
		// set up correctly
		DirectPosition lowerCorner = envelope.getLowerCorner();
		DirectPosition upperCorner = envelope.getUpperCorner();

		if (lowerCorner != null && upperCorner != null) {
			List<Double> lowerPoints = lowerCorner.getValue();
			List<Double> upperPoints = upperCorner.getValue();

			if (lowerPoints != null && upperCorner != null) {

				while (lowerPoints.size() < 3)
					lowerPoints.add(0.0);

				while (upperPoints.size() < 3)
					upperPoints.add(0.0);

				if (lowerPoints.size() == 3 && upperPoints.size() == 3)
					return true;
			}
		}

		// check if we have data to convert
		List<Point> points = new ArrayList<Point>();	

		// poslist
		if (envelope.isSetPos()) {
			for (DirectPosition directPosition : envelope.getPos())
				if (directPosition.isSetValue()) {
					List<Double> value = directPosition.toList();
					if (value != null)
						points.add(new Point(value.get(0), value.get(1), value.get(2)));
				}
		}

		// coords
		if (envelope.isSetCoord()) {
			for (Coord coord : envelope.getCoord()) {
				Double x = coord.getX();
				Double y = coord.getY();
				Double z = coord.getZ();

				if (x != null && y != null) {
					if (z == null)
						z = 0.0;
					
					points.add(new Point(x, y, z));	
				}
			}
		}

		// coordinates
		if (envelope.isSetCoordinates()) {
			List<Double> coordinates = envelope.getCoordinates().toList();
			if (coordinates != null)
				for (int i = 0; i < coordinates.size(); i += 3)
					points.add(new Point(
							coordinates.get(i),
							coordinates.get(i + 1),
							coordinates.get(i + 2)));
		}

		if (points.size() >= 2) {
			envelope.setLowerCorner(new Point(Double.MAX_VALUE));
			envelope.setUpperCorner(new Point(-Double.MAX_VALUE));
			envelope.setSrsDimension(3);

			for (Point point : points) {
				envelope.calcLowerCorner(point);
				envelope.calcUpperCorner(point);
			}

			envelope.unsetPos();
			envelope.unsetCoord();
			envelope.unsetCoordinates();

			return true;
		} else
			return false;
	}

	public boolean isSetEnvelope() {
		return boundingShapeType.isSetEnvelope();
	}

	public boolean isSetNull() {
		return boundingShapeType.isSetNull();
	}

	public void unsetEnvelope() {
		boundingShapeType.setEnvelope(null);
	}

	public void unsetNull() {
		boundingShapeType.unsetNull();
	}

}
