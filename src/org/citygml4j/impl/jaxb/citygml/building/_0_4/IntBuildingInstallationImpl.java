package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometryPropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.IntBuildingInstallationType;
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
		return BuildingModule.v0_4_0;
	}

	@Override
	public String getClazz() {
		return intBuildingInstallationType.getClazz();
	}

	@Override
	public List<String> getFunction() {
		return intBuildingInstallationType.getFunction();
	}

	@Override
	public GeometryProperty getLod4Geometry() {
		if (intBuildingInstallationType.isSetLod4Geometry())
			return new GeometryPropertyImpl(intBuildingInstallationType.getLod4Geometry());

		return null;
	}

	@Override
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

	@Override
	public void addFunction(String function) {
		intBuildingInstallationType.getFunction().add(function);
	}

	@Override
	public void addUsage(String usage) {
		intBuildingInstallationType.getUsage().add(usage);
	}

	@Override
	public void setClazz(String clazz) {
		intBuildingInstallationType.setClazz(clazz);
	}

	@Override
	public void setFunction(List<String> function) {
		intBuildingInstallationType.unsetFunction();
		intBuildingInstallationType.getFunction().addAll(function);
	}

	@Override
	public void setUsage(List<String> usage) {
		intBuildingInstallationType.unsetUsage();
		intBuildingInstallationType.getUsage().addAll(usage);
	}

	@Override
	public void setLod4Geometry(GeometryProperty lod4Geometry) {
		intBuildingInstallationType.setLod4Geometry(((GeometryPropertyImpl)lod4Geometry).getJAXBObject());
	}

	@Override
	public void addGenericApplicationPropertyOfIntBuildingInstallation(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			intBuildingInstallationType.get_GenericApplicationPropertyOfIntBuildingInstallation().add(jaxbElem);
	}

	@Override
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

	@Override
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

	@Override
	public boolean isSetClazz() {
		return intBuildingInstallationType.isSetClazz();
	}

	@Override
	public boolean isSetFunction() {
		return intBuildingInstallationType.isSetFunction();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfIntBuildingInstallation() {
		return intBuildingInstallationType.isSet_GenericApplicationPropertyOfIntBuildingInstallation();
	}

	@Override
	public boolean isSetLod4Geometry() {
		return intBuildingInstallationType.isSetLod4Geometry();
	}

	@Override
	public boolean isSetUsage() {
		return intBuildingInstallationType.isSetUsage();
	}

	@Override
	public void unsetClazz() {
		intBuildingInstallationType.setClazz(null);
	}

	@Override
	public void unsetFunction() {
		intBuildingInstallationType.unsetFunction();
	}

	@Override
	public void unsetGenericApplicationPropertyOfIntBuildingInstallation() {
		intBuildingInstallationType.unset_GenericApplicationPropertyOfIntBuildingInstallation();
	}

	@Override
	public void unsetLod4Geometry() {
		intBuildingInstallationType.setLod4Geometry(null);
	}

	@Override
	public void unsetUsage() {
		intBuildingInstallationType.unsetUsage();
	}

	@Override
	public boolean unsetFunction(String function) {
		if (intBuildingInstallationType.isSetFunction())
			return intBuildingInstallationType.getFunction().remove(function);
		
		return false;
	}

	@Override
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

	@Override
	public boolean unsetUsage(String usage) {
		if (intBuildingInstallationType.isSetUsage())
			return intBuildingInstallationType.getUsage().remove(usage);
		
		return false;
	}

}
