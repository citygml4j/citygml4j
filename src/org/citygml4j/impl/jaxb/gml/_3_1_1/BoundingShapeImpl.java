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

	@Override
	public Envelope getEnvelope() {
		if (boundingShapeType.isSetEnvelope()) {
			JAXBElement<? extends EnvelopeType> envelopeElem = boundingShapeType.getEnvelope();
			if (envelopeElem.getValue() != null)
				return new EnvelopeImpl(envelopeElem.getValue());
		}

		return null;
	}

	@Override
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

	@Override
	public void setEnvelope(Envelope envelope) {
		EnvelopeType envelopeType = ((EnvelopeImpl)envelope).getJAXBObject();
		boundingShapeType.setEnvelope(ObjectFactory.GML.createEnvelope(envelopeType));
	}

	@Override
	public void setNull(String _null) {
		boundingShapeType.unsetNull();
		boundingShapeType.getNull().add(_null);
	}

	@Override
	public boolean convertEnvelope(boolean to3D) {
		Envelope envelope = getEnvelope();
		if (envelope == null)
			return false;

		// we immediately return if lowerCorner and upperCorner are already
		// set up correctly;
		DirectPosition lowerCorner = envelope.getLowerCorner();
		DirectPosition upperCorner = envelope.getUpperCorner();

		if (lowerCorner != null && upperCorner != null) {
			List<Double> lowerPoints = lowerCorner.getValue();
			List<Double> upperPoints = upperCorner.getValue();

			if (lowerPoints != null && upperCorner != null) {

				if (to3D) {
					while (lowerPoints.size() < 3)
						lowerPoints.add(0.0);

					while (upperPoints.size() < 3)
						upperPoints.add(0.0);
				}

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
					List<Double> values = directPosition.getValue();

					if (to3D)
						while (values.size() < 3)
							values.add(0.0);

					if (values.size() == 3)
						points.add(new Point(values.get(0), values.get(1), values.get(2)));
				}
		}

		// coords
		if (envelope.isSetCoord()) {
			for (Coord coord : envelope.getCoord()) {
				Double x = coord.getX();
				Double y = coord.getY();
				Double z = coord.getZ();

				if (to3D && z == null)
					z = 0.0;

				if (x != null && y != null && z != null)
					points.add(new Point(x, y, z));					
			}
		}

		// not supporting coordinates...

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

	@Override
	public boolean convertEnvelope() {
		return convertEnvelope(false);
	}

	@Override
	public boolean isSetEnvelope() {
		return boundingShapeType.isSetEnvelope();
	}

	@Override
	public boolean isSetNull() {
		return boundingShapeType.isSetNull();
	}

	@Override
	public void unsetEnvelope() {
		boundingShapeType.setEnvelope(null);
	}

	@Override
	public void unsetNull() {
		boundingShapeType.unsetNull();
	}

}
