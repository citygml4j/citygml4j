package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.DependentLocalityType;
import org.citygml4j.model.xal.DependentLocalityName;
import org.citygml4j.model.xal.XALClass;

public class DependentLocalityNameImpl extends XALBaseImpl implements DependentLocalityName {
	private DependentLocalityType.DependentLocalityName dependentLocalityName;
	
	public DependentLocalityNameImpl() {
		dependentLocalityName = new DependentLocalityType.DependentLocalityName();
	}
	
	public DependentLocalityNameImpl(DependentLocalityType.DependentLocalityName dependentLocalityName) {
		this.dependentLocalityName = dependentLocalityName;
	}
	
	@Override
	public DependentLocalityType.DependentLocalityName getJAXBObject() {
		return dependentLocalityName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.DEPENDENTLOCALITYNAME;
	}
	
	public String getContent() {
		return dependentLocalityName.getContent();
	}

	public String getType() {
		return dependentLocalityName.getType();
	}

	public void setContent(String content) {
		dependentLocalityName.setContent(content);
	}

	public void setType(String type) {
		dependentLocalityName.setType(type);
	}
	
	public String getCode() {
		return dependentLocalityName.getCode();
	}

	public void setCode(String code) {
		dependentLocalityName.setCode(code);
	}

	public boolean isSetContent() {
		return dependentLocalityName.isSetContent();
	}

	public boolean isSetType() {
		return dependentLocalityName.isSetType();
	}

	public void unsetContent() {
		dependentLocalityName.setContent(null);
	}

	public void unsetType() {
		dependentLocalityName.setType(null);
	}

	public boolean isSetCode() {
		return dependentLocalityName.isSetCode();
	}

	public void unsetCode() {
		dependentLocalityName.setCode(null);
	}

}
