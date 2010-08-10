package org.citygml4j.impl.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.valueObjects.CategoryExtent;
import org.citygml4j.model.gml.valueObjects.CountExtent;
import org.citygml4j.model.gml.valueObjects.QuantityExtent;
import org.citygml4j.model.gml.valueObjects.ValueExtent;

public class ValueExtentImpl implements ValueExtent {
	private CategoryExtent categoryExtent;
	private QuantityExtent quantityExtent;
	private CountExtent countExtent;
	private Object parent;
	
	public ValueExtentImpl() {
		
	}
	
	public ValueExtentImpl(CategoryExtent categoryExtent) {
		setCategoryExtent(categoryExtent);
	}
	
	public ValueExtentImpl(QuantityExtent quantityExtent) {
		setQuantityExtent(quantityExtent);
	}
	
	public ValueExtentImpl(CountExtent countExtent) {
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
	
	public Object getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueExtent copy = (target == null) ? new ValueExtentImpl() : (ValueExtent)target;
		
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
		return copyTo(new ValueExtentImpl(), copyBuilder);
	}

}
