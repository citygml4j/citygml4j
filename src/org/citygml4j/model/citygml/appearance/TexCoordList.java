package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface TexCoordList extends TextureParameterization {
	public List<TextureCoordinates> getTextureCoordinates();
	public List<ADEComponent> getGenericApplicationPropertyOfTexCoordList();
	public boolean isSetTextureCoordinates();
	public boolean isSetGenericApplicationPropertyOfTexCoordList();
	
	public void setTextureCoordinates(List<TextureCoordinates> textureCoordinates);
	public void addTextureCoordinates(TextureCoordinates textureCoordinates);	
	public void addGenericApplicationPropertyOfTexCoordList(ADEComponent ade);
	public void setGenericApplicationPropertyOfTexCoordList(List<ADEComponent> ade);
	public void unsetTextureCoordinates();
	public boolean unsetTextureCoordinates(TextureCoordinates textureCoordinates);
	public void unsetGenericApplicationPropertyOfTexCoordList();
	public boolean unsetGenericApplicationPropertyOfTexCoordList(ADEComponent ade);
}
