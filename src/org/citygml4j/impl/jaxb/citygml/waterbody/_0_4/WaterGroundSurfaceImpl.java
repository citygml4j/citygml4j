package org.citygml4j.impl.jaxb.citygml.waterbody._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.WaterGroundSurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;

public class WaterGroundSurfaceImpl extends WaterBoundarySurfaceImpl implements WaterGroundSurface {
	private WaterGroundSurfaceType waterGroundSurfaceType;

	public WaterGroundSurfaceImpl() {
		this(new WaterGroundSurfaceType());
	}

	public WaterGroundSurfaceImpl(WaterGroundSurfaceType waterGroundSurfaceType) {
		super(waterGroundSurfaceType);
		this.waterGroundSurfaceType = waterGroundSurfaceType;
	}

	@Override
	public WaterGroundSurfaceType getJAXBObject() {
		return waterGroundSurfaceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATERGROUNDSURFACE;
	}

	@Override
	public void addGenericApplicationPropertyOfWaterGroundSurface(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			waterGroundSurfaceType.get_GenericApplicationPropertyOfWaterGroundSurface().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfWaterGroundSurface() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : waterGroundSurfaceType.get_GenericApplicationPropertyOfWaterGroundSurface()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfWaterGroundSurface(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			waterGroundSurfaceType.unset_GenericApplicationPropertyOfWaterGroundSurface();
			waterGroundSurfaceType.get_GenericApplicationPropertyOfWaterGroundSurface().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfWaterGroundSurface() {
		return waterGroundSurfaceType.isSet_GenericApplicationPropertyOfWaterGroundSurface();
	}

	@Override
	public void unsetGenericApplicationPropertyOfWaterGroundSurface() {
		waterGroundSurfaceType.unset_GenericApplicationPropertyOfWaterGroundSurface();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfWaterGroundSurface(ADEComponent adeObject) {
		if (waterGroundSurfaceType.isSet_GenericApplicationPropertyOfWaterGroundSurface()) {
			Iterator<JAXBElement<?>> iter = waterGroundSurfaceType.get_GenericApplicationPropertyOfWaterGroundSurface().iterator();
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
