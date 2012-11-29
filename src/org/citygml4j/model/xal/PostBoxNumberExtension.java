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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
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

	public ModelType getModelType() {
		return ModelType.XAL;
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
	
	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
