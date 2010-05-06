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

	public void addFunction(String function) {
		plantCoverType.getFunction().add(function);
	}

	public Length getAverageHeight() {
		if (plantCoverType.isSetAverageHeight())
			return new LengthImpl(plantCoverType.getAverageHeight());

		return null;
	}

	public String getClazz() {
		return plantCoverType.getClazz();
	}

	public List<String> getFunction() {
		return plantCoverType.getFunction();
	}

	public MultiSolidProperty getLod1MultiSolid() {
		if (plantCoverType.isSetLod1MultiSolid())
			return new MultiSolidPropertyImpl(plantCoverType.getLod1MultiSolid());

		return null;
	}

	public MultiSurfaceProperty getLod1MultiSurface() {
		if (plantCoverType.isSetLod1MultiSurface())
			return new MultiSurfacePropertyImpl(plantCoverType.getLod1MultiSurface());

		return null;
	}

	public MultiSolidProperty getLod2MultiSolid() {
		if (plantCoverType.isSetLod2MultiSolid())
			return new MultiSolidPropertyImpl(plantCoverType.getLod2MultiSolid());

		return null;
	}

	public MultiSurfaceProperty getLod2MultiSurface() {
		if (plantCoverType.isSetLod2MultiSurface())
			return new MultiSurfacePropertyImpl(plantCoverType.getLod2MultiSurface());

		return null;
	}

	public MultiSolidProperty getLod3MultiSolid() {
		if (plantCoverType.isSetLod3MultiSolid())
			return new MultiSolidPropertyImpl(plantCoverType.getLod3MultiSolid());

		return null;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		if (plantCoverType.isSetLod3MultiSurface())
			return new MultiSurfacePropertyImpl(plantCoverType.getLod3MultiSurface());

		return null;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		if (plantCoverType.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(plantCoverType.getLod4MultiSurface());

		return null;
	}

	public void setAverageHeight(Length averageHeight) {
		plantCoverType.setAverageHeight(((LengthImpl)averageHeight).getJAXBObject());
	}

	public void setClazz(String clazz) {
		plantCoverType.setClazz(clazz);
	}

	public void setFunction(List<String> function) {
		plantCoverType.unsetFunction();
		plantCoverType.getFunction().addAll(function);
	}

	public void setLod1MultiSolid(MultiSolidProperty lod1MultiSolid) {
		plantCoverType.setLod1MultiSolid(((MultiSolidPropertyImpl)lod1MultiSolid).getJAXBObject());
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		plantCoverType.setLod1MultiSurface(((MultiSurfacePropertyImpl)lod1MultiSurface).getJAXBObject());
	}

	public void setLod2MultiSolid(MultiSolidProperty lod2MultiSolid) {
		plantCoverType.setLod2MultiSolid(((MultiSolidPropertyImpl)lod2MultiSolid).getJAXBObject());
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		plantCoverType.setLod2MultiSurface(((MultiSurfacePropertyImpl)lod2MultiSurface).getJAXBObject());
	}

	public void setLod3MultiSolid(MultiSolidProperty lod3MultiSolid) {
		plantCoverType.setLod3MultiSolid(((MultiSolidPropertyImpl)lod3MultiSolid).getJAXBObject());
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		plantCoverType.setLod3MultiSurface(((MultiSurfacePropertyImpl)lod3MultiSurface).getJAXBObject());
	}

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

	public void addGenericApplicationPropertyOfPlantCover(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			plantCoverType.get_GenericApplicationPropertyOfPlantCover().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfPlantCover() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : plantCoverType.get_GenericApplicationPropertyOfPlantCover()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

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

	public boolean isSetAverageHeight() {
		return plantCoverType.isSetAverageHeight();
	}

	public boolean isSetClazz() {
		return plantCoverType.isSetClazz();
	}

	public boolean isSetFunction() {
		return plantCoverType.isSetFunction();
	}

	public boolean isSetGenericApplicationPropertyOfPlantCover() {
		return plantCoverType.isSet_GenericApplicationPropertyOfPlantCover();
	}

	public boolean isSetLod1MultiSolid() {
		return plantCoverType.isSetLod1MultiSolid();
	}

	public boolean isSetLod1MultiSurface() {
		return plantCoverType.isSetLod1MultiSurface();
	}

	public boolean isSetLod2MultiSolid() {
		return plantCoverType.isSetLod2MultiSolid();
	}

	public boolean isSetLod2MultiSurface() {
		return plantCoverType.isSetLod2MultiSurface();
	}

	public boolean isSetLod3MultiSolid() {
		return plantCoverType.isSetLod3MultiSolid();
	}

	public boolean isSetLod3MultiSurface() {
		return plantCoverType.isSetLod3MultiSurface();
	}

	public boolean isSetLod4MultiSurface() {
		return plantCoverType.isSetLod4MultiSurface();
	}

	public void unsetAverageHeight() {
		plantCoverType.setAverageHeight(null);
	}

	public void unsetClazz() {
		plantCoverType.setClazz(null);
	}

	public void unsetFunction() {
		plantCoverType.unsetFunction();
	}

	public void unsetGenericApplicationPropertyOfPlantCover() {
		plantCoverType.unset_GenericApplicationPropertyOfPlantCover();
	}

	public void unsetLod1MultiSolid() {
		plantCoverType.setLod1MultiSolid(null);
	}

	public void unsetLod1MultiSurface() {
		plantCoverType.setLod1MultiSurface(null);
	}

	public void unsetLod2MultiSolid() {
		plantCoverType.setLod2MultiSolid(null);
	}

	public void unsetLod2MultiSurface() {
		plantCoverType.setLod2MultiSurface(null);
	}

	public void unsetLod3MultiSolid() {
		plantCoverType.setLod3MultiSolid(null);
	}

	public void unsetLod3MultiSurface() {
		plantCoverType.setLod3MultiSurface(null);
	}

	public void unsetLod4MultiSurface() {
		plantCoverType.setLod4MultiSurface(null);
	}
	
	public boolean unsetFunction(String function) {
		if (plantCoverType.isSetFunction())
			return plantCoverType.getFunction().remove(function);
		
		return false;
	}

	public boolean unsetGenericApplicationPropertyOfPlantCover(ADEComponent adeObject) {
		if (plantCoverType.isSet_GenericApplicationPropertyOfPlantCover()) {
			Iterator<JAXBElement<?>> iter = plantCoverType.get_GenericApplicationPropertyOfPlantCover().iterator();
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
