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

public class IntegerOrNullList implements GML, Child, Copyable {
	private List<IntegerOrNull> integerOrNull;
	private ModelObject parent;

	public void addIntegerOrNull(IntegerOrNull integerOrNull) {
		if (this.integerOrNull == null)
			this.integerOrNull = new ChildList<IntegerOrNull>(this);
		
		this.integerOrNull.add(integerOrNull);
	}

	public List<IntegerOrNull> getIntegerOrNull() {
		if (integerOrNull == null)
			integerOrNull = new ChildList<IntegerOrNull>(this);
		
		return integerOrNull;
	}

	public boolean isSetIntegerOrNull() {
		return integerOrNull != null && !integerOrNull.isEmpty();
	}

	public void setIntegerOrNull(List<IntegerOrNull> integerOrNull) {
		this.integerOrNull = new ChildList<IntegerOrNull>(this, integerOrNull);
	}

	public void unsetIntegerOrNull() {
		if (isSetIntegerOrNull())
			integerOrNull.clear();
		
		integerOrNull = null;
	}

	public boolean unsetIntegerOrNull(IntegerOrNull integerOrNull) {
		return isSetIntegerOrNull() ? this.integerOrNull.remove(integerOrNull) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.INTEGER_OR_NULL_LIST;
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
		return copyTo(new IntegerOrNullList(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntegerOrNullList copy = (target == null) ? new IntegerOrNullList() : (IntegerOrNullList)target;
		
		if (isSetIntegerOrNull()) {
			for (IntegerOrNull part : integerOrNull) {
				IntegerOrNull copyPart = (IntegerOrNull)copyBuilder.copy(part);
				copy.addIntegerOrNull(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
