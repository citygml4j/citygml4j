/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.xml.io.reader;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.gml.base.MetaDataProperty;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.LocationProperty;

import java.util.List;

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
