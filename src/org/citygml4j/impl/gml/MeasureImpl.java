package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Measure;

public class MeasureImpl implements Measure {
	private double value;
	private String uom;
	private Object parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.MEASURE;
	}

	public String getUom() {
		return uom;
	}

	public double getValue() {
		return value;
	}

	public boolean isSetUom() {
		return uom != null;
	}

	public boolean isSetValue() {
		return true;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void setValue(double value) {
		this.value = value;
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

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Measure copy = (target == null) ? new MeasureImpl() : (Measure)target;
		
		if (isSetValue())
			copy.setValue((Double)copyBuilder.copy(value));
		
		if (isSetUom())
			copy.setUom(copyBuilder.copy(uom));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MeasureImpl(), copyBuilder);
	}
}
