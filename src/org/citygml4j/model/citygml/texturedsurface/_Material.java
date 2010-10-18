/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
