package org.citygml4j.impl.jaxb.citygml.waterbody._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SurfacePropertyImpl;
import org.citygml4j.jaxb.citygml._0_4._WaterBoundarySurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.WaterBodyModule;
import org.citygml4j.model.citygml.waterbody.WaterBoundarySurface;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.SurfaceProperty;

public abstract class WaterBoundarySurfaceImpl extends CityObjectImpl implements WaterBoundarySurface {
	private _WaterBoundarySurfaceType waterBoundarySurfaceType;

	public WaterBoundarySurfaceImpl(_WaterBoundarySurfaceType waterBoundarySurfaceType) {
		super(waterBoundarySurfaceType);
		this.waterBoundarySurfaceType = waterBoundarySurfaceType;
	}

	@Override
	public _WaterBoundarySurfaceType getJAXBObject() {
		return waterBoundarySurfaceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATERBOUNDARYSURFACE;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return WaterBodyModule.v0_4_0;
	}

	public SurfaceProperty getLod2Surface() {
		if (waterBoundarySurfaceType.isSetLod2Surface())
			return new SurfacePropertyImpl(waterBoundarySurfaceType.getLod2Surface());

		return null;
	}

	public SurfaceProperty getLod3Surface() {
		if (waterBoundarySurfaceType.isSetLod3Surface())
			return new SurfacePropertyImpl(waterBoundarySurfaceType.getLod3Surface());

		return null;
	}

	public SurfaceProperty getLod4Surface() {
		if (waterBoundarySurfaceType.isSetLod4Surface())
			return new SurfacePropertyImpl(waterBoundarySurfaceType.getLod4Surface());

		return null;
	}

	public void setLod2Surface(SurfaceProperty lod2Surface) {
		waterBoundarySurfaceType.setLod2Surface(((SurfacePropertyImpl)lod2Surface).getJAXBObject());
	}

	public void setLod3Surface(SurfaceProperty lod3Surface) {
		waterBoundarySurfaceType.setLod3Surface(((SurfacePropertyImpl)lod3Surface).getJAXBObject());
	}

	public void setLod4Surface(SurfaceProperty lod4Surface) {
		waterBoundarySurfaceType.setLod4Surface(((SurfacePropertyImpl)lod4Surface).getJAXBObject());
	}

	@Override
	public void calcBoundedBy() {
		SurfaceProperty surfaceProperty = null;

		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				surfaceProperty = getLod2Surface();
				break;
			case 3:
				surfaceProperty = getLod3Surface();
				break;
			case 4:
				surfaceProperty = getLod4Surface();
				break;
			}

			if (surfaceProperty != null) {
				AbstractSurface abstractSurface = surfaceProperty.getSurface();
				if (abstractSurface != null) {
					calcBoundedBy(abstractSurface);
				} else {
					// xlink?
				}
			}
		}
	}

	public void addGenericApplicationPropertyOfWaterBoundarySurface(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			waterBoundarySurfaceType.get_GenericApplicationPropertyOfWaterBoundarySurface().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWaterBoundarySurface() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : waterBoundarySurfaceType.get_GenericApplicationPropertyOfWaterBoundarySurface()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfWaterBoundarySurface(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			waterBoundarySurfaceType.unset_GenericApplicationPropertyOfWaterBoundarySurface();
			waterBoundarySurfaceType.get_GenericApplicationPropertyOfWaterBoundarySurface().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfWaterBoundarySurface() {
		return waterBoundarySurfaceType.isSet_GenericApplicationPropertyOfWaterBoundarySurface();
	}

	public boolean isSetLod2Surface() {
		return waterBoundarySurfaceType.isSetLod2Surface();
	}

	public boolean isSetLod3Surface() {
		return waterBoundarySurfaceType.isSetLod3Surface();
	}

	public boolean isSetLod4Surface() {
		return waterBoundarySurfaceType.isSetLod4Surface();
	}

	public void unsetGenericApplicationPropertyOfWaterBoundarySurface() {
		waterBoundarySurfaceType.unset_GenericApplicationPropertyOfWaterBoundarySurface();
	}

	public void unsetLod2Surface() {
		waterBoundarySurfaceType.setLod2Surface(null);
	}

	public void unsetLod3Surface() {
		waterBoundarySurfaceType.setLod3Surface(null);
	}

	public void unsetLod4Surface() {
		waterBoundarySurfaceType.setLod4Surface(null);
	}

	public boolean unsetGenericApplicationPropertyOfWaterBoundarySurface(ADEComponent adeObject) {
		if (waterBoundarySurfaceType.isSet_GenericApplicationPropertyOfWaterBoundarySurface()) {
			Iterator<JAXBElement<?>> iter = waterBoundarySurfaceType.get_GenericApplicationPropertyOfWaterBoundarySurface().iterator();
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
