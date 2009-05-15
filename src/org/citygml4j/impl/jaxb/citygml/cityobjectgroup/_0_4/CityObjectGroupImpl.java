package org.citygml4j.impl.jaxb.citygml.cityobjectgroup._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometryPropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.CityObjectGroupMemberType;
import org.citygml4j.jaxb.citygml._0_4.CityObjectGroupType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModule;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.GeometryProperty;

public class CityObjectGroupImpl extends CityObjectImpl implements CityObjectGroup {
	private CityObjectGroupType cityObjectGroupType;

	public CityObjectGroupImpl() {
		this(new CityObjectGroupType());
	}

	public CityObjectGroupImpl(CityObjectGroupType cityObjectGroupType) {
		super(cityObjectGroupType);
		this.cityObjectGroupType = cityObjectGroupType;
	}

	@Override
	public CityObjectGroupType getJAXBObject() {
		return cityObjectGroupType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITYOBJECTGROUP;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CityObjectGroupModule.v0_4_0;
	}

	public void addFunction(String function) {
		cityObjectGroupType.getFunction().add(function);
	}

	public void addGroupMember(CityObjectGroupMember groupMember) {
		cityObjectGroupType.getGroupMember().add(((CityObjectGroupMemberImpl)groupMember).getJAXBObject());
	}

	public void addUsage(String usage) {
		cityObjectGroupType.getUsage().add(usage);
	}

	public String getClazz() {
		return cityObjectGroupType.getClazz();
	}

	public List<String> getFunction() {
		return cityObjectGroupType.getFunction();
	}

	public GeometryProperty getGeometry() {
		if (cityObjectGroupType.isSetGeometry())
			return new GeometryPropertyImpl(cityObjectGroupType.getGeometry());

		return null;
	}

	public List<CityObjectGroupMember> getGroupMember() {
		List<CityObjectGroupMember> groupMemberList = new ArrayList<CityObjectGroupMember>();

		for (CityObjectGroupMemberType groupMemberType : cityObjectGroupType.getGroupMember())
			groupMemberList.add(new CityObjectGroupMemberImpl(groupMemberType));

		return groupMemberList;
	}

	public CityObjectGroupParent getParent() {
		if (cityObjectGroupType.isSetParent())
			return new CityObjectGroupParentImpl(cityObjectGroupType.getParent());

		return null;
	}

	public List<String> getUsage() {
		return cityObjectGroupType.getUsage();
	}

	public void setClazz(String clazz) {
		cityObjectGroupType.setClazz(clazz);
	}

	public void setFunction(List<String> function) {
		cityObjectGroupType.unsetFunction();
		cityObjectGroupType.getFunction().addAll(function);
	}

	public void setGeometry(GeometryProperty geometry) {
		cityObjectGroupType.setGeometry(((GeometryPropertyImpl)geometry).getJAXBObject());
	}

	public void setGroupMember(List<CityObjectGroupMember> groupMember) {
		List<CityObjectGroupMemberType> groupMemberTypeList = new ArrayList<CityObjectGroupMemberType>();

		for (CityObjectGroupMember member : groupMember)
			groupMemberTypeList.add(((CityObjectGroupMemberImpl)member).getJAXBObject());

		cityObjectGroupType.unsetGroupMember();
		cityObjectGroupType.getGroupMember().addAll(groupMemberTypeList);
	}

	public void setParent(CityObjectGroupParent parent) {
		cityObjectGroupType.setParent(((CityObjectGroupParentImpl)parent).getJAXBObject());
	}

	public void setUsage(List<String> usage) {
		cityObjectGroupType.unsetUsage();
		cityObjectGroupType.getUsage().addAll(usage);
	}

	@Override
	public void calcBoundedBy() {
		if (getGeometry() != null) {
			GeometryProperty geometryProperty = getGeometry();
			AbstractGeometry abstractGeometry = geometryProperty.getGeometry();
			if (abstractGeometry != null) {
				calcBoundedBy(abstractGeometry);
			} else {
				// xlink?
			}
		}

		if (isSetGroupMember()) {
			for (CityObjectGroupMember groupMember : getGroupMember()) {
				if (groupMember.isSetObject()) {
					calcBoundedBy(groupMember.getObject());
				} else {
					// xlink?
				}
			}
		}
	}

	public void addGenericApplicationPropertyOfCityObjectGroup(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			cityObjectGroupType.get_GenericApplicationPropertyOfCityObjectGroup().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfCityObjectGroup() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : cityObjectGroupType.get_GenericApplicationPropertyOfCityObjectGroup()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfCityObjectGroup(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			cityObjectGroupType.unset_GenericApplicationPropertyOfCityObjectGroup();
			cityObjectGroupType.get_GenericApplicationPropertyOfCityObjectGroup().addAll(elemList);
		}
	}

	public boolean isSetClazz() {
		return cityObjectGroupType.isSetClazz();
	}

	public boolean isSetFunction() {
		return cityObjectGroupType.isSetFunction();
	}

	public boolean isSetGenericApplicationPropertyOfCityObjectGroup() {
		return cityObjectGroupType.isSet_GenericApplicationPropertyOfCityObjectGroup();
	}

	public boolean isSetGeometry() {
		return cityObjectGroupType.isSetGeometry();
	}

	public boolean isSetGroupMember() {
		return cityObjectGroupType.isSetGroupMember();
	}

	public boolean isSetParent() {
		return cityObjectGroupType.isSetParent();
	}

	public boolean isSetUsage() {
		return cityObjectGroupType.isSetUsage();
	}

	public void unsetClazz() {
		cityObjectGroupType.setClazz(null);
	}

	public void unsetFunction() {
		cityObjectGroupType.unsetFunction();
	}

	public void unsetGenericApplicationPropertyOfCityObjectGroup() {
		cityObjectGroupType.unset_GenericApplicationPropertyOfCityObjectGroup();
	}

	public void unsetGeometry() {
		cityObjectGroupType.setGeometry(null);
	}

	public void unsetGroupMember() {
		cityObjectGroupType.unsetGroupMember();
	}

	public void unsetParent() {
		cityObjectGroupType.setParent(null);
	}

	public void unsetUsage() {
		cityObjectGroupType.unsetUsage();
	}

	public boolean unsetFunction(String function) {
		if (cityObjectGroupType.isSetFunction())
			return cityObjectGroupType.getFunction().remove(function);
		
		return false;
	}

	public boolean unsetGenericApplicationPropertyOfCityObjectGroup(ADEComponent adeObject) {
		if (cityObjectGroupType.isSet_GenericApplicationPropertyOfCityObjectGroup()) {
			Iterator<JAXBElement<?>> iter = cityObjectGroupType.get_GenericApplicationPropertyOfCityObjectGroup().iterator();
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

	public boolean unsetGroupMember(CityObjectGroupMember groupMember) {
		if (cityObjectGroupType.isSetGroupMember())
			return cityObjectGroupType.getGroupMember().remove(((CityObjectGroupMemberImpl)groupMember).getJAXBObject());
			
		return false;
	}

	public boolean unsetUsage(String usage) {
		if (cityObjectGroupType.isSetUsage())
			return cityObjectGroupType.getUsage().remove(usage);
		
		return false;
	}

}
