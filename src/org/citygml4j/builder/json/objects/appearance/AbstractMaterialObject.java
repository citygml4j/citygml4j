package org.citygml4j.builder.json.objects.appearance;

import java.util.List;

public abstract class AbstractMaterialObject {
	protected transient String theme;
	private Integer value;

	public abstract boolean isSetValues();
	public abstract void addNullValue();
	public abstract int getNumValues();
	public abstract List<Integer> flatValues();
	public abstract void unsetValues();

	AbstractMaterialObject() {
	}

	public AbstractMaterialObject(String theme) {
		this.theme = theme != null ? theme : "";
	}

	public String getTheme() {
		return theme;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void unsetValue() {
		value = null;
	}

	public boolean collapseValues() {
		List<Integer> values = flatValues();
		if (values == null || values.isEmpty())
			return false;

		Integer compareTo = values.get(0);
		for (int i = 1 ; i < values.size(); i++) {
			if (values.get(i) != compareTo)
				return false;
		}

		unsetValues();
		if (compareTo != null)
			setValue(compareTo);

		return true;
	}

}
