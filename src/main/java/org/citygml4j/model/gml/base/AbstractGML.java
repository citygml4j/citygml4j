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
package org.citygml4j.model.gml.base;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Code;

import java.util.HashMap;
import java.util.List;

public abstract class AbstractGML implements GML, StandardObjectProperties, Associable, Child, Copyable {
	private static final long serialVersionUID = 8038430725115673854L;

	private String id;
	private StringOrRef description;
	private List<Code> name;
	private List<MetaDataProperty> metaDataProperty;
	private HashMap<String, Object> localProperties;
	private ModelObject parent;

	public String getId() {
		return id;
	}

	public boolean isSetId() {
		return id != null;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void unsetId() {
		id = null;
	}

	public void addMetaDataProperty(MetaDataProperty metaDataProperty) {
		if (this.metaDataProperty == null)
			this.metaDataProperty = new ChildList<MetaDataProperty>(this);
		
		this.metaDataProperty.add(metaDataProperty);
	}
	
	public void addName(Code name) {
		if (this.name == null)
			this.name = new ChildList<Code>(this);

		this.name.add(name);
	}

	public StringOrRef getDescription() {
		return description;
	}

	public List<MetaDataProperty> getMetaDataProperty() {
		if (metaDataProperty == null)
			metaDataProperty = new ChildList<MetaDataProperty>(this);
		
		return metaDataProperty;
	}
	
	public List<Code> getName() {
		if (name == null)
			name = new ChildList<Code>(this);

		return name;
	}

	public boolean isSetDescription() {
		return description != null;
	}

	public boolean isSetMetaDataProperty() {
		return metaDataProperty != null && !metaDataProperty.isEmpty();
	}

	public boolean isSetName() {
		return name != null && !name.isEmpty();
	}

	public void setDescription(StringOrRef description) {
		if (description != null)
			description.setParent(this);

		this.description = description;
	}

	public void setMetaDataProperty(List<MetaDataProperty> metaDataProperty) {
		this.metaDataProperty = new ChildList<MetaDataProperty>(this, metaDataProperty);
	}

	public void setName(List<Code> name) {
		this.name = new ChildList<Code>(this, name);
	}

	public void unsetDescription() {
		if (isSetDescription())
			description.unsetParent();

		description = null;
	}

	public void unsetMetaDataProperty() {
		if (isSetMetaDataProperty())
			metaDataProperty.clear();
		
		metaDataProperty = null;
	}
	
	public boolean unsetMetaDataProperty(MetaDataProperty metaDataProperty) {
		return isSetMetaDataProperty() ? this.metaDataProperty.remove(metaDataProperty) : false;
	}

	public void unsetName() {
		if (isSetName())
			name.clear();

		name = null;
	}

	public boolean unsetName(Code name) {
		return isSetName() ? this.name.remove(name) : false;
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

	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_GML;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractGML copy = (AbstractGML)target;

		if (isSetId())
			copy.setId(copyBuilder.copy(id));

		if (isSetDescription()) {
			copy.setDescription((StringOrRef)copyBuilder.copy(description));
			if (copy.getDescription() == description)
				description.setParent(this);
		}

		if (isSetName()) {
			for (Code part : name) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addName(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}			
		}
		
		if (isSetMetaDataProperty()) {
			for (MetaDataProperty part : metaDataProperty) {
				MetaDataProperty copyPart = (MetaDataProperty)copyBuilder.copy(part);
				copy.addMetaDataProperty(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		copy.unsetParent();

		return copy;
	}
	
	public abstract void accept(GMLVisitor visitor);
	public abstract <T> T accept(GMLFunctor<T> visitor);

}
