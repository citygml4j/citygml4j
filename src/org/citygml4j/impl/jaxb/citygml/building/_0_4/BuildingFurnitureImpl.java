package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.impl.jaxb.citygml.core._0_4.ImplicitRepresentationPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometryPropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.BuildingFurnitureType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.GeometryProperty;

public class BuildingFurnitureImpl extends CityObjectImpl implements BuildingFurniture {
	private BuildingFurnitureType buildingFurnitureType;

	public BuildingFurnitureImpl() {
		this(new BuildingFurnitureType());
	}

	public BuildingFurnitureImpl(BuildingFurnitureType buildingFurnitureType) {
		super(buildingFurnitureType);
		this.buildingFurnitureType = buildingFurnitureType;
	}

	@Override
	public BuildingFurnitureType getJAXBObject() {
		return buildingFurnitureType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDINGFURNITURE;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v0_4_0;
	}

	@Override
	public String getClazz() {
		return buildingFurnitureType.getClazz();
	}

	@Override
	public List<String> getFunction() {
		return buildingFurnitureType.getFunction();
	}

	@Override
	public GeometryProperty getLod4Geometry() {
		if (buildingFurnitureType.isSetLod4Geometry())
			return new GeometryPropertyImpl(buildingFurnitureType.getLod4Geometry());

		return null;
	}

	@Override
	public List<String> getUsage() {
		return buildingFurnitureType.getUsage();
	}

	@Override
	public void calcBoundedBy() {
		if (getLod4Geometry() != null) {
			GeometryProperty geometryProperty = getLod4Geometry();
			AbstractGeometry abstractGeometry = geometryProperty.getGeometry();
			if (abstractGeometry != null) {
				calcBoundedBy(abstractGeometry);
			} else {
				// xlink?
			}
		}
	}

	@Override
	public void addFunction(String function) {
		buildingFurnitureType.getFunction().add(function);
	}

	@Override
	public void addUsage(String usage) {
		buildingFurnitureType.getUsage().add(usage);
	}

	@Override
	public void setClazz(String clazz) {
		buildingFurnitureType.setClazz(clazz);
	}

	@Override
	public void setFunction(List<String> function) {
		buildingFurnitureType.unsetFunction();
		buildingFurnitureType.getFunction().addAll(function);
	}

	@Override
	public void setUsage(List<String> usage) {
		buildingFurnitureType.unsetUsage();
		buildingFurnitureType.getUsage().addAll(usage);
	}

	@Override
	public void setLod4Geometry(GeometryProperty lod4Geometry) {
		buildingFurnitureType.setLod4Geometry(((GeometryPropertyImpl)lod4Geometry).getJAXBObject());
	}

	@Override
	public ImplicitRepresentationProperty getLoD4ImplicitRepresentation() {
		if (buildingFurnitureType.isSetLod4ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(buildingFurnitureType.getLod4ImplicitRepresentation());

		return null;
	}

	@Override
	public void setLoD4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
		buildingFurnitureType.setLod4ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod4ImplicitRepresentation).getJAXBObject());
	}

	@Override
	public void addGenericApplicationPropertyOfBuildingFurniture(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			buildingFurnitureType.get_GenericApplicationPropertyOfBuildingFurniture().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfBuildingFurniture() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = buildingFurnitureType.get_GenericApplicationPropertyOfBuildingFurniture();

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
	public void setGenericApplicationPropertyOfBuildingFurniture(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			buildingFurnitureType.unset_GenericApplicationPropertyOfBuildingFurniture();
			buildingFurnitureType.get_GenericApplicationPropertyOfBuildingFurniture().addAll(elemList);
		}
	}

	@Override
	public boolean isSetClazz() {
		return buildingFurnitureType.isSetClazz();
	}

	@Override
	public boolean isSetFunction() {
		return buildingFurnitureType.isSetFunction();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfBuildingFurniture() {
		return buildingFurnitureType.isSet_GenericApplicationPropertyOfBuildingFurniture();
	}

	@Override
	public boolean isSetLod4Geometry() {
		return buildingFurnitureType.isSetLod4Geometry();
	}

	@Override
	public boolean isSetLoD4ImplicitRepresentation() {
		return buildingFurnitureType.isSetLod4ImplicitRepresentation();
	}

	@Override
	public boolean isSetUsage() {
		return buildingFurnitureType.isSetUsage();
	}

	@Override
	public void unsetClazz() {
		buildingFurnitureType.setClazz(null);
	}

	@Override
	public void unsetFunction() {
		buildingFurnitureType.unsetFunction();
	}

	@Override
	public void unsetGenericApplicationPropertyOfBuildingFurniture() {
		buildingFurnitureType.unset_GenericApplicationPropertyOfBuildingFurniture();
	}

	@Override
	public void unsetLod4Geometry() {
		buildingFurnitureType.setLod4Geometry(null);
	}

	@Override
	public void unsetLoD4ImplicitRepresentation() {
		buildingFurnitureType.setLod4ImplicitRepresentation(null);
	}

	@Override
	public void unsetUsage() {
		buildingFurnitureType.unsetUsage();
	}

	@Override
	public boolean unsetFunction(String function) {
		if (buildingFurnitureType.isSetFunction())
			return buildingFurnitureType.getFunction().remove(function);
		
		return false;
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfBuildingFurniture(ADEComponent adeObject) {
		if (buildingFurnitureType.isSet_GenericApplicationPropertyOfBuildingFurniture()) {
			Iterator<JAXBElement<?>> iter = buildingFurnitureType.get_GenericApplicationPropertyOfBuildingFurniture().iterator();
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
		if (buildingFurnitureType.isSetUsage())
			return buildingFurnitureType.getUsage().remove(usage);
		
		return false;
	}

}
