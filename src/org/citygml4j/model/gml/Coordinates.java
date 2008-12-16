package org.citygml4j.model.gml;

public interface Coordinates extends GMLBase {
	public String getValue();
	public String getDecimal();
	public String getCs();
	public String getTs();
	public boolean isSetValue();
	public boolean isSetDecimal();
	public boolean isSetCs();
	public boolean isSetTs();
	
	public void setValue(String value);
	public void setDecimal(String decimal);
	public void setCs(String cs);
	public void setTs(String ts);
	public void unsetValue();
	public void unsetDecimal();
	public void unsetCs();
	public void unsetTs();
}
