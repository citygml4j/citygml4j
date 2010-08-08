package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface NameOrNull extends GML, Child, Copyable {
	public String getName();
	public Null getNull();
	public boolean isSetName();
	public boolean isSetNull();
	
	public void setName(String name);
	public void setNull(Null _null);
	public void unsetName();
	public void unsetNull();
}
