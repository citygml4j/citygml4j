package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.xal.AddressDetails;

public class XalAddressPropertyImpl implements XalAddressProperty {
	private AddressDetails addressDetails;
	private CoreModule module;
	private Object parent;

	public XalAddressPropertyImpl() {
		
	}
	
	public XalAddressPropertyImpl(CoreModule module) {
		this.module = module;
	}
	
	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public boolean isSetAddressDetails() {
		return addressDetails != null;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		if (addressDetails != null)
			addressDetails.setParent(this);

		this.addressDetails = addressDetails;
	}

	public void unsetAddressDetails() {
		if (isSetAddressDetails())
			addressDetails.unsetParent();

		addressDetails = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.XALADDRESSPROPERTYTYPE;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
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
		return copyTo(new XalAddressPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		XalAddressProperty copy = (target == null) ? new XalAddressPropertyImpl() : (XalAddressProperty)target;

		if (isSetAddressDetails()) {
			copy.setAddressDetails((AddressDetails)copyBuilder.copy(addressDetails));
			if (copy.getAddressDetails() == addressDetails)
				addressDetails.setParent(this);
		}

		copy.unsetParent();

		return copy;
	}

}
