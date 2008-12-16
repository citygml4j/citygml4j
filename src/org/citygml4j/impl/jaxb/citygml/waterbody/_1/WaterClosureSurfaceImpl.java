package org.citygml4j.impl.jaxb.citygml.waterbody._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml.wtr._1.WaterClosureSurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;

public class WaterClosureSurfaceImpl extends WaterBoundarySurfaceImpl implements WaterClosureSurface {
	private WaterClosureSurfaceType waterClosureSurfaceType;

	public WaterClosureSurfaceImpl() {
		this(new WaterClosureSurfaceType());
	}

	public WaterClosureSurfaceImpl(WaterClosureSurfaceType waterClosureSurfaceType) {
		super(waterClosureSurfaceType);
		this.waterClosureSurfaceType = waterClosureSurfaceType;
	}

	@Override
	public WaterClosureSurfaceType getJAXBObject() {
		return waterClosureSurfaceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATERCLOSURESURFACE;
	}

	@Override
	public void addGenericApplicationPropertyOfWaterClosureSurface(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			waterClosureSurfaceType.get_GenericApplicationPropertyOfWaterClosureSurface().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfWaterClosureSurface() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = waterClosureSurfaceType.get_GenericApplicationPropertyOfWaterClosureSurface();

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
	public void setGenericApplicationPropertyOfWaterClosureSurface(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			waterClosureSurfaceType.unset_GenericApplicationPropertyOfWaterClosureSurface();
			waterClosureSurfaceType.get_GenericApplicationPropertyOfWaterClosureSurface().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfWaterClosureSurface() {
		return waterClosureSurfaceType.isSet_GenericApplicationPropertyOfWaterClosureSurface();
	}

	@Override
	public void unsetGenericApplicationPropertyOfWaterClosureSurface() {
		waterClosureSurfaceType.unset_GenericApplicationPropertyOfWaterClosureSurface();
	}
	
	@Override
	public boolean unsetGenericApplicationPropertyOfWaterClosureSurface(ADEComponent adeObject) {
		if (waterClosureSurfaceType.isSet_GenericApplicationPropertyOfWaterClosureSurface()) {
			Iterator<JAXBElement<?>> iter = waterClosureSurfaceType.get_GenericApplicationPropertyOfWaterClosureSurface().iterator();
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
