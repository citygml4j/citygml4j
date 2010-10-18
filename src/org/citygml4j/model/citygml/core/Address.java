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
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;

public interface Address extends CoreModuleComponent, AbstractFeature {
	public XalAddressProperty getXalAddress();
	public MultiPointProperty getMultiPoint();
	public List<ADEComponent> getGenericApplicationPropertyOfAddress();
	public boolean isSetXalAddress();
	public boolean isSetMultiPoint();
	public boolean isSetGenericApplicationPropertyOfAddress();
	
	public void setXalAddress(XalAddressProperty xalAddress);
	public void setMultiPoint(MultiPointProperty multiPoint);	
	public void addGenericApplicationPropertyOfAddress(ADEComponent ade);
	public void setGenericApplicationPropertyOfAddress(List<ADEComponent> ade);
	public void unsetXalAddress();
	public void unsetMultiPoint();
	public void unsetGenericApplicationPropertyOfAddress();
	public boolean unsetGenericApplicationPropertyOfAddress(ADEComponent ade);
}
