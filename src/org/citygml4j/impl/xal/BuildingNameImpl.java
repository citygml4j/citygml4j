package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.xal.BuildingName;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class BuildingNameImpl implements BuildingName {
	private String content;
	private String type;
	private String typeOccurrence;
	private String code;
	private Object parent;
	
	public String getContent() {
		return content;
	}

	public String getType() {
		return type;
	}

	public String getTypeOccurrence() {
		return typeOccurrence;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public boolean isSetTypeOccurrence() {
		return typeOccurrence != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTypeOccurrence(String typeOccurrence) {
		if (typeOccurrence.equals("Before") || typeOccurrence.equals("After"))
			this.typeOccurrence = typeOccurrence;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetType() {
		type = null;
	}

	public void unsetTypeOccurrence() {
		typeOccurrence = null;
	}

	public XALClass getXALClass() {
		return XALClass.BUILDING_NAME;
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
		return copyTo(new BuildingNameImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BuildingName copy = (target == null) ? new BuildingNameImpl() : (BuildingName)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		if (isSetTypeOccurrence())
			copy.setTypeOccurrence(copyBuilder.copy(typeOccurrence));
		
		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));
		
		copy.unsetParent();
		
		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T visit(XALFunction<T> visitor) {
		return visitor.accept(this);
	}

}
