package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MeasureOrNullList;

public class MeasureOrNullListImpl extends DoubleOrNullListImpl implements MeasureOrNullList {
	private String uom;

	public String getUom() {
		return uom;
	}
	
	public boolean isSetUom() {
		return uom != null;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void unsetUom() {
		uom = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MEASUREORNULLLIST;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MeasureOrNullListImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MeasureOrNullList copy = (target == null) ? new MeasureOrNullListImpl() : (MeasureOrNullList)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetUom())
			copy.setUom(copyBuilder.copy(uom));
		
		return copy;
	}

}
