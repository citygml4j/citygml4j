package org.citygml4j.impl.jaxb.citygml.relief._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiCurvePropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.BreaklineReliefType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.gml.MultiCurve;
import org.citygml4j.model.gml.MultiCurveProperty;

public class BreaklineReliefImpl extends ReliefComponentImpl implements BreaklineRelief {
	private BreaklineReliefType breaklineReliefType;

	public BreaklineReliefImpl() {
		this(new BreaklineReliefType());
	}

	public BreaklineReliefImpl(BreaklineReliefType breaklineReliefType) {
		super(breaklineReliefType);
		this.breaklineReliefType = breaklineReliefType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BREAKLINERELIEF;
	}

	@Override
	public BreaklineReliefType getJAXBObject() {
		return breaklineReliefType;
	}

	@Override
	public MultiCurveProperty getBreaklines() {
		if (breaklineReliefType.isSetBreaklines())
			return new MultiCurvePropertyImpl(breaklineReliefType.getBreaklines());

		return null;
	}

	@Override
	public MultiCurveProperty getRidgeOrValleyLines() {
		if (breaklineReliefType.isSetRidgeOrValleyLines())
			return new MultiCurvePropertyImpl(breaklineReliefType.getRidgeOrValleyLines());

		return null;
	}

	@Override
	public void setBreaklines(MultiCurveProperty breaklines) {
		breaklineReliefType.setBreaklines(((MultiCurvePropertyImpl)breaklines).getJAXBObject());
	}

	@Override
	public void setRidgeOrValleyLines(MultiCurveProperty ridgeOrValleyLines) {
		breaklineReliefType.setRidgeOrValleyLines(((MultiCurvePropertyImpl)ridgeOrValleyLines).getJAXBObject());
	}

	@Override
	public void calcBoundedBy() {
		super.calcBoundedBy();

		if (isSetBreaklines()) {
			MultiCurve multiCurve = getBreaklines().getMultiCurve();

			if (multiCurve != null)
				calcBoundedBy(multiCurve);
		}

		if (isSetRidgeOrValleyLines()) {
			MultiCurve multiCurve = getRidgeOrValleyLines().getMultiCurve();

			if (multiCurve != null)
				calcBoundedBy(multiCurve);
		}
	}

	@Override
	public void addGenericApplicationPropertyOfBreaklineRelief(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			breaklineReliefType.get_GenericApplicationPropertyOfBreaklineRelief().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfBreaklineRelief() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = breaklineReliefType.get_GenericApplicationPropertyOfBreaklineRelief();

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
	public void setGenericApplicationPropertyOfBreaklineRelief(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			breaklineReliefType.unset_GenericApplicationPropertyOfBreaklineRelief();
			breaklineReliefType.get_GenericApplicationPropertyOfBreaklineRelief().addAll(elemList);
		}
	}

	@Override
	public boolean isSetBreaklines() {
		return breaklineReliefType.isSetBreaklines();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfBreaklineRelief() {
		return breaklineReliefType.isSet_GenericApplicationPropertyOfBreaklineRelief();
	}

	@Override
	public boolean isSetRidgeOrValleyLines() {
		return breaklineReliefType.isSetRidgeOrValleyLines();
	}

	@Override
	public void unsetBreaklines() {
		breaklineReliefType.setBreaklines(null);
	}

	@Override
	public void unsetGenericApplicationPropertyOfBreaklineRelief() {
		breaklineReliefType.unset_GenericApplicationPropertyOfBreaklineRelief();
	}

	@Override
	public void unsetRidgeOrValleyLines() {
		breaklineReliefType.setRidgeOrValleyLines(null);
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfBreaklineRelief(ADEComponent adeObject) {
		if (breaklineReliefType.isSet_GenericApplicationPropertyOfBreaklineRelief()) {
			Iterator<JAXBElement<?>> iter = breaklineReliefType.get_GenericApplicationPropertyOfBreaklineRelief().iterator();
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
