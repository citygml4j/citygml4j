package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractRingProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceInterpolation;
import org.citygml4j.model.gml.geometry.primitives.Triangle;

public class TriangleImpl extends AbstractSurfacePatchImpl implements Triangle {
	private AbstractRingProperty exterior;
	private SurfaceInterpolation interpolation;
	private Object parent;

	public AbstractRingProperty getExterior() {
		return exterior;
	}

	public SurfaceInterpolation getInterpolation() {
		if (interpolation == null)
			return SurfaceInterpolation.PLANAR;
		else
			return interpolation;
	}

	public boolean isSetExterior() {
		return exterior != null;
	}

	public boolean isSetInterpolation() {
		return interpolation != null;
	}

	public void setExterior(AbstractRingProperty exterior) {
		if (exterior != null)
			exterior.setParent(this);

		this.exterior = exterior;
	}

	public void setInterpolation(SurfaceInterpolation interpolation) {
		this.interpolation = SurfaceInterpolation.PLANAR;
	}

	public void unsetExterior() {
		if (isSetExterior())
			exterior.unsetParent();

		exterior = null;
	}

	public void unsetInterpolation() {
		interpolation = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetExterior() && exterior.isSetRing()) 
			bbox.update(exterior.getRing().calcBoundingBox());
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.TRIANGLE;
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
		return copyTo(new TriangleImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Triangle copy = (target == null) ? new TriangleImpl() : (Triangle)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetExterior()) {
			copy.setExterior((AbstractRingProperty)copyBuilder.copy(exterior));
			if (copy.getExterior() == exterior)
				exterior.setParent(this);
		}

		if (isSetInterpolation())
			copy.setInterpolation((SurfaceInterpolation)copyBuilder.copy(interpolation));

		return copy;
	}

}
