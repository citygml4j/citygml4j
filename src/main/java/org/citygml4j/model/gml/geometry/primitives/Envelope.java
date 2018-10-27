/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Coordinates;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.SRSReferenceGroup;

import java.util.ArrayList;
import java.util.List;

public class Envelope implements SRSReferenceGroup, Child, Copyable {
	private DirectPosition lowerCorner;
	private DirectPosition upperCorner;
	private List<Coord> coord;
	private List<DirectPosition> pos;
	private Coordinates coordinates;
	private Integer srsDimension;
	private String srsName;
	private List<String> axisLabels;
	private List<String> uomLabels;
	private ModelObject parent;

	public Envelope() {

	}

	public Envelope(BoundingBox boundingBox) {
		if (boundingBox != null && !boundingBox.isNull()) {
			setLowerCorner(boundingBox.getLowerCorner());
			setUpperCorner(boundingBox.getUpperCorner());
			setSrsDimension(3);
		}
	}

	public void addCoord(Coord coord) {
		if (this.coord == null)
			this.coord = new ChildList<Coord>(this);

		this.coord.add(coord);
	}

	public void addPos(DirectPosition pos) {
		if (this.pos == null)
			this.pos = new ChildList<DirectPosition>(this);

		this.pos.add(pos);
	}

	public List<Coord> getCoord() {
		if (coord == null)
			coord = new ChildList<Coord>(this);

		return coord;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public DirectPosition getLowerCorner() {
		return lowerCorner;
	}

	public List<DirectPosition> getPos() {
		if (pos == null)
			pos = new ChildList<DirectPosition>(this);

		return pos;
	}

	public DirectPosition getUpperCorner() {
		return upperCorner;
	}

	public boolean isSetCoord() {
		return coord != null && !coord.isEmpty();
	}

	public boolean isSetCoordinates() {
		return coordinates != null;
	}

	public boolean isSetLowerCorner() {
		return lowerCorner != null;
	}

	public boolean isSetPos() {
		return pos != null && !pos.isEmpty();
	}

	public boolean isSetUpperCorner() {
		return upperCorner != null;
	}

	public void setCoord(List<Coord> coord) {
		this.coord = new ChildList<Coord>(this, coord);
	}

	public void setCoordinates(Coordinates coordinates) {
		if (coordinates != null)
			coordinates.setParent(this);

		this.coordinates = coordinates;
	}

	public void setLowerCorner(DirectPosition lowerCorner) {
		if (lowerCorner != null)
			lowerCorner.setParent(this);

		this.lowerCorner = lowerCorner;
	}

	public void setLowerCorner(Point lowerCorner) {
		if (lowerCorner != null) {
			if (!isSetLowerCorner())
				setLowerCorner(new DirectPosition());
			else
				this.lowerCorner.unsetValue();

			this.lowerCorner.addValue(lowerCorner.getX());
			this.lowerCorner.addValue(lowerCorner.getY());
			this.lowerCorner.addValue(lowerCorner.getZ());
		}
	}

	public void setPos(List<DirectPosition> pos) {
		this.pos = new ChildList<DirectPosition>(this, pos);
	}

	public void setUpperCorner(DirectPosition upperCorner) {
		if (upperCorner != null)
			upperCorner.setParent(this);

		this.upperCorner = upperCorner;
	}

	public void setUpperCorner(Point upperCorner) {
		if (upperCorner != null) {
			if (!isSetUpperCorner())
				setUpperCorner(new DirectPosition());
			else
				this.upperCorner.unsetValue();

			this.upperCorner.addValue(upperCorner.getX());
			this.upperCorner.addValue(upperCorner.getY());
			this.upperCorner.addValue(upperCorner.getZ());
		}
	}

	public void unsetCoord() {
		if (isSetCoord())
			coord.clear();

		coord = null;
	}

	public boolean unsetCoord(Coord coord) {
		return isSetCoord() ? this.coord.remove(coord) : false;
	}

	public void unsetCoordinates() {
		if (isSetCoordinates())
			coordinates.unsetParent();

		coordinates = null;
	}

	public void unsetLowerCorner() {
		if (isSetLowerCorner())
			lowerCorner.unsetParent();

		lowerCorner = null;
	}

	public void unsetPos() {
		if (isSetPos())
			pos.clear();

		pos = null;
	}

	public boolean unsetPos(DirectPosition pos) {
		return isSetPos() ? this.pos.remove(pos) : false;
	}

	public void unsetUpperCorner() {
		if (isSetUpperCorner())
			upperCorner.unsetParent();

		upperCorner = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ENVELOPE;
	}

	public Integer getSrsDimension() {
		return srsDimension;
	}

	public String getSrsName() {
		return srsName;
	}

	public String getInheritedSrsName() {
		if (srsName == null) {
			Child child = this;
			ModelObject parent = null;

			while ((parent = child.getParent()) != null) {
				if (parent instanceof AbstractFeature) {
					AbstractFeature feature = (AbstractFeature)parent;
					if (feature.isSetBoundedBy() 
							&& feature.getBoundedBy().isSetEnvelope()
							&& feature.getBoundedBy().getEnvelope().isSetSrsName())
						return feature.getBoundedBy().getEnvelope().getSrsName();
				}

				if (parent instanceof Child)
					child = (Child)parent;
				else 
					break;
			}
		} 

		return srsName;
	}

	public boolean isSetSrsDimension() {
		return srsDimension != null;
	}

	public boolean isSetSrsName() {
		return srsName != null;
	}

	public void setSrsDimension(Integer srsDimension) {
		if (srsDimension > 0)
			this.srsDimension = srsDimension;
	}

	public void setSrsName(String srsName) {
		this.srsName = srsName;
	}

	public void unsetSrsDimension() {
		srsDimension = null;
	}

	public void unsetSrsName() {
		srsName = null;
	}

	public void addAxisLabel(String axisLabel) {
		if (axisLabels == null)
			axisLabels = new ArrayList<String>();

		axisLabels.add(axisLabel);
	}

	public void addUomLabel(String uomLabel) {
		if (uomLabels == null)
			uomLabels = new ArrayList<String>();

		uomLabels.add(uomLabel);
	}

	public List<String> getAxisLabels() {
		if (axisLabels == null)
			axisLabels = new ArrayList<String>();

		return axisLabels;
	}

	public List<String> getUomLabels() {
		if (uomLabels == null)
			uomLabels = new ArrayList<String>();

		return uomLabels;
	}

	public boolean isSetAxisLabels() {
		return axisLabels != null && !axisLabels.isEmpty();
	}

	public boolean isSetUomLabels() {
		return uomLabels != null && !uomLabels.isEmpty();
	}

	public void setAxisLabels(List<String> axisLabels) {
		this.axisLabels = axisLabels;
	}

	public void setUomLabels(List<String> uomLabels) {
		this.uomLabels = uomLabels;
	}

	public void unsetAxisLabels() {
		axisLabels = null;
	}

	public boolean unsetAxisLabels(String axisLabel) {
		return isSetAxisLabels() ? axisLabels.remove(axisLabel) : false;
	}

	public void unsetUomLabels() {
		uomLabels = null;
	}

	public boolean unsetUomLabels(String uomLabel) {
		return isSetUomLabels() ? uomLabels.remove(uomLabel) : false;
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
		return copyTo(new Envelope(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Envelope copy = (target == null) ? new Envelope() : (Envelope)target;

		if (isSetLowerCorner()) {
			copy.setLowerCorner((DirectPosition)copyBuilder.copy(lowerCorner));
			if (copy.getLowerCorner() == lowerCorner)
				lowerCorner.setParent(this);
		}

		if (isSetUpperCorner()) {
			copy.setUpperCorner((DirectPosition)copyBuilder.copy(upperCorner));
			if (copy.getUpperCorner() == upperCorner)
				upperCorner.setParent(this);
		}

		if (isSetCoord()) {
			for (Coord part : coord) {
				Coord copyPart = (Coord)copyBuilder.copy(part);
				copy.addCoord(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetPos()) {
			for (DirectPosition part : pos) {
				DirectPosition copyPart = (DirectPosition)copyBuilder.copy(part);
				copy.addPos(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetCoordinates()) {
			copy.setCoordinates((Coordinates)copyBuilder.copy(coordinates));
			if (copy.getCoordinates() == coordinates)
				coordinates.setParent(this);
		}

		if (isSetSrsDimension())
			copy.setSrsDimension((Integer)copyBuilder.copy(srsDimension));

		if (isSetSrsName())
			copy.setSrsName(copyBuilder.copy(srsName));

		if (isSetAxisLabels())
			copy.setAxisLabels((List<String>)copyBuilder.copy(axisLabels));

		if (isSetUomLabels())
			copy.setUomLabels((List<String>)copyBuilder.copy(uomLabels));

		copy.unsetParent();

		return copy;
	}

	public boolean isNull() {
		return toBoundingBox().isNull();
	}
	
	public void setBoundingBox(BoundingBox boundingBox) {
		if (boundingBox != null && !boundingBox.isNull()) {
			setLowerCorner(boundingBox.getLowerCorner());
			setUpperCorner(boundingBox.getUpperCorner());
			setSrsDimension(3);

			unsetPos();
			unsetCoord();
			unsetCoordinates();
		}
	}

	public void update(BoundingBox boundingBox) {
		BoundingBox bbox = toBoundingBox();
		bbox.update(boundingBox);
		setBoundingBox(bbox);
	}

	public Envelope convert3d() {	
		return new Envelope(toBoundingBox());
	}

	public BoundingBox toBoundingBox() {
		BoundingBox bbox = new BoundingBox();

		if (isSetLowerCorner()) {
			List<Double> value = lowerCorner.toList3d();
			bbox.setLowerCorner(value.get(0), value.get(1), value.get(2));
		}

		if (isSetUpperCorner()) {
			List<Double> value = upperCorner.toList3d();
			bbox.setUpperCorner(value.get(0), value.get(1), value.get(2));
		}

		if (isSetPos()) {
			for (DirectPosition directPosition : pos)
				if (directPosition.isSetValue()) {
					List<Double> value = directPosition.toList3d();
					bbox.update(value.get(0), value.get(1), value.get(2));
				}
		}

		if (isSetCoord()) {
			for (Coord coord : this.coord)
				if (coord.isSetX() && coord.isSetY())
					bbox.update(coord.getX(), coord.getY(), coord.isSetZ() ? coord.getZ() : 0.0);	
		}

		if (isSetCoordinates()) {
			List<Double> coordinates = this.coordinates.toList3d();
			for (int i = 0; i < coordinates.size(); i += 3)
				bbox.update(coordinates.get(i), coordinates.get(i + 1), coordinates.get(i + 2));
		}

		return bbox;
	}

}
