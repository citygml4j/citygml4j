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

public class NameOrNull implements GML, Child, Copyable {
	private String name;
	private Null _null;
	private ModelObject parent;

	public NameOrNull() {

	}

	public NameOrNull(String name) {
		setName(name);
	}

	public NameOrNull(Null _null) {
		setNull(_null);
	}

	public GMLClass getGMLClass() {
		return GMLClass.NAME_OR_NULL;
	}

	public String getName() {
		return name;
	}

	public Null getNull() {
		return _null;
	}

	public boolean isSetName() {
		return name != null;
	}

	public boolean isSetNull() {
		return _null != null;
	}

	public void setName(String name) {
		if (name != null && name.length() > 0) {			
			String[] split = name.trim().split("\\s");
			if (split.length > 0) {
				this.name = split[0];
				unsetNull();
			}
		}
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);

		this._null = _null;
		unsetName();
	}

	public void unsetName() {
		name = null;
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
		return copyTo(new NameOrNull(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		NameOrNull copy = (target == null) ? new NameOrNull() : (NameOrNull)target;

		if (isSetName())
			copy.setName(copyBuilder.copy(name));

		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}

		copy.unsetParent();

		return copy;
	}

}
