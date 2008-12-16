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

	@Override
	public String getGroupRole() {
		return cityObjectGroupMemberType.getGroupRole();
	}

	@Override
	public void setGroupRole(String groupRole) {
		cityObjectGroupMemberType.setGroupRole(groupRole);
	}

	@Override
	public CityObject getObject() {
		CityObject cityObject = null;		
		if (cityObjectGroupMemberType.isSet_CityObject()) 
			cityObject = ModelMapper.CITYOBJECT_1.toCityGML(cityObjectGroupMemberType.get_CityObject());
		
		return cityObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setObject(CityObject object) {
		JAXBElement<? extends AbstractCityObjectType> cityObjectElem = (JAXBElement<? extends AbstractCityObjectType>)ModelMapper.CITYOBJECT_1.toJAXB(object);
		
		if (cityObjectElem != null)
			cityObjectGroupMemberType.set_CityObject(cityObjectElem);
	}

	@Override
	public String getActuate() {
		return cityObjectGroupMemberType.getActuate();
	}

	@Override
	public String getArcrole() {
		return cityObjectGroupMemberType.getArcrole();
	}

	@Override
	public String getHref() {
		return cityObjectGroupMemberType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return cityObjectGroupMemberType.getRemoteSchema();
	}

	@Override
	public String getShow() {
		return cityObjectGroupMemberType.getShow();
	}

	@Override
	public String getTitle() {
		return cityObjectGroupMemberType.getTitle();
	}

	@Override
	public String getType() {
		return cityObjectGroupMemberType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		cityObjectGroupMemberType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		cityObjectGroupMemberType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		cityObjectGroupMemberType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		cityObjectGroupMemberType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setShow(String show) {
		cityObjectGroupMemberType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		cityObjectGroupMemberType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		cityObjectGroupMemberType.setType(type);
	}

	@Override
	public String getRole() {
		return cityObjectGroupMemberType.getRole();
	}

	@Override
	public void setRole(String role) {
		cityObjectGroupMemberType.setRole(role);
	}
	
	@Override
	public boolean isSetObject() {
		return cityObjectGroupMemberType.isSet_CityObject();
	}

	@Override
	public void unsetObject() {
		cityObjectGroupMemberType.set_CityObject(null);
	}
	
	@Override
	public boolean isSetActuate() {
		return cityObjectGroupMemberType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return cityObjectGroupMemberType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return cityObjectGroupMemberType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return cityObjectGroupMemberType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return cityObjectGroupMemberType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return cityObjectGroupMemberType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return cityObjectGroupMemberType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return cityObjectGroupMemberType.isSetType();
	}

	@Override
	public void unsetActuate() {
		cityObjectGroupMemberType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		cityObjectGroupMemberType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		cityObjectGroupMemberType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		cityObjectGroupMemberType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		cityObjectGroupMemberType.setRole(null);
	}

	@Override
	public void unsetShow() {
		cityObjectGroupMemberType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		cityObjectGroupMemberType.setTitle(null);
	}

	@Override
	public void unsetType() {
		cityObjectGroupMemberType.setType(null);
	}

	@Override
	public boolean isSetGroupRole() {
		return cityObjectGroupMemberType.isSetGroupRole();
	}

	@Override
	public void unsetGroupRole() {
		cityObjectGroupMemberType.setGroupRole(null);
	}
	
}
