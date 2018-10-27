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
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

import java.util.List;

public class DoubleOrNullList implements GML, Child, Copyable {
	private List<DoubleOrNull> doubleOrNull;
	private ModelObject parent;

	public void addDoubleOrNull(DoubleOrNull doubleOrNull) {
		if (this.doubleOrNull == null)
			this.doubleOrNull = new ChildList<DoubleOrNull>(this);
		
		this.doubleOrNull.add(doubleOrNull);
	}

	public List<DoubleOrNull> getDoubleOrNull() {
		if (doubleOrNull == null)
			doubleOrNull = new ChildList<DoubleOrNull>(this);
		
		return doubleOrNull;
	}

	public boolean isSetDoubleOrNull() {
		return doubleOrNull != null && !doubleOrNull.isEmpty();
	}

	public void setDoubleOrNull(List<DoubleOrNull> doubleOrNull) {
		this.doubleOrNull = new ChildList<DoubleOrNull>(this, doubleOrNull);
	}

	public void unsetDoubleOrNull() {
		if (isSetDoubleOrNull())
			doubleOrNull.clear();
		
		doubleOrNull = null;
	}

	public boolean unsetDoubleOrNull(DoubleOrNull doubleOrNull) {
		return isSetDoubleOrNull() ? this.doubleOrNull.remove(doubleOrNull) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.DOUBLE_OR_NULL_LIST;
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DoubleOrNullList(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DoubleOrNullList copy = (target == null) ? new DoubleOrNullList() : (DoubleOrNullList)target;
		
		if (isSetDoubleOrNull()) {
			for (DoubleOrNull part : doubleOrNull) {
				DoubleOrNull copyPart = (DoubleOrNull)copyBuilder.copy(part);
				copy.addDoubleOrNull(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
