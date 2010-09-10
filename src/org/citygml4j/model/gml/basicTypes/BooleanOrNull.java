package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface BooleanOrNull extends GML, Child, Copyable {
	public Boolean getBoolean();
	public Null getNull();
	public boolean isSetBoolean();
	public boolean isSetNull();
	
	public void setBoolean(Boolean _boolean);
	public void setNull(Null _null);
	public void unsetBoolean();
	public void unsetNull();
}
