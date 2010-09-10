package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


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
