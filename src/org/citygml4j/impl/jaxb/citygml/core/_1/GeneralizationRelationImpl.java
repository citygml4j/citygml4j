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
	
	@Override
	public CityObject getObject() {
		CityObject cityObject = null;		
		if (generalizationRelationType.isSet_CityObject()) 
			cityObject = ModelMapper.CITYOBJECT_1.toCityGML(generalizationRelationType.get_CityObject());
		
		return cityObject;
	}

	@Override
	public String getActuate() {
		return generalizationRelationType.getActuate();
	}

	@Override
	public String getArcrole() {
		return generalizationRelationType.getArcrole();
	}

	@Override
	public String getHref() {
		return generalizationRelationType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return generalizationRelationType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return generalizationRelationType.getRole();
	}

	@Override
	public String getShow() {
		return generalizationRelationType.getShow();
	}

	@Override
	public String getTitle() {
		return generalizationRelationType.getTitle();
	}

	@Override
	public String getType() {
		return generalizationRelationType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		generalizationRelationType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		generalizationRelationType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		generalizationRelationType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		generalizationRelationType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		generalizationRelationType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		generalizationRelationType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		generalizationRelationType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		generalizationRelationType.setType(type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setObject(CityObject object) {
		JAXBElement<? extends AbstractCityObjectType> cityObjectElem = (JAXBElement<? extends AbstractCityObjectType>)ModelMapper.CITYOBJECT_1.toJAXB(object);
		
		if (cityObjectElem != null)
			generalizationRelationType.set_CityObject(cityObjectElem);
	}

	@Override
	public boolean isSetObject() {
		return generalizationRelationType.isSet_CityObject();
	}

	@Override
	public void unsetObject() {
		generalizationRelationType.set_CityObject(null);
	}
	
	@Override
	public boolean isSetActuate() {
		return generalizationRelationType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return generalizationRelationType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return generalizationRelationType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return generalizationRelationType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return generalizationRelationType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return generalizationRelationType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return generalizationRelationType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return generalizationRelationType.isSetType();
	}

	@Override
	public void unsetActuate() {
		generalizationRelationType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		generalizationRelationType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		generalizationRelationType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		generalizationRelationType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		generalizationRelationType.setRole(null);
	}

	@Override
	public void unsetShow() {
		generalizationRelationType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		generalizationRelationType.setTitle(null);
	}

	@Override
	public void unsetType() {
		generalizationRelationType.setType(null);
	}
}
