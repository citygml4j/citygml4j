package org.citygml4j.geometry;

public class BoundingVolume implements Geometry {
	private Point lowerCorner;
	private Point upperCorner;

	public BoundingVolume() {
		lowerCorner = new Point();
		upperCorner = new Point();
	}

	public BoundingVolume(Point lowerCorner, Point upperCorner) {
		this.lowerCorner = lowerCorner;
		this.upperCorner = upperCorner;
	}

	public BoundingVolume(BoundingVolume boundingVolume) {
		this.lowerCorner = new Point(boundingVolume.getLowerCorner());
		this.upperCorner = new Point(boundingVolume.getUpperCorner());
	}

	public BoundingVolume clone() {
		return new BoundingVolume(this);
	}

	public Point getLowerCorner() {
		return lowerCorner;
	}

	public void setLowerCorner(Point lowerCorner) {
		this.lowerCorner = lowerCorner;
	}

	public Point getUpperCorner() {
		return upperCorner;
	}

	public void setUpperCorner(Point upperCorner) {
		this.upperCorner = upperCorner;
	}
}
