package org.citygml4j.model.gml.feature;

import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface LocationProperty extends GeometryProperty<AbstractGeometry> {
	public Code getLocationKeyWord();
	public StringOrRef getLocationString();
	public Null getNull();
	public boolean isSetLocationKeyWord();
	public boolean isSetLocationString();
	public boolean isSetNull();
	
	public void setLocationKeyWord(Code locationKeyWord);
	public void setLocationString(StringOrRef locationString);
	public void setNull(Null _null);
	public void unsetLocationKeyWord();
	public void unsetLocationString();
	public void unsetNull();
}
