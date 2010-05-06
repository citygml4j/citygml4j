package org.citygml4j.impl.jaxb.citygml.building._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._1.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.jaxb.citygml.bldg._1.AbstractOpeningType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.building.Opening;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;

public abstract class OpeningImpl extends CityObjectImpl implements Opening {
	private AbstractOpeningType openingType;

	public OpeningImpl(AbstractOpeningType openingType) {
		super(openingType);
		this.openingType = openingType;
	}

	@Override
	public AbstractOpeningType getJAXBObject() {
		return openingType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.OPENING;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v1_0_0;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		if (openingType.isSetLod3MultiSurface())
			return new MultiSurfacePropertyImpl(openingType.getLod3MultiSurface());

		return null;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		if (openingType.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(openingType.getLod4MultiSurface());

		return null;
	}

	@Override
	public void calcBoundedBy() {
		MultiSurfaceProperty multiSurfaceProperty = null;

		for (int lod = 3; lod < 5; lod++) {
			switch (lod) {
			case 3:
				multiSurfaceProperty = getLod3MultiSurface();
				break;
			case 4:
				multiSurfaceProperty = getLod4MultiSurface();
				break;
			}

			if (multiSurfaceProperty != null) {
				MultiSurface multiSurface = multiSurfaceProperty.getMultiSurface();
				if (multiSurface != null) {
					calcBoundedBy(multiSurface);
				} else {
					// xlink?
				}
			}
		}
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		openingType.setLod3MultiSurface(((MultiSurfacePropertyImpl)lod3MultiSurface).getJAXBObject());
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		openingType.setLod4MultiSurface(((MultiSurfacePropertyImpl)lod4MultiSurface).getJAXBObject());
	}

	public void addGenericApplicationPropertyOfOpening(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			openingType.get_GenericApplicationPropertyOfOpening().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfOpening() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : openingType.get_GenericApplicationPropertyOfOpening()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfOpening(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			openingType.unset_GenericApplicationPropertyOfOpening();
			openingType.get_GenericApplicationPropertyOfOpening().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfOpening() {
		return openingType.isSet_GenericApplicationPropertyOfOpening();
	}

	public boolean isSetLod3MultiSurface() {
		return openingType.isSetLod3MultiSurface();
	}

	public boolean isSetLod4MultiSurface() {
		return openingType.isSetLod4MultiSurface();
	}

	public void unsetGenericApplicationPropertyOfOpening() {
		openingType.unset_GenericApplicationPropertyOfOpening();
	}

	public void unsetLod3MultiSurface() {
		openingType.setLod3MultiSurface(null);
	}

	public void unsetLod4MultiSurface() {
		openingType.setLod4MultiSurface(null);
	}

	public boolean unsetGenericApplicationPropertyOfOpening(ADEComponent adeObject) {
		if (openingType.isSet_GenericApplicationPropertyOfOpening()) {
			Iterator<JAXBElement<?>> iter = openingType.get_GenericApplicationPropertyOfOpening().iterator();
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
