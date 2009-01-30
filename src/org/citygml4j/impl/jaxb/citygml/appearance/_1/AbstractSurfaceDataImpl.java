package org.citygml4j.impl.jaxb.citygml.appearance._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractFeatureImpl;
import org.citygml4j.jaxb.citygml.app._1.AbstractSurfaceDataType;
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
		return AppearanceModule.v1_0_0;
	}

	@Override
	public void calcBoundedBy() {
		// we do not need this here
	}

	@Override
	public void addGenericApplicationPropertyOfSurfaceData(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			abstractSurfaceDataType.get_GenericApplicationPropertyOfSurfaceData().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfSurfaceData() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : abstractSurfaceDataType.get_GenericApplicationPropertyOfSurfaceData()) {
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
			abstractSurfaceDataType.unset_GenericApplicationPropertyOfSurfaceData();
			abstractSurfaceDataType.get_GenericApplicationPropertyOfSurfaceData().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfSurfaceData() {
		return abstractSurfaceDataType.isSet_GenericApplicationPropertyOfSurfaceData();
	}

	@Override
	public boolean isSetIsFront() {
		return abstractSurfaceDataType.isSetIsFront();
	}

	@Override
	public void unsetGenericApplicationPropertyOfSurfaceData() {
		abstractSurfaceDataType.unset_GenericApplicationPropertyOfSurfaceData();
	}

	@Override
	public void unsetIsFront() {
		abstractSurfaceDataType.setIsFront(null);
	}
	
	@Override
	public boolean unsetGenericApplicationPropertyOfSurfaceData(ADEComponent adeObject) {
		if (abstractSurfaceDataType.isSet_GenericApplicationPropertyOfSurfaceData()) {
			Iterator<JAXBElement<?>> iter = abstractSurfaceDataType.get_GenericApplicationPropertyOfSurfaceData().iterator();
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
