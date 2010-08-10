package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.gml.GML;


public interface Code extends GML, Child, Copyable {
	public String getValue();
	public String getCodeSpace();
	public boolean isSetValue();
	public boolean isSetCodeSpace();

	public void setValue(String value);
	public void setCodeSpace(String codeSpace);
	public void unsetValue();
	public void unsetCodeSpace();
}
