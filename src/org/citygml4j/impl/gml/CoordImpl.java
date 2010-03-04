package org.citygml4j.impl.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.GMLClass;

public class CoordImpl implements Coord {
	private Double x;
	private Double y;
	private Double z;
	private Object parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.COORD;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public Double getZ() {
		return z;
	}

	public boolean isSetX() {
		return x != null;
	}

	public boolean isSetY() {
		return y != null;
	}

	public boolean isSetZ() {
		return z != null;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();
		
		if (isSetX() && isSetY()) {
			tmp.add(x);
			tmp.add(y);			
			tmp.add(isSetZ() ? z : 0.0);
		}
		
		return tmp;
	}

	public void unsetX() {
		x = null;
	}

	public void unsetY() {
		y = null;
	}

	public void unsetZ() {
		z = null;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Coord copy = (target == null) ? new CoordImpl() : (Coord)target;
		
		if (isSetX())
			copy.setX((Double)copyBuilder.copy(x));
		
		if (isSetY())
			copy.setY((Double)copyBuilder.copy(y));
		
		if (isSetZ())
			copy.setZ((Double)copyBuilder.copy(z));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CoordImpl(), copyBuilder);
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

}
