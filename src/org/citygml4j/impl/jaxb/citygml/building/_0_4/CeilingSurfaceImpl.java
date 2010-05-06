package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.CeilingSurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.CeilingSurface;

public class CeilingSurfaceImpl extends BoundarySurfaceImpl implements CeilingSurface {
	private CeilingSurfaceType ceilingSurfaceType;

	public CeilingSurfaceImpl() {
		this(new CeilingSurfaceType());
	}

	public CeilingSurfaceImpl(CeilingSurfaceType ceilingSurfaceType) {
		super(ceilingSurfaceType);
		this.ceilingSurfaceType = ceilingSurfaceType;
	}

	@Override
	public CeilingSurfaceType getJAXBObject() {
		return ceilingSurfaceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CEILINGSURFACE;
	}

	public void addGenericApplicationPropertyOfCeilingSurface(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			ceilingSurfaceType.get_GenericApplicationPropertyOfCeilingSurface().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfCeilingSurface() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : ceilingSurfaceType.get_GenericApplicationPropertyOfCeilingSurface()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfCeilingSurface(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			ceilingSurfaceType.unset_GenericApplicationPropertyOfCeilingSurface();
			ceilingSurfaceType.get_GenericApplicationPropertyOfCeilingSurface().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfCeilingSurface() {
		return ceilingSurfaceType.isSet_GenericApplicationPropertyOfCeilingSurface();
	}

	public void unsetGenericApplicationPropertyOfCeilingSurface() {
		ceilingSurfaceType.unset_GenericApplicationPropertyOfCeilingSurface();
	}

	public boolean unsetGenericApplicationPropertyOfCeilingSurface(ADEComponent adeObject) {
		if (ceilingSurfaceType.isSet_GenericApplicationPropertyOfCeilingSurface()) {
			Iterator<JAXBElement<?>> iter = ceilingSurfaceType.get_GenericApplicationPropertyOfCeilingSurface().iterator();
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
