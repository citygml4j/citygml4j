package org.citygml4j.impl.jaxb.citygml.landuse._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.LandUseType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.landuse.LandUseModule;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;

public class LandUseImpl extends CityObjectImpl implements LandUse {
	private LandUseType landUseType;

	public LandUseImpl() {
		this(new LandUseType());
	}

	public LandUseImpl(LandUseType landUseType) {
		super(landUseType);
		this.landUseType = landUseType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.LANDUSE;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return LandUseModule.v0_4_0;
	}

	@Override
	public LandUseType getJAXBObject() {
		return landUseType;
	}


	@Override
	public String getClazz() {
		return landUseType.getClazz();
	}

	@Override
	public List<String> getFunction() {
		return landUseType.getFunction();
	}

	@Override
	public List<String> getUsage() {
		return landUseType.getUsage();
	}

	@Override
	public MultiSurfaceProperty getLod0MultiSurface() {
		if (landUseType.isSetLod0MultiSurface())
			return new MultiSurfacePropertyImpl(landUseType.getLod0MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod1MultiSurface() {
		if (landUseType.isSetLod1MultiSurface())
			return new MultiSurfacePropertyImpl(landUseType.getLod1MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod2MultiSurface() {
		if (landUseType.isSetLod2MultiSurface())
			return new MultiSurfacePropertyImpl(landUseType.getLod2MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod3MultiSurface() {
		if (landUseType.isSetLod3MultiSurface())
			return new MultiSurfacePropertyImpl(landUseType.getLod3MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod4MultiSurface() {
		if (landUseType.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(landUseType.getLod4MultiSurface());

		return null;
	}

	@Override
	public void setClazz(String clazz) {
		landUseType.setClazz(clazz);
	}

	@Override
	public void setFunction(List<String> function) {
		landUseType.unsetFunction();
		landUseType.getFunction().addAll(function);
	}

	@Override
	public void addFunction(String function) {
		landUseType.getFunction().add(function);
	}

	@Override
	public void setUsage(List<String> usage) {
		landUseType.unsetUsage();
		landUseType.getUsage().addAll(usage);
	}

	@Override
	public void addUsage(String usage) {
		landUseType.getUsage().add(usage);
	}


	@Override
	public void setLod0MultiSurface(MultiSurfaceProperty lod0MultiSurface) {
		landUseType.setLod0MultiSurface(((MultiSurfacePropertyImpl)lod0MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		landUseType.setLod1MultiSurface(((MultiSurfacePropertyImpl)lod1MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		landUseType.setLod2MultiSurface(((MultiSurfacePropertyImpl)lod2MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		landUseType.setLod3MultiSurface(((MultiSurfacePropertyImpl)lod3MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		landUseType.setLod4MultiSurface(((MultiSurfacePropertyImpl)lod4MultiSurface).getJAXBObject());
	}

	@Override
	public void calcBoundedBy() {
		MultiSurfaceProperty multiSurfaceProperty = null;

		for (int lod = 0; lod < 5; lod++) {
			switch (lod) {
			case 0:
				multiSurfaceProperty = getLod0MultiSurface();
				break;
			case 1:
				multiSurfaceProperty = getLod1MultiSurface();
				break;
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

	@Override
	public void addGenericApplicationPropertyOfLandUse(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			landUseType.get_GenericApplicationPropertyOfLandUse().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfLandUse() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = landUseType.get_GenericApplicationPropertyOfLandUse();

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
	public void setGenericApplicationPropertyOfLandUse(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			landUseType.unset_GenericApplicationPropertyOfLandUse();
			landUseType.get_GenericApplicationPropertyOfLandUse().addAll(elemList);
		}
	}

	@Override
	public boolean isSetClazz() {
		return landUseType.isSetClazz();
	}

	@Override
	public boolean isSetFunction() {
		return landUseType.isSetFunction();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfLandUse() {
		return landUseType.isSet_GenericApplicationPropertyOfLandUse();
	}

	@Override
	public boolean isSetLod0MultiSurface() {
		return landUseType.isSetLod0MultiSurface();
	}

	@Override
	public boolean isSetLod1MultiSurface() {
		return landUseType.isSetLod1MultiSurface();
	}

	@Override
	public boolean isSetLod2MultiSurface() {
		return landUseType.isSetLod2MultiSurface();
	}

	@Override
	public boolean isSetLod3MultiSurface() {
		return landUseType.isSetLod3MultiSurface();
	}

	@Override
	public boolean isSetLod4MultiSurface() {
		return landUseType.isSetLod4MultiSurface();
	}

	@Override
	public boolean isSetUsage() {
		return landUseType.isSetUsage();
	}

	@Override
	public void unsetClazz() {
		landUseType.setClazz(null);
	}

	@Override
	public void unsetFunction() {
		landUseType.unsetFunction();
	}

	@Override
	public void unsetGenericApplicationPropertyOfLandUse() {
		landUseType.unset_GenericApplicationPropertyOfLandUse();
	}

	@Override
	public void unsetLod0MultiSurface() {
		landUseType.setLod0MultiSurface(null);
	}

	@Override
	public void unsetLod1MultiSurface() {
		landUseType.setLod1MultiSurface(null);
	}

	@Override
	public void unsetLod2MultiSurface() {
		landUseType.setLod2MultiSurface(null);
	}

	@Override
	public void unsetLod3MultiSurface() {
		landUseType.setLod3MultiSurface(null);
	}

	@Override
	public void unsetLod4MultiSurface() {
		landUseType.setLod4MultiSurface(null);
	}

	@Override
	public void unsetUsage() {
		landUseType.unsetUsage();
	}

	@Override
	public boolean unsetFunction(String function) {
		if (landUseType.isSetFunction())
			return landUseType.getFunction().remove(function);
		
		return false;
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfLandUse(ADEComponent adeObject) {
		if (landUseType.isSet_GenericApplicationPropertyOfLandUse()) {
			Iterator<JAXBElement<?>> iter = landUseType.get_GenericApplicationPropertyOfLandUse().iterator();
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

	@Override
	public boolean unsetUsage(String usage) {
		if (landUseType.isSetUsage())
			return landUseType.getUsage().remove(usage);
		
		return false;
	}

}
