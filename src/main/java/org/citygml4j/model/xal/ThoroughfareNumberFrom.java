/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

import java.util.List;

public class ThoroughfareNumberFrom implements XAL, GrPostal, Child, Copyable {
	private List<ThoroughfareNumberFromContent> content;
	private String code;
	private ModelObject parent;

	public void addAddressLine(AddressLine addressLine) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(new ThoroughfareNumberFromContent(addressLine));
	}

	public void addContent(ThoroughfareNumberFromContent content) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(content);
	}

	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(new ThoroughfareNumberFromContent(thoroughfareNumber));
	}

	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(new ThoroughfareNumberFromContent(thoroughfareNumberPrefix));
	}

	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(new ThoroughfareNumberFromContent(thoroughfareNumberSuffix));
	}

	public void addString(String string) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(new ThoroughfareNumberFromContent(string));
	}

	public List<ThoroughfareNumberFromContent> getContent() {
		if (content == null)
			content = new ChildList<ThoroughfareNumberFromContent>(this);

		return content;
	}

	public boolean isSetContent() {
		return content != null && !content.isEmpty();
	}

	public void setContent(List<ThoroughfareNumberFromContent> content) {
		this.content = new ChildList<ThoroughfareNumberFromContent>(this, content);
	}

	public void unsetContent() {
		if (isSetContent())
			content.clear();

		content = null;
	}

	public boolean unsetContent(ThoroughfareNumberFromContent content) {
		return isSetContent() ? this.content.remove(content) : false;
	}
	
	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetContent() ? content.removeIf(c -> c.getAddressLine() == addressLine) : false;
	}

	public boolean unsetThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		return isSetContent() ? content.removeIf(c -> c.getThoroughfareNumber() == thoroughfareNumber) : false;
	}

	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		return isSetContent() ? content.removeIf(c -> c.getThoroughfareNumberPrefix() == thoroughfareNumberPrefix) : false;
	}

	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		return isSetContent() ? content.removeIf(c -> c.getThoroughfareNumberSuffix() == thoroughfareNumberSuffix) : false;
	}

	public boolean unsetString(String string) {
		return isSetContent() ? content.removeIf(c -> c.isSetString() && c.getString().equals(string)) : false;
	}

	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE_NUMBER_FROM;
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
		return copyTo(new ThoroughfareNumberFrom(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ThoroughfareNumberFrom copy = (target == null) ? new ThoroughfareNumberFrom() : (ThoroughfareNumberFrom)target;

		if (isSetContent()) {
			for (ThoroughfareNumberFromContent part : content) {
				ThoroughfareNumberFromContent copyPart = (ThoroughfareNumberFromContent)copyBuilder.copy(part);
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
