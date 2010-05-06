package org.citygml4j.impl.jaxb.citygml.building._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._1.AddressPropertyImpl;
import org.citygml4j.jaxb.citygml.bldg._1.DoorType;
import org.citygml4j.jaxb.citygml.core._1.AddressPropertyType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.core.AddressProperty;

public class DoorImpl extends OpeningImpl implements Door {
	private DoorType doorType;

	public DoorImpl() {
		this(new DoorType());
	}

	public DoorImpl(DoorType doorType) {
		super(doorType);
		this.doorType = doorType;
	}

	@Override
	public DoorType getJAXBObject() {
		return doorType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.DOOR;
	}

	public void addAddress(AddressProperty address) {
		doorType.getAddress().add(((AddressPropertyImpl)address).getJAXBObject());
	}

	public List<AddressProperty> getAddress() {
		List<AddressProperty> addressPropertyList = new ArrayList<AddressProperty>();

		for (AddressPropertyType addressPropertyType : doorType.getAddress())
			addressPropertyList.add(new AddressPropertyImpl(addressPropertyType));

		return addressPropertyList;
	}

	public void setAddress(List<AddressProperty> address) {
		List<AddressPropertyType> addressPropertyTypeList = new ArrayList<AddressPropertyType>();

		for (AddressProperty addressProperty : address)
			addressPropertyTypeList.add(((AddressPropertyImpl)addressProperty).getJAXBObject());

		doorType.unsetAddress();
		doorType.getAddress().addAll(addressPropertyTypeList);
	}

	public void addGenericApplicationPropertyOfDoor(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			doorType.get_GenericApplicationPropertyOfDoor().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfDoor() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : doorType.get_GenericApplicationPropertyOfDoor()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfDoor(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			doorType.unset_GenericApplicationPropertyOfDoor();
			doorType.get_GenericApplicationPropertyOfDoor().addAll(elemList);
		}
	}

	public boolean isSetAddress() {
		return doorType.isSetAddress();
	}

	public boolean isSetGenericApplicationPropertyOfDoor() {
		return doorType.isSet_GenericApplicationPropertyOfDoor();
	}

	public void unsetAddress() {
		doorType.unsetAddress();
	}

	public void unsetGenericApplicationPropertyOfDoor() {
		doorType.unset_GenericApplicationPropertyOfDoor();
	}

	public boolean unsetAddress(AddressProperty address) {
		if (doorType.isSetAddress())
			return doorType.getAddress().remove(((AddressPropertyImpl)address).getJAXBObject());
		
		return false;
	}

	public boolean unsetGenericApplicationPropertyOfDoor(ADEComponent adeObject) {
		if (doorType.isSet_GenericApplicationPropertyOfDoor()) {
			Iterator<JAXBElement<?>> iter = doorType.get_GenericApplicationPropertyOfDoor().iterator();
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
