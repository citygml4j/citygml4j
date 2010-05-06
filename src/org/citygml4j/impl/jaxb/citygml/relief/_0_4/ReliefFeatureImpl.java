package org.citygml4j.impl.jaxb.citygml.relief._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.jaxb.citygml._0_4.ReliefComponentPropertyType;
import org.citygml4j.jaxb.citygml._0_4.ReliefFeatureType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.ReliefModule;

public class ReliefFeatureImpl extends CityObjectImpl implements ReliefFeature {
	private ReliefFeatureType reliefFeatureType;

	public ReliefFeatureImpl() {
		this(new ReliefFeatureType());
	}

	public ReliefFeatureImpl(ReliefFeatureType reliefFeatureType) {
		super(reliefFeatureType);
		this.reliefFeatureType = reliefFeatureType;
	}

	@Override
	public ReliefFeatureType getJAXBObject() {
		return reliefFeatureType;
	}

	public void addReliefComponent(ReliefComponentProperty reliefComponent) {
		reliefFeatureType.getReliefComponent().add(((ReliefComponentPropertyImpl)reliefComponent).getJAXBObject());
	}

	public int getLod() {
		return reliefFeatureType.getLod();
	}

	public List<ReliefComponentProperty> getReliefComponent() {
		List<ReliefComponentProperty> propertyList = new ArrayList<ReliefComponentProperty>();

		for (ReliefComponentPropertyType propertyType : reliefFeatureType.getReliefComponent())
			propertyList.add(new ReliefComponentPropertyImpl(propertyType));

		return propertyList;
	}

	public void setLod(int lod) {
		reliefFeatureType.setLod(lod);
	}

	public void setReliefComponent(List<ReliefComponentProperty> reliefComponent) {
		List<ReliefComponentPropertyType> propertyTypeList = new ArrayList<ReliefComponentPropertyType>();

		for (ReliefComponentProperty property : reliefComponent)
			propertyTypeList.add(((ReliefComponentPropertyImpl)property).getJAXBObject());

		reliefFeatureType.unsetReliefComponent();
		reliefFeatureType.getReliefComponent().addAll(propertyTypeList);
	}

	@Override
	public void calcBoundedBy() {
		if (isSetReliefComponent()) {
			for (ReliefComponentProperty property : getReliefComponent()) {
				if (property.isSetObject()) {
					calcBoundedBy(property.getObject());
				} else {
					// xlink?
				}
			}
		}
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RELIEFFEATURE;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return ReliefModule.v0_4_0;
	}

	public void addGenericApplicationPropertyOfReliefFeature(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			reliefFeatureType.get_GenericApplicationPropertyOfReliefFeature().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfReliefFeature() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : reliefFeatureType.get_GenericApplicationPropertyOfReliefFeature()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfReliefFeature(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			reliefFeatureType.unset_GenericApplicationPropertyOfReliefFeature();
			reliefFeatureType.get_GenericApplicationPropertyOfReliefFeature().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfReliefFeature() {
		return reliefFeatureType.isSet_GenericApplicationPropertyOfReliefFeature();
	}

	public boolean isSetLod() {
		return reliefFeatureType.isSetLod();
	}

	public boolean isSetReliefComponent() {
		return reliefFeatureType.isSetReliefComponent();
	}

	public void unsetGenericApplicationPropertyOfReliefFeature() {
		reliefFeatureType.unset_GenericApplicationPropertyOfReliefFeature();
	}

	public void unsetReliefComponent() {
		reliefFeatureType.unsetReliefComponent();
	}

	public boolean unsetGenericApplicationPropertyOfReliefFeature(ADEComponent adeObject) {
		if (reliefFeatureType.isSet_GenericApplicationPropertyOfReliefFeature()) {
			Iterator<JAXBElement<?>> iter = reliefFeatureType.get_GenericApplicationPropertyOfReliefFeature().iterator();
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

	public boolean unsetReliefComponent(ReliefComponentProperty reliefComponent) {
		if (reliefFeatureType.isSetReliefComponent())
			return reliefFeatureType.getReliefComponent().remove(((ReliefComponentPropertyImpl)reliefComponent).getJAXBObject());
			
		return false;
	}

}
