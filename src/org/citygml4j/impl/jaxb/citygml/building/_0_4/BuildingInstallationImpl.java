package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometryPropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.BuildingInstallationType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.GeometryProperty;

public class BuildingInstallationImpl extends CityObjectImpl implements	BuildingInstallation {
	private BuildingInstallationType buildingInstallationType;

	public BuildingInstallationImpl() {
		this(new BuildingInstallationType());
	}

	public BuildingInstallationImpl(BuildingInstallationType buildingInstallationType) {
		super(buildingInstallationType);
		this.buildingInstallationType = buildingInstallationType;
	}

	@Override
	public BuildingInstallationType getJAXBObject() {
		return buildingInstallationType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDINGINSTALLATION;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v0_4_0;
	}

	@Override
	public String getClazz() {
		return buildingInstallationType.getClazz();
	}

	@Override
	public List<String> getFunction() {
		return buildingInstallationType.getFunction();
	}

	@Override
	public GeometryProperty getLod2Geometry() {
		if (buildingInstallationType.isSetLod2Geometry())
			return new GeometryPropertyImpl(buildingInstallationType.getLod2Geometry());

		return null;
	}

	@Override
	public GeometryProperty getLod3Geometry() {
		if (buildingInstallationType.isSetLod3Geometry())
			return new GeometryPropertyImpl(buildingInstallationType.getLod3Geometry());

		return null;
	}

	@Override
	public GeometryProperty getLod4Geometry() {
		if (buildingInstallationType.isSetLod4Geometry())
			return new GeometryPropertyImpl(buildingInstallationType.getLod4Geometry());

		return null;
	}

	@Override
	public List<String> getUsage() {
		return buildingInstallationType.getUsage();
	}

	@Override
	public void calcBoundedBy() {
		GeometryProperty geometryProperty = null;

		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
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

	@Override
	public void addFunction(String function) {
		buildingInstallationType.getFunction().add(function);
	}

	@Override
	public void addUsage(String usage) {
		buildingInstallationType.getUsage().add(usage);
	}

	@Override
	public void setClazz(String clazz) {
		buildingInstallationType.setClazz(clazz);
	}

	@Override
	public void setFunction(List<String> function) {
		buildingInstallationType.unsetFunction();
		buildingInstallationType.getFunction().addAll(function);
	}

	@Override
	public void setUsage(List<String> usage) {
		buildingInstallationType.unsetUsage();
		buildingInstallationType.getUsage().addAll(usage);
	}

	@Override
	public void setLod2Geometry(GeometryProperty lod2Geometry) {
		buildingInstallationType.setLod2Geometry(((GeometryPropertyImpl)lod2Geometry).getJAXBObject());
	}

	@Override
	public void setLod3Geometry(GeometryProperty lod3Geometry) {
		buildingInstallationType.setLod3Geometry(((GeometryPropertyImpl)lod3Geometry).getJAXBObject());
	}

	@Override
	public void setLod4Geometry(GeometryProperty lod4Geometry) {
		buildingInstallationType.setLod4Geometry(((GeometryPropertyImpl)lod4Geometry).getJAXBObject());
	}

	@Override
	public void addGenericApplicationPropertyOfBuildingInstallation(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			buildingInstallationType.get_GenericApplicationPropertyOfBuildingInstallation().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfBuildingInstallation() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : buildingInstallationType.get_GenericApplicationPropertyOfBuildingInstallation()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfBuildingInstallation(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			buildingInstallationType.unset_GenericApplicationPropertyOfBuildingInstallation();
			buildingInstallationType.get_GenericApplicationPropertyOfBuildingInstallation().addAll(elemList);
		}
	}

	@Override
	public boolean isSetClazz() {
		return buildingInstallationType.isSetClazz();
	}

	@Override
	public boolean isSetFunction() {
		return buildingInstallationType.isSetFunction();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfBuildingInstallation() {
		return buildingInstallationType.isSet_GenericApplicationPropertyOfBuildingInstallation();
	}

	@Override
	public boolean isSetLod2Geometry() {
		return buildingInstallationType.isSetLod2Geometry();
	}

	@Override
	public boolean isSetLod3Geometry() {
		return buildingInstallationType.isSetLod3Geometry();
	}

	@Override
	public boolean isSetLod4Geometry() {
		return buildingInstallationType.isSetLod4Geometry();
	}

	@Override
	public boolean isSetUsage() {
		return buildingInstallationType.isSetUsage();
	}

	@Override
	public void unsetClazz() {
		buildingInstallationType.setClazz(null);
	}

	@Override
	public void unsetFunction() {
		buildingInstallationType.unsetFunction();
	}

	@Override
	public void unsetGenericApplicationPropertyOfBuildingInstallation() {
		buildingInstallationType.unset_GenericApplicationPropertyOfBuildingInstallation();
	}

	@Override
	public void unsetLod2Geometry() {
		buildingInstallationType.setLod2Geometry(null);
	}

	@Override
	public void unsetLod3Geometry() {
		buildingInstallationType.setLod3Geometry(null);
	}

	@Override
	public void unsetLod4Geometry() {
		buildingInstallationType.setLod4Geometry(null);
	}

	@Override
	public void unsetUsage() {
		buildingInstallationType.unsetUsage();
	}

	@Override
	public boolean unsetFunction(String function) {
		if (buildingInstallationType.isSetFunction())
			return buildingInstallationType.getFunction().remove(function);
		
		return false;
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfBuildingInstallation(ADEComponent adeObject) {
		if (buildingInstallationType.isSet_GenericApplicationPropertyOfBuildingInstallation()) {
			Iterator<JAXBElement<?>> iter = buildingInstallationType.get_GenericApplicationPropertyOfBuildingInstallation().iterator();
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

	@Override
	public boolean unsetUsage(String usage) {
		if (buildingInstallationType.isSetUsage())
			return buildingInstallationType.getUsage().remove(usage);
		
		return false;
	}

}
