package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.DependentLocalityType;
import org.citygml4j.model.xal.DependentLocalityNumber;
import org.citygml4j.model.xal.XALClass;

public class DependentLocalityNumberImpl extends XALBaseImpl implements DependentLocalityNumber {
	private DependentLocalityType.DependentLocalityNumber dependentLocalityNumber;
	
	public DependentLocalityNumberImpl() {
		dependentLocalityNumber = new DependentLocalityType.DependentLocalityNumber();
	}
	
	public DependentLocalityNumberImpl(DependentLocalityType.DependentLocalityNumber dependentLocalityNumber) {
		this.dependentLocalityNumber = dependentLocalityNumber;
	}
	
	@Override
	public DependentLocalityType.DependentLocalityNumber getJAXBObject() {
		return dependentLocalityNumber;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.DEPENDENTLOCALITYNUMBER;
	}

	@Override
	public String getContent() {
		return dependentLocalityNumber.getContent();
	}

	@Override
	public String getNameNumberOccurrence() {
		return dependentLocalityNumber.getNameNumberOccurrence();
	}

	@Override
	public void setContent(String content) {
		dependentLocalityNumber.setContent(content);
	}

	@Override
	public void setNameNumberOccurrence(String nameNumberOccurrence) {
		if (nameNumberOccurrence.equals("Before") || nameNumberOccurrence.equals("After"))
			dependentLocalityNumber.setNameNumberOccurrence(nameNumberOccurrence);
	}

	@Override
	public String getCode() {
		return dependentLocalityNumber.getCode();
	}

	@Override
	public void setCode(String code) {
		dependentLocalityNumber.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return dependentLocalityNumber.isSetContent();
	}

	@Override
	public boolean isSetNameNumberOccurrence() {
		return dependentLocalityNumber.isSetNameNumberOccurrence();
	}

	@Override
	public void unsetContent() {
		dependentLocalityNumber.setContent(null);
	}

	@Override
	public void unsetNameNumberOccurrence() {
		dependentLocalityNumber.setNameNumberOccurrence(null);
	}

	@Override
	public boolean isSetCode() {
		return dependentLocalityNumber.isSetCode();
	}

	@Override
	public void unsetCode() {
		dependentLocalityNumber.setCode(null);
	}

}
