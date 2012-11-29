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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id$
 */
package org.citygml4j.model.gml.basicTypes;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Null;

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

	public ModelType getModelType() {
		return ModelType.GML;
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
