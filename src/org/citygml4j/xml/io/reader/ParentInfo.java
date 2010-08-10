package org.citygml4j.xml.io.reader;

import java.util.List;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.base.MetaDataProperty;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.LocationProperty;

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
