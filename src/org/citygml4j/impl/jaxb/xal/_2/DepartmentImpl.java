package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.DepartmentElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.Department;
import org.citygml4j.model.xal.DepartmentName;
import org.citygml4j.model.xal.MailStop;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.XALClass;

public class DepartmentImpl extends XALBaseImpl implements Department {
	private DepartmentElement department;

	public DepartmentImpl() {
		department = new DepartmentElement();
	}

	public DepartmentImpl(DepartmentElement department) {
		this.department = department;
	}

	@Override
	public DepartmentElement getJAXBObject() {
		return department;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.DEPARTMENT;
	}

	public void addAddressLine(AddressLine addressLine) {
		department.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addDepartmentName(DepartmentName departmentName) {
		department.getDepartmentName().add(((DepartmentNameImpl)departmentName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : department.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public List<DepartmentName> getDepartmentName() {
		List<DepartmentName> departmentNameList = new ArrayList<DepartmentName>();

		for (DepartmentElement.DepartmentName departmentNameElem : department.getDepartmentName())
			departmentNameList.add(new DepartmentNameImpl(departmentNameElem));

		return departmentNameList;
	}

	public MailStop getMailStop() {
		if (department.isSetMailStop())
			return new MailStopImpl(department.getMailStop());

		return null;
	}

	public PostalCode getPostalCode() {
		if (department.isSetPostalCode())
			return new PostalCodeImpl(department.getPostalCode());

		return null;
	}

	public String getType() {
		return department.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		department.unsetAddressLine();
		department.getAddressLine().addAll(addressLineElemList);
	}

	public void setDepartmentName(List<DepartmentName> departmentName) {
		List<DepartmentElement.DepartmentName> departmentNameElemList = new ArrayList<DepartmentElement.DepartmentName>();

		for (DepartmentName departmentNameItem : departmentName)
			departmentNameElemList.add(((DepartmentNameImpl)departmentNameItem).getJAXBObject());

		department.unsetDepartmentName();
		department.getDepartmentName().addAll(departmentNameElemList);
	}

	public void setMailStop(MailStop mailStop) {
		department.setMailStop(((MailStopImpl)mailStop).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		department.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setType(String type) {
		department.setType(type);
	}

	public boolean isSetAddressLine() {
		return department.isSetAddressLine();
	}

	public boolean isSetDepartmentName() {
		return department.isSetDepartmentName();
	}

	public boolean isSetMailStop() {
		return department.isSetMailStop();
	}

	public boolean isSetPostalCode() {
		return department.isSetPostalCode();
	}

	public boolean isSetType() {
		return department.isSetType();
	}

	public void unsetAddressLine() {
		department.unsetAddressLine();
	}

	public void unsetDepartmentName() {
		department.unsetDepartmentName();
	}

	public void unsetMailStop() {
		department.setMailStop(null);
	}

	public void unsetPostalCode() {
		department.setPostalCode(null);
	}

	public void unsetType() {
		department.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (department.isSetAddressLine())
			return department.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetDepartmentName(DepartmentName departmentName) {
		if (department.isSetDepartmentName())
			return department.getDepartmentName().remove(((DepartmentNameImpl)departmentName).getJAXBObject());
		
		return false;
	}

}
