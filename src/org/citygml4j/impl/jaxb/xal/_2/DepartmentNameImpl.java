package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.DepartmentElement;
import org.citygml4j.model.xal.DepartmentName;
import org.citygml4j.model.xal.XALClass;

public class DepartmentNameImpl extends XALBaseImpl implements DepartmentName {
	private DepartmentElement.DepartmentName departmentName;
	
	public DepartmentNameImpl() {
		departmentName = new DepartmentElement.DepartmentName();
	}
	
	public DepartmentNameImpl(DepartmentElement.DepartmentName departmentName) {
		this.departmentName = departmentName;
	}
	
	@Override
	public DepartmentElement.DepartmentName getJAXBObject() {
		return departmentName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.DEPARTMENTNAME;
	}

	public String getContent() {
		return departmentName.getContent();
	}

	public String getType() {
		return departmentName.getType();
	}

	public void setContent(String content) {
		departmentName.setContent(content);
	}

	public void setType(String type) {
		departmentName.setType(type);
	}

	public String getCode() {
		return departmentName.getCode();
	}

	public void setCode(String code) {
		departmentName.setCode(code);
	}

	public boolean isSetContent() {
		return departmentName.isSetContent();
	}

	public boolean isSetType() {
		return departmentName.isSetType();
	}

	public void unsetContent() {
		departmentName.setContent(null);
	}

	public void unsetType() {
		departmentName.setType(null);
	}

	public boolean isSetCode() {
		return departmentName.isSetCode();
	}

	public void unsetCode() {
		departmentName.setCode(null);
	}

}
