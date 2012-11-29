/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
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
 * 
 * $Id: CityModelWriter.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.xml.io.writer;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.feature.AbstractFeature;

public interface CityModelWriter extends AbstractCityGMLWriter {
	public void writeStartDocument() throws CityGMLWriteException;
	public void writeEndDocument() throws CityGMLWriteException;
	public void writeFeatureMember(AbstractFeature feature) throws CityGMLWriteException;
	public void writeFeatureMember(ADEComponent adeComponent) throws CityGMLWriteException;
	public void writeFeatureMembers(List<ModelObject> features) throws CityGMLWriteException;
	
	public CityModelInfo getCityModelInfo();	
	public void setCityModelInfo(CityModelInfo cityModelInfo);
}
