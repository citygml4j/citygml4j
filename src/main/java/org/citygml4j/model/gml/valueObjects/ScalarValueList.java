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
import org.citygml4j.model.gml.basicTypes.BooleanOrNullList;
import org.citygml4j.model.gml.basicTypes.CodeOrNullList;
import org.citygml4j.model.gml.basicTypes.IntegerOrNullList;
import org.citygml4j.model.gml.basicTypes.MeasureOrNullList;

public class ScalarValueList implements GML, Child, Copyable {
	private BooleanOrNullList booleanList;
	private CodeOrNullList categoryList;
	private MeasureOrNullList quantityList;
	private IntegerOrNullList countList;
	private ModelObject parent;
	
	public ScalarValueList() {
		
	}
	
	public ScalarValueList(BooleanOrNullList booleanList) {
		setBooleanList(booleanList);
	}
	
	public ScalarValueList(CodeOrNullList categoryList) {
		setCategoryList(categoryList);
	}
	
	public ScalarValueList(MeasureOrNullList quantityList) {
		setQuantityList(quantityList);
	}
	
	public ScalarValueList(IntegerOrNullList countList) {
		setCountList(countList);
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.SCALAR_VALUE_LIST;
	}

	public BooleanOrNullList getBooleanList() {
		return booleanList;
	}

	public CodeOrNullList getCategoryList() {
		return categoryList;
	}

	public MeasureOrNullList getQuantityList() {
		return quantityList;
	}

	public IntegerOrNullList getCountList() {
		return countList;
	}

	public boolean isSetBooleanList() {
		return booleanList != null;
	}

	public boolean isSetCategoryList() {
		return categoryList != null;
	}

	public boolean isSetQuantityList() {
		return quantityList != null;
	}

	public boolean isSetCountList() {
		return countList != null;
	}

	public void setBooleanList(BooleanOrNullList booleanList) {
		if (booleanList != null)
			booleanList.setParent(this);
		
		this.booleanList = booleanList;
		
		unsetCategoryList();
		unsetCountList();
		unsetQuantityList();
	}

	public void setCategoryList(CodeOrNullList categoryList) {
		if (categoryList != null)
			categoryList.setParent(this);
		
		this.categoryList = categoryList;
		
		unsetBooleanList();
		unsetCountList();
		unsetQuantityList();
	}

	public void setQuantityList(MeasureOrNullList quantityList) {
		if (quantityList != null)
			quantityList.setParent(this);
		
		this.quantityList = quantityList;
		
		unsetBooleanList();
		unsetCategoryList();
		unsetCountList();
	}

	public void setCountList(IntegerOrNullList countList) {
		if (countList != null)
			countList.setParent(this);
		
		this.countList = countList;
		
		unsetBooleanList();
		unsetCategoryList();
		unsetQuantityList();
	}

	public void unsetBooleanList() {
		if (isSetBooleanList())
			booleanList.unsetParent();
		
		booleanList = null;
	}

	public void unsetCategoryList() {
		if (categoryList != null)
			categoryList.unsetParent();
		
		categoryList = null;
	}

	public void unsetQuantityList() {
		if (quantityList != null)
			quantityList.unsetParent();
		
		quantityList = null;
	}

	public void unsetCountList() {
		if (countList != null)
			countList.unsetParent();
		
		countList = null;
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
		ScalarValueList copy = (target == null) ? new ScalarValueList() : (ScalarValueList)target;
		
		if (isSetBooleanList()) {
			copy.setBooleanList((BooleanOrNullList)copyBuilder.copy(booleanList));
			if (copy.getBooleanList() == booleanList)
				booleanList.setParent(this);
		}
		
		if (isSetCategoryList()) {
			copy.setCategoryList((CodeOrNullList)copyBuilder.copy(categoryList));
			if (copy.getCategoryList() == categoryList)
				categoryList.setParent(this);
		}
		
		if (isSetQuantityList()) {
			copy.setQuantityList((MeasureOrNullList)copyBuilder.copy(quantityList));
			if (copy.getQuantityList() == quantityList)
				quantityList.setParent(this);
		}
		
		if (isSetCountList()) {
			copy.setCountList((IntegerOrNullList)copyBuilder.copy(countList));
			if (copy.getCountList() == countList)
				countList.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ScalarValueList(), copyBuilder);
	}

}
