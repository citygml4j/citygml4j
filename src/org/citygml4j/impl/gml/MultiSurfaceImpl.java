package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.SurfaceArrayProperty;
import org.citygml4j.model.gml.SurfaceProperty;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class MultiSurfaceImpl extends AbstractGeometricAggregateImpl implements MultiSurface {
	private List<SurfaceProperty> surfaceMember;
	private SurfaceArrayProperty surfaceMembers;
	
	public void addSurfaceMember(SurfaceProperty surfaceMember) {
		if (this.surfaceMember == null)
			this.surfaceMember = new ChildList<SurfaceProperty>(this);
		
		this.surfaceMember.add(surfaceMember);
	}

	public List<SurfaceProperty> getSurfaceMember() {
		if (surfaceMember == null)
			surfaceMember = new ChildList<SurfaceProperty>(this);
		
		return surfaceMember;
	}

	public SurfaceArrayProperty getSurfaceMembers() {
		return surfaceMembers;
	}

	public boolean isSetSurfaceMember() {
		return surfaceMember != null && !surfaceMember.isEmpty();
	}

	public boolean isSetSurfaceMembers() {
		return surfaceMembers != null;
	}

	public void setSurfaceMember(List<SurfaceProperty> surfaceMember) {
		this.surfaceMember = new ChildList<SurfaceProperty>(this, surfaceMember);
	}

	public void setSurfaceMembers(SurfaceArrayProperty surfaceMembers) {
		if (surfaceMembers != null)
			surfaceMembers.setParent(this);
		
		this.surfaceMembers = surfaceMembers;
	}

	public void unsetSurfaceMember() {
		if (isSetSurfaceMember())
			surfaceMember.clear();
		
		surfaceMember = null;
	}

	public boolean unsetSurfaceMember(SurfaceProperty surfaceMember) {
		return isSetSurfaceMember() ? this.surfaceMember.remove(surfaceMember) : false;
	}

	public void unsetSurfaceMembers() {
		if (isSetSurfaceMembers())
			surfaceMembers.unsetParent();
		
		surfaceMembers = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : getSurfaceMember())
				if (surfaceProperty.isSetSurface())
					bbox.update(surfaceProperty.getSurface().calcBoundingBox());
		}

		if (isSetSurfaceMembers()) {
			SurfaceArrayProperty surfaceArrayProperty = getSurfaceMembers();

			if (surfaceArrayProperty.isSetSurface())
				for (AbstractSurface abstractSurface : surfaceArrayProperty.getSurface())
					bbox.update(abstractSurface.calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTISURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiSurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiSurface copy = (target == null) ? new MultiSurfaceImpl() : (MultiSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetSurfaceMember()) {
			for (SurfaceProperty part : surfaceMember) {
				SurfaceProperty copyPart = (SurfaceProperty)copyBuilder.copy(part);
				copy.addSurfaceMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetSurfaceMembers()) {
			copy.setSurfaceMembers((SurfaceArrayProperty)copyBuilder.copy(surfaceMembers));
			if (copy.getSurfaceMembers() == surfaceMembers)
				surfaceMembers.setParent(this);
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
