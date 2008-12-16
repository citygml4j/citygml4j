package org.citygml4j.model.citygml.texturedsurface;

import java.util.List;

public interface _SimpleTexture extends _Appearance {
	public String getTextureMap();
	public List<Double> getTextureCoordinates();
	public _TextureType getTextureType();
	public Boolean getRepeat();
	public boolean isSetTextureMap();
	public boolean isSetTextureCoordinates();
	public boolean isSetTextureType();
	public boolean isSetRepeat();

	public void setTextureMap(String textureMap);
	public void setTextureCoordinates(List<Double> textureCoordinates);
	public void setTextureType(_TextureType textureType);
	public void setRepeat(Boolean repeat);
	public void unsetTextureType();
	public void unsetRepeat();
}
