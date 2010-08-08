package org.citygml4j.impl.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.Coordinates;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.Envelope;
import org.citygml4j.model.gml.GMLClass;

public class EnvelopeImpl implements Envelope {
	private DirectPosition lowerCorner;
	private DirectPosition upperCorner;
	private List<Coord> coord;
	private List<DirectPosition> pos;
	private Coordinates coordinates;
	private Integer srsDimension;
	private String srsName;
	private List<String> axisLabels;
	private List<String> uomLabels;
	private Object parent;

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
				setLowerCorner(new DirectPositionImpl());
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
				setUpperCorner(new DirectPositionImpl());
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
		return copyTo(new EnvelopeImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Envelope copy = (target == null) ? new EnvelopeImpl() : (Envelope)target;

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

	public Envelope convert3d() {	
		BoundingBox bbox = toBoundingBox();
		
		if (bbox != null) {
			Envelope envelope = new EnvelopeImpl();			

			envelope.setLowerCorner(bbox.getLowerCorner());
			envelope.setUpperCorner(bbox.getUpperCorner());
			envelope.setSrsDimension(3);
			
			return envelope;
		} else
			return null;
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

		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

}
