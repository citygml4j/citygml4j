package org.citygml4j.impl.gml.basicTypes;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Null;

public class NullImpl implements Null {
	private String value;
	private Object parent;

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

	public Object getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new NullImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Null copy = (target == null) ? new NullImpl() : (Null)target;

		if (isSetValue())
			copy.setValue(copyBuilder.copy(value));

		copy.unsetParent();

		return copy;
	}

}
