package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.Envelope;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Null;

public class BoundingShapeImpl implements BoundingShape {
	private Envelope envelope;
	private Null _null;
	private Object parent;

	public Envelope getEnvelope() {
		return envelope;
	}

	public Null getNull() {
		return _null;
	}

	public boolean isSetEnvelope() {
		return envelope != null;
	}

	public boolean isSetNull() {
		return _null != null;
	}

	public void setEnvelope(Envelope envelope) {
		if (envelope != null)
			envelope.setParent(this);

		this.envelope = envelope;
	}

	public void setEnvelope(BoundingBox boundingBox) {
		if (boundingBox != null) {
			if (!isSetEnvelope())
				setEnvelope(new EnvelopeImpl());
			else {
				envelope.unsetPos();
				envelope.unsetCoord();
				envelope.unsetCoordinates();
			}

			envelope.setLowerCorner(boundingBox.getLowerCorner());
			envelope.setUpperCorner(boundingBox.getUpperCorner());
			envelope.setSrsDimension(3);
		}
	}

	public void updateEnvelope(BoundingBox boundingBox) {
		if (boundingBox != null) {
			if (!isSetEnvelope())
				setEnvelope(boundingBox);
			else {
				BoundingBox bbox = envelope.toBoundingBox();
				if (bbox != null) {
					bbox.update(boundingBox);
					setEnvelope(bbox);
				} else
					setEnvelope(boundingBox);
			}
		}
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);

		this._null = _null;
	}

	public void unsetEnvelope() {
		if (isSetEnvelope())
			envelope.unsetParent();

		envelope = null;
	}

	public void unsetNull() {
		if (isSetNull())
			_null.unsetParent();

		_null = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.BOUNDINGSHAPE;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BoundingShapeImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BoundingShape copy = (target == null) ? new BoundingShapeImpl() : (BoundingShape)target;

		if (isSetEnvelope()) {
			copy.setEnvelope((Envelope)copyBuilder.copy(envelope));
			if (copy.getEnvelope() == envelope)
				envelope.setParent(this);
		}

		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}

		copy.unsetParent();

		return copy;
	}

}
