package org.citygml4j.xml.io.reader;

import java.util.List;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.Code;
import org.citygml4j.model.gml.LocationProperty;
import org.citygml4j.model.gml.MetaDataProperty;
import org.citygml4j.model.gml.StringOrRef;

public interface ParentInfo {
	public boolean isSetParentInfo();
	public ParentInfo getParentInfo();
	
	public boolean isSetId();
	public String getId();
	public boolean isSetName();
	public List<Code> getName();
	public boolean isSetDescription();
	public StringOrRef getDescription();
	public boolean isSetMetaDataProperty();
	public List<MetaDataProperty> getMetaDataProperty();
	public boolean isSetBoundedBy();
	public BoundingShape getBoundedBy();
	public boolean isSetLocation();
	public LocationProperty getLocation();	
	public CityGMLClass getCityGMLClass();
}
