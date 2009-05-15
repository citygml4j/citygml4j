package org.citygml4j.impl.jaxb.citygml.cityobjectgroup._1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._1.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml.core._1.AbstractCityObjectType;
import org.citygml4j.jaxb.citygml.grp._1.CityObjectGroupParentType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModule;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.citygml.core.CityObject;

public class CityObjectGroupParentImpl extends CityGMLBaseImpl implements CityObjectGroupParent {
	CityObjectGroupParentType cityObjectGroupParentType;
	
	public CityObjectGroupParentImpl() {
		cityObjectGroupParentType = new CityObjectGroupParentType();
	}
	
	public CityObjectGroupParentImpl(CityObjectGroupParentType cityObjectGroupParentType) {
		this.cityObjectGroupParentType = cityObjectGroupParentType;
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
	public CityObjectGroupParentType getJAXBObject() {
		return cityObjectGroupParentType;
	}

	public CityObject getObject() {
		CityObject cityObject = null;		
		if (cityObjectGroupParentType.isSet_CityObject()) 
			cityObject = ModelMapper.CITYOBJECT_1.toCityGML(cityObjectGroupParentType.get_CityObject());
		
		return cityObject;
	}

	@SuppressWarnings("unchecked")
	public void setObject(CityObject object) {
		JAXBElement<? extends AbstractCityObjectType> cityObjectElem = (JAXBElement<? extends AbstractCityObjectType>)ModelMapper.CITYOBJECT_1.toJAXB(object);
		
		if (cityObjectElem != null)
			cityObjectGroupParentType.set_CityObject(cityObjectElem);
	}

	public String getActuate() {
		return cityObjectGroupParentType.getActuate();
	}

	public String getArcrole() {
		return cityObjectGroupParentType.getArcrole();
	}

	public String getHref() {
		return cityObjectGroupParentType.getHref();
	}

	public String getRemoteSchema() {
		return cityObjectGroupParentType.getRemoteSchema();
	}

	public String getShow() {
		return cityObjectGroupParentType.getShow();
	}

	public String getTitle() {
		return cityObjectGroupParentType.getTitle();
	}

	public String getType() {
		return cityObjectGroupParentType.getType();
	}

	public void setActuate(String actuate) {
		cityObjectGroupParentType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		cityObjectGroupParentType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		cityObjectGroupParentType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		cityObjectGroupParentType.setRemoteSchema(remoteSchema);
	}

	public void setShow(String show) {
		cityObjectGroupParentType.setShow(show);
	}

	public void setTitle(String title) {
		cityObjectGroupParentType.setTitle(title);
	}

	public void setType(String type) {
		cityObjectGroupParentType.setType(type);
	}

	public String getRole() {
		return cityObjectGroupParentType.getRole();
	}

	public void setRole(String role) {
		cityObjectGroupParentType.setRole(role);
	}
	
	public boolean isSetObject() {
		return cityObjectGroupParentType.isSet_CityObject();
	}

	public void unsetObject() {
		cityObjectGroupParentType.set_CityObject(null);
	}
	
	public boolean isSetActuate() {
		return cityObjectGroupParentType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return cityObjectGroupParentType.isSetArcrole();
	}

	public boolean isSetHref() {
		return cityObjectGroupParentType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return cityObjectGroupParentType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return cityObjectGroupParentType.isSetRole();
	}

	public boolean isSetShow() {
		return cityObjectGroupParentType.isSetShow();
	}

	public boolean isSetTitle() {
		return cityObjectGroupParentType.isSetTitle();
	}

	public boolean isSetType() {
		return cityObjectGroupParentType.isSetType();
	}

	public void unsetActuate() {
		cityObjectGroupParentType.setActuate(null);
	}

	public void unsetArcrole() {
		cityObjectGroupParentType.setArcrole(null);
	}

	public void unsetHref() {
		cityObjectGroupParentType.setHref(null);
	}

	public void unsetRemoteSchema() {
		cityObjectGroupParentType.setRemoteSchema(null);
	}

	public void unsetRole() {
		cityObjectGroupParentType.setRole(null);
	}

	public void unsetShow() {
		cityObjectGroupParentType.setShow(null);
	}

	public void unsetTitle() {
		cityObjectGroupParentType.setTitle(null);
	}

	public void unsetType() {
		cityObjectGroupParentType.setType(null);
	}
}
