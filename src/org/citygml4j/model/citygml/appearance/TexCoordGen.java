package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface TexCoordGen extends TextureParameterization {
	public WorldToTexture getWorldToTexture();
	public List<ADEComponent> getGenericApplicationPropertyOfTexCoordGen();
	public boolean isSetWorldToTexture();
	public boolean isSetGenericApplicationPropertyOfTexCoordGen();
	
	public void setWorldToTexture(WorldToTexture worldToTexture);	
	public void addGenericApplicationPropertyOfTexCoordGen(ADEComponent ade);
	public void setGenericApplicationPropertyOfTexCoordGen(List<ADEComponent> ade);
	public void unsetWorldToTexture();
	public void unsetGenericApplicationPropertyOfTexCoordGen();
	public boolean unsetGenericApplicationPropertyOfTexCoordGen(ADEComponent ade);
}
