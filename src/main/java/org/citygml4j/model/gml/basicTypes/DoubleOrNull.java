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
package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public class DoubleOrNull implements GML, Child, Copyable {
	private Double _double;
	private Null _null;
	private ModelObject parent;
	
	public DoubleOrNull() {
		
	}
	
	public DoubleOrNull(Double _double) {
		this._double = _double;
	}
	
	public DoubleOrNull(Null _null) {
		setNull(_null);
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.DOUBLE_OR_NULL;
	}

	public Double getDouble() {
		return _double;
	}
	
	public Null getNull() {
		return _null;
	}

	public boolean isSetDouble() {
		return _double != null;
	}
	
	public boolean isSetNull() {
		return _null != null;
	}

	public void setDouble(Double _double) {
		this._double = _double;
		
		unsetNull();
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);
		
		this._null = _null;
		unsetDouble();
	}

	public void unsetDouble() {
		_double = null;
	}
	
	public void unsetNull() {
		if (isSetNull())
			_null.unsetParent();
		
		_null = null;
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DoubleOrNull(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DoubleOrNull copy = (target == null) ? new DoubleOrNull() : (DoubleOrNull)target;
		
		if (isSetDouble())
			copy.setDouble((Double)copyBuilder.copy(_double));
			
		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
