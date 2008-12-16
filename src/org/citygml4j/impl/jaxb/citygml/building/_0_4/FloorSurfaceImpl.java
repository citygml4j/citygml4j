package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.FloorSurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.FloorSurface;

public class FloorSurfaceImpl extends BoundarySurfaceImpl implements FloorSurface {
	private FloorSurfaceType floorSurfaceType;

	public FloorSurfaceImpl() {
		this(new FloorSurfaceType());
	}

	public FloorSurfaceImpl(FloorSurfaceType floorSurfaceType) {
		super(floorSurfaceType);
		this.floorSurfaceType = floorSurfaceType;
	}

	@Override
	public FloorSurfaceType getJAXBObject() {
		return floorSurfaceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.FLOORSURFACE;
	}

	@Override
	public void addGenericApplicationPropertyOfFloorSurface(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			floorSurfaceType.get_GenericApplicationPropertyOfFloorSurface().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfFloorSurface() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = floorSurfaceType.get_GenericApplicationPropertyOfFloorSurface();

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
	public void setGenericApplicationPropertyOfFloorSurface(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			floorSurfaceType.unset_GenericApplicationPropertyOfFloorSurface();
			floorSurfaceType.get_GenericApplicationPropertyOfFloorSurface().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfFloorSurface() {
		return floorSurfaceType.isSet_GenericApplicationPropertyOfFloorSurface();
	}

	@Override
	public void unsetGenericApplicationPropertyOfFloorSurface() {
		floorSurfaceType.unset_GenericApplicationPropertyOfFloorSurface();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfFloorSurface(ADEComponent adeObject) {
		if (floorSurfaceType.isSet_GenericApplicationPropertyOfFloorSurface()) {
			Iterator<JAXBElement<?>> iter = floorSurfaceType.get_GenericApplicationPropertyOfFloorSurface().iterator();
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
