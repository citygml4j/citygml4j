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
package org.citygml4j.model.citygml.cityobjectgroup;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface CityObjectGroup extends CityObjectGroupModuleComponent, AbstractCityObject {
	public String getClazz();
	public List<String> getFunction();
	public List<String> getUsage();
	public List<CityObjectGroupMember> getGroupMember();
	public CityObjectGroupParent getGroupParent();
	public GeometryProperty<? extends AbstractGeometry> getGeometry();
	public List<ADEComponent> getGenericApplicationPropertyOfCityObjectGroup();
	public boolean isSetClazz();
	public boolean isSetFunction();
	public boolean isSetUsage();
	public boolean isSetGroupMember();
	public boolean isSetGroupParent();
	public boolean isSetGeometry();
	public boolean isSetGenericApplicationPropertyOfCityObjectGroup();	
	
	public void setClazz(String clazz);
	public void setFunction(List<String> function);
	public void addFunction(String function);
	public void setUsage(List<String> usage);
	public void addUsage(String usage);
	public void setGroupMember(List<CityObjectGroupMember> groupMember);
	public void addGroupMember(CityObjectGroupMember groupMember);
	public void setGroupParent(CityObjectGroupParent groupParent);
	public void setGeometry(GeometryProperty<? extends AbstractGeometry> geometry);	
	public void addGenericApplicationPropertyOfCityObjectGroup(ADEComponent ade);
	public void setGenericApplicationPropertyOfCityObjectGroup(List<ADEComponent> ade);
	public void unsetClazz();
	public void unsetFunction();
	public boolean unsetFunction(String function);
	public void unsetUsage();
	public boolean unsetUsage(String usage);
	public void unsetGroupMember();
	public boolean unsetGroupMember(CityObjectGroupMember groupMember);
	public void unsetGroupParent();
	public void unsetGeometry();
	public void unsetGenericApplicationPropertyOfCityObjectGroup();	
	public boolean unsetGenericApplicationPropertyOfCityObjectGroup(ADEComponent ade);	
}
