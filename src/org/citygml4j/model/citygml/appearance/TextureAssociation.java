package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.gml.AssociationAttributeGroup;

public interface TextureAssociation extends AppearanceModuleComponent, AssociationAttributeGroup, Child, Copyable {
	public TextureParameterization getTextureParameterization();
	public String getUri();
	public boolean isSetTextureParameterization();
	public boolean isSetUri();

	public void setTextureParameterization(TextureParameterization textureParameterization);
	public void setUri(String uri);
	public void unsetTextureParameterization();
	public void unsetUri();
}
