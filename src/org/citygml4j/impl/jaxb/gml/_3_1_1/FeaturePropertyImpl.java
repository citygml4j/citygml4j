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
	
	@Override
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
	@Override
	public void setFeature(AbstractFeature abstractFeature) {
		if (abstractFeature instanceof ADEComponent) {
			ADEComponent ade = (ADEComponent)abstractFeature;
			JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(ade);
			
			if (jaxbElem != null && jaxbElem.getValue() instanceof AbstractFeatureType)
				featurePropertyType.set_Feature((JAXBElement<? extends AbstractFeatureType>)jaxbElem);
		}
	}

	@Override
	public String getActuate() {
		return featurePropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return featurePropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return featurePropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return featurePropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return featurePropertyType.getRole();
	}

	@Override
	public String getShow() {
		return featurePropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return featurePropertyType.getTitle();
	}

	@Override
	public String getType() {
		return featurePropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		featurePropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		featurePropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		featurePropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		featurePropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		featurePropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		featurePropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		featurePropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		featurePropertyType.setType(type);
	}

	@Override
	public boolean isSetActuate() {
		return featurePropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return featurePropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return featurePropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return featurePropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return featurePropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return featurePropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return featurePropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return featurePropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		featurePropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		featurePropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		featurePropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		featurePropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		featurePropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		featurePropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		featurePropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		featurePropertyType.setType(null);
	}

	@Override
	public boolean isSetFeature() {
		return featurePropertyType.isSet_Feature();
	}

	@Override
	public void unsetFeature() {
		featurePropertyType.set_Feature(null);
	}
	
}
