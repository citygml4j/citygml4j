package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.RoofSurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.RoofSurface;

public class RoofSurfaceImpl extends BoundarySurfaceImpl implements RoofSurface {
	private RoofSurfaceType roofSurfaceType;

	public RoofSurfaceImpl() {
		this(new RoofSurfaceType());
	}

	public RoofSurfaceImpl(RoofSurfaceType roofSurfaceType) {
		super(roofSurfaceType);
		this.roofSurfaceType = roofSurfaceType;
	}

	@Override
	public RoofSurfaceType getJAXBObject() {
		return roofSurfaceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ROOFSURFACE;
	}

	@Override
	public void addGenericApplicationPropertyOfRoofSurface(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			roofSurfaceType.get_GenericApplicationPropertyOfRoofSurface().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfRoofSurface() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = roofSurfaceType.get_GenericApplicationPropertyOfRoofSurface();

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
	public void setGenericApplicationPropertyOfRoofSurface(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			roofSurfaceType.unset_GenericApplicationPropertyOfRoofSurface();
			roofSurfaceType.get_GenericApplicationPropertyOfRoofSurface().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfRoofSurface() {
		return roofSurfaceType.isSet_GenericApplicationPropertyOfRoofSurface();
	}

	@Override
	public void unsetGenericApplicationPropertyOfRoofSurface() {
		roofSurfaceType.unset_GenericApplicationPropertyOfRoofSurface();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfRoofSurface(ADEComponent adeObject) {
		if (roofSurfaceType.isSet_GenericApplicationPropertyOfRoofSurface()) {
			Iterator<JAXBElement<?>> iter = roofSurfaceType.get_GenericApplicationPropertyOfRoofSurface().iterator();
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
