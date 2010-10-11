package org.citygml4j.impl.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepOrRefImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class TextureAssociationImpl extends AssociationByRepOrRefImpl<AbstractTextureParameterization> implements TextureAssociation {
	private String uri;
	private AppearanceModule module;
	
	public TextureAssociationImpl() {
		
	}
	
	public TextureAssociationImpl(AppearanceModule module) {
		this.module = module;
	}
	
	public AbstractTextureParameterization getTextureParameterization() {
		return super.getObject();
	}

	public String getUri() {
		return uri;
	}

	public boolean isSetTextureParameterization() {
		return super.isSetObject();
	}

	public boolean isSetUri() {
		return uri != null;
	}

	public void setTextureParameterization(AbstractTextureParameterization textureParameterization) {
		super.setObject(textureParameterization);
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void unsetTextureParameterization() {
		super.unsetObject();
	}

	public void unsetUri() {
		uri = null;
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTURE_ASSOCIATION;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TextureAssociationImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TextureAssociation copy = (target == null) ? new TextureAssociationImpl() : (TextureAssociation)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetUri())
			copy.setUri(copyBuilder.copy(uri));
		
		return copy;
	}

}
