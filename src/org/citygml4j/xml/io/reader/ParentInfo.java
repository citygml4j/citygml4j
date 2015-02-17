/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.xml.io.reader;

import java.util.List;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.gml.base.MetaDataProperty;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.LocationProperty;

public interface ParentInfo {
	public boolean isSetParentInfo();
	public ParentInfo getParentInfo();
	
	public boolean isSetId();
	public String getId();
	public boolean isSetName();
	public List<Code> getName();
	public boolean isSetDescription();
	public StringOrRef getDescription();
	public boolean isSetMetaDataProperty();
	public List<MetaDataProperty> getMetaDataProperty();
	public boolean isSetBoundedBy();
	public BoundingShape getBoundedBy();
	public boolean isSetLocation();
	public LocationProperty getLocation();
	public boolean isSetAppearance();
	public List<? extends AppearanceProperty> getAppearance();
	public CityGMLClass getCityGMLClass();
}
