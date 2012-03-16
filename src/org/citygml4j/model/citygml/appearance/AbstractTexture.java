/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.basicTypes.Code;

public interface AbstractTexture extends AbstractSurfaceData {
	public String getImageURI();
	public Code getMimeType();
	public TextureType getTextureType();
	public WrapMode getWrapMode();
	public ColorPlusOpacity getBorderColor();
	public List<ADEComponent> getGenericApplicationPropertyOfTexture();
	public boolean isSetImageURI();
	public boolean isSetMimeType();
	public boolean isSetTextureType();
	public boolean isSetWrapMode();
	public boolean isSetBorderColor();
	public boolean isSetGenericApplicationPropertyOfTexture();	
	
	public void setImageURI(String imageURI);
	public void setMimeType(Code mimeType);
	public void setTextureType(TextureType textureType);
	public void setWrapMode(WrapMode wrapMode);
	public void setBorderColor(ColorPlusOpacity borderColor);	
	public void addGenericApplicationPropertyOfTexture(ADEComponent ade);
	public void setGenericApplicationPropertyOfTexture(List<ADEComponent> ade);
	public void unsetImageURI();
	public void unsetMimeType();
	public void unsetTextureType();
	public void unsetWrapMode();
	public void unsetBorderColor();
	public void unsetGenericApplicationPropertyOfTexture();
	public boolean unsetGenericApplicationPropertyOfTexture(ADEComponent ade);
}
