/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.generics;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;

import java.util.List;

public class GenericAttributeSet extends AbstractGenericAttribute {
	private List<AbstractGenericAttribute> genericAttribute;
	private String codeSpace;

	public GenericAttributeSet() {

	}

	public GenericAttributeSet(List<AbstractGenericAttribute> attributes) {
		genericAttribute = new ChildList<>(this, attributes);
	}
	
	public GenericAttributeSet(String name, List<AbstractGenericAttribute> attributes) {
		genericAttribute = new ChildList<>(this, attributes);
		setName(name);
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GENERIC_ATTRIBUTE_SET;
	}

	public void addGenericAttribute(AbstractGenericAttribute genericAttribute) {
		getGenericAttribute().add(genericAttribute);
	}

	public List<AbstractGenericAttribute> getGenericAttribute() {
		if (genericAttribute == null)
			genericAttribute = new ChildList<>(this);

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
		this.genericAttribute = new ChildList<>(this, genericAttribute);
	}

	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}

	public void unsetGenericAttribute() {
		genericAttribute = ModelObjects.setNull(genericAttribute);
	}

	public boolean unsetGenericAttribute(AbstractGenericAttribute genericAttribute) {
		return isSetGenericAttribute() && this.genericAttribute.remove(genericAttribute);
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
