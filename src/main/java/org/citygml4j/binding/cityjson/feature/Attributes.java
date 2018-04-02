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
package org.citygml4j.binding.cityjson.feature;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attributes {
	@JsonAdapter(DateTimeAdapter.class)
	private ZonedDateTime creationDate;
	@JsonAdapter(DateTimeAdapter.class)
	private ZonedDateTime terminationDate;
	@SerializedName("class")
	private String clazz;
	private String function;
	private String usage;
	private transient Map<String, Object> genericAttributes;
	private transient List<String> attributeNames;

	public boolean isSetCreationDate() {
		return creationDate != null;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate.atZone(ZoneId.systemDefault());
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate.atStartOfDay(ZoneId.systemDefault());
	}
	
	public void unsetCreationDate() {
		creationDate = null;
	}

	public boolean isSetTerminationDate() {
		return terminationDate != null;
	}

	public ZonedDateTime getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(ZonedDateTime terminationDate) {
		this.terminationDate = terminationDate;
	}

	public void setTerminationDate(LocalDateTime terminationDate) {
		this.terminationDate = terminationDate.atZone(ZoneId.systemDefault());
	}

	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate.atStartOfDay(ZoneId.systemDefault());
	}

	public void unsetTerminationDate() {
		terminationDate = null;
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void unsetClazz() {
		clazz = null;
	}
	
	public boolean isSetFunction() {
		return function != null;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
	public void unsetFunction() {
		function = null;
	}

	public boolean isSetUsage() {
		return usage != null;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	public void unsetUsage() {
		usage = null;
	}

	public boolean isSetGenericAttributes() {
		return genericAttributes != null;
	}

	public void addGenericAttribute(String name, Object value) {
		if (genericAttributes == null)
			genericAttributes = new HashMap<>();

		genericAttributes.put(name, value);
	}

	public Map<String, Object> getGenericAttributes() {
		return genericAttributes;
	}

	public void setGenericAttributes(Map<String, Object> genericAttributes) {
		this.genericAttributes = genericAttributes;
	}
	
	public void removeGenericAttribute(String name) {
		if (genericAttributes != null)
			genericAttributes.remove(name);
	}
	
	public void unsetGenericAttributes() {
		genericAttributes = null;
	}

	public boolean hasAttributes() {
		return creationDate != null
				|| terminationDate != null
				|| clazz != null
				|| function!= null
				|| usage != null
				|| genericAttributes != null;
	}

	protected List<String> getAttributeNames() {
		if (attributeNames == null) {
			attributeNames = new ArrayList<>();

			Class<?> clazz = this.getClass();
			do {
				for (Field field : clazz.getDeclaredFields()) {
					if (Modifier.isTransient(field.getModifiers()))
						continue;

					SerializedName name = field.getAnnotation(SerializedName.class);
					attributeNames.add(name != null ? name.value() : field.getName());
				}
			} while ((clazz = clazz.getSuperclass()) != null);
		}

		return attributeNames;
	}

}
