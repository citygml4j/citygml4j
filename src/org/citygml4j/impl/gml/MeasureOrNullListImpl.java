package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.DoubleOrNull;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MeasureOrNullList;

public class MeasureOrNullListImpl implements MeasureOrNullList {
	private List<DoubleOrNull> doubleOrNull;
	private String uom;
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

	public String getUom() {
		return uom;
	}

	public boolean isSetDoubleOrNull() {
		return doubleOrNull != null && !doubleOrNull.isEmpty();
	}

	public boolean isSetUom() {
		return uom != null;
	}

	public void setDoubleOrNull(List<DoubleOrNull> doubleOrNull) {
		this.doubleOrNull = new ChildList<DoubleOrNull>(this, doubleOrNull);
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void unsetDoubleOrNull() {
		if (isSetDoubleOrNull())
			doubleOrNull.clear();
		
		doubleOrNull = null;
	}

	public boolean unsetDoubleOrNull(DoubleOrNull doubleOrNull) {
		return isSetDoubleOrNull() ? this.doubleOrNull.remove(doubleOrNull) : false;
	}

	public void unsetUom() {
		uom = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MEASUREORNULLLIST;
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
		return copyTo(new MeasureOrNullListImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MeasureOrNullList copy = (target == null) ? new MeasureOrNullListImpl() : (MeasureOrNullList)target;
		
		if (isSetDoubleOrNull()) {
			for (DoubleOrNull part : doubleOrNull) {
				DoubleOrNull copyPart = (DoubleOrNull)copyBuilder.copy(part);
				copy.addDoubleOrNull(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetUom())
			copy.setUom(copyBuilder.copy(uom));
		
		copy.unsetParent();
		
		return copy;
	}

}
