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
package org.citygml4j.model.citygml.cityobjectgroup;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;

public class CityObjectGroupMember extends FeatureProperty<AbstractCityObject> implements CityObjectGroupModuleComponent {
	private String groupRole;
	private CityObjectGroupModule module;
	
	public CityObjectGroupMember() {
		
	}
	
	public CityObjectGroupMember(AbstractCityObject abstractCityObject) {
		super(abstractCityObject);
	}
	
	public CityObjectGroupMember(String href) {
		super(href);
	}
	
	public CityObjectGroupMember(CityObjectGroupModule module) {
		this.module = module;
	}
	
	public AbstractCityObject getCityObject() {
		return super.getObject();
	}

	public boolean isSetCityObject() {
		return super.isSetObject();
	}

	public void setCityObject(AbstractCityObject cityObject) {
		super.setObject(cityObject);
	}

	public void unsetCityObject() {
		super.unsetObject();
	}

	public String getGroupRole() {
		return groupRole;
	}

	public boolean isSetGroupRole() {
		return groupRole != null;
	}

	public void setGroupRole(String groupRole) {
		this.groupRole = groupRole;
	}

	public void unsetGroupRole() {
		groupRole = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITY_OBJECT_GROUP_MEMBER;
	}

	public final CityObjectGroupModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractCityObject> getAssociableClass() {
		return AbstractCityObject.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CityObjectGroupMember(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CityObjectGroupMember copy = (target == null) ? new CityObjectGroupMember() : (CityObjectGroupMember)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGroupRole())
			copy.setGroupRole(copyBuilder.copy(groupRole));
		
		return copy;
	}

}
