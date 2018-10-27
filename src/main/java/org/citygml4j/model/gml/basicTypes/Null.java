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
package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Null implements GML, Child, Copyable {
	public static String INAPPLICABLE = "inapplicable";
	public static String MISSING = "missing";
	public static String TEMPLATE = "template";
	public static String UNKNOWN = "unknown";
	public static String WITHHELD = "withheld";
	
	private String value;
	private ModelObject parent;

	public String getValue() {
		return value;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setValue(String value) {
		if (value.equals(Null.INAPPLICABLE) ||
				value.equals(Null.MISSING) ||
				value.equals(Null.TEMPLATE) ||
				value.equals(Null.UNKNOWN) ||
				value.equals(Null.WITHHELD))
			this.value = value;
		else if (value != null && value.length() != 0){
			Pattern p = Pattern.compile("other:\\w{2,}");
			Matcher m = p.matcher(value);

			if (m.matches())
				this.value = value;
			else {
				try {
					URI uri = new URI(value);
					if (uri.toURL() != null)
						this.value = uri.toString();
				} catch (URISyntaxException e) {
					// 
				} catch (MalformedURLException e) {
					//
				} catch (IllegalArgumentException e) {
					//
				}
			}
		}
	}

	public void unsetValue() {
		value = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.NULL;
	}

	public ModelObject getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Null(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Null copy = (target == null) ? new Null() : (Null)target;

		if (isSetValue())
			copy.setValue(copyBuilder.copy(value));

		copy.unsetParent();

		return copy;
	}

}
