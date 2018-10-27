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
package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

public class Value implements GML, Associable, Child, Copyable {
	private ValueObject valueObject;
	private AbstractGeometry geometry;
	private GenericValueObject genericValueObject;
	private Null _null;
	private ModelObject parent;
	
	public Value() {
		
	}
	
	public Value(ValueObject valueObject) {
		setValueObject(valueObject);
	}
	
	public Value(AbstractGeometry geometry) {
		setGeometry(geometry);
	}
	
	public Value(GenericValueObject genericValueObject) {
		setGenericValueObject(genericValueObject);
	}
	
	public Value(Null _null) {
		setNull(_null);
	}

	public GMLClass getGMLClass() {
		return GMLClass.VALUE;
	}

	public ValueObject getValueObject() {
		return valueObject;
	}

	public AbstractGeometry getGeometry() {
		return geometry;
	}

	public GenericValueObject getGenericValueObject() {
		return genericValueObject;
	}

	public Null getNull() {
		return _null;
	}

	public boolean isSetValueObject() {
		return valueObject != null;
	}

	public boolean isSetGeometry() {
		return geometry != null;
	}

	public boolean isSetGenericValueObject() {
		return genericValueObject != null;
	}

	public boolean isSetNull() {
		return _null != null;
	}

	public void setValueObject(ValueObject valueObject) {
		if (valueObject != null)
			valueObject.setParent(this);
		
		this.valueObject = valueObject;
		
		unsetGeometry();
		unsetNull();
		unsetGenericValueObject();
	}

	public void setGeometry(AbstractGeometry geometry) {
		if (geometry != null)
			geometry.setParent(this);
		
		this.geometry = geometry;
		
		unsetNull();
		unsetValueObject();
		unsetGenericValueObject();
	}

	public void setGenericValueObject(GenericValueObject genericValueObject) {
		if (genericValueObject != null)
			genericValueObject.setParent(this);
		
		this.genericValueObject = genericValueObject;
		
		unsetGeometry();
		unsetNull();
		unsetValueObject();
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);
		
		this._null = _null;
		
		unsetGeometry();
		unsetValueObject();
		unsetGenericValueObject();
	}

	public void unsetValueObject() {
		if (isSetValueObject())
			valueObject.unsetParent();
		
		valueObject = null;
	}

	public void unsetGeometry() {
		if (isSetGeometry())
			geometry.unsetParent();
		
		geometry = null;
	}

	public void unsetGenericValueObject() {
		if (isSetGenericValueObject())
			genericValueObject.unsetParent();
		
		genericValueObject = null;
	}

	public void unsetNull() {
		if (isSetNull())
			_null.unsetParent();
		
		_null = null;
	}
	
	public ModelObject getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Value copy = (target == null) ? new Value() : (Value)target;
		
		if (isSetValueObject()) {
			copy.setValueObject((ValueObject)copyBuilder.copy(valueObject));
			if (copy.getValueObject() == valueObject)
				valueObject.setParent(this);
		}
		
		if (isSetGeometry()) {
			copy.setGeometry((AbstractGeometry)copyBuilder.copy(geometry));
			if (copy.getGeometry() == geometry)
				geometry.setParent(this);
		}
		
		if (isSetGenericValueObject()) {
			copy.setGenericValueObject((GenericValueObject)copyBuilder.copy(genericValueObject));
			if (copy.getGenericValueObject() == genericValueObject)
				genericValueObject.setParent(this);
		}
		
		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Value(), copyBuilder);
	}

}
