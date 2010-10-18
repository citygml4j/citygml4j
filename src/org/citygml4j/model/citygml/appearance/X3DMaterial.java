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
