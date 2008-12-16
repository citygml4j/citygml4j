package org.citygml4j.impl.jaxb.citygml.vegetation._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.LengthImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSolidPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.jaxb.citygml.veg._1.PlantCoverType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.gml.Length;
import org.citygml4j.model.gml.MultiSolid;
import org.citygml4j.model.gml.MultiSolidProperty;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;

public class PlantCoverImpl extends VegetationObjectImpl implements PlantCover {
	private PlantCoverType plantCoverType;

	public PlantCoverImpl() {
		this(new PlantCoverType());
	}

	public PlantCoverImpl(PlantCoverType plantCoverType) {
		super(plantCoverType);
		this.plantCoverType = plantCoverType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.PLANTCOVER;
	}

	@Override
	public PlantCoverType getJAXBObject() {
		return plantCoverType;
	}

	@Override
	public void addFunction(String function) {
		plantCoverType.getFunction().add(function);
	}

	@Override
	public Length getAverageHeight() {
		if (plantCoverType.isSetAverageHeight())
			return new LengthImpl(plantCoverType.getAverageHeight());

		return null;
	}

	@Override
	public String getClazz() {
		return plantCoverType.getClazz();
	}

	@Override
	public List<String> getFunction() {
		return plantCoverType.getFunction();
	}

	@Override
	public MultiSolidProperty getLod1MultiSolid() {
		if (plantCoverType.isSetLod1MultiSolid())
			return new MultiSolidPropertyImpl(plantCoverType.getLod1MultiSolid());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod1MultiSurface() {
		if (plantCoverType.isSetLod1MultiSurface())
			return new MultiSurfacePropertyImpl(plantCoverType.getLod1MultiSurface());

		return null;
	}

	@Override
	public MultiSolidProperty getLod2MultiSolid() {
		if (plantCoverType.isSetLod2MultiSolid())
			return new MultiSolidPropertyImpl(plantCoverType.getLod2MultiSolid());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod2MultiSurface() {
		if (plantCoverType.isSetLod2MultiSurface())
			return new MultiSurfacePropertyImpl(plantCoverType.getLod2MultiSurface());

		return null;
	}

	@Override
	public MultiSolidProperty getLod3MultiSolid() {
		if (plantCoverType.isSetLod3MultiSolid())
			return new MultiSolidPropertyImpl(plantCoverType.getLod3MultiSolid());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod3MultiSurface() {
		if (plantCoverType.isSetLod3MultiSurface())
			return new MultiSurfacePropertyImpl(plantCoverType.getLod3MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod4MultiSurface() {
		if (plantCoverType.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(plantCoverType.getLod4MultiSurface());

		return null;
	}

	@Override
	public void setAverageHeight(Length averageHeight) {
		plantCoverType.setAverageHeight(((LengthImpl)averageHeight).getJAXBObject());
	}

	@Override
	public void setClazz(String clazz) {
		plantCoverType.setClazz(clazz);
	}

	@Override
	public void setFunction(List<String> function) {
		plantCoverType.unsetFunction();
		plantCoverType.getFunction().addAll(function);
	}

	@Override
	public void setLod1MultiSolid(MultiSolidProperty lod1MultiSolid) {
		plantCoverType.setLod1MultiSolid(((MultiSolidPropertyImpl)lod1MultiSolid).getJAXBObject());
	}

	@Override
	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		plantCoverType.setLod1MultiSurface(((MultiSurfacePropertyImpl)lod1MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod2MultiSolid(MultiSolidProperty lod2MultiSolid) {
		plantCoverType.setLod2MultiSolid(((MultiSolidPropertyImpl)lod2MultiSolid).getJAXBObject());
	}

	@Override
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		plantCoverType.setLod2MultiSurface(((MultiSurfacePropertyImpl)lod2MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod3MultiSolid(MultiSolidProperty lod3MultiSolid) {
		plantCoverType.setLod3MultiSolid(((MultiSolidPropertyImpl)lod3MultiSolid).getJAXBObject());
	}

	@Override
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		plantCoverType.setLod3MultiSurface(((MultiSurfacePropertyImpl)lod3MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		plantCoverType.setLod4MultiSurface(((MultiSurfacePropertyImpl)lod4MultiSurface).getJAXBObject());
	}

	@Override
	public void calcBoundedBy() {
		MultiSolidProperty multiSolidProperty = null;
		for (int lod = 1; lod < 4; lod++) {
			switch (lod) {
			case 1:
				multiSolidProperty = getLod1MultiSolid();
				break;
			case 2:
				multiSolidProperty = getLod2MultiSolid();
				break;
			case 3:
				multiSolidProperty = getLod3MultiSolid();
				break;
			}

			if (multiSolidProperty != null) {
				MultiSolid multiSolid = multiSolidProperty.getMultiSolid();
				if (multiSolid != null) {
					calcBoundedBy(multiSolid);
				} else {
					// xlink?
				}
			}
		}

		MultiSurfaceProperty multiSurfaceProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
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
	public void addGenericApplicationPropertyOfPlantCover(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			plantCoverType.get_GenericApplicationPropertyOfPlantCover().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfPlantCover() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = plantCoverType.get_GenericApplicationPropertyOfPlantCover();

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
	public void setGenericApplicationPropertyOfPlantCover(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			plantCoverType.unset_GenericApplicationPropertyOfPlantCover();
			plantCoverType.get_GenericApplicationPropertyOfPlantCover().addAll(elemList);
		}
	}

	@Override
	public boolean isSetAverageHeight() {
		return plantCoverType.isSetAverageHeight();
	}

	@Override
	public boolean isSetClazz() {
		return plantCoverType.isSetClazz();
	}

	@Override
	public boolean isSetFunction() {
		return plantCoverType.isSetFunction();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfPlantCover() {
		return plantCoverType.isSet_GenericApplicationPropertyOfPlantCover();
	}

	@Override
	public boolean isSetLod1MultiSolid() {
		return plantCoverType.isSetLod1MultiSolid();
	}

	@Override
	public boolean isSetLod1MultiSurface() {
		return plantCoverType.isSetLod1MultiSurface();
	}

	@Override
	public boolean isSetLod2MultiSolid() {
		return plantCoverType.isSetLod2MultiSolid();
	}

	@Override
	public boolean isSetLod2MultiSurface() {
		return plantCoverType.isSetLod2MultiSurface();
	}

	@Override
	public boolean isSetLod3MultiSolid() {
		return plantCoverType.isSetLod3MultiSolid();
	}

	@Override
	public boolean isSetLod3MultiSurface() {
		return plantCoverType.isSetLod3MultiSurface();
	}

	@Override
	public boolean isSetLod4MultiSurface() {
		return plantCoverType.isSetLod4MultiSurface();
	}

	@Override
	public void unsetAverageHeight() {
		plantCoverType.setAverageHeight(null);
	}

	@Override
	public void unsetClazz() {
		plantCoverType.setClazz(null);
	}

	@Override
	public void unsetFunction() {
		plantCoverType.unsetFunction();
	}

	@Override
	public void unsetGenericApplicationPropertyOfPlantCover() {
		plantCoverType.unset_GenericApplicationPropertyOfPlantCover();
	}

	@Override
	public void unsetLod1MultiSolid() {
		plantCoverType.setLod1MultiSolid(null);
	}

	@Override
	public void unsetLod1MultiSurface() {
		plantCoverType.setLod1MultiSurface(null);
	}

	@Override
	public void unsetLod2MultiSolid() {
		plantCoverType.setLod2MultiSolid(null);
	}

	@Override
	public void unsetLod2MultiSurface() {
		plantCoverType.setLod2MultiSurface(null);
	}

	@Override
	public void unsetLod3MultiSolid() {
		plantCoverType.setLod3MultiSolid(null);
	}

	@Override
	public void unsetLod3MultiSurface() {
		plantCoverType.setLod3MultiSurface(null);
	}

	@Override
	public void unsetLod4MultiSurface() {
		plantCoverType.setLod4MultiSurface(null);
	}
	
	@Override
	public boolean unsetFunction(String function) {
		if (plantCoverType.isSetFunction())
			return plantCoverType.getFunction().remove(function);
		
		return false;
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfPlantCover(ADEComponent adeObject) {
		if (plantCoverType.isSet_GenericApplicationPropertyOfPlantCover()) {
			Iterator<JAXBElement<?>> iter = plantCoverType.get_GenericApplicationPropertyOfPlantCover().iterator();
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
