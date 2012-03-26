/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.geometry.primitives.Envelope;

public class BoundingShape implements GML, Child, Copyable {
	private Envelope envelope;
	private Null _null;
	private ModelObject parent;

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
				setEnvelope(new Envelope());
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

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.BOUNDING_SHAPE;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BoundingShape(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BoundingShape copy = (target == null) ? new BoundingShape() : (BoundingShape)target;

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
