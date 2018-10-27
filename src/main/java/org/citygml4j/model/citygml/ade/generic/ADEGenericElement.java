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
package org.citygml4j.model.citygml.ade.generic;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.DeepCopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.w3c.dom.Element;

public class ADEGenericElement implements ADEComponent {
	private Element content;
	private ModelObject parent;	
	
	public ADEGenericElement() {
		
	}
	
	public ADEGenericElement(Element content) {
		this.content = content;
	}
	
	public Element getContent() {
		return content;
	}
	
	public boolean isSetContent() {
		return content != null;
	}
	
	public void setContent(Element content) {
		this.content = content;
	}
	
	public void unsetContent() {
		content = null;
	}

	public String getLocalName() {
		return isSetContent() ? content.getLocalName() : null;
	}
	
	public String getPrefix() {
		return isSetContent() ? content.getPrefix() : null;
	}
	
	public String getNamespaceURI() {
		return isSetContent() ? content.getNamespaceURI() : null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADE_COMPONENT;
	}

	@Override
	public ADEClass getADEClass() {
		return ADEClass.GENERIC_ELEMENT;
	}

	@Override
	public ModelObject getParent() {
		return parent;
	}

	@Override
	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	@Override
	public boolean isSetParent() {
		return parent != null;
	}

	@Override
	public void unsetParent() {
		parent = null;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ADEGenericElement(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ADEGenericElement copy = (target == null) ? new ADEGenericElement() : (ADEGenericElement)target;
		
		if (isSetContent()) {
			if (copyBuilder instanceof DeepCopyBuilder)
				copy.setContent((Element)content.cloneNode(true));
			else
				copy.setContent((Element)copyBuilder.copy(content));
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public void visit(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T apply(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
}
