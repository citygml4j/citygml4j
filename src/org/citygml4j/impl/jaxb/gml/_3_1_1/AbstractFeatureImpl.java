package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureType;
import org.citygml4j.jaxb.gml._3_1_1.LocationPropertyType;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.Envelope;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LocationProperty;

public abstract class AbstractFeatureImpl extends AbstractGMLImpl implements AbstractFeature {
	private AbstractFeatureType abstractFeatureType;

	public AbstractFeatureImpl(AbstractFeatureType abstractFeatureType) {
		super(abstractFeatureType);
		this.abstractFeatureType = abstractFeatureType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTFEATURE;
	}

	@Override
	public AbstractFeatureType getJAXBObject() {
		return abstractFeatureType;
	}

	@Override
	public BoundingShape getBoundedBy() {
		if (abstractFeatureType.isSetBoundedBy())
			return new BoundingShapeImpl(abstractFeatureType.getBoundedBy());

		return null;
	}

	@Override
	public LocationProperty getLocation() {
		if (abstractFeatureType.isSetLocation()) {
			JAXBElement<? extends LocationPropertyType> locationPropertyElem = abstractFeatureType.getLocation();
			if (locationPropertyElem.getValue() != null)
				return new LocationPropertyImpl(locationPropertyElem.getValue());
		}

		return null;
	}

	@Override
	public void setBoundedBy(BoundingShape boundingShape) {
		abstractFeatureType.setBoundedBy(((BoundingShapeImpl)boundingShape).getJAXBObject());
	}

	@Override
	public void calcBoundedBy(AbstractFeature abstractFeature) {			
		if (abstractFeature.getBoundedBy() == null || 
				!abstractFeature.getBoundedBy().convertEnvelope())
			abstractFeature.calcBoundedBy();

		BoundingShape boundingShape = abstractFeature.getBoundedBy();
		if (boundingShape == null || boundingShape.getEnvelope() == null)
			return;

		List<Double> lowerCornerPoints = null;
		List<Double> upperCornerPoints = null;

		if (boundingShape.getEnvelope().getLowerCorner() != null)
			lowerCornerPoints = boundingShape.getEnvelope().getLowerCorner().getValue();

		if (boundingShape.getEnvelope().getUpperCorner() != null)
			upperCornerPoints = boundingShape.getEnvelope().getUpperCorner().getValue();

		if (lowerCornerPoints == null || upperCornerPoints == null ||
				lowerCornerPoints.size() != 3 || upperCornerPoints.size() != 3)
			return;

		BoundingShape boundedBy;
		Envelope envelope;

		boundedBy = getBoundedBy();
		if (boundedBy == null) {
			boundedBy = new BoundingShapeImpl();
			setBoundedBy(boundedBy);
		}

		envelope = boundedBy.getEnvelope();
		if (envelope == null) {
			envelope = new EnvelopeImpl();
			boundedBy.setEnvelope(envelope);
		}

		envelope.calcLowerCorner(new Point(lowerCornerPoints.get(0),
				lowerCornerPoints.get(1),
				lowerCornerPoints.get(2)));

		envelope.calcUpperCorner(new Point(upperCornerPoints.get(0),
				upperCornerPoints.get(1),
				upperCornerPoints.get(2)));
	}

	@Override
	public void calcBoundedBy(AbstractGeometry abstractGeometry) {
		if (abstractGeometry == null)
			return;
		
		Point min = new Point(Double.MAX_VALUE);
		Point max = new Point(-Double.MAX_VALUE);

		// calc bounding box
		abstractGeometry.calcBoundingBox(min, max);
		if (min.isEqual(Double.MAX_VALUE) || max.isEqual(-Double.MIN_VALUE))
			return;

		BoundingShape boundingShape;
		Envelope envelope;

		boundingShape = getBoundedBy();
		if (boundingShape == null) {
			boundingShape = new BoundingShapeImpl();
			setBoundedBy(boundingShape);
		}

		envelope = boundingShape.getEnvelope();
		if (envelope == null) {
			envelope = new EnvelopeImpl();
			boundingShape.setEnvelope(envelope);
		}

		envelope.calcLowerCorner(min);
		envelope.calcUpperCorner(max);
	}

	@Override
	public void calcBoundedBy() {
		// do nothing by default
	}

	@Override
	public boolean isSetBoundedBy() {
		return abstractFeatureType.isSetBoundedBy();
	}

	@Override
	public boolean isSetLocation() {
		return abstractFeatureType.isSetLocation();
	}

	@Override
	public void unsetBoundedBy() {
		abstractFeatureType.setBoundedBy(null);
	}

	@Override
	public void unsetLocation() {
		abstractFeatureType.setLocation(null);
	}

}
