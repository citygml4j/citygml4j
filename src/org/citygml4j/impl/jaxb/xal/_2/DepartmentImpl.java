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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		department.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addDepartmentName(DepartmentName departmentName) {
		department.getDepartmentName().add(((DepartmentNameImpl)departmentName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<AddressLineElement> addressLineElemList = department.getAddressLine();

		for (AddressLineElement addressLineElem : addressLineElemList)
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public List<DepartmentName> getDepartmentName() {
		List<DepartmentName> departmentNameList = new ArrayList<DepartmentName>();
		List<DepartmentElement.DepartmentName> departmentNameElemList = department.getDepartmentName();

		for (DepartmentElement.DepartmentName departmentNameElem : departmentNameElemList)
			departmentNameList.add(new DepartmentNameImpl(departmentNameElem));

		return departmentNameList;
	}

	@Override
	public MailStop getMailStop() {
		if (department.isSetMailStop())
			return new MailStopImpl(department.getMailStop());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (department.isSetPostalCode())
			return new PostalCodeImpl(department.getPostalCode());

		return null;
	}

	@Override
	public String getType() {
		return department.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		department.unsetAddressLine();
		department.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setDepartmentName(List<DepartmentName> departmentName) {
		List<DepartmentElement.DepartmentName> departmentNameElemList = new ArrayList<DepartmentElement.DepartmentName>();

		for (DepartmentName departmentNameItem : departmentName)
			departmentNameElemList.add(((DepartmentNameImpl)departmentNameItem).getJAXBObject());

		department.unsetDepartmentName();
		department.getDepartmentName().addAll(departmentNameElemList);
	}

	@Override
	public void setMailStop(MailStop mailStop) {
		department.setMailStop(((MailStopImpl)mailStop).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		department.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		department.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return department.isSetAddressLine();
	}

	@Override
	public boolean isSetDepartmentName() {
		return department.isSetDepartmentName();
	}

	@Override
	public boolean isSetMailStop() {
		return department.isSetMailStop();
	}

	@Override
	public boolean isSetPostalCode() {
		return department.isSetPostalCode();
	}

	@Override
	public boolean isSetType() {
		return department.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		department.unsetAddressLine();
	}

	@Override
	public void unsetDepartmentName() {
		department.unsetDepartmentName();
	}

	@Override
	public void unsetMailStop() {
		department.setMailStop(null);
	}

	@Override
	public void unsetPostalCode() {
		department.setPostalCode(null);
	}

	@Override
	public void unsetType() {
		department.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (department.isSetAddressLine())
			return department.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetDepartmentName(DepartmentName departmentName) {
		if (department.isSetDepartmentName())
			return department.getDepartmentName().remove(((DepartmentNameImpl)departmentName).getJAXBObject());
		
		return false;
	}

}
