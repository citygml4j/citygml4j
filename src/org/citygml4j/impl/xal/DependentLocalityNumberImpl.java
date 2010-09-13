package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.DependentLocalityNumber;
import org.citygml4j.model.xal.XALClass;

public class DependentLocalityNumberImpl implements DependentLocalityNumber {
	private String content;
	private String nameNumberOccurrence;
	private String code;
	private Object parent;
	
	public String getContent() {
		return content;
	}

	public String getNameNumberOccurrence() {
		return nameNumberOccurrence;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetNameNumberOccurrence() {
		return nameNumberOccurrence != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNameNumberOccurrence(String nameNumberOccurrence) {
		if (nameNumberOccurrence.equals("Before") || nameNumberOccurrence.equals("After"))
			this.nameNumberOccurrence = nameNumberOccurrence;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetNameNumberOccurrence() {
		nameNumberOccurrence = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.DEPENDENT_LOCALITY_NUMBER;
	}

	public String getCode() {
		return code;
	}

	public boolean isSetCode() {
		return code != null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void unsetCode() {
		code = null;
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
		return copyTo(new DependentLocalityNumberImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DependentLocalityNumber copy = (target == null) ? new DependentLocalityNumberImpl() : (DependentLocalityNumber)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetNameNumberOccurrence())
			copy.setNameNumberOccurrence(copyBuilder.copy(nameNumberOccurrence));
		
		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));
		
		copy.unsetParent();
		
		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
