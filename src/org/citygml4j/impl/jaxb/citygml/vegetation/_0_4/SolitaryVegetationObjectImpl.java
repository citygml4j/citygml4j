package org.citygml4j.impl.jaxb.citygml.vegetation._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.ImplicitRepresentationPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometryPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LengthImpl;
import org.citygml4j.jaxb.citygml._0_4.SolitaryVegetationObjectType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.Length;

public class SolitaryVegetationObjectImpl extends VegetationObjectImpl implements SolitaryVegetationObject {
	private SolitaryVegetationObjectType solitaryVegetationObjectType;

	public SolitaryVegetationObjectImpl() {
		this(new SolitaryVegetationObjectType());
	}

	public SolitaryVegetationObjectImpl(SolitaryVegetationObjectType solitaryVegetationObjectType) {
		super(solitaryVegetationObjectType);
		this.solitaryVegetationObjectType = solitaryVegetationObjectType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.SOLITARYVEGETATIONOBJECT;
	}

	@Override
	public SolitaryVegetationObjectType getJAXBObject() {
		return solitaryVegetationObjectType;
	}

	public void addFunction(String function) {
		solitaryVegetationObjectType.getFunction().add(function);
	}

	public String getClazz() {
		return solitaryVegetationObjectType.getClazz();
	}

	public Length getCrownDiameter() {
		if (solitaryVegetationObjectType.isSetCrownDiameter())
			return new LengthImpl(solitaryVegetationObjectType.getCrownDiameter());

		return null;
	}

	public List<String> getFunction() {
		return solitaryVegetationObjectType.getFunction();
	}

	public Length getHeight() {
		if (solitaryVegetationObjectType.isSetHeight())
			return new LengthImpl(solitaryVegetationObjectType.getHeight());

		return null;
	}

	public GeometryProperty getLod1Geometry() {
		if (solitaryVegetationObjectType.isSetLod1Geometry())
			return new GeometryPropertyImpl(solitaryVegetationObjectType.getLod1Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod1ImplicitRepresentation() {
		if (solitaryVegetationObjectType.isSetLod1ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(solitaryVegetationObjectType.getLod1ImplicitRepresentation());

		return null;
	}

	public GeometryProperty getLod2Geometry() {
		if (solitaryVegetationObjectType.isSetLod2Geometry())
			return new GeometryPropertyImpl(solitaryVegetationObjectType.getLod2Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod2ImplicitRepresentation() {
		if (solitaryVegetationObjectType.isSetLod2ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(solitaryVegetationObjectType.getLod2ImplicitRepresentation());

		return null;
	}

	public GeometryProperty getLod3Geometry() {
		if (solitaryVegetationObjectType.isSetLod3Geometry())
			return new GeometryPropertyImpl(solitaryVegetationObjectType.getLod3Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod3ImplicitRepresentation() {
		if (solitaryVegetationObjectType.isSetLod3ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(solitaryVegetationObjectType.getLod3ImplicitRepresentation());

		return null;
	}

	public GeometryProperty getLod4Geometry() {
		if (solitaryVegetationObjectType.isSetLod4Geometry())
			return new GeometryPropertyImpl(solitaryVegetationObjectType.getLod4Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
		if (solitaryVegetationObjectType.isSetLod4ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(solitaryVegetationObjectType.getLod4ImplicitRepresentation());

		return null;
	}

	public String getSpecies() {
		return solitaryVegetationObjectType.getSpecies();
	}

	public Length getTrunkDiameter() {
		if (solitaryVegetationObjectType.isSetTrunkDiameter())
			return new LengthImpl(solitaryVegetationObjectType.getTrunkDiameter());

		return null;
	}

	public void setClazz(String clazz) {
		solitaryVegetationObjectType.setClazz(clazz);
	}

	public void setCrownDiameter(Length crownDiameter) {
		solitaryVegetationObjectType.setCrownDiameter(((LengthImpl)crownDiameter).getJAXBObject());
	}

	public void setFunction(List<String> function) {
		solitaryVegetationObjectType.unsetFunction();
		solitaryVegetationObjectType.getFunction().addAll(function);
	}

	public void setSpecies(String species) {
		solitaryVegetationObjectType.setSpecies(species);
	}

	public void setHeight(Length height) {
		solitaryVegetationObjectType.setHeight(((LengthImpl)height).getJAXBObject());
	}

	public void setLod1Geometry(GeometryProperty lod1Geometry) {
		solitaryVegetationObjectType.setLod1Geometry(((GeometryPropertyImpl)lod1Geometry).getJAXBObject());
	}

	public void setLod1ImplicitRepresentation(ImplicitRepresentationProperty lod1ImplicitRepresentation) {
		solitaryVegetationObjectType.setLod1ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod1ImplicitRepresentation).getJAXBObject());
	}

	public void setLod2Geometry(GeometryProperty lod2Geometry) {
		solitaryVegetationObjectType.setLod2Geometry(((GeometryPropertyImpl)lod2Geometry).getJAXBObject());
	}

	public void setLod2ImplicitRepresentation(ImplicitRepresentationProperty lod2ImplicitRepresentation) {
		solitaryVegetationObjectType.setLod2ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod2ImplicitRepresentation).getJAXBObject());
	}

	public void setLod3Geometry(GeometryProperty lod3Geometry) {
		solitaryVegetationObjectType.setLod3Geometry(((GeometryPropertyImpl)lod3Geometry).getJAXBObject());
	}

	public void setLod3ImplicitRepresentation(ImplicitRepresentationProperty lod3ImplicitRepresentation) {
		solitaryVegetationObjectType.setLod3ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod3ImplicitRepresentation).getJAXBObject());
	}

	public void setLod4Geometry(GeometryProperty lod4Geometry) {
		solitaryVegetationObjectType.setLod4Geometry(((GeometryPropertyImpl)lod4Geometry).getJAXBObject());
	}

	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
		solitaryVegetationObjectType.setLod4ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod4ImplicitRepresentation).getJAXBObject());
	}

	public void setTrunkDiameter(Length trunkDiameter) {
		solitaryVegetationObjectType.setTrunkDiameter(((LengthImpl)trunkDiameter).getJAXBObject());
	}

	@Override
	public void calcBoundedBy() {
		GeometryProperty geometryProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				geometryProperty = getLod1Geometry();
				break;
			case 2:
				geometryProperty = getLod2Geometry();
				break;
			case 3:
				geometryProperty = getLod3Geometry();
				break;
			case 4:
				geometryProperty = getLod4Geometry();
				break;
			}

			if (geometryProperty != null) {
				AbstractGeometry abstractGeometry = geometryProperty.getGeometry();
				if (abstractGeometry != null) {
					calcBoundedBy(abstractGeometry);
				} else {
					// xlink?
				}
			}
		}
	}

	public void addGenericApplicationPropertyOfSolitaryVegetationObject(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			solitaryVegetationObjectType.get_GenericApplicationPropertyOfSolitaryVegetationObject().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfSolitaryVegetationObject() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : solitaryVegetationObjectType.get_GenericApplicationPropertyOfSolitaryVegetationObject()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfSolitaryVegetationObject(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			solitaryVegetationObjectType.unset_GenericApplicationPropertyOfSolitaryVegetationObject();
			solitaryVegetationObjectType.get_GenericApplicationPropertyOfSolitaryVegetationObject().addAll(elemList);
		}
	}

	public boolean isSetClazz() {
		return solitaryVegetationObjectType.isSetClazz();
	}

	public boolean isSetCrownDiameter() {
		return solitaryVegetationObjectType.isSetCrownDiameter();
	}

	public boolean isSetFunction() {
		return solitaryVegetationObjectType.isSetFunction();
	}

	public boolean isSetGenericApplicationPropertyOfSolitaryVegetationObject() {
		return solitaryVegetationObjectType.isSet_GenericApplicationPropertyOfSolitaryVegetationObject();
	}

	public boolean isSetHeight() {
		return solitaryVegetationObjectType.isSetHeight();
	}

	public boolean isSetLod1Geometry() {
		return solitaryVegetationObjectType.isSetLod1Geometry();
	}

	public boolean isSetLod1ImplicitRepresentation() {
		return solitaryVegetationObjectType.isSetLod1ImplicitRepresentation();
	}

	public boolean isSetLod2Geometry() {
		return solitaryVegetationObjectType.isSetLod2Geometry();
	}

	public boolean isSetLod2ImplicitRepresentation() {
		return solitaryVegetationObjectType.isSetLod2ImplicitRepresentation();
	}

	public boolean isSetLod3Geometry() {
		return solitaryVegetationObjectType.isSetLod3Geometry();
	}

	public boolean isSetLod3ImplicitRepresentation() {
		return solitaryVegetationObjectType.isSetLod3ImplicitRepresentation();
	}

	public boolean isSetLod4Geometry() {
		return solitaryVegetationObjectType.isSetLod4Geometry();
	}

	public boolean isSetLod4ImplicitRepresentation() {
		return solitaryVegetationObjectType.isSetLod4ImplicitRepresentation();
	}

	public boolean isSetSpecies() {
		return solitaryVegetationObjectType.isSetSpecies();
	}

	public boolean isSetTrunkDiameter() {
		return solitaryVegetationObjectType.isSetTrunkDiameter();
	}

	public void unsetClazz() {
		solitaryVegetationObjectType.setClazz(null);
	}

	public void unsetCrownDiameter() {
		solitaryVegetationObjectType.setCrownDiameter(null);
	}

	public void unsetFunction() {
		solitaryVegetationObjectType.unsetFunction();
	}

	public void unsetGenericApplicationPropertyOfSolitaryVegetationObject() {
		solitaryVegetationObjectType.unset_GenericApplicationPropertyOfSolitaryVegetationObject();
	}

	public void unsetHeight() {
		solitaryVegetationObjectType.setHeight(null);
	}

	public void unsetLod1Geometry() {
		solitaryVegetationObjectType.setLod1Geometry(null);
	}

	public void unsetLod1ImplicitRepresentation() {
		solitaryVegetationObjectType.setLod1ImplicitRepresentation(null);
	}

	public void unsetLod2Geometry() {
		solitaryVegetationObjectType.setLod2Geometry(null);
	}

	public void unsetLod2ImplicitRepresentation() {
		solitaryVegetationObjectType.setLod2ImplicitRepresentation(null);
	}

	public void unsetLod3Geometry() {
		solitaryVegetationObjectType.setLod3Geometry(null);
	}

	public void unsetLod3ImplicitRepresentation() {
		solitaryVegetationObjectType.setLod3ImplicitRepresentation(null);
	}

	public void unsetLod4Geometry() {
		solitaryVegetationObjectType.setLod4Geometry(null);
	}

	public void unsetLod4ImplicitRepresentation() {
		solitaryVegetationObjectType.setLod4ImplicitRepresentation(null);
	}

	public void unsetSpecies() {
		solitaryVegetationObjectType.setSpecies(null);
	}

	public void unsetTrunkDiameter() {
		solitaryVegetationObjectType.setTrunkDiameter(null);
	}

	public boolean unsetFunction(String function) {
		if (solitaryVegetationObjectType.isSetFunction())
			return solitaryVegetationObjectType.getFunction().remove(function);
		
		return false;
	}

	public boolean unsetGenericApplicationPropertyOfSolitaryVegetationObject(ADEComponent adeObject) {
		if (solitaryVegetationObjectType.isSet_GenericApplicationPropertyOfSolitaryVegetationObject()) {
			Iterator<JAXBElement<?>> iter = solitaryVegetationObjectType.get_GenericApplicationPropertyOfSolitaryVegetationObject().iterator();
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
