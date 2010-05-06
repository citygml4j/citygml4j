package org.citygml4j.impl.jaxb.citygml.core._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractFeatureImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiPointPropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.AddressType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.gml.MultiPointProperty;

public class AddressImpl extends AbstractFeatureImpl implements	Address {
	private AddressType addressType;

	public AddressImpl() {
		this(new AddressType());
	}

	public AddressImpl(AddressType addressType) {
		super(addressType);
		this.addressType = addressType;
	}

	@Override
	public AddressType getJAXBObject() {
		return addressType;
	}

	public MultiPointProperty getMultiPoint() {
		if (addressType.isSetMultiPoint())
			return new MultiPointPropertyImpl(addressType.getMultiPoint());

		return null;
	}

	public XalAddressProperty getXalAddress() {
		if (addressType.isSetXalAddress())
			return new XalAddressPropertyImpl(addressType.getXalAddress());

		return null;
	}

	public void setMultiPoint(MultiPointProperty multiPoint) {
		addressType.setMultiPoint(((MultiPointPropertyImpl)multiPoint).getJAXBObject());
	}

	public void setXalAddress(XalAddressProperty xalAddressProperty) {
		addressType.setXalAddress(((XalAddressPropertyImpl)xalAddressProperty).getJAXBObject());
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADDRESS;
	}

	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v0_4_0;
	}

	@Override
	public void calcBoundedBy() {
		// we don't need that here
	}

	public void addGenericApplicationPropertyOfAddress(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			addressType.get_GenericApplicationPropertyOfAddress().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAddress() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : addressType.get_GenericApplicationPropertyOfAddress()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfAddress(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			addressType.unset_GenericApplicationPropertyOfAddress();
			addressType.get_GenericApplicationPropertyOfAddress().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfAddress() {
		return addressType.isSet_GenericApplicationPropertyOfAddress();
	}

	public boolean isSetMultiPoint() {
		return addressType.isSetMultiPoint();
	}

	public boolean isSetXalAddress() {
		return addressType.isSetXalAddress();
	}

	public void unsetGenericApplicationPropertyOfAddress() {
		addressType.unset_GenericApplicationPropertyOfAddress();
	}

	public void unsetMultiPoint() {
		addressType.setMultiPoint(null);
	}

	public void unsetXalAddress() {
		addressType.setXalAddress(null);
	}

	public boolean unsetGenericApplicationPropertyOfAddress(ADEComponent adeObject) {
		if (addressType.isSet_GenericApplicationPropertyOfAddress()) {
			Iterator<JAXBElement<?>> iter = addressType.get_GenericApplicationPropertyOfAddress().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}

		return false;
	}

}
