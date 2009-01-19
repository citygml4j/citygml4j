package org.citygml4j.impl.jaxb.citygml.waterbody._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.WaterSurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.WaterSurface;

public class WaterSurfaceImpl extends WaterBoundarySurfaceImpl implements WaterSurface {
	private WaterSurfaceType waterSurfaceType;

	public WaterSurfaceImpl() {
		this(new WaterSurfaceType());
	}

	public WaterSurfaceImpl(WaterSurfaceType waterSurfaceType) {
		super(waterSurfaceType);
		this.waterSurfaceType = waterSurfaceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATERSURFACE;
	}

	@Override
	public String getWaterLevel() {
		return waterSurfaceType.getWaterLevel();
	}

	@Override
	public void setWaterLevel(String waterLevel) {
		waterSurfaceType.setWaterLevel(waterLevel);
	}

	@Override
	public WaterSurfaceType getJAXBObject() {
		return waterSurfaceType;
	}

	@Override
	public void addGenericApplicationPropertyOfWaterSurface(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			waterSurfaceType.get_GenericApplicationPropertyOfWaterSurface().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfWaterSurface() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : waterSurfaceType.get_GenericApplicationPropertyOfWaterSurface()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfWaterSurface(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			waterSurfaceType.unset_GenericApplicationPropertyOfWaterSurface();
			waterSurfaceType.get_GenericApplicationPropertyOfWaterSurface().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfWaterSurface() {
		return waterSurfaceType.isSet_GenericApplicationPropertyOfWaterSurface();
	}

	@Override
	public boolean isSetWaterLevel() {
		return waterSurfaceType.isSetWaterLevel();
	}

	@Override
	public void unsetGenericApplicationPropertyOfWaterSurface() {
		waterSurfaceType.unset_GenericApplicationPropertyOfWaterSurface();
	}

	@Override
	public void unsetWaterLevel() {
		waterSurfaceType.setWaterLevel(null);
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfWaterSurface(ADEComponent adeObject) {
		if (waterSurfaceType.isSet_GenericApplicationPropertyOfWaterSurface()) {
			Iterator<JAXBElement<?>> iter = waterSurfaceType.get_GenericApplicationPropertyOfWaterSurface().iterator();
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
