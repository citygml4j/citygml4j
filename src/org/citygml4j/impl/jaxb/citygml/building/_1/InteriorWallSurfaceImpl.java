package org.citygml4j.impl.jaxb.citygml.building._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml.bldg._1.InteriorWallSurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.InteriorWallSurface;

public class InteriorWallSurfaceImpl extends BoundarySurfaceImpl implements	InteriorWallSurface {
	private InteriorWallSurfaceType interiorWallSurfaceType;

	public InteriorWallSurfaceImpl() {
		this(new InteriorWallSurfaceType());
	}

	public InteriorWallSurfaceImpl(InteriorWallSurfaceType interiorWallSurfaceType) {
		super(interiorWallSurfaceType);
		this.interiorWallSurfaceType = interiorWallSurfaceType;
	}

	@Override
	public InteriorWallSurfaceType getJAXBObject() {
		return interiorWallSurfaceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIORWALLSURFACE;
	}

	@Override
	public void addGenericApplicationPropertyOfInteriorWallSurface(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			interiorWallSurfaceType.get_GenericApplicationPropertyOfInteriorWallSurface().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfInteriorWallSurface() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : interiorWallSurfaceType.get_GenericApplicationPropertyOfInteriorWallSurface()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfInteriorWallSurface(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			interiorWallSurfaceType.unset_GenericApplicationPropertyOfInteriorWallSurface();
			interiorWallSurfaceType.get_GenericApplicationPropertyOfInteriorWallSurface().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfInteriorWallSurface() {
		return interiorWallSurfaceType.isSet_GenericApplicationPropertyOfInteriorWallSurface();
	}

	@Override
	public void unsetGenericApplicationPropertyOfInteriorWallSurface() {
		interiorWallSurfaceType.unset_GenericApplicationPropertyOfInteriorWallSurface();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfInteriorWallSurface(ADEComponent adeObject) {
		if (interiorWallSurfaceType.isSet_GenericApplicationPropertyOfInteriorWallSurface()) {
			Iterator<JAXBElement<?>> iter = interiorWallSurfaceType.get_GenericApplicationPropertyOfInteriorWallSurface().iterator();
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
