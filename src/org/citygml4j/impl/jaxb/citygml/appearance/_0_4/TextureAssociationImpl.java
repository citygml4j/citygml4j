package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml._0_4.TexCoordGenType;
import org.citygml4j.jaxb.citygml._0_4.TexCoordListType;
import org.citygml4j.jaxb.citygml._0_4.TextureAssociationType;
import org.citygml4j.jaxb.citygml._0_4.TextureParameterizationType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.TextureParameterization;

public class TextureAssociationImpl extends CityGMLBaseImpl implements TextureAssociation {
	private TextureAssociationType textureAssociationType;

	public TextureAssociationImpl() {
		this.textureAssociationType = new TextureAssociationType();
	}

	public TextureAssociationImpl(TextureAssociationType textureAssociationType) {
		this.textureAssociationType = textureAssociationType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTUREASSOCIATION;
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v0_4_0;
	}

	@Override
	public TextureAssociationType getJAXBObject() {
		return textureAssociationType;
	}

	public TextureParameterization getTextureParameterization() {
		if (textureAssociationType.isSet_TextureParameterization()) {
			JAXBElement<? extends TextureParameterizationType> elem = textureAssociationType.get_TextureParameterization();

			if (elem.getValue() != null) {
				if (elem.getValue() instanceof TexCoordListType)
					return new TexCoordListImpl((TexCoordListType)elem.getValue());
				else if (elem.getValue() instanceof TexCoordGenType)
					return new TexCoordGenImpl((TexCoordGenType)elem.getValue());
			}
		}

		return null;
	}

	public void setTextureParameterization(TextureParameterization textureParameterization) {
		JAXBElement<? extends TextureParameterizationType> jaxbElem = null;

		switch (textureParameterization.getCityGMLClass()) {
		case TEXCOORDLIST:
			jaxbElem = ObjectFactory.CITYGML_0_4.createTexCoordList(((TexCoordListImpl)textureParameterization).getJAXBObject());
			break;
		case TEXCOORDGEN:
			jaxbElem = ObjectFactory.CITYGML_0_4.createTexCoordGen(((TexCoordGenImpl)textureParameterization).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			textureAssociationType.set_TextureParameterization(jaxbElem);
	}

	public String getUri() {
		return textureAssociationType.getUri();
	}

	public void setUri(String uri) {
		textureAssociationType.setUri(uri);
	}

	public String getActuate() {
		return textureAssociationType.getActuate();
	}

	public String getArcrole() {
		return textureAssociationType.getArcrole();
	}

	public String getHref() {
		return textureAssociationType.getHref();
	}

	public String getRemoteSchema() {
		return textureAssociationType.getRemoteSchema();
	}

	public String getRole() {
		return textureAssociationType.getRole();
	}

	public String getShow() {
		return textureAssociationType.getShow();
	}

	public String getTitle() {
		return textureAssociationType.getTitle();
	}

	public String getType() {
		return textureAssociationType.getType();
	}

	public void setActuate(String actuate) {
		textureAssociationType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		textureAssociationType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		textureAssociationType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		textureAssociationType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		textureAssociationType.setRole(role);
	}

	public void setShow(String show) {
		textureAssociationType.setShow(show);
	}

	public void setTitle(String title) {
		textureAssociationType.setTitle(title);
	}

	public void setType(String type) {
		textureAssociationType.setType(type);
	}

	public boolean isSetTextureParameterization() {
		return textureAssociationType.isSet_TextureParameterization();
	}

	public boolean isSetUri() {
		return textureAssociationType.isSetUri();
	}

	public void unsetTextureParameterization() {
		textureAssociationType.set_TextureParameterization(null);
	}

	public void unsetUri() {
		textureAssociationType.setUri(null);
	}

	public boolean isSetActuate() {
		return textureAssociationType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return textureAssociationType.isSetArcrole();
	}

	public boolean isSetHref() {
		return textureAssociationType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return textureAssociationType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return textureAssociationType.isSetRole();
	}

	public boolean isSetShow() {
		return textureAssociationType.isSetShow();
	}

	public boolean isSetTitle() {
		return textureAssociationType.isSetTitle();
	}

	public boolean isSetType() {
		return textureAssociationType.isSetType();
	}

	public void unsetActuate() {
		textureAssociationType.setActuate(null);
	}

	public void unsetArcrole() {
		textureAssociationType.setArcrole(null);
	}

	public void unsetHref() {
		textureAssociationType.setHref(null);
	}

	public void unsetRemoteSchema() {
		textureAssociationType.setRemoteSchema(null);
	}

	public void unsetRole() {
		textureAssociationType.setRole(null);
	}

	public void unsetShow() {
		textureAssociationType.setShow(null);
	}

	public void unsetTitle() {
		textureAssociationType.setTitle(null);
	}

	public void unsetType() {
		textureAssociationType.setType(null);
	}
}
