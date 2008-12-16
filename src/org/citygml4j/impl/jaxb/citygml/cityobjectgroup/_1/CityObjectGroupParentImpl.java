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

	@Override
	public CityObject getObject() {
		CityObject cityObject = null;		
		if (cityObjectGroupParentType.isSet_CityObject()) 
			cityObject = ModelMapper.CITYOBJECT_1.toCityGML(cityObjectGroupParentType.get_CityObject());
		
		return cityObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setObject(CityObject object) {
		JAXBElement<? extends AbstractCityObjectType> cityObjectElem = (JAXBElement<? extends AbstractCityObjectType>)ModelMapper.CITYOBJECT_1.toJAXB(object);
		
		if (cityObjectElem != null)
			cityObjectGroupParentType.set_CityObject(cityObjectElem);
	}

	@Override
	public String getActuate() {
		return cityObjectGroupParentType.getActuate();
	}

	@Override
	public String getArcrole() {
		return cityObjectGroupParentType.getArcrole();
	}

	@Override
	public String getHref() {
		return cityObjectGroupParentType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return cityObjectGroupParentType.getRemoteSchema();
	}

	@Override
	public String getShow() {
		return cityObjectGroupParentType.getShow();
	}

	@Override
	public String getTitle() {
		return cityObjectGroupParentType.getTitle();
	}

	@Override
	public String getType() {
		return cityObjectGroupParentType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		cityObjectGroupParentType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		cityObjectGroupParentType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		cityObjectGroupParentType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		cityObjectGroupParentType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setShow(String show) {
		cityObjectGroupParentType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		cityObjectGroupParentType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		cityObjectGroupParentType.setType(type);
	}

	@Override
	public String getRole() {
		return cityObjectGroupParentType.getRole();
	}

	@Override
	public void setRole(String role) {
		cityObjectGroupParentType.setRole(role);
	}
	
	@Override
	public boolean isSetObject() {
		return cityObjectGroupParentType.isSet_CityObject();
	}

	@Override
	public void unsetObject() {
		cityObjectGroupParentType.set_CityObject(null);
	}
	
	@Override
	public boolean isSetActuate() {
		return cityObjectGroupParentType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return cityObjectGroupParentType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return cityObjectGroupParentType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return cityObjectGroupParentType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return cityObjectGroupParentType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return cityObjectGroupParentType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return cityObjectGroupParentType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return cityObjectGroupParentType.isSetType();
	}

	@Override
	public void unsetActuate() {
		cityObjectGroupParentType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		cityObjectGroupParentType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		cityObjectGroupParentType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		cityObjectGroupParentType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		cityObjectGroupParentType.setRole(null);
	}

	@Override
	public void unsetShow() {
		cityObjectGroupParentType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		cityObjectGroupParentType.setTitle(null);
	}

	@Override
	public void unsetType() {
		cityObjectGroupParentType.setType(null);
	}
}
