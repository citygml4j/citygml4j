package org.citygml4j.impl.jaxb.citygml.relief._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._1.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.PolygonPropertyImpl;
import org.citygml4j.jaxb.citygml.dem._1.AbstractReliefComponentType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefModule;
import org.citygml4j.model.gml.PolygonProperty;

public abstract class ReliefComponentImpl extends CityObjectImpl implements ReliefComponent {
	private AbstractReliefComponentType reliefComponentType;

	public ReliefComponentImpl(AbstractReliefComponentType reliefComponentType) {
		super(reliefComponentType);
		this.reliefComponentType = reliefComponentType;
	}

	@Override
	public AbstractReliefComponentType getJAXBObject() {
		return reliefComponentType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RELIEFCOMPONENT;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return ReliefModule.v1_0_0;
	}

	public PolygonProperty getExtent() {
		if (reliefComponentType.isSetExtent())
			return new PolygonPropertyImpl(reliefComponentType.getExtent());

		return null;
	}

	public int getLod() {
		return reliefComponentType.getLod();
	}

	public void setExtent(PolygonProperty extent) {
		reliefComponentType.setExtent(((PolygonPropertyImpl)extent).getJAXBObject());
	}

	public void setLod(int lod) {
		reliefComponentType.setLod(lod);
	}

	@Override
	public void calcBoundedBy() {
		if (isSetExtent()) {
			PolygonProperty property = getExtent();
			if (property.isSetPolygon())
				calcBoundedBy(property.getPolygon());
		}	
	}

	public void addGenericApplicationPropertyOfReliefComponent(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			reliefComponentType.get_GenericApplicationPropertyOfReliefComponent().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfReliefComponent() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : reliefComponentType.get_GenericApplicationPropertyOfReliefComponent()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfReliefComponent(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			reliefComponentType.unset_GenericApplicationPropertyOfReliefComponent();
			reliefComponentType.get_GenericApplicationPropertyOfReliefComponent().addAll(elemList);
		}
	}

	public boolean isSetExtent() {
		return reliefComponentType.isSetExtent();
	}

	public boolean isSetGenericApplicationPropertyOfReliefComponent() {
		return reliefComponentType.isSet_GenericApplicationPropertyOfReliefComponent();
	}

	public boolean isSetLod() {
		return reliefComponentType.isSetLod();
	}

	public void unsetExtent() {
		reliefComponentType.setExtent(null);
	}

	public void unsetGenericApplicationPropertyOfReliefComponent() {
		reliefComponentType.unset_GenericApplicationPropertyOfReliefComponent();
	}
	
	public boolean unsetGenericApplicationPropertyOfReliefComponent(ADEComponent adeObject) {
		if (reliefComponentType.isSet_GenericApplicationPropertyOfReliefComponent()) {
			Iterator<JAXBElement<?>> iter = reliefComponentType.get_GenericApplicationPropertyOfReliefComponent().iterator();
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
