package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractFeatureImpl;
import org.citygml4j.jaxb.citygml._0_4.AbstractSurfaceDataType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AppearanceModule;

public abstract class AbstractSurfaceDataImpl extends AbstractFeatureImpl implements AbstractSurfaceData {
	private AbstractSurfaceDataType abstractSurfaceDataType;

	public AbstractSurfaceDataImpl(AbstractSurfaceDataType abstractSurfaceDataType) {
		super(abstractSurfaceDataType);
		this.abstractSurfaceDataType = abstractSurfaceDataType;
	}

	@Override
	public AbstractSurfaceDataType getJAXBObject() {
		return abstractSurfaceDataType;
	}

	@Override
	public Boolean getIsFront() {
		return abstractSurfaceDataType.isIsFront();
	}

	@Override
	public void setIsFront(Boolean isFront) {
		abstractSurfaceDataType.setIsFront(isFront);
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ABSTRACTSURFACEDATA;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v0_4_0;
	}

	@Override
	public void calcBoundedBy() {
		// we do not need this here
	}

	@Override
	public void addGenericApplicationPropertyOfSurfaceData(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			abstractSurfaceDataType.get_GenericApplicationPropertyOfAbstractSurfaceData().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfSurfaceData() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : abstractSurfaceDataType.get_GenericApplicationPropertyOfAbstractSurfaceData()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfSurfaceData(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			abstractSurfaceDataType.unset_GenericApplicationPropertyOfAbstractSurfaceData();
			abstractSurfaceDataType.get_GenericApplicationPropertyOfAbstractSurfaceData().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfSurfaceData() {
		return abstractSurfaceDataType.isSet_GenericApplicationPropertyOfAbstractSurfaceData();
	}

	@Override
	public boolean isSetIsFront() {
		return abstractSurfaceDataType.isSetIsFront();
	}

	@Override
	public void unsetGenericApplicationPropertyOfSurfaceData() {
		abstractSurfaceDataType.unset_GenericApplicationPropertyOfAbstractSurfaceData();
	}

	@Override
	public void unsetIsFront() {
		abstractSurfaceDataType.setIsFront(null);
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfSurfaceData(ADEComponent adeObject) {
		if (abstractSurfaceDataType.isSet_GenericApplicationPropertyOfAbstractSurfaceData()) {
			Iterator<JAXBElement<?>> iter = abstractSurfaceDataType.get_GenericApplicationPropertyOfAbstractSurfaceData().iterator();
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
