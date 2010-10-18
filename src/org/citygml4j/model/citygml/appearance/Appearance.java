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
package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.feature.AbstractFeature;

public interface Appearance extends AppearanceModuleComponent, AbstractFeature {
	public String getTheme();
	public List<SurfaceDataProperty> getSurfaceDataMember();
	public List<ADEComponent> getGenericApplicationPropertyOfAppearance();
	public boolean isSetTheme();
	public boolean isSetSurfaceDataMember();
	public boolean isSetGenericApplicationPropertyOfAppearance();
	
	public void setTheme(String theme);
	public void setSurfaceDataMember(List<SurfaceDataProperty> surfaceDataMember);
	public void addSurfaceDataMember(SurfaceDataProperty surfaceDataMember);	
	public void addGenericApplicationPropertyOfAppearance(ADEComponent ade);
	public void setGenericApplicationPropertyOfAppearance(List<ADEComponent> ade);
	public void unsetTheme();
	public void unsetSurfaceDataMember();
	public boolean unsetSurfaceDataMember(SurfaceDataProperty surfaceDataMember);
	public void unsetGenericApplicationPropertyOfAppearance();
	public boolean unsetGenericApplicationPropertyOfAppearance(ADEComponent ade);
}
