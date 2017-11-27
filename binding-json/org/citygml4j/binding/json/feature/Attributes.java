package org.citygml4j.binding.json.feature;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Attributes {
	private Date creationDate;
	private Date terminationDate;
	@SerializedName("class")
	private String clazz;
	private String function;
	private String usage;
	private transient Map<String, Object> genericAttributes;
	private transient List<String> attributeNames;

	public boolean isSetCreationDate() {
		return creationDate != null;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isSetTerminationDate() {
		return terminationDate != null;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
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

	public boolean isSetFunction() {
		return function != null;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
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
