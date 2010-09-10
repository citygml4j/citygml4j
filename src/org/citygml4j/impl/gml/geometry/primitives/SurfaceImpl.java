package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurfacePatch;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.model.gml.geometry.primitives.SurfacePatchArrayProperty;

public class SurfaceImpl extends AbstractSurfaceImpl implements Surface {
	private SurfacePatchArrayProperty patches;
	
	public SurfacePatchArrayProperty getPatches() {
		return patches;
	}

	public boolean isSetPatches() {
		return patches != null;
	}

	public void setPatches(SurfacePatchArrayProperty patches) {
		if (patches != null)
			patches.setParent(this);
		
		this.patches = patches;
	}

	public void unsetPatches() {
		if (isSetPatches())
			patches.unsetParent();
		
		patches = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (getPatches() != null) {
			SurfacePatchArrayProperty arrayProperty = getPatches();
			
			if (arrayProperty.isSetSurfacePatch())
				for (AbstractSurfacePatch surfacePatch : arrayProperty.getSurfacePatch())
					bbox.update(surfacePatch.calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Surface copy = (target == null) ? new SurfaceImpl() : (Surface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetPatches()) {
			copy.setPatches((SurfacePatchArrayProperty)copyBuilder.copy(patches));
			if (copy.getPatches() == patches)
				patches.setParent(this);
		}
		
		return copy;
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
