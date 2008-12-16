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
	@Override
	public String getContent() {
		return dependentLocalityName.getContent();
	}

	@Override
	public String getType() {
		return dependentLocalityName.getType();
	}

	@Override
	public void setContent(String content) {
		dependentLocalityName.setContent(content);
	}

	@Override
	public void setType(String type) {
		dependentLocalityName.setType(type);
	}
	
	@Override
	public String getCode() {
		return dependentLocalityName.getCode();
	}

	@Override
	public void setCode(String code) {
		dependentLocalityName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return dependentLocalityName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return dependentLocalityName.isSetType();
	}

	@Override
	public void unsetContent() {
		dependentLocalityName.setContent(null);
	}

	@Override
	public void unsetType() {
		dependentLocalityName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return dependentLocalityName.isSetCode();
	}

	@Override
	public void unsetCode() {
		dependentLocalityName.setCode(null);
	}

}
