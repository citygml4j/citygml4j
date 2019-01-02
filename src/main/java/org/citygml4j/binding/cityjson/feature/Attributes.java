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
package org.citygml4j.binding.cityjson.feature;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class Attributes {
	@JsonAdapter(DateAdapter.class)
	private LocalDate creationDate;
	@JsonAdapter(DateAdapter.class)
	private LocalDate terminationDate;
	@SerializedName("class")
	private String clazz;
	private String function;
	private String usage;
	private transient Map<String, Object> extensionAttributes;

	public boolean isSetCreationDate() {
		return creationDate != null;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate.toLocalDate();
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate.toLocalDate();
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	public void unsetCreationDate() {
		creationDate = null;
	}

	public boolean isSetTerminationDate() {
		return terminationDate != null;
	}

	public LocalDate getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(ZonedDateTime terminationDate) {
		this.terminationDate = terminationDate.toLocalDate();
	}

	public void setTerminationDate(LocalDateTime terminationDate) {
		this.terminationDate = terminationDate.toLocalDate();
	}

	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
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

	public boolean isSetExtensionAttributes() {
		return extensionAttributes != null;
	}

	public void addExtensionAttribute(String name, Object value) {
		if (extensionAttributes == null)
			extensionAttributes = new HashMap<>();

		extensionAttributes.put(name, value);
	}

	public Map<String, Object> getExtensionAttributes() {
		return extensionAttributes;
	}

	public void setExtensionAttributes(Map<String, Object> extensionAttributes) {
		this.extensionAttributes = extensionAttributes;
	}

	public void removeExtensionAttribute(String name) {
		if (extensionAttributes != null)
			extensionAttributes.remove(name);
	}

	public void unsetExtensionAttributes() {
		extensionAttributes = null;
	}
}
