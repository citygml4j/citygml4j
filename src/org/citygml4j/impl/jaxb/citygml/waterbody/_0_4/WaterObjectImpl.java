package org.citygml4j.impl.jaxb.citygml.waterbody._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.jaxb.citygml._0_4._WaterObjectType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.WaterBodyModule;
import org.citygml4j.model.citygml.waterbody.WaterObject;

public abstract class WaterObjectImpl extends CityObjectImpl implements WaterObject {
	private _WaterObjectType waterObjectType;

	public WaterObjectImpl(_WaterObjectType waterObjectType) {
		super(waterObjectType);
		this.waterObjectType = waterObjectType;
	}

	@Override
	public _WaterObjectType getJAXBObject() {
		return waterObjectType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATEROBJECT;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return WaterBodyModule.v0_4_0;
	}

	@Override
	public void addGenericApplicationPropertyOfWaterObject(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			waterObjectType.get_GenericApplicationPropertyOfWaterObject().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfWaterObject() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = waterObjectType.get_GenericApplicationPropertyOfWaterObject();

		for (JAXBElement<?> elem : elemList) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfWaterObject(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			waterObjectType.unset_GenericApplicationPropertyOfWaterObject();
			waterObjectType.get_GenericApplicationPropertyOfWaterObject().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfWaterObject() {
		return waterObjectType.isSet_GenericApplicationPropertyOfWaterObject();
	}

	@Override
	public void unsetGenericApplicationPropertyOfWaterObject() {
		waterObjectType.unset_GenericApplicationPropertyOfWaterObject();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfWaterObject(ADEComponent adeObject) {
		if (waterObjectType.isSet_GenericApplicationPropertyOfWaterObject()) {
			Iterator<JAXBElement<?>> iter = waterObjectType.get_GenericApplicationPropertyOfWaterObject().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue().equals(adeObject.getJAXBObject())) {
					iter.remove();
					return true;
				}
			}				
		}

		return false;
	}

	
}
