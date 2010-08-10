package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class SolidImpl extends AbstractSolidImpl implements Solid {
	private SurfaceProperty exterior;
	private List<SurfaceProperty> interior;
	
	public void addInterior(SurfaceProperty interior) {
		if (this.interior == null)
			this.interior = new ChildList<SurfaceProperty>(this);
		
		this.interior.add(interior);
	}

	public SurfaceProperty getExterior() {
		return exterior;
	}

	public List<SurfaceProperty> getInterior() {
		if (interior == null)
			interior = new ChildList<SurfaceProperty>(this);
		
		return interior;
	}

	public boolean isSetExterior() {
		return exterior != null;
	}

	public boolean isSetInterior() {
		return interior != null && !interior.isEmpty();
	}

	public void setExterior(SurfaceProperty exterior) {
		if (exterior != null)
			exterior.setParent(this);
		
		this.exterior = exterior;
	}

	public void setInterior(List<SurfaceProperty> interior) {
		this.interior = new ChildList<SurfaceProperty>(this, interior);
	}

	public void unsetExterior() {
		if (exterior != null)
			exterior.unsetParent();
	}

	public void unsetInterior() {
		if (isSetInterior())
			interior.clear();
		
		interior = null;
	}

	public boolean unsetInterior(SurfaceProperty interior) {
		return (isSetInterior()) ? this.interior.remove(interior) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetExterior()) {
			SurfaceProperty exterior = getExterior();
			if (exterior.isSetSurface())
				bbox.update(exterior.getSurface().calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.SOLID;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SolidImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Solid copy = (target == null) ? new SolidImpl() : (Solid)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetExterior()) {
			copy.setExterior((SurfaceProperty)copyBuilder.copy(exterior));
			if (copy.getExterior() == exterior)
				exterior.setParent(this);
		}
		
		if (isSetInterior()) {
			for (SurfaceProperty part : interior) {
				SurfaceProperty copyPart = (SurfaceProperty)copyBuilder.copy(part);
				copy.addInterior(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void visit(GeometryVisitor visitor) {
		visitor.accept(this);
	}

	public <T> T apply(GeometryFunction<T> visitor) {
		return visitor.accept(this);
	}
	
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}

}
