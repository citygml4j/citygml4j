package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.AbstractSurfacePatch;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SurfacePatchArrayProperty;

public class SurfacePatchArrayPropertyImpl implements SurfacePatchArrayProperty {
	private List<AbstractSurfacePatch> surfacePatch;
	private Object parent;
	
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch) {
		if (this.surfacePatch == null)
			this.surfacePatch = new ChildList<AbstractSurfacePatch>(this);
		
		this.surfacePatch.add(surfacePatch);
	}

	public List<? extends AbstractSurfacePatch> getSurfacePatch() {
		if (surfacePatch == null)
			surfacePatch = new ChildList<AbstractSurfacePatch>(this);
		
		return surfacePatch;
	}

	public boolean isSetSurfacePatch() {
		return surfacePatch != null && !surfacePatch.isEmpty();
	}

	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch) {
		this.surfacePatch = new ChildList<AbstractSurfacePatch>(this, surfacePatch);
	}

	public void unsetSurfacePatch() {
		if (isSetSurfacePatch())
			surfacePatch.clear();
		
		surfacePatch = null;
	}

	public boolean unsetSurfacePatch(AbstractSurfacePatch surfacePatch) {
		return isSetSurfacePatch() ? this.surfacePatch.remove(surfacePatch) : false;
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
		return copyTo(new SurfacePatchArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfacePatchArrayProperty copy = (target == null) ? new SurfacePatchArrayPropertyImpl() : (SurfacePatchArrayProperty)target;
		
		if (isSetSurfacePatch()) {
			for (AbstractSurfacePatch part : surfacePatch) {
				AbstractSurfacePatch copyPart = (AbstractSurfacePatch)copyBuilder.copy(part);
				copy.addSurfacePatch(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
