package org.citygml4j.geometry;

import org.citygml4j.builder.copy.CopyBuilder;

public class BoundingBox implements Geometry {
	private Point lowerCorner;
	private Point upperCorner;

	public BoundingBox() {
		lowerCorner = new Point(Double.MAX_VALUE);
		upperCorner = new Point(-Double.MAX_VALUE);
	}

	public BoundingBox(Point lowerCorner, Point upperCorner) {
		this.lowerCorner = new Point(lowerCorner);
		this.upperCorner = new Point(upperCorner);
	}

	public BoundingBox(BoundingBox boundingBox) {
		this.lowerCorner = new Point(boundingBox.getLowerCorner());
		this.upperCorner = new Point(boundingBox.getUpperCorner());
	}

	public Point getLowerCorner() {
		return lowerCorner;
	}

	public void setLowerCorner(Point lowerCorner) {
		this.lowerCorner = lowerCorner;
	}

	public void setLowerCorner(double x, double y, double z) {
		lowerCorner.setX(x);
		lowerCorner.setY(y);
		lowerCorner.setZ(z);
	}

	public Point getUpperCorner() {
		return upperCorner;
	}

	public void setUpperCorner(Point upperCorner) {
		this.upperCorner = upperCorner;
	}

	public void setUpperCorner(double x, double y, double z) {
		upperCorner.setX(x);
		upperCorner.setY(y);
		upperCorner.setZ(z);
	}

	public void updateLowerCorner(double x, double y, double z) {
		if (x < lowerCorner.getX())
			lowerCorner.setX(x);

		if (y < lowerCorner.getY())
			lowerCorner.setY(y);

		if (z < lowerCorner.getZ())
			lowerCorner.setZ(z);
	}

	public void updateLowerCorner(Point lowerCorner) {
		updateLowerCorner(lowerCorner.getX(), lowerCorner.getY(), lowerCorner.getZ());
	}

	public void updateUpperCorner(double x, double y, double z) {
		if (x > upperCorner.getX())
			upperCorner.setX(x);

		if (y > upperCorner.getY())
			upperCorner.setY(y);

		if (z > upperCorner.getZ())
			upperCorner.setZ(z);
	}

	public void updateUpperCorner(Point upperCorner) {
		updateUpperCorner(upperCorner.getX(), upperCorner.getY(), upperCorner.getZ());
	}

	public void update(BoundingBox boundingBox) {
		if (boundingBox != null) {
			updateLowerCorner(boundingBox.getLowerCorner());
			updateUpperCorner(boundingBox.getUpperCorner());
		}
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BoundingBox(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BoundingBox copy = (target == null) ? new BoundingBox() : (BoundingBox)target;
		
		copy.setLowerCorner((Point)copyBuilder.copy(lowerCorner));
		copy.setUpperCorner((Point)copyBuilder.copy(upperCorner));
		
		return copy;
	}

}
