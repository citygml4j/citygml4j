package org.citygml4j.impl.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.valueObjects.ValueArray;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;

public class ValueArrayImpl extends CompositeValueImpl implements ValueArray {
	private String codeSpace;
	private String uom;
	
	public String getCodeSpace() {
		return codeSpace;
	}

	public String getUom() {
		return uom;
	}

	public boolean isSetCodeSpace() {
		return codeSpace != null;
	}

	public boolean isSetUom() {
		return uom != null;
	}

	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void unsetCodeSpace() {
		codeSpace = null;
	}

	public void unsetUom() {
		uom = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.VALUE_ARRAY;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueArray copy = (target == null) ? new ValueArrayImpl() : (ValueArray)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetCodeSpace())
			copy.setCodeSpace(copyBuilder.copy(codeSpace));
		
		if (isSetUom())
			copy.setUom(copyBuilder.copy(uom));
		
		return copy;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueArrayImpl(), copyBuilder);
	}

	@Override
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}

	@Override
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}

}
