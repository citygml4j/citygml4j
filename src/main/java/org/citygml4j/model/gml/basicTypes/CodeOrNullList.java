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
package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

import java.util.List;

public class CodeOrNullList implements GML, Child, Copyable {
	private List<NameOrNull> nameOrNull;
	private String codeSpace;
	private ModelObject parent;

	public GMLClass getGMLClass() {
		return GMLClass.CODE_OR_NULL_LIST;
	}

	public List<NameOrNull> getNameOrNull() {
		if (nameOrNull == null)
			nameOrNull = new ChildList<NameOrNull>(this);

		return nameOrNull;
	}

	public String getCodeSpace() {
		return codeSpace;
	}

	public boolean isSetNameOrNull() {
		return nameOrNull != null && !nameOrNull.isEmpty();
	}

	public boolean isSetCodeSpace() {
		return codeSpace != null;
	}

	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}

	public void setNameOrNull(List<NameOrNull> nameOrNull) {
		this.nameOrNull = new ChildList<NameOrNull>(this, nameOrNull);
	}

	public void addNameOrNull(NameOrNull nameOrNull) {
		if (this.nameOrNull == null)
			this.nameOrNull = new ChildList<NameOrNull>(this);

		this.nameOrNull.add(nameOrNull);
	}

	public void unsetNameOrNull() {
		if (isSetNameOrNull())
			nameOrNull.clear();

		nameOrNull = null;
	}

	public boolean unsetNameOrNull(NameOrNull nameOrNull) {
		return isSetNameOrNull() ? this.nameOrNull.remove(nameOrNull) : false;
	}

	public void unsetCodeSpace() {
		codeSpace = null;
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
		CodeOrNullList copy = (target == null) ? new CodeOrNullList() : (CodeOrNullList)target;

		if (isSetNameOrNull()) {
			for (NameOrNull part : nameOrNull) {
				NameOrNull copyPart = (NameOrNull)copyBuilder.copy(part);
				copy.addNameOrNull(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetCodeSpace())
			copy.setCodeSpace(copyBuilder.copy(codeSpace));

		copy.unsetParent();

		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CodeOrNullList(), copyBuilder);
	}

}
