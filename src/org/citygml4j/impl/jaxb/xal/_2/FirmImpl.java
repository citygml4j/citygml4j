package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.DepartmentElement;
import org.citygml4j.jaxb.xal.FirmType;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.Department;
import org.citygml4j.model.xal.Firm;
import org.citygml4j.model.xal.FirmName;
import org.citygml4j.model.xal.MailStop;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.XALClass;

public class FirmImpl extends XALBaseImpl implements Firm {
	private FirmType firmType;

	public FirmImpl() {
		firmType = new FirmType();
	}

	public FirmImpl(FirmType firmType) {
		this.firmType = firmType;
	}

	@Override
	public FirmType getJAXBObject() {
		return firmType;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.FIRM;
	}

	public void addAddressLine(AddressLine addressLine) {
		firmType.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addDepartment(Department department) {
		firmType.getDepartment().add(((DepartmentImpl)department).getJAXBObject());
	}

	public void addFirmName(FirmName firmName) {
		firmType.getFirmName().add(((FirmNameImpl)firmName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : firmType.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public List<Department> getDepartment() {
		List<Department> departmentList = new ArrayList<Department>();

		for (DepartmentElement depElem : firmType.getDepartment())
			departmentList.add(new DepartmentImpl(depElem));

		return departmentList;
	}

	public List<FirmName> getFirmName() {
		List<FirmName> firmNameList = new ArrayList<FirmName>();

		for (FirmType.FirmName firmNameElem : firmType.getFirmName())
			firmNameList.add(new FirmNameImpl(firmNameElem));

		return firmNameList;
	}

	public MailStop getMailStop() {
		if (firmType.isSetMailStop())
			return new MailStopImpl(firmType.getMailStop());

		return null;
	}

	public PostalCode getPostalCode() {
		if (firmType.isSetPostalCode())
			return new PostalCodeImpl(firmType.getPostalCode());

		return null;
	}

	public String getType() {
		return firmType.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		firmType.unsetAddressLine();
		firmType.getAddressLine().addAll(addressLineElemList);
	}

	public void setDepartment(List<Department> department) {
		List<DepartmentElement> depElemList = new ArrayList<DepartmentElement>();

		for (Department depItem : department)
			depElemList.add(((DepartmentImpl)depItem).getJAXBObject());

		firmType.unsetDepartment();
		firmType.getDepartment().addAll(depElemList);
	}

	public void setFirmName(List<FirmName> firmName) {
		List<FirmType.FirmName> firmNameElemList = new ArrayList<FirmType.FirmName>();

		for (FirmName firmNameItem : firmName)
			firmNameElemList.add(((FirmNameImpl)firmNameItem).getJAXBObject());

		firmType.unsetFirmName();
		firmType.getFirmName().addAll(firmNameElemList);
	}

	public void setMailStop(MailStop mailStop) {
		firmType.setMailStop(((MailStopImpl)mailStop).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		firmType.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setType(String type) {
		firmType.setType(type);
	}

	public boolean isSetAddressLine() {
		return firmType.isSetAddressLine();
	}

	public boolean isSetDepartment() {
		return firmType.isSetDepartment();
	}

	public boolean isSetFirmName() {
		return firmType.isSetFirmName();
	}

	public boolean isSetMailStop() {
		return firmType.isSetMailStop();
	}

	public boolean isSetPostalCode() {
		return firmType.isSetPostalCode();
	}

	public boolean isSetType() {
		return firmType.isSetType();
	}

	public void unsetAddressLine() {
		firmType.unsetAddressLine();
	}

	public void unsetDepartment() {
		firmType.unsetDepartment();
	}

	public void unsetFirmName() {
		firmType.unsetFirmName();
	}

	public void unsetMailStop() {
		firmType.setMailStop(null);
	}

	public void unsetPostalCode() {
		firmType.setPostalCode(null);
	}

	public void unsetType() {
		firmType.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (firmType.isSetAddressLine())
			return firmType.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetDepartment(Department department) {
		if (firmType.isSetDepartment())
			return firmType.getDepartment().remove(((DepartmentImpl)department).getJAXBObject());
		
		return false;
	}

	public boolean unsetFirmName(FirmName firmName) {
		if (firmType.isSetFirmName())
			return firmType.getFirmName().remove(((FirmNameImpl)firmName).getJAXBObject());
		
		return false;
	}

}
