package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

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
