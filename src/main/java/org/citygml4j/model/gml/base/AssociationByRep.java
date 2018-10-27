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
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.association.Association;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

import java.util.HashMap;

public abstract class AssociationByRep<T extends Associable & Child> implements GML, Association<T>, Child, Copyable {
	private T object;
	private HashMap<String, Object> localProperties;
	private ModelObject parent;

	public AssociationByRep() {

	}

	public AssociationByRep(T object) {
		setObject(object);
	}

	public T getObject() {
		return object;
	}

	public boolean isSetObject() {
		return object != null;
	}

	public void setObject(T object) {
		if (object != null)
			object.setParent(this);

		this.object = object;
	}

	public void unsetObject() {
		if (isSetObject())
			object.unsetParent();

		object = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ASSOCIATION_BY_REP;
	}

	public Object getLocalProperty(String name) {
		if (localProperties != null)
			return localProperties.get(name);

		return null;
	}

	public void setLocalProperty(String name, Object value) {
		if (localProperties == null)
			localProperties = new HashMap<String, Object>();

		localProperties.put(name, value);
	}

	public boolean hasLocalProperty(String name) {
		return localProperties != null && localProperties.containsKey(name);
	}

	public Object unsetLocalProperty(String name) {
		if (localProperties != null)
			return localProperties.remove(name);

		return null;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AssociationByRep<T> copy = (AssociationByRep<T>)target;

		if (isSetObject()) {
			copy.setObject((T)copyBuilder.copy(object));
			if (copy.getObject() == object)
				object.setParent(this);
		}

		copy.unsetParent();

		return copy;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

}
