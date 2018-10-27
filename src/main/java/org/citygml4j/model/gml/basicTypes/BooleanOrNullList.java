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

public class BooleanOrNullList implements GML, Child, Copyable {
	private List<BooleanOrNull> booleanOrNull;
	private ModelObject parent;

	public void addBooleanOrNull(BooleanOrNull booleanOrNull) {
		if (this.booleanOrNull == null)
			this.booleanOrNull = new ChildList<BooleanOrNull>(this);
		
		this.booleanOrNull.add(booleanOrNull);
	}

	public List<BooleanOrNull> getBooleanOrNull() {
		if (booleanOrNull == null)
			booleanOrNull = new ChildList<BooleanOrNull>(this);
		
		return booleanOrNull;
	}

	public boolean isSetBooleanOrNull() {
		return booleanOrNull != null && !booleanOrNull.isEmpty();
	}

	public void setBooleanOrNull(List<BooleanOrNull> booleanOrNull) {
		this.booleanOrNull = new ChildList<BooleanOrNull>(this, booleanOrNull);
	}

	public void unsetBooleanOrNull() {
		if (isSetBooleanOrNull())
			booleanOrNull.clear();
		
		booleanOrNull = null;
	}

	public boolean unsetBooleanOrNull(BooleanOrNull booleanOrNull) {
		return isSetBooleanOrNull() ? this.booleanOrNull.remove(booleanOrNull) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.BOOLEAN_OR_NULL_LIST;
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
		return copyTo(new BooleanOrNullList(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BooleanOrNullList copy = (target == null) ? new BooleanOrNullList() : (BooleanOrNullList)target;
		
		if (isSetBooleanOrNull()) {
			for (BooleanOrNull part : booleanOrNull) {
				BooleanOrNull copyPart = (BooleanOrNull)copyBuilder.copy(part);
				copy.addBooleanOrNull(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
