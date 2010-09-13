package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.xal.AddressDetails;

public class XalAddressPropertyImpl extends AssociationByRepImpl<AddressDetails> implements XalAddressProperty {
	private CoreModule module;

	public XalAddressPropertyImpl() {
		
	}
	
	public XalAddressPropertyImpl(CoreModule module) {
		this.module = module;
	}
	
	public AddressDetails getAddressDetails() {
		return super.getObject();
	}

	public boolean isSetAddressDetails() {
		return super.isSetObject();
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		super.setObject(addressDetails);
	}

	public void unsetAddressDetails() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.XAL_ADDRESS_PROPERTY_TYPE;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new XalAddressPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		XalAddressProperty copy = (target == null) ? new XalAddressPropertyImpl() : (XalAddressProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
