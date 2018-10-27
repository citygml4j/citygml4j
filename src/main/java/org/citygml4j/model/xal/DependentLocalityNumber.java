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

public class DependentLocalityNumber implements XAL, GrPostal, Child, Copyable {
	private String content;
	private String nameNumberOccurrence;
	private String code;
	private ModelObject parent;
	
	public String getContent() {
		return content;
	}

	public String getNameNumberOccurrence() {
		return nameNumberOccurrence;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetNameNumberOccurrence() {
		return nameNumberOccurrence != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNameNumberOccurrence(String nameNumberOccurrence) {
		if (nameNumberOccurrence.equals("Before") || nameNumberOccurrence.equals("After"))
			this.nameNumberOccurrence = nameNumberOccurrence;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetNameNumberOccurrence() {
		nameNumberOccurrence = null;
	}

	public XALClass getXALClass() {
		return XALClass.DEPENDENT_LOCALITY_NUMBER;
	}

	public String getCode() {
		return code;
	}

	public boolean isSetCode() {
		return code != null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void unsetCode() {
		code = null;
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
		return copyTo(new DependentLocalityNumber(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DependentLocalityNumber copy = (target == null) ? new DependentLocalityNumber() : (DependentLocalityNumber)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetNameNumberOccurrence())
			copy.setNameNumberOccurrence(copyBuilder.copy(nameNumberOccurrence));
		
		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));
		
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
