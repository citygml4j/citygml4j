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

public class ValueExtent implements GML, Child, Copyable {
	private CategoryExtent categoryExtent;
	private QuantityExtent quantityExtent;
	private CountExtent countExtent;
	private ModelObject parent;
	
	public ValueExtent() {
		
	}
	
	public ValueExtent(CategoryExtent categoryExtent) {
		setCategoryExtent(categoryExtent);
	}
	
	public ValueExtent(QuantityExtent quantityExtent) {
		setQuantityExtent(quantityExtent);
	}
	
	public ValueExtent(CountExtent countExtent) {
		setCountExtent(countExtent);
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.VALUE_EXTENT;
	}

	public CategoryExtent getCategoryExtent() {
		return categoryExtent;
	}

	public QuantityExtent getQuantityExtent() {
		return quantityExtent;
	}

	public CountExtent getCountExtent() {
		return countExtent;
	}

	public boolean isSetCategoryExtent() {
		return categoryExtent != null;
	}

	public boolean isSetQuantityExtent() {
		return quantityExtent != null;
	}

	public boolean isSetCountExtent() {
		return countExtent != null;
	}

	public void setCategoryExtent(CategoryExtent categoryExtent) {
		if (categoryExtent != null)
			categoryExtent.setParent(this);
		
		this.categoryExtent = categoryExtent;
		
		unsetCountExtent();
		unsetQuantityExtent();
	}

	public void setQuantityExtent(QuantityExtent quantityExtent) {
		if (quantityExtent != null)
			quantityExtent.setParent(this);
		
		this.quantityExtent = quantityExtent;
		
		unsetCategoryExtent();
		unsetCountExtent();
	}

	public void setCountExtent(CountExtent countExtent) {
		if (countExtent != null)
			countExtent.setParent(this);
		
		this.countExtent = countExtent;
		
		unsetCategoryExtent();
		unsetQuantityExtent();
	}

	public void unsetCategoryExtent() {
		if (isSetCategoryExtent())
			categoryExtent.unsetParent();
		
		categoryExtent = null;
	}

	public void unsetQuantityExtent() {
		if (isSetQuantityExtent())
			quantityExtent.unsetParent();
		
		quantityExtent = null;
	}

	public void unsetCountExtent() {
		if (isSetCountExtent())
			countExtent.unsetParent();
		
		countExtent = null;
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
		ValueExtent copy = (target == null) ? new ValueExtent() : (ValueExtent)target;
		
		if (isSetCategoryExtent()) {
			copy.setCategoryExtent((CategoryExtent)copyBuilder.copy(categoryExtent));
			if (copy.getCategoryExtent() == categoryExtent)
				categoryExtent.setParent(this);
		}
		
		if (isSetCountExtent()) {
			copy.setCountExtent((CountExtent)copyBuilder.copy(countExtent));
			if (copy.getCountExtent() == countExtent)
				countExtent.setParent(this);
		}
		
		if (isSetQuantityExtent()) {
			copy.setQuantityExtent((QuantityExtent)copyBuilder.copy(quantityExtent));
			if (copy.getQuantityExtent() == quantityExtent)
				quantityExtent.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueExtent(), copyBuilder);
	}

}
