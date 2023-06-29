/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

import java.util.List;

public class ThoroughfareNumberTo implements XAL, GrPostal, Child, Copyable {
	private List<ThoroughfareNumberToContent> content;
	private String code;
	private ModelObject parent;

	public void addAddressLine(AddressLine addressLine) {
		getContent().add(new ThoroughfareNumberToContent(addressLine));
	}

	public void addContent(ThoroughfareNumberToContent content) {
		getContent().add(content);
	}

	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		getContent().add(new ThoroughfareNumberToContent(thoroughfareNumber));
	}

	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		getContent().add(new ThoroughfareNumberToContent(thoroughfareNumberPrefix));
	}

	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		getContent().add(new ThoroughfareNumberToContent(thoroughfareNumberSuffix));
	}

	public void addString(String string) {
		getContent().add(new ThoroughfareNumberToContent(string));
	}

	public List<ThoroughfareNumberToContent> getContent() {
		if (content == null)
			content = new ChildList<>(this);

		return content;
	}

	public boolean isSetContent() {
		return content != null && !content.isEmpty();
	}

	public void setContent(List<ThoroughfareNumberToContent> content) {
		this.content = new ChildList<>(this, content);
	}

	public void unsetContent() {
		content = ModelObjects.setNull(content);
	}

	public boolean unsetContent(ThoroughfareNumberToContent content) {
		return isSetContent() && this.content.remove(content);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetContent() && content.removeIf(c -> c.getAddressLine() == addressLine);
	}
	
	public boolean unsetThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		return isSetContent() && content.removeIf(c -> c.getThoroughfareNumber() == thoroughfareNumber);
	}

	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		return isSetContent() && content.removeIf(c -> c.getThoroughfareNumberPrefix() == thoroughfareNumberPrefix);
	}

	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		return isSetContent() && content.removeIf(c -> c.getThoroughfareNumberSuffix() == thoroughfareNumberSuffix);
	}

	public boolean unsetString(String string) {
		return isSetContent() && content.removeIf(c -> c.isSetString() && c.getString().equals(string));
	}

	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE_NUMBER_TO;
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
		return copyTo(new ThoroughfareNumberTo(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ThoroughfareNumberTo copy = (target == null) ? new ThoroughfareNumberTo() : (ThoroughfareNumberTo)target;
		
		if (isSetContent()) {
			for (ThoroughfareNumberToContent part : content) {
				ThoroughfareNumberToContent copyPart = (ThoroughfareNumberToContent)copyBuilder.copy(part);
				copy.addContent(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
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
