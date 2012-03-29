/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
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
	
	public ModelType getModelType() {
		return ModelType.GML;
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