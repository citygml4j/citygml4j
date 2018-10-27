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
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.basicTypes.Measure;

public class ScalarValue implements GML, Child, Copyable {
	private Boolean _boolean;
	private Code category;
	private Measure quantity;
	private Integer count;
	private ModelObject parent;
	
	public ScalarValue() {
		
	}
	
	public ScalarValue(boolean _boolean) {
		this._boolean = _boolean;
	}
	
	public ScalarValue(Code category) {
		setCategory(category);
	}
	
	public ScalarValue(Measure quantity) {
		setQuantity(quantity);
	}
	
	public ScalarValue(Integer count) {
		this.count = count;
	}

	public GMLClass getGMLClass() {
		return GMLClass.SCALAR_VALUE;
	}

	public Boolean getBoolean() {
		return _boolean;
	}

	public Code getCategory() {
		return category;
	}

	public Measure getQuantity() {
		return quantity;
	}

	public Integer getCount() {
		return count;
	}

	public boolean isSetBoolean() {
		return _boolean != null;
	}

	public boolean isSetCategory() {
		return category != null;
	}

	public boolean isSetQuantity() {
		return quantity != null;
	}

	public boolean isSetCount() {
		return count != null;
	}

	public void setBoolean(Boolean _boolean) {
		this._boolean = _boolean;
		
		unsetCategory();
		unsetCount();
		unsetQuantity();
	}

	public void setCategory(Code category) {
		if (category != null)
			category.setParent(this);
		
		this.category = category;
		
		unsetBoolean();
		unsetCount();
		unsetQuantity();
	}

	public void setQuantity(Measure quantity) {
		if (quantity != null)
			quantity.setParent(this);
		
		this.quantity = quantity;
		
		unsetBoolean();
		unsetCategory();
		unsetCount();
	}

	public void setCount(Integer count) {
		this.count = count;
		
		unsetBoolean();
		unsetCategory();
		unsetQuantity();
	}

	public void unsetBoolean() {
		_boolean = null;
	}

	public void unsetCategory() {
		if (isSetCategory())
			category.unsetParent();
		
		category = null;
	}

	public void unsetQuantity() {
		if (isSetQuantity())
			quantity.unsetParent();
		
		quantity = null;
	}

	public void unsetCount() {
		count = null;
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
		ScalarValue copy = (target == null) ? new ScalarValue() : (ScalarValue)target;
		
		if (isSetBoolean())
			copy.setBoolean(copyBuilder.copy(_boolean));

		if (isSetCategory()) {
			copy.setCategory((Code)copyBuilder.copy(category));
			if (copy.getCategory() == category)
				category.setParent(this);
		}
		
		if (isSetCount())
			copy.setCount((Integer)copyBuilder.copy(count));
		
		if (isSetQuantity()) {
			copy.setQuantity((Measure)copyBuilder.copy(quantity));
			if (copy.getQuantity() == quantity)
				quantity.setParent(this);
		}
		
		copy.unsetParent();

		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ScalarValue(), copyBuilder);
	}

}
