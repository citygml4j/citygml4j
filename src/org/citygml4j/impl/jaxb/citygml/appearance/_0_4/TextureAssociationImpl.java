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

	@Override
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

	@Override
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

	@Override
	public String getUri() {
		return textureAssociationType.getUri();
	}

	@Override
	public void setUri(String uri) {
		textureAssociationType.setUri(uri);
	}

	@Override
	public String getActuate() {
		return textureAssociationType.getActuate();
	}

	@Override
	public String getArcrole() {
		return textureAssociationType.getArcrole();
	}

	@Override
	public String getHref() {
		return textureAssociationType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return textureAssociationType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return textureAssociationType.getRole();
	}

	@Override
	public String getShow() {
		return textureAssociationType.getShow();
	}

	@Override
	public String getTitle() {
		return textureAssociationType.getTitle();
	}

	@Override
	public String getType() {
		return textureAssociationType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		textureAssociationType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		textureAssociationType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		textureAssociationType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		textureAssociationType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		textureAssociationType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		textureAssociationType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		textureAssociationType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		textureAssociationType.setType(type);
	}

	@Override
	public boolean isSetTextureParameterization() {
		return textureAssociationType.isSet_TextureParameterization();
	}

	@Override
	public boolean isSetUri() {
		return textureAssociationType.isSetUri();
	}

	@Override
	public void unsetTextureParameterization() {
		textureAssociationType.set_TextureParameterization(null);
	}

	@Override
	public void unsetUri() {
		textureAssociationType.setUri(null);
	}

	@Override
	public boolean isSetActuate() {
		return textureAssociationType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return textureAssociationType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return textureAssociationType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return textureAssociationType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return textureAssociationType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return textureAssociationType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return textureAssociationType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return textureAssociationType.isSetType();
	}

	@Override
	public void unsetActuate() {
		textureAssociationType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		textureAssociationType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		textureAssociationType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		textureAssociationType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		textureAssociationType.setRole(null);
	}

	@Override
	public void unsetShow() {
		textureAssociationType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		textureAssociationType.setTitle(null);
	}

	@Override
	public void unsetType() {
		textureAssociationType.setType(null);
	}
}
