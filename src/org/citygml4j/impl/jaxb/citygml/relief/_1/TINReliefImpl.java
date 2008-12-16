package org.citygml4j.impl.jaxb.citygml.relief._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml.dem._1.TINReliefType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.gml.TriangulatedSurface;

public class TINReliefImpl extends ReliefComponentImpl implements TINRelief {
	private TINReliefType tinReliefType;

	public TINReliefImpl() {
		this(new TINReliefType());
	}

	public TINReliefImpl(TINReliefType tinReliefType) {
		super(tinReliefType);
		this.tinReliefType = tinReliefType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TINRELIEF;
	}

	@Override
	public TINReliefType getJAXBObject() {
		return tinReliefType;
	}

	@Override
	public TinProperty getTin() {
		if (tinReliefType.isSetTin())
			return new TinPropertyImpl(tinReliefType.getTin());

		return null;
	}

	@Override
	public void setTin(TinProperty tin) {
		tinReliefType.setTin(((TinPropertyImpl)tin).getJAXBObject());
	}

	@Override
	public void calcBoundedBy() {
		super.calcBoundedBy();

		if (isSetTin()) {
			TinProperty tinProperty = getTin();

			if (tinProperty.isSetObject()) {
				TriangulatedSurface surface = tinProperty.getObject();

				if (surface != null)
					calcBoundedBy(surface);
			}
		}
	}

	@Override
	public void addGenericApplicationPropertyOfTinRelief(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			tinReliefType.get_GenericApplicationPropertyOfTinRelief().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfTinRelief() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = tinReliefType.get_GenericApplicationPropertyOfTinRelief();

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
	public void setGenericApplicationPropertyOfTinRelief(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			tinReliefType.unset_GenericApplicationPropertyOfTinRelief();
			tinReliefType.get_GenericApplicationPropertyOfTinRelief().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfTinRelief() {
		return tinReliefType.isSet_GenericApplicationPropertyOfTinRelief();
	}

	@Override
	public boolean isSetTin() {
		return tinReliefType.isSetTin();
	}

	@Override
	public void unsetGenericApplicationPropertyOfTinRelief() {
		tinReliefType.unset_GenericApplicationPropertyOfTinRelief();
	}

	@Override
	public void unsetTin() {
		tinReliefType.setTin(null);
	}
	
	@Override
	public boolean unsetGenericApplicationPropertyOfTinRelief(ADEComponent adeObject) {
		if (tinReliefType.isSet_GenericApplicationPropertyOfTinRelief()) {
			Iterator<JAXBElement<?>> iter = tinReliefType.get_GenericApplicationPropertyOfTinRelief().iterator();
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
