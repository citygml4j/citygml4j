/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.gml.base;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;

public class MetaDataProperty extends AssociationByRepOrRef<MetaData> {
	private String about;
	
	public MetaDataProperty() {
		
	}
	
	public MetaDataProperty(MetaData metaData) {
		super(metaData);
	}
	
	public MetaDataProperty(String href) {
		super(href);
	}
	
	public String getAbout() {
		return about;
	}

	public MetaData getMetaData() {
		return super.getObject();
	}

	public boolean isSetAbout() {
		return about != null;
	}

	public boolean isSetMetaData() {
		return super.isSetObject();
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setMetaData(MetaData metaData) {
		super.setObject(metaData);
	}

	public void unsetAbout() {
		about = null;
	}

	public void unsetMetaData() {
		super.unsetObject();
	}

	public GMLClass getGMLClass() {
		return GMLClass.META_DATA_PROPERTY;
	}
	
	public Class<MetaData> getAssociableClass() {
		return MetaData.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MetaDataProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MetaDataProperty copy = (target == null) ? new MetaDataProperty() : (MetaDataProperty)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetAbout())
			copy.setAbout(copyBuilder.copy(about));
		
		return copy;
	}

}
