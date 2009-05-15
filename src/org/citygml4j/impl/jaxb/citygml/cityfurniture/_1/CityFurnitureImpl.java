package org.citygml4j.impl.jaxb.citygml.cityfurniture._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._1.CityObjectImpl;
import org.citygml4j.impl.jaxb.citygml.core._1.ImplicitRepresentationPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometryPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiCurvePropertyImpl;
import org.citygml4j.jaxb.citygml.frn._1.CityFurnitureType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityfurniture.CityFurnitureModule;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.MultiCurveProperty;

public class CityFurnitureImpl extends CityObjectImpl implements CityFurniture {
	private CityFurnitureType cityFurnitureType;

	public CityFurnitureImpl() {
		this(new CityFurnitureType());
	}

	public CityFurnitureImpl(CityFurnitureType cityFurnitureType) {
		super(cityFurnitureType);
		this.cityFurnitureType = cityFurnitureType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITYFURNITURE;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CityFurnitureModule.v1_0_0;
	}
	@Override
	public CityFurnitureType getJAXBObject() {
		return cityFurnitureType;
	}

	public String getClazz() {
		return cityFurnitureType.getClazz();
	}

	public List<String> getFunction() {
		return cityFurnitureType.getFunction();
	}

	public GeometryProperty getLod1Geometry() {
		if (cityFurnitureType.isSetLod1Geometry())
			return new GeometryPropertyImpl(cityFurnitureType.getLod1Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod1ImplicitRepresentation() {
		if (cityFurnitureType.isSetLod1ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(cityFurnitureType.getLod1ImplicitRepresentation());

		return null;
	}

	public GeometryProperty getLod2Geometry() {
		if (cityFurnitureType.isSetLod2Geometry())
			return new GeometryPropertyImpl(cityFurnitureType.getLod2Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod2ImplicitRepresentation() {
		if (cityFurnitureType.isSetLod2ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(cityFurnitureType.getLod2ImplicitRepresentation());

		return null;
	}

	public GeometryProperty getLod3Geometry() {
		if (cityFurnitureType.isSetLod3Geometry())
			return new GeometryPropertyImpl(cityFurnitureType.getLod3Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod3ImplicitRepresentation() {
		if (cityFurnitureType.isSetLod3ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(cityFurnitureType.getLod3ImplicitRepresentation());

		return null;
	}

	public GeometryProperty getLod4Geometry() {
		if (cityFurnitureType.isSetLod4Geometry())
			return new GeometryPropertyImpl(cityFurnitureType.getLod4Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
		if (cityFurnitureType.isSetLod4ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(cityFurnitureType.getLod4ImplicitRepresentation());

		return null;
	}

	public MultiCurveProperty getLod1TerrainIntersection() {
		if (cityFurnitureType.isSetLod1TerrainIntersection())
			return new MultiCurvePropertyImpl(cityFurnitureType.getLod1TerrainIntersection());

		return null;
	}

	public MultiCurveProperty getLod2TerrainIntersection() {
		if (cityFurnitureType.isSetLod2TerrainIntersection())
			return new MultiCurvePropertyImpl(cityFurnitureType.getLod2TerrainIntersection());

		return null;
	}

	public MultiCurveProperty getLod3TerrainIntersection() {
		if (cityFurnitureType.isSetLod3TerrainIntersection())
			return new MultiCurvePropertyImpl(cityFurnitureType.getLod3TerrainIntersection());

		return null;
	}

	public MultiCurveProperty getLod4TerrainIntersection() {
		if (cityFurnitureType.isSetLod4TerrainIntersection())
			return new MultiCurvePropertyImpl(cityFurnitureType.getLod4TerrainIntersection());

		return null;
	}

	public void setClazz(String clazz) {
		cityFurnitureType.setClazz(clazz);
	}

	public void setFunction(List<String> function) {
		cityFurnitureType.unsetFunction();
		cityFurnitureType.getFunction().addAll(function);
	}

	public void addFunction(String function) {
		cityFurnitureType.getFunction().add(function);
	}

	public void setLod1Geometry(GeometryProperty lod1Geometry) {
		cityFurnitureType.setLod1Geometry(((GeometryPropertyImpl)lod1Geometry).getJAXBObject());
	}

	public void setLod1ImplicitRepresentation(
			ImplicitRepresentationProperty lod1ImplicitRepresentation) {
		cityFurnitureType.setLod1ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod1ImplicitRepresentation).getJAXBObject());
	}

	public void setLod2Geometry(GeometryProperty lod2Geometry) {
		cityFurnitureType.setLod2Geometry(((GeometryPropertyImpl)lod2Geometry).getJAXBObject());
	}

	public void setLod2ImplicitRepresentation(
			ImplicitRepresentationProperty lod2ImplicitRepresentation) {
		cityFurnitureType.setLod2ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod2ImplicitRepresentation).getJAXBObject());
	}

	public void setLod3Geometry(GeometryProperty lod3Geometry) {
		cityFurnitureType.setLod3Geometry(((GeometryPropertyImpl)lod3Geometry).getJAXBObject());
	}

	public void setLod3ImplicitRepresentation(
			ImplicitRepresentationProperty lod3ImplicitRepresentation) {
		cityFurnitureType.setLod3ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod3ImplicitRepresentation).getJAXBObject());
	}

	public void setLod4Geometry(GeometryProperty lod4Geometry) {
		cityFurnitureType.setLod4Geometry(((GeometryPropertyImpl)lod4Geometry).getJAXBObject());
	}

	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
		cityFurnitureType.setLod4ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod4ImplicitRepresentation).getJAXBObject());
	}

	public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection) {
		cityFurnitureType.setLod1TerrainIntersection(((MultiCurvePropertyImpl)lod1TerrainIntersection).getJAXBObject());
	}

	public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection) {
		cityFurnitureType.setLod2TerrainIntersection(((MultiCurvePropertyImpl)lod2TerrainIntersection).getJAXBObject());
	}

	public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection) {
		cityFurnitureType.setLod3TerrainIntersection(((MultiCurvePropertyImpl)lod3TerrainIntersection).getJAXBObject());
	}

	public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection) {
		cityFurnitureType.setLod4TerrainIntersection(((MultiCurvePropertyImpl)lod4TerrainIntersection).getJAXBObject());
	}

	@Override
	public void calcBoundedBy() {
		// obviously we cannot rely on remote geometry objects for this...
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

	public void addGenericApplicationPropertyOfCityFurniture(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			cityFurnitureType.get_GenericApplicationPropertyOfCityFurniture().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfCityFurniture() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : cityFurnitureType.get_GenericApplicationPropertyOfCityFurniture()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfCityFurniture(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			cityFurnitureType.unset_GenericApplicationPropertyOfCityFurniture();
			cityFurnitureType.get_GenericApplicationPropertyOfCityFurniture().addAll(elemList);
		}
	}

	public boolean isSetClazz() {
		return cityFurnitureType.isSetClazz();
	}

	public boolean isSetFunction() {
		return cityFurnitureType.isSetFunction();
	}

	public boolean isSetGenericApplicationPropertyOfCityFurniture() {
		return cityFurnitureType.isSet_GenericApplicationPropertyOfCityFurniture();
	}

	public boolean isSetLod1Geometry() {
		return cityFurnitureType.isSetLod1Geometry();
	}

	public boolean isSetLod1ImplicitRepresentation() {
		return cityFurnitureType.isSetLod1ImplicitRepresentation();
	}

	public boolean isSetLod1TerrainIntersection() {
		return cityFurnitureType.isSetLod1TerrainIntersection();
	}

	public boolean isSetLod2Geometry() {
		return cityFurnitureType.isSetLod2Geometry();
	}

	public boolean isSetLod2ImplicitRepresentation() {
		return cityFurnitureType.isSetLod2ImplicitRepresentation();
	}

	public boolean isSetLod2TerrainIntersection() {
		return cityFurnitureType.isSetLod2TerrainIntersection();
	}

	public boolean isSetLod3Geometry() {
		return cityFurnitureType.isSetLod3Geometry();
	}

	public boolean isSetLod3ImplicitRepresentation() {
		return cityFurnitureType.isSetLod3ImplicitRepresentation();
	}

	public boolean isSetLod3TerrainIntersection() {
		return cityFurnitureType.isSetLod3TerrainIntersection();
	}

	public boolean isSetLod4Geometry() {
		return cityFurnitureType.isSetLod4Geometry();
	}

	public boolean isSetLod4ImplicitRepresentation() {
		return cityFurnitureType.isSetLod4ImplicitRepresentation();
	}

	public boolean isSetLod4TerrainIntersection() {
		return cityFurnitureType.isSetLod4TerrainIntersection();
	}

	public void unsetClazz() {
		cityFurnitureType.setClazz(null);
	}

	public void unsetFunction() {
		cityFurnitureType.unsetFunction();
	}

	public void unsetGenericApplicationPropertyOfCityFurniture() {
		cityFurnitureType.unset_GenericApplicationPropertyOfCityFurniture();
	}

	public void unsetLod1Geometry() {
		cityFurnitureType.setLod1Geometry(null);
	}

	public void unsetLod1ImplicitRepresentation() {
		cityFurnitureType.setLod1ImplicitRepresentation(null);
	}

	public void unsetLod1TerrainIntersection() {
		cityFurnitureType.setLod1TerrainIntersection(null);
	}

	public void unsetLod2Geometry() {
		cityFurnitureType.setLod2Geometry(null);
	}

	public void unsetLod2ImplicitRepresentation() {
		cityFurnitureType.setLod2ImplicitRepresentation(null);
	}

	public void unsetLod2TerrainIntersection() {
		cityFurnitureType.setLod2TerrainIntersection(null);
	}

	public void unsetLod3Geometry() {
		cityFurnitureType.setLod3Geometry(null);
	}

	public void unsetLod3ImplicitRepresentation() {
		cityFurnitureType.setLod3ImplicitRepresentation(null);
	}

	public void unsetLod3TerrainIntersection() {
		cityFurnitureType.setLod3TerrainIntersection(null);
	}

	public void unsetLod4Geometry() {
		cityFurnitureType.setLod4Geometry(null);
	}

	public void unsetLod4ImplicitRepresentation() {
		cityFurnitureType.setLod4ImplicitRepresentation(null);
	}

	public void unsetLod4TerrainIntersection() {
		cityFurnitureType.setLod4TerrainIntersection(null);
	}
	
	public boolean unsetFunction(String function) {
		if (cityFurnitureType.isSetFunction())
			return cityFurnitureType.getFunction().remove(function);
		
		return false;
	}

	public boolean unsetGenericApplicationPropertyOfCityFurniture(ADEComponent adeObject) {
		if (cityFurnitureType.isSet_GenericApplicationPropertyOfCityFurniture()) {
			Iterator<JAXBElement<?>> iter = cityFurnitureType.get_GenericApplicationPropertyOfCityFurniture().iterator();
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
