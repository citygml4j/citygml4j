/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id: GenericAttributeSet.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.citygml.generics;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.module.citygml.GenericsModule;

public class GenericAttributeSet extends AbstractGenericAttribute {
	private List<AbstractGenericAttribute> genericAttribute;
	private String codeSpace;
	
	public GenericAttributeSet() {
		
	}
	
	public GenericAttributeSet(GenericsModule module) {
		super(module);
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GENERIC_ATTRIBUTE_SET;
	}

	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public void addGenericAttribute(AbstractGenericAttribute genericAttribute) {
		if (this.genericAttribute == null)
			this.genericAttribute = new ChildList<AbstractGenericAttribute>(this);
		
		this.genericAttribute.add(genericAttribute);
	}
	
	public List<AbstractGenericAttribute> getGenericAttribute() {
		if (genericAttribute == null)
			genericAttribute = new ChildList<AbstractGenericAttribute>(this);
		
		return genericAttribute;
	}

	public String getCodeSpace() {
		return codeSpace;
	}

	public boolean isSetGenericAttribute() {
		return genericAttribute != null && !genericAttribute.isEmpty();
	}

	public boolean isSetCodeSpace() {
		return genericAttribute != null;
	}

	public void setGenericAttribute(List<AbstractGenericAttribute> genericAttribute) {
		this.genericAttribute = new ChildList<AbstractGenericAttribute>(this, genericAttribute);
	}

	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}

	public void unsetGenericAttribute() {
		if (isSetGenericAttribute())
			genericAttribute.clear();
		
		genericAttribute = null;
	}

	public boolean unsetGenericAttribute(AbstractGenericAttribute genericAttribute) {
		return isSetGenericAttribute() ? this.genericAttribute.remove(genericAttribute) : false;
	}

	public void unsetCodeSpace() {
		codeSpace = null;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GenericAttributeSet(), copyBuilder);
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GenericAttributeSet copy = (target == null) ? new GenericAttributeSet() : (GenericAttributeSet)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetCodeSpace())
			copy.setCodeSpace(copyBuilder.copy(codeSpace));
		
		if (isSetGenericAttribute()) {
			for (AbstractGenericAttribute part : genericAttribute) {
				AbstractGenericAttribute copyPart = (AbstractGenericAttribute)copyBuilder.copy(part);
				copy.addGenericAttribute(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}

}
