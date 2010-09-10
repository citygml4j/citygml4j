package org.citygml4j.impl.gml.basicTypes;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.DoubleOrNull;
import org.citygml4j.model.gml.basicTypes.DoubleOrNullList;

public class DoubleOrNullListImpl implements DoubleOrNullList {
	private List<DoubleOrNull> doubleOrNull;
	private Object parent;

	public void addDoubleOrNull(DoubleOrNull doubleOrNull) {
		if (this.doubleOrNull == null)
			this.doubleOrNull = new ChildList<DoubleOrNull>(this);
		
		this.doubleOrNull.add(doubleOrNull);
	}

	public List<DoubleOrNull> getDoubleOrNull() {
		if (doubleOrNull == null)
			doubleOrNull = new ChildList<DoubleOrNull>(this);
		
		return doubleOrNull;
	}

	public boolean isSetDoubleOrNull() {
		return doubleOrNull != null && !doubleOrNull.isEmpty();
	}

	public void setDoubleOrNull(List<DoubleOrNull> doubleOrNull) {
		this.doubleOrNull = new ChildList<DoubleOrNull>(this, doubleOrNull);
	}

	public void unsetDoubleOrNull() {
		if (isSetDoubleOrNull())
			doubleOrNull.clear();
		
		doubleOrNull = null;
	}

	public boolean unsetDoubleOrNull(DoubleOrNull doubleOrNull) {
		return isSetDoubleOrNull() ? this.doubleOrNull.remove(doubleOrNull) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.DOUBLE_OR_NULL_LIST;
	}

	public Object getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DoubleOrNullListImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DoubleOrNullList copy = (target == null) ? new DoubleOrNullListImpl() : (DoubleOrNullList)target;
		
		if (isSetDoubleOrNull()) {
			for (DoubleOrNull part : doubleOrNull) {
				DoubleOrNull copyPart = (DoubleOrNull)copyBuilder.copy(part);
				copy.addDoubleOrNull(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
