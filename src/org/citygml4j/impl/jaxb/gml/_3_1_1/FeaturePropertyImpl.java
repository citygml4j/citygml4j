package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureType;
import org.citygml4j.jaxb.gml._3_1_1.FeaturePropertyType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.FeatureProperty;
import org.citygml4j.model.gml.GMLClass;

public class FeaturePropertyImpl extends GMLBaseImpl implements FeatureProperty {
	private FeaturePropertyType featurePropertyType;

	public FeaturePropertyImpl() {
		featurePropertyType = new FeaturePropertyType();
	}
	
	public FeaturePropertyImpl(FeaturePropertyType featurePropertyType) {
		this.featurePropertyType = featurePropertyType;
	}

	@Override
	public FeaturePropertyType getJAXBObject() {
		return featurePropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.FEATUREPROPERTY;
	}
	
	public AbstractFeature getFeature() {
		if (featurePropertyType.isSet_Feature()) {
			JAXBElement<? extends AbstractFeatureType> abstractFeature = featurePropertyType.get_Feature();
			
			if (abstractFeature.getValue() != null) {
				AbstractFeatureType elem = abstractFeature.getValue();
				QName name = abstractFeature.getName();
				
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem, name);
				if (ade != null && ade instanceof AbstractFeature)
					return (AbstractFeature)ade;
			}
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public void setFeature(AbstractFeature abstractFeature) {
		if (abstractFeature instanceof ADEComponent) {
			ADEComponent ade = (ADEComponent)abstractFeature;
			JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(ade);
			
			if (jaxbElem != null && jaxbElem.getValue() instanceof AbstractFeatureType)
				featurePropertyType.set_Feature((JAXBElement<? extends AbstractFeatureType>)jaxbElem);
		}
	}

	public String getActuate() {
		return featurePropertyType.getActuate();
	}

	public String getArcrole() {
		return featurePropertyType.getArcrole();
	}

	public String getHref() {
		return featurePropertyType.getHref();
	}

	public String getRemoteSchema() {
		return featurePropertyType.getRemoteSchema();
	}

	public String getRole() {
		return featurePropertyType.getRole();
	}

	public String getShow() {
		return featurePropertyType.getShow();
	}

	public String getTitle() {
		return featurePropertyType.getTitle();
	}

	public String getType() {
		return featurePropertyType.getType();
	}

	public void setActuate(String actuate) {
		featurePropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		featurePropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		featurePropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		featurePropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		featurePropertyType.setRole(role);
	}

	public void setShow(String show) {
		featurePropertyType.setShow(show);
	}

	public void setTitle(String title) {
		featurePropertyType.setTitle(title);
	}

	public void setType(String type) {
		featurePropertyType.setType(type);
	}

	public boolean isSetActuate() {
		return featurePropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return featurePropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return featurePropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return featurePropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return featurePropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return featurePropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return featurePropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return featurePropertyType.isSetType();
	}

	public void unsetActuate() {
		featurePropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		featurePropertyType.setArcrole(null);
	}

	public void unsetHref() {
		featurePropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		featurePropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		featurePropertyType.setRole(null);
	}

	public void unsetShow() {
		featurePropertyType.setShow(null);
	}

	public void unsetTitle() {
		featurePropertyType.setTitle(null);
	}

	public void unsetType() {
		featurePropertyType.setType(null);
	}

	public boolean isSetFeature() {
		return featurePropertyType.isSet_Feature();
	}

	public void unsetFeature() {
		featurePropertyType.set_Feature(null);
	}
	
}
