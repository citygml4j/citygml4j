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
package org.citygml4j.model.gml.xlink;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public enum XLinkShow implements GML, Copyable {
	NEW("new"),
	REPLACE("replace"),
	EMBED("embed"),
	OTHER("other"),
	NONE("none");

	private final String value;

	XLinkShow(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public static XLinkShow fromValue(String v) {
		v = v.trim();

		for (XLinkShow c: XLinkShow.values())
			if (c.value.equals(v))
				return c;

		return NONE;
	}

	public String toString() {
		return value;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.XLINK_SHOW;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? NONE : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}

}
