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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		firmType.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addDepartment(Department department) {
		firmType.getDepartment().add(((DepartmentImpl)department).getJAXBObject());
	}

	@Override
	public void addFirmName(FirmName firmName) {
		firmType.getFirmName().add(((FirmNameImpl)firmName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : firmType.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public List<Department> getDepartment() {
		List<Department> departmentList = new ArrayList<Department>();

		for (DepartmentElement depElem : firmType.getDepartment())
			departmentList.add(new DepartmentImpl(depElem));

		return departmentList;
	}

	@Override
	public List<FirmName> getFirmName() {
		List<FirmName> firmNameList = new ArrayList<FirmName>();

		for (FirmType.FirmName firmNameElem : firmType.getFirmName())
			firmNameList.add(new FirmNameImpl(firmNameElem));

		return firmNameList;
	}

	@Override
	public MailStop getMailStop() {
		if (firmType.isSetMailStop())
			return new MailStopImpl(firmType.getMailStop());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (firmType.isSetPostalCode())
			return new PostalCodeImpl(firmType.getPostalCode());

		return null;
	}

	@Override
	public String getType() {
		return firmType.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		firmType.unsetAddressLine();
		firmType.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setDepartment(List<Department> department) {
		List<DepartmentElement> depElemList = new ArrayList<DepartmentElement>();

		for (Department depItem : department)
			depElemList.add(((DepartmentImpl)depItem).getJAXBObject());

		firmType.unsetDepartment();
		firmType.getDepartment().addAll(depElemList);
	}

	@Override
	public void setFirmName(List<FirmName> firmName) {
		List<FirmType.FirmName> firmNameElemList = new ArrayList<FirmType.FirmName>();

		for (FirmName firmNameItem : firmName)
			firmNameElemList.add(((FirmNameImpl)firmNameItem).getJAXBObject());

		firmType.unsetFirmName();
		firmType.getFirmName().addAll(firmNameElemList);
	}

	@Override
	public void setMailStop(MailStop mailStop) {
		firmType.setMailStop(((MailStopImpl)mailStop).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		firmType.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		firmType.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return firmType.isSetAddressLine();
	}

	@Override
	public boolean isSetDepartment() {
		return firmType.isSetDepartment();
	}

	@Override
	public boolean isSetFirmName() {
		return firmType.isSetFirmName();
	}

	@Override
	public boolean isSetMailStop() {
		return firmType.isSetMailStop();
	}

	@Override
	public boolean isSetPostalCode() {
		return firmType.isSetPostalCode();
	}

	@Override
	public boolean isSetType() {
		return firmType.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		firmType.unsetAddressLine();
	}

	@Override
	public void unsetDepartment() {
		firmType.unsetDepartment();
	}

	@Override
	public void unsetFirmName() {
		firmType.unsetFirmName();
	}

	@Override
	public void unsetMailStop() {
		firmType.setMailStop(null);
	}

	@Override
	public void unsetPostalCode() {
		firmType.setPostalCode(null);
	}

	@Override
	public void unsetType() {
		firmType.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (firmType.isSetAddressLine())
			return firmType.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetDepartment(Department department) {
		if (firmType.isSetDepartment())
			return firmType.getDepartment().remove(((DepartmentImpl)department).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetFirmName(FirmName firmName) {
		if (firmType.isSetFirmName())
			return firmType.getFirmName().remove(((FirmNameImpl)firmName).getJAXBObject());
		
		return false;
	}

}
