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
package org.citygml4j.util.child;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

public class ChildInfo {

	public AbstractFeature getParentFeature(Child child) {
		if (child == null)
			return null;

		ModelObject parent = null;

		while ((parent = child.getParent()) != null) {
			if (parent instanceof AbstractFeature)
				return (AbstractFeature)parent;
			else if (parent instanceof Child)
				child = (Child)parent;
			else 
				break;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractFeature> T getParentFeature(Child child, Class<T> type) {
		while ((child = getParentFeature(child)) != null)
			if (type.isInstance(child)) 
				return (T)child;

		return null;
	}

	public AbstractFeature getRootFeature(Child child) {
		AbstractFeature parent = null;
		AbstractFeature root = null;

		while ((parent = getParentFeature(child)) != null)
			child = root = parent;

		return root;	
	}

	public AbstractCityObject getParentCityObject(Child child) {
		AbstractFeature parent = null;

		while ((parent = getParentFeature(child)) != null) {
			if (parent instanceof AbstractCityObject)
				return (AbstractCityObject)parent;
			else if (parent instanceof Child)
				child = (Child)parent;
			else 
				break;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractCityObject> T getParentCityObject(Child child, Class<T> type) {
		while ((child = getParentCityObject(child)) != null)
			if (type.isInstance(child)) 
				return (T)child;

		return null;
	}

	public AbstractCityObject getRootCityObject(Child child) {
		AbstractCityObject parent = null;
		AbstractCityObject root = null;

		while ((parent = getParentCityObject(child)) != null)
			child = root = parent;

		return root;	
	}

	public CityGML getParentCityGML(Child child) {
		if (child == null)
			return null;

		ModelObject parent = null;

		while ((parent = child.getParent()) != null) {
			if (parent instanceof CityGML)
				return (CityGML)parent;
			else if (parent instanceof Child)
				child = (Child)parent;
			else 
				break;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public <T extends CityGML> T getParentCityGML(Child child, Class<T> type) {
		CityGML cityGML = getParentCityGML(child);
		
		if (type.isInstance(cityGML))
			return (T)cityGML;
		else if (cityGML instanceof Child)
			return getParentCityGML((Child)cityGML, type);
		else 
			return null;
	}

	public CityGML getRootCityGML(Child child) {
		if (child == null)
			return null;

		ModelObject parent = null;
		ModelObject root = null;

		while ((parent = child.getParent()) != null) {
			if (parent instanceof CityGML)
				root = (CityGML)parent;

			if (parent instanceof Child)
				child = (Child)parent;
			else 
				break;
		}

		return (root instanceof CityGML) ? (CityGML)root : null;
	}

	public AbstractGeometry getParentGeometry(Child child) {
		if (child == null)
			return null;

		ModelObject parent = null;

		while ((parent = child.getParent()) != null) {
			if (parent instanceof AbstractGeometry)
				return (AbstractGeometry)parent;
			else if (!(parent instanceof AbstractFeature) && (parent instanceof Child))
				child = (Child)parent;
			else 
				break;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractGeometry> T getParentGeometry(Child child, Class<T> type) {
		while ((child = getParentGeometry(child)) != null)
			if (type.isInstance(child)) 
				return (T)child;

		return null;
	}

	public AbstractGeometry getRootGeometry(Child child) {
		AbstractGeometry parent = null;
		AbstractGeometry root = null;

		while ((parent = getParentGeometry(child)) != null)
			child = root = parent;

		return root;			
	}

}
