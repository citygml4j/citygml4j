package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface X3DMaterial extends AbstractSurfaceData {
	public Double getAmbientIntensity();
	public Color getDiffuseColor();
	public Color getEmissiveColor();
	public Color getSpecularColor();
	public Double getShininess();
	public Double getTransparency();
	public Boolean getIsSmooth();
	public List<String> getTarget();
	public List<ADEComponent> getGenericApplicationPropertyOfX3DMaterial();
	public boolean isSetAmbientIntensity();
	public boolean isSetDiffuseColor();
	public boolean isSetEmissiveColor();
	public boolean isSetSpecularColor();
	public boolean isSetShininess();
	public boolean isSetTransparency();
	public boolean isSetIsSmooth();
	public boolean isSetTarget();
	public boolean isSetGenericApplicationPropertyOfX3DMaterial();
	
	public void setAmbientIntensity(Double ambientIntensity);
	public void setDiffuseColor(Color diffuseColor);
	public void setEmissiveColor(Color emissiveColor);
	public void setSpecularColor(Color specularColor);
	public void setShininess(Double shininess);
	public void setTransparency(Double transparency);
	public void setIsSmooth(Boolean isSmooth);
	public void setTarget(List<String> target);
	public void addTarget(String target);	
	public void addGenericApplicationPropertyOfX3DMaterial(ADEComponent ade);
	public void setGenericApplicationPropertyOfX3DMaterial(List<ADEComponent> ade);
	public void unsetAmbientIntensity();
	public void unsetDiffuseColor();
	public void unsetEmissiveColor();
	public void unsetSpecularColor();
	public void unsetShininess();
	public void unsetTransparency();
	public void unsetIsSmooth();
	public void unsetTarget();
	public boolean unsetTarget(String target);
	public void unsetGenericApplicationPropertyOfX3DMaterial();
	public boolean unsetGenericApplicationPropertyOfX3DMaterial(ADEComponent ade);
}
