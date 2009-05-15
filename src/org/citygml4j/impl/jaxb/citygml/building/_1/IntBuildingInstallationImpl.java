package org.citygml4j.impl.jaxb.citygml.building._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._1.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometryPropertyImpl;
import org.citygml4j.jaxb.citygml.bldg._1.IntBuildingInstallationType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.GeometryProperty;

public class IntBuildingInstallationImpl extends CityObjectImpl implements IntBuildingInstallation {
	private IntBuildingInstallationType intBuildingInstallationType;

	public IntBuildingInstallationImpl() {
		this(new IntBuildingInstallationType());
	}

	public IntBuildingInstallationImpl(IntBuildingInstallationType intBuildingInstallationType) {
		super(intBuildingInstallationType);
		this.intBuildingInstallationType = intBuildingInstallationType;
	}

	@Override
	public IntBuildingInstallationType getJAXBObject() {
		return intBuildingInstallationType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTBUILDINGINSTALLATION;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v1_0_0;
	}

	public String getClazz() {
		return intBuildingInstallationType.getClazz();
	}

	public List<String> getFunction() {
		return intBuildingInstallationType.getFunction();
	}

	public GeometryProperty getLod4Geometry() {
		if (intBuildingInstallationType.isSetLod4Geometry())
			return new GeometryPropertyImpl(intBuildingInstallationType.getLod4Geometry());

		return null;
	}

	public List<String> getUsage() {
		return intBuildingInstallationType.getUsage();
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

	public void addFunction(String function) {
		intBuildingInstallationType.getFunction().add(function);
	}

	public void addUsage(String usage) {
		intBuildingInstallationType.getUsage().add(usage);
	}

	public void setClazz(String clazz) {
		intBuildingInstallationType.setClazz(clazz);
	}

	public void setFunction(List<String> function) {
		intBuildingInstallationType.unsetFunction();
		intBuildingInstallationType.getFunction().addAll(function);
	}

	public void setUsage(List<String> usage) {
		intBuildingInstallationType.unsetUsage();
		intBuildingInstallationType.getUsage().addAll(usage);
	}

	public void setLod4Geometry(GeometryProperty lod4Geometry) {
		intBuildingInstallationType.setLod4Geometry(((GeometryPropertyImpl)lod4Geometry).getJAXBObject());
	}

	public void addGenericApplicationPropertyOfIntBuildingInstallation(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			intBuildingInstallationType.get_GenericApplicationPropertyOfIntBuildingInstallation().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfIntBuildingInstallation() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : intBuildingInstallationType.get_GenericApplicationPropertyOfIntBuildingInstallation()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfIntBuildingInstallation(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			intBuildingInstallationType.unset_GenericApplicationPropertyOfIntBuildingInstallation();
			intBuildingInstallationType.get_GenericApplicationPropertyOfIntBuildingInstallation().addAll(elemList);
		}
	}

	public boolean isSetClazz() {
		return intBuildingInstallationType.isSetClazz();
	}

	public boolean isSetFunction() {
		return intBuildingInstallationType.isSetFunction();
	}

	public boolean isSetGenericApplicationPropertyOfIntBuildingInstallation() {
		return intBuildingInstallationType.isSet_GenericApplicationPropertyOfIntBuildingInstallation();
	}

	public boolean isSetLod4Geometry() {
		return intBuildingInstallationType.isSetLod4Geometry();
	}

	public boolean isSetUsage() {
		return intBuildingInstallationType.isSetUsage();
	}

	public void unsetClazz() {
		intBuildingInstallationType.setClazz(null);
	}

	public void unsetFunction() {
		intBuildingInstallationType.unsetFunction();
	}

	public void unsetGenericApplicationPropertyOfIntBuildingInstallation() {
		intBuildingInstallationType.unset_GenericApplicationPropertyOfIntBuildingInstallation();
	}

	public void unsetLod4Geometry() {
		intBuildingInstallationType.setLod4Geometry(null);
	}

	public void unsetUsage() {
		intBuildingInstallationType.unsetUsage();
	}

	public boolean unsetFunction(String function) {
		if (intBuildingInstallationType.isSetFunction())
			return intBuildingInstallationType.getFunction().remove(function);
		
		return false;
	}

	public boolean unsetGenericApplicationPropertyOfIntBuildingInstallation(ADEComponent adeObject) {
		if (intBuildingInstallationType.isSet_GenericApplicationPropertyOfIntBuildingInstallation()) {
			Iterator<JAXBElement<?>> iter = intBuildingInstallationType.get_GenericApplicationPropertyOfIntBuildingInstallation().iterator();
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

	public boolean unsetUsage(String usage) {
		if (intBuildingInstallationType.isSetUsage())
			return intBuildingInstallationType.getUsage().remove(usage);
		
		return false;
	}
	
}
