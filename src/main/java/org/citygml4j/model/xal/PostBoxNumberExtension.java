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
package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public class PostBoxNumberExtension implements XAL, Child, Copyable {
	private String content;
	private String numberExtensionSeparator;
	private ModelObject parent;
	
	public String getContent() {
		return content;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void unsetContent() {
		content = null;
	}

	public XALClass getXALClass() {
		return XALClass.POST_BOX_NUMBER_EXTENSION;
	}

	public String getNumberExtensionSeparator() {
		return numberExtensionSeparator;
	}

	public boolean isSetNumberExtensionSeparator() {
		return numberExtensionSeparator != null;
	}

	public void setNumberExtensionSeparator(String numberExtensionSeparator) {
		this.numberExtensionSeparator = numberExtensionSeparator;
	}

	public void unsetNumberExtensionSeparator() {
		numberExtensionSeparator = null;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PostBoxNumberExtension(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostBoxNumberExtension copy = (target == null) ? new PostBoxNumberExtension() : (PostBoxNumberExtension)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetNumberExtensionSeparator())
			copy.setNumberExtensionSeparator(copyBuilder.copy(numberExtensionSeparator));
		
		copy.unsetParent();
		
		return copy;
	}
	
	public void accept(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
