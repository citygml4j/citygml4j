package org.citygml4j.impl.xal;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.AdministrativeArea;
import org.citygml4j.model.xal.AdministrativeAreaName;
import org.citygml4j.model.xal.Locality;
import org.citygml4j.model.xal.PostOffice;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.SubAdministrativeArea;
import org.citygml4j.model.xal.XALClass;

public class AdministrativeAreaImpl implements AdministrativeArea {
	private List<AddressLine> addressLine;
	private List<AdministrativeAreaName> administrativeAreaName;
	private SubAdministrativeArea subAdministrativeArea;
	private Locality locality;
	private PostOffice postOffice;
	private PostalCode postalCode;
	private String usageType;
	private String indicator;
	private String type;
	private Object parent;

	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public void addAdministrativeAreaName(AdministrativeAreaName administrativeAreaName) {
		if (this.administrativeAreaName == null)
			this.administrativeAreaName = new ChildList<AdministrativeAreaName>(this);

		this.administrativeAreaName.add(administrativeAreaName);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public List<AdministrativeAreaName> getAdministrativeAreaName() {
		if (administrativeAreaName == null)
			administrativeAreaName = new ChildList<AdministrativeAreaName>(this);

		return administrativeAreaName;
	}

	public String getIndicator() {
		return indicator;
	}

	public Locality getLocality() {
		return locality;
	}

	public PostOffice getPostOffice() {
		return postOffice;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public SubAdministrativeArea getSubAdministrativeArea() {
		return subAdministrativeArea;
	}

	public String getType() {
		return type;
	}

	public String getUsageType() {
		return usageType;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetAdministrativeAreaName() {
		return administrativeAreaName != null && !administrativeAreaName.isEmpty();
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public boolean isSetLocality() {
		return locality != null;
	}

	public boolean isSetPostOffice() {
		return postOffice != null;
	}

	public boolean isSetPostalCode() {
		return postalCode != null;
	}

	public boolean isSetSubAdministrativeArea() {
		return subAdministrativeArea != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public boolean isSetUsageType() {
		return usageType != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setAdministrativeAreaName(List<AdministrativeAreaName> administrativeAreaName) {
		this.administrativeAreaName = new ChildList<AdministrativeAreaName>(this, administrativeAreaName);
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setLocality(Locality locality) {
		if (locality != null)
			locality.setParent(this);

		this.locality = locality;
	}

	public void setPostOffice(PostOffice postOffice) {
		if (postOffice != null)
			postOffice.setParent(this);

		this.postOffice = postOffice;
	}

	public void setPostalCode(PostalCode postalCode) {
		if (postalCode != null)
			postalCode.setParent(this);

		this.postalCode = postalCode;
	}

	public void setSubAdministrativeArea(SubAdministrativeArea subAdministrativeArea) {
		if (subAdministrativeArea != null)
			subAdministrativeArea.setParent(this);

		this.subAdministrativeArea = subAdministrativeArea;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.clear();

		addressLine = null;
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() ? this.addressLine.remove(addressLine) : false;
	}

	public void unsetAdministrativeAreaName() {
		if (isSetAdministrativeAreaName())
			administrativeAreaName.clear();

		administrativeAreaName = null;
	}

	public boolean unsetAdministrativeAreaName(AdministrativeAreaName administrativeAreaName) {
		return isSetAdministrativeAreaName() ? this.administrativeAreaName.remove(administrativeAreaName) : false;
	}

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetLocality() {
		if (isSetLocality())
			locality.unsetParent();

		locality = null;
	}

	public void unsetPostOffice() {
		if (isSetPostOffice())
			postOffice.unsetParent();

		postOffice = null;
	}

	public void unsetPostalCode() {
		if (isSetPostalCode())
			postalCode.unsetParent();

		postalCode = null;
	}

	public void unsetSubAdministrativeArea() {
		if (isSetSubAdministrativeArea())
			subAdministrativeArea.unsetParent();

		subAdministrativeArea = null;
	}

	public void unsetType() {
		type = null;
	}

	public void unsetUsageType() {
		usageType = null;
	}

	public XALClass getXALClass() {
		return XALClass.ADMINISTRATIVE_AREA;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new AdministrativeAreaImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AdministrativeArea copy = (target == null) ? new AdministrativeAreaImpl() : (AdministrativeArea)target;

		if (isSetType())
			copy.setType(copyBuilder.copy(type));

		if (isSetUsageType())
			copy.setUsageType(copyBuilder.copy(usageType));

		if (isSetIndicator())
			copy.setIndicator(copyBuilder.copy(indicator));

		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetAdministrativeAreaName()) {
			for (AdministrativeAreaName part : administrativeAreaName) {
				AdministrativeAreaName copyPart = (AdministrativeAreaName)copyBuilder.copy(part);
				copy.addAdministrativeAreaName(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetSubAdministrativeArea()) {
			copy.setSubAdministrativeArea((SubAdministrativeArea)copyBuilder.copy(subAdministrativeArea));
			if (copy.getSubAdministrativeArea() == subAdministrativeArea)
				subAdministrativeArea.setParent(this);
		}

		if (isSetLocality()) {
			copy.setLocality((Locality)copyBuilder.copy(locality));
			if (copy.getLocality() == locality)
				locality.setParent(this);
		}

		if (isSetPostOffice()) {
			copy.setPostOffice((PostOffice)copyBuilder.copy(postOffice));
			if (copy.getPostOffice() == postOffice)
				postOffice.setParent(this);
		}

		if (isSetPostalCode()) {
			copy.setPostalCode((PostalCode)copyBuilder.copy(postalCode));
			if (copy.getPostalCode() == postalCode)
				postalCode.setParent(this);
		}

		copy.unsetParent();

		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
