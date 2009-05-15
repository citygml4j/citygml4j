package org.citygml4j.impl.jaxb.citygml.core._1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml.core._1.AbstractCityObjectType;
import org.citygml4j.jaxb.citygml.core._1.GeneralizationRelationType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.GeneralizationRelation;

public class GeneralizationRelationImpl extends CityGMLBaseImpl implements	GeneralizationRelation {
	private GeneralizationRelationType generalizationRelationType;

	public GeneralizationRelationImpl() {
		generalizationRelationType = new GeneralizationRelationType();
	}

	public GeneralizationRelationImpl(GeneralizationRelationType generalizationRelationType) {
		this.generalizationRelationType = generalizationRelationType;
	}

	@Override
	public GeneralizationRelationType getJAXBObject() {
		return generalizationRelationType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GENERALIZATIONRELATION;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}
	
	public CityObject getObject() {
		CityObject cityObject = null;		
		if (generalizationRelationType.isSet_CityObject()) 
			cityObject = ModelMapper.CITYOBJECT_1.toCityGML(generalizationRelationType.get_CityObject());
		
		return cityObject;
	}

	public String getActuate() {
		return generalizationRelationType.getActuate();
	}

	public String getArcrole() {
		return generalizationRelationType.getArcrole();
	}

	public String getHref() {
		return generalizationRelationType.getHref();
	}

	public String getRemoteSchema() {
		return generalizationRelationType.getRemoteSchema();
	}

	public String getRole() {
		return generalizationRelationType.getRole();
	}

	public String getShow() {
		return generalizationRelationType.getShow();
	}

	public String getTitle() {
		return generalizationRelationType.getTitle();
	}

	public String getType() {
		return generalizationRelationType.getType();
	}

	public void setActuate(String actuate) {
		generalizationRelationType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		generalizationRelationType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		generalizationRelationType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		generalizationRelationType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		generalizationRelationType.setRole(role);
	}

	public void setShow(String show) {
		generalizationRelationType.setShow(show);
	}

	public void setTitle(String title) {
		generalizationRelationType.setTitle(title);
	}

	public void setType(String type) {
		generalizationRelationType.setType(type);
	}

	@SuppressWarnings("unchecked")
	public void setObject(CityObject object) {
		JAXBElement<? extends AbstractCityObjectType> cityObjectElem = (JAXBElement<? extends AbstractCityObjectType>)ModelMapper.CITYOBJECT_1.toJAXB(object);
		
		if (cityObjectElem != null)
			generalizationRelationType.set_CityObject(cityObjectElem);
	}

	public boolean isSetObject() {
		return generalizationRelationType.isSet_CityObject();
	}

	public void unsetObject() {
		generalizationRelationType.set_CityObject(null);
	}
	
	public boolean isSetActuate() {
		return generalizationRelationType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return generalizationRelationType.isSetArcrole();
	}

	public boolean isSetHref() {
		return generalizationRelationType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return generalizationRelationType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return generalizationRelationType.isSetRole();
	}

	public boolean isSetShow() {
		return generalizationRelationType.isSetShow();
	}

	public boolean isSetTitle() {
		return generalizationRelationType.isSetTitle();
	}

	public boolean isSetType() {
		return generalizationRelationType.isSetType();
	}

	public void unsetActuate() {
		generalizationRelationType.setActuate(null);
	}

	public void unsetArcrole() {
		generalizationRelationType.setArcrole(null);
	}

	public void unsetHref() {
		generalizationRelationType.setHref(null);
	}

	public void unsetRemoteSchema() {
		generalizationRelationType.setRemoteSchema(null);
	}

	public void unsetRole() {
		generalizationRelationType.setRole(null);
	}

	public void unsetShow() {
		generalizationRelationType.setShow(null);
	}

	public void unsetTitle() {
		generalizationRelationType.setTitle(null);
	}

	public void unsetType() {
		generalizationRelationType.setType(null);
	}
}
