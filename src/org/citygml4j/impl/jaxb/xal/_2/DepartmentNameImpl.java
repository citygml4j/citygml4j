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

	@Override
	public String getContent() {
		return departmentName.getContent();
	}

	@Override
	public String getType() {
		return departmentName.getType();
	}

	@Override
	public void setContent(String content) {
		departmentName.setContent(content);
	}

	@Override
	public void setType(String type) {
		departmentName.setType(type);
	}

	@Override
	public String getCode() {
		return departmentName.getCode();
	}

	@Override
	public void setCode(String code) {
		departmentName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return departmentName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return departmentName.isSetType();
	}

	@Override
	public void unsetContent() {
		departmentName.setContent(null);
	}

	@Override
	public void unsetType() {
		departmentName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return departmentName.isSetCode();
	}

	@Override
	public void unsetCode() {
		departmentName.setCode(null);
	}

}
