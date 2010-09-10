package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface DoubleOrNull extends GML, Child, Copyable {
	public Double getDouble();
	public Null getNull();
	public boolean isSetDouble();
	public boolean isSetNull();
	
	public void setDouble(Double _double);
	public void setNull(Null _null);
	public void unsetDouble();
	public void unsetNull();
}
