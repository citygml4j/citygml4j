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
package org.citygml4j.model.citygml.texturedsurface;

import java.util.List;

public interface _SimpleTexture extends _AbstractAppearance {
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
	public void setTextureType(_TextureType _textureType);
	public void setRepeat(Boolean repeat);
	public void unsetTextureType();
	public void unsetRepeat();
}
