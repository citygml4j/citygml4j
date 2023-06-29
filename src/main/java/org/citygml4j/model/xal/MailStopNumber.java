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
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public class MailStopNumber implements XAL, GrPostal, Child, Copyable {
	private String content;
	private String nameNumberSeparator;
	private String code;
	private ModelObject parent;
	
	public String getContent() {
		return content;
	}

	public String getNameNumberSeparator() {
		return nameNumberSeparator;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetNameNumberSeparator() {
		return nameNumberSeparator != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNameNumberSeparator(String nameNumberSeparator) {
		this.nameNumberSeparator = nameNumberSeparator;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetNameNumberSeparator() {
		nameNumberSeparator = null;
	}

	public XALClass getXALClass() {
		return XALClass.MAIL_STOP_NUMBER;
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
		return copyTo(new MailStopNumber(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MailStopNumber copy = (target == null) ? new MailStopNumber() : (MailStopNumber)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetNameNumberSeparator())
			copy.setNameNumberSeparator(copyBuilder.copy(nameNumberSeparator));
		
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
