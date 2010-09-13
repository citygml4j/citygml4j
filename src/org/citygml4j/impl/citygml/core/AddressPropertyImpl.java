package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.CoreModule;

public class AddressPropertyImpl extends FeaturePropertyImpl<Address> implements AddressProperty {
	private CoreModule module;
	
	public AddressPropertyImpl() {
		
	}
	
	public AddressPropertyImpl(CoreModule module) {
		this.module = module;
	}
	
	public Address getAddress() {
		return super.getObject();
	}

	public boolean isSetAddress() {
		return super.isSetObject();
	}

	public void setAddress(Address address) {
		super.setObject(address);
	}

	public void unsetAddress() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADDRESS_PROPERTY;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new AddressPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AddressProperty copy = (target == null) ? new AddressPropertyImpl() : (AddressProperty)target;
		return super.copyTo(copy, copyBuilder);		
	}

}
