package org.citygml4j.impl.jaxb.citygml.cityobjectgroup._1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._1.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml.core._1.AbstractCityObjectType;
import org.citygml4j.jaxb.citygml.grp._1.CityObjectGroupMemberType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModule;
import org.citygml4j.model.citygml.core.CityObject;

public class CityObjectGroupMemberImpl extends CityGMLBaseImpl implements CityObjectGroupMember {
	CityObjectGroupMemberType cityObjectGroupMemberType;
	
	public CityObjectGroupMemberImpl() {
		cityObjectGroupMemberType = new CityObjectGroupMemberType();
	}
	
	public CityObjectGroupMemberImpl(CityObjectGroupMemberType cityObjectGroupMemberType) {
		this.cityObjectGroupMemberType = cityObjectGroupMemberType;
	}
	
	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITYOBJECTGROUPMEMBER;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CityObjectGroupModule.v1_0_0;
	}
	
	@Override
	public CityObjectGroupMemberType getJAXBObject() {
		return cityObjectGroupMemberType;
	}

	public String getGroupRole() {
		return cityObjectGroupMemberType.getGroupRole();
	}

	public void setGroupRole(String groupRole) {
		cityObjectGroupMemberType.setGroupRole(groupRole);
	}

	public CityObject getObject() {
		CityObject cityObject = null;		
		if (cityObjectGroupMemberType.isSet_CityObject()) 
			cityObject = ModelMapper.CITYOBJECT_1.toCityGML(cityObjectGroupMemberType.get_CityObject());
		
		return cityObject;
	}

	@SuppressWarnings("unchecked")
	public void setObject(CityObject object) {
		JAXBElement<? extends AbstractCityObjectType> cityObjectElem = (JAXBElement<? extends AbstractCityObjectType>)ModelMapper.CITYOBJECT_1.toJAXB(object);
		
		if (cityObjectElem != null)
			cityObjectGroupMemberType.set_CityObject(cityObjectElem);
	}

	public String getActuate() {
		return cityObjectGroupMemberType.getActuate();
	}

	public String getArcrole() {
		return cityObjectGroupMemberType.getArcrole();
	}

	public String getHref() {
		return cityObjectGroupMemberType.getHref();
	}

	public String getRemoteSchema() {
		return cityObjectGroupMemberType.getRemoteSchema();
	}

	public String getShow() {
		return cityObjectGroupMemberType.getShow();
	}

	public String getTitle() {
		return cityObjectGroupMemberType.getTitle();
	}

	public String getType() {
		return cityObjectGroupMemberType.getType();
	}

	public void setActuate(String actuate) {
		cityObjectGroupMemberType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		cityObjectGroupMemberType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		cityObjectGroupMemberType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		cityObjectGroupMemberType.setRemoteSchema(remoteSchema);
	}

	public void setShow(String show) {
		cityObjectGroupMemberType.setShow(show);
	}

	public void setTitle(String title) {
		cityObjectGroupMemberType.setTitle(title);
	}

	public void setType(String type) {
		cityObjectGroupMemberType.setType(type);
	}

	public String getRole() {
		return cityObjectGroupMemberType.getRole();
	}

	public void setRole(String role) {
		cityObjectGroupMemberType.setRole(role);
	}
	
	public boolean isSetObject() {
		return cityObjectGroupMemberType.isSet_CityObject();
	}

	public void unsetObject() {
		cityObjectGroupMemberType.set_CityObject(null);
	}
	
	public boolean isSetActuate() {
		return cityObjectGroupMemberType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return cityObjectGroupMemberType.isSetArcrole();
	}

	public boolean isSetHref() {
		return cityObjectGroupMemberType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return cityObjectGroupMemberType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return cityObjectGroupMemberType.isSetRole();
	}

	public boolean isSetShow() {
		return cityObjectGroupMemberType.isSetShow();
	}

	public boolean isSetTitle() {
		return cityObjectGroupMemberType.isSetTitle();
	}

	public boolean isSetType() {
		return cityObjectGroupMemberType.isSetType();
	}

	public void unsetActuate() {
		cityObjectGroupMemberType.setActuate(null);
	}

	public void unsetArcrole() {
		cityObjectGroupMemberType.setArcrole(null);
	}

	public void unsetHref() {
		cityObjectGroupMemberType.setHref(null);
	}

	public void unsetRemoteSchema() {
		cityObjectGroupMemberType.setRemoteSchema(null);
	}

	public void unsetRole() {
		cityObjectGroupMemberType.setRole(null);
	}

	public void unsetShow() {
		cityObjectGroupMemberType.setShow(null);
	}

	public void unsetTitle() {
		cityObjectGroupMemberType.setTitle(null);
	}

	public void unsetType() {
		cityObjectGroupMemberType.setType(null);
	}

	public boolean isSetGroupRole() {
		return cityObjectGroupMemberType.isSetGroupRole();
	}

	public void unsetGroupRole() {
		cityObjectGroupMemberType.setGroupRole(null);
	}
	
}
