package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface AbstractTexture extends AbstractSurfaceData {
	public String getImageURI();
	public String getMimeType();
	public TextureType getTextureType();
	public WrapMode getWrapMode();
	public ColorPlusOpacity getBorderColor();
	public List<ADEComponent> getGenericApplicationPropertyOfTexture();
	public boolean isSetImageUri();
	public boolean isSetMimeType();
	public boolean isSetTextureType();
	public boolean isSetWrapMode();
	public boolean isSetBorderColor();
	public boolean isSetGenericApplicationPropertyOfTexture();	
	
	public void setImageURI(String imageURI);
	public void setMimeType(String mimeType);
	public void setTextureType(TextureType textureType);
	public void setWrapMode(WrapMode wrapMode);
	public void setBorderColor(ColorPlusOpacity borderColor);	
	public void addGenericApplicationPropertyOfTexture(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfTexture(List<ADEComponent> adeObject);
	public void unsetImageUri();
	public void unsetMimeType();
	public void unsetTextureType();
	public void unsetWrapMode();
	public void unsetBorderColor();
	public void unsetGenericApplicationPropertyOfTexture();
	public boolean unsetGenericApplicationPropertyOfTexture(ADEComponent adeObject);
}
