package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.OpeningPropertyType;
import org.citygml4j.jaxb.citygml._0_4._BoundarySurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BoundarySurface;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;

public abstract class BoundarySurfaceImpl extends CityObjectImpl implements BoundarySurface {
	private _BoundarySurfaceType boundarySurfaceType;

	public BoundarySurfaceImpl(_BoundarySurfaceType boundarySurfaceType) {
		super(boundarySurfaceType);
		this.boundarySurfaceType = boundarySurfaceType;
	}

	@Override
	public _BoundarySurfaceType getJAXBObject() {
		return boundarySurfaceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BOUNDARYSURFACE;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v0_4_0;
	}

	public MultiSurfaceProperty getLod2MultiSurface() {
		if (boundarySurfaceType.isSetLod2MultiSurface())
			return new MultiSurfacePropertyImpl(boundarySurfaceType.getLod2MultiSurface());

		return null;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		if (boundarySurfaceType.isSetLod3MultiSurface())
			return new MultiSurfacePropertyImpl(boundarySurfaceType.getLod3MultiSurface());

		return null;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		if (boundarySurfaceType.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(boundarySurfaceType.getLod4MultiSurface());

		return null;
	}

	public List<OpeningProperty> getOpening() {
		List<OpeningProperty> openingPropertyList = new ArrayList<OpeningProperty>();

		for (OpeningPropertyType openingPropertyType : boundarySurfaceType.getOpening())
			openingPropertyList.add(new OpeningPropertyImpl(openingPropertyType));

		return openingPropertyList;
	}

	@Override
	public void calcBoundedBy() {
		MultiSurfaceProperty multiSurfaceProperty = null;

		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				multiSurfaceProperty = getLod2MultiSurface();
				break;
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

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		boundarySurfaceType.setLod2MultiSurface(((MultiSurfacePropertyImpl)lod2MultiSurface).getJAXBObject());
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		boundarySurfaceType.setLod3MultiSurface(((MultiSurfacePropertyImpl)lod3MultiSurface).getJAXBObject());
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		boundarySurfaceType.setLod4MultiSurface(((MultiSurfacePropertyImpl)lod4MultiSurface).getJAXBObject());
	}

	public void addOpening(OpeningProperty opening) {
		boundarySurfaceType.getOpening().add(((OpeningPropertyImpl)opening).getJAXBObject());
	}

	public void setOpening(List<OpeningProperty> opening) {
		List<OpeningPropertyType> openingPropertyTypeList = new ArrayList<OpeningPropertyType>();

		for (OpeningProperty openingProperty : opening)
			openingPropertyTypeList.add(((OpeningPropertyImpl)openingProperty).getJAXBObject());

		boundarySurfaceType.unsetOpening();
		boundarySurfaceType.getOpening().addAll(openingPropertyTypeList);
	}

	public void addGenericApplicationPropertyOfBoundarySurface(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			boundarySurfaceType.get_GenericApplicationPropertyOfBoundarySurface().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfBoundarySurface() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : boundarySurfaceType.get_GenericApplicationPropertyOfBoundarySurface()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfBoundarySurface(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			boundarySurfaceType.unset_GenericApplicationPropertyOfBoundarySurface();
			boundarySurfaceType.get_GenericApplicationPropertyOfBoundarySurface().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfBoundarySurface() {
		return boundarySurfaceType.isSet_GenericApplicationPropertyOfBoundarySurface();
	}

	public boolean isSetLod2MultiSurface() {
		return boundarySurfaceType.isSetLod2MultiSurface();
	}

	public boolean isSetLod3MultiSurface() {
		return boundarySurfaceType.isSetLod3MultiSurface();
	}

	public boolean isSetLod4MultiSurface() {
		return boundarySurfaceType.isSetLod4MultiSurface();
	}

	public boolean isSetOpening() {
		return boundarySurfaceType.isSetOpening();
	}

	public void unsetGenericApplicationPropertyOfBoundarySurface() {
		boundarySurfaceType.unset_GenericApplicationPropertyOfBoundarySurface();
	}

	public void unsetLod2MultiSurface() {
		boundarySurfaceType.setLod2MultiSurface(null);
	}

	public void unsetLod3MultiSurface() {
		boundarySurfaceType.setLod3MultiSurface(null);
	}

	public void unsetLod4MultiSurface() {
		boundarySurfaceType.setLod4MultiSurface(null);
	}

	public void unsetOpening() {
		boundarySurfaceType.unsetOpening();
	}

	public boolean unsetGenericApplicationPropertyOfBoundarySurface(ADEComponent adeObject) {
		if (boundarySurfaceType.isSet_GenericApplicationPropertyOfBoundarySurface()) {
			Iterator<JAXBElement<?>> iter = boundarySurfaceType.get_GenericApplicationPropertyOfBoundarySurface().iterator();
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

	public boolean unsetOpening(OpeningProperty opening) {
		if (boundarySurfaceType.isSetOpening())
			return boundarySurfaceType.getOpening().remove(((OpeningPropertyImpl)opening).getJAXBObject());
		
		return false;
	}

}
