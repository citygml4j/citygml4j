package org.citygml4j.model.citygml.texturedsurface;

public interface _Material extends _AbstractAppearance {
	public Double getShininess();
	public Double getTransparency();
	public Double getAmbientIntensity();
	public _Color getDiffuseColor();
	public _Color getEmissiveColor();
	public _Color getSpecularColor();
	public boolean isSetShininess();
	public boolean isSetTransparency();
	public boolean isSetAmbientIntensity();
	public boolean isSetDiffuseColor();
	public boolean isSetEmissiveColor();
	public boolean isSetSpecularColor();
	
	public void setShininess(Double shininess);
	public void setTransparency(Double transparency);
	public void setAmbientIntensity(Double ambientIntensity);
	public void setDiffuseColor(_Color diffuseColor);
	public void setEmissiveColor(_Color emissiveColor);
	public void setSpecularColor(_Color specularColor);
	public void unsetShininess();
	public void unsetTransparency();
	public void unsetAmbientIntensity();
	public void unsetDiffuseColor();
	public void unsetEmissiveColor();
	public void unsetSpecularColor();
}
