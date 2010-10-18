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
package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.gml.feature.AbstractFeatureCollection;

public interface CityModel extends CoreModuleComponent, AbstractFeatureCollection {
	public List<CityObjectMember> getCityObjectMember();
	public List<AppearanceMember> getAppearanceMember();
	public List<ADEComponent> getGenericApplicationPropertyOfCityModel();
	public boolean isSetCityObjectMember();
	public boolean isSetAppearanceMember();
	public boolean isSetGenericApplicationPropertyOfCityModel();

	public void addCityObjectMember(CityObjectMember cityObjectMember);
	public void setCityObjectMember(List<CityObjectMember> cityObjectMember);
	public void addAppearanceMember(AppearanceMember appearanceMember);	
	public void setAppearanceMember(List<AppearanceMember> appearanceMember);	
	public void addGenericApplicationPropertyOfCityModel(ADEComponent ade);
	public void setGenericApplicationPropertyOfCityModel(List<ADEComponent> ade);
	public void unsetCityObjectMember();
	public boolean unsetCityObjectMember(CityObjectMember cityObjectMember);
	public void unsetAppearanceMember();
	public boolean unsetAppearanceMember(AppearanceMember appearanceMember);
	public void unsetGenericApplicationPropertyOfCityModel();
	public boolean unsetGenericApplicationPropertyOfCityModel(ADEComponent ade);
}
