package org.citygml4j.model.citygml.appearance;

import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.gml.AssociationAttributeGroup;

public interface TextureAssociation extends CityGMLBase, AssociationAttributeGroup {
	public TextureParameterization getTextureParameterization();
	public String getUri();
	public boolean isSetTextureParameterization();
	public boolean isSetUri();

	public void setTextureParameterization(TextureParameterization textureParameterization);
	public void setUri(String uri);
	public void unsetTextureParameterization();
	public void unsetUri();
}
