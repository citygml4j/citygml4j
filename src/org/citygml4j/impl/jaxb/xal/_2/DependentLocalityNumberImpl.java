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

	public String getContent() {
		return dependentLocalityNumber.getContent();
	}

	public String getNameNumberOccurrence() {
		return dependentLocalityNumber.getNameNumberOccurrence();
	}

	public void setContent(String content) {
		dependentLocalityNumber.setContent(content);
	}

	public void setNameNumberOccurrence(String nameNumberOccurrence) {
		if (nameNumberOccurrence.equals("Before") || nameNumberOccurrence.equals("After"))
			dependentLocalityNumber.setNameNumberOccurrence(nameNumberOccurrence);
	}

	public String getCode() {
		return dependentLocalityNumber.getCode();
	}

	public void setCode(String code) {
		dependentLocalityNumber.setCode(code);
	}

	public boolean isSetContent() {
		return dependentLocalityNumber.isSetContent();
	}

	public boolean isSetNameNumberOccurrence() {
		return dependentLocalityNumber.isSetNameNumberOccurrence();
	}

	public void unsetContent() {
		dependentLocalityNumber.setContent(null);
	}

	public void unsetNameNumberOccurrence() {
		dependentLocalityNumber.setNameNumberOccurrence(null);
	}

	public boolean isSetCode() {
		return dependentLocalityNumber.isSetCode();
	}

	public void unsetCode() {
		dependentLocalityNumber.setCode(null);
	}

}
