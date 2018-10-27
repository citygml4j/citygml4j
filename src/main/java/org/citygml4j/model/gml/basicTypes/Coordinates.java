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
package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

import java.util.ArrayList;
import java.util.List;

public class Coordinates implements GML, Child, Copyable {
	private String value;
	private String decimal;
	private String cs;
	private String ts;
	private ModelObject parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.COORDINATES;
	}

	public String getCs() {
		if (cs == null)
			return ",";
		else
			return cs;
	}

	public String getDecimal() {
		if (decimal == null)
			return ".";
		else
			return decimal;
	}

	public String getTs() {
		if (ts == null)
			return " ";
		else
			return ts;
	}

	public String getValue() {
		return value;
	}

	public boolean isSetCs() {
		return cs != null;
	}

	public boolean isSetDecimal() {
		return decimal != null;
	}

	public boolean isSetTs() {
		return ts != null;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	public void setDecimal(String decimal) {
		this.decimal = decimal;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();
		boolean isValid = false;

		if (isSetValue()) {
			String coordinates = getValue();
			String decimal = prepareRegex(getDecimal());
			String cs = prepareRegex(getCs());
			String ts = prepareRegex(getTs());

			isValid = true;
			coordinates = coordinates.replaceAll("[\\t\\n\\r]+", ts);

			String[] tupels = coordinates.split(ts);
			for (int i = 0; i < tupels.length && isValid ; ++i) {
				if (tupels[i] != null && tupels[i].length() != 0) {
					String[] coords = tupels[i].split(cs);
					List<Double> point = new ArrayList<Double>();

					for (int j = 0; j < coords.length && isValid; ++j) {
						if (coords[j] != null && coords[j].trim().length() != 0) {
							coords[j] = coords[j].replaceAll(decimal, ".");

							try {
								double result = Double.parseDouble(coords[j]);
								point.add(result);
							} catch (NumberFormatException e) {
								isValid = false;
								break;
							}
						} else
							isValid = false;
					}

					if (isValid) {
						while (point.size() < 3)
							point.add(0.0);

						tmp.addAll(point.subList(0, 3));
					}
				}
			}
		}

		if (!isValid || tmp.size() == 0)
			tmp.clear();

		return tmp;
	}

	public List<Double> toList3d(boolean reverseOrder) {
		List<Double> tmp = toList3d();

		if (reverseOrder) {
			List<Double> reversed = new ArrayList<Double>();

			for (int i = tmp.size() - 3; i >= 0; i -=3)
				reversed.addAll(tmp.subList(i, i + 3));

			tmp = reversed;
		}

		return tmp;
	}

	public void unsetCs() {
		cs = null;
	}

	public void unsetDecimal() {
		decimal = null;
	}

	public void unsetTs() {
		ts = null;
	}

	public void unsetValue() {
		value = null;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Coordinates copy = (target == null) ? new Coordinates() : (Coordinates)target;
		
		if (isSetValue())
			copy.setValue(copyBuilder.copy(value));
		
		if (isSetDecimal())
			copy.setDecimal(copyBuilder.copy(decimal));
		
		if (isSetCs())
			copy.setCs(copyBuilder.copy(cs));
		
		if (isSetTs())
			copy.setTs(copyBuilder.copy(ts));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Coordinates(), copyBuilder);
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

	private String prepareRegex(String input) {
		StringBuilder buffer = new StringBuilder();

		for (char c : input.toCharArray()) {
			if ("+()^$.{}[]|\\".indexOf(c) != -1)
				buffer.append('\\').append(c);
			else
				buffer.append(c);
		}

		return buffer.toString();
	}

}
