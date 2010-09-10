package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface Null extends GML, Child, Copyable {
	public static String INAPPLICABLE = "inapplicable";
	public static String MISSING = "missing";
	public static String TEMPLATE = "template";
	public static String UNKNOWN = "unknown";
	public static String WITHHELD = "withheld";
	
	public String getValue();
	public boolean isSetValue();
	
	public void setValue(String value);
	public void unsetValue();
}
