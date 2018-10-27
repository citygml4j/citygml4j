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

public class Code implements GML, Child, Copyable {
	private String value;
	private String codeSpace;
	private ModelObject parent;
	
	public Code() {
	}
	
	public Code(String value) {
		this.value = value;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.CODE;
	}

	public String getCodeSpace() {
		return codeSpace;
	}

	public String getValue() {
		return value;
	}

	public boolean isSetCodeSpace() {
		return codeSpace != null;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void unsetCodeSpace() {
		codeSpace = null;
	}

	public void unsetValue() {
		value = null;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Code copy = (target == null) ? new Code() : (Code)target;
		
		if (isSetValue())
			copy.setValue(copyBuilder.copy(value));
		
		if (isSetCodeSpace())
			copy.setCodeSpace(copyBuilder.copy(codeSpace));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Code(), copyBuilder);
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
