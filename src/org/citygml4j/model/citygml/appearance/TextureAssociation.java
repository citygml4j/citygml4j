package org.citygml4j.model.citygml.appearance;

import org.citygml4j.model.gml.base.AssociationByRepOrRef;

public interface TextureAssociation extends AppearanceModuleComponent, AssociationByRepOrRef<AbstractTextureParameterization> {
	public AbstractTextureParameterization getTextureParameterization();
	public String getUri();
	public boolean isSetTextureParameterization();
	public boolean isSetUri();

	public void setTextureParameterization(AbstractTextureParameterization textureParameterization);
	public void setUri(String uri);
	public void unsetTextureParameterization();
	public void unsetUri();
}
