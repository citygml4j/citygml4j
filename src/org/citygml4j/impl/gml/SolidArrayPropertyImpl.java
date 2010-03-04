package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SolidArrayProperty;

public class SolidArrayPropertyImpl implements SolidArrayProperty {
	private List<AbstractSolid> solid;
	private Object parent;
	
	public void addSolid(AbstractSolid abstractSolid) {
		if (solid == null)
			solid = new ChildList<AbstractSolid>(this);
		
		solid.add(abstractSolid);
	}

	public List<AbstractSolid> getSolid() {
		if (solid == null)
			solid = new ChildList<AbstractSolid>(this);
		
		return solid;
	}

	public boolean isSetSolid() {
		return solid != null && !solid.isEmpty();
	}

	public void setSolid(List<AbstractSolid> abstractSolid) {
		solid = new ChildList<AbstractSolid>(this, abstractSolid);
	}

	public void unsetSolid() {
		if (isSetSolid())
			solid.clear();
		
		solid = null;
	}

	public boolean unsetSolid(AbstractSolid abstractSolid) {
		return isSetSolid() ? solid.remove(abstractSolid) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.SOLIDARRAYPROPERTY;
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
		return copyTo(new SolidArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SolidArrayProperty copy = (target == null) ? new SolidArrayPropertyImpl() : (SolidArrayProperty)target;
		
		if (isSetSolid()) {
			for (AbstractSolid part : solid) {
				AbstractSolid copyPart = (AbstractSolid)copyBuilder.copy(part);
				copy.addSolid(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
