package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SurfaceArrayProperty;

public class SurfaceArrayPropertyImpl implements SurfaceArrayProperty {
	private List<AbstractSurface> surface;
	private Object parent;
	
	public void addSurface(AbstractSurface abstractSurface) {
		if (surface == null)
			surface = new ChildList<AbstractSurface>(this);
		
		surface.add(abstractSurface);
	}

	public List<AbstractSurface> getSurface() {
		if (surface == null)
			surface = new ChildList<AbstractSurface>(this);
		
		return surface;
	}

	public boolean isSetSurface() {
		return surface != null && !surface.isEmpty();
	}

	public void setSurface(List<AbstractSurface> abstractSurface) {
		surface = new ChildList<AbstractSurface>(this, abstractSurface);
	}

	public void unsetSurface() {
		if (isSetSurface())
			surface.clear();
		
		surface = null;
	}

	public boolean unsetSurface(AbstractSurface abstractSurface) {
		return isSetSurface() ? surface.remove(abstractSurface) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACEARRAYPROPERTY;
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
		return copyTo(new SurfaceArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfaceArrayProperty copy = (target == null) ? new SurfaceArrayPropertyImpl() : (SurfaceArrayProperty)target;
		
		if (isSetSurface()) {
			for (AbstractSurface part : surface) {
				AbstractSurface copyPart = (AbstractSurface)copyBuilder.copy(part);
				copy.addSurface(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
