package org.citygml4j.model.gml;

public interface MultiPointProperty extends GMLBase, AssociationAttributeGroup {
	public MultiPoint getMultiPoint();
	public boolean isSetMultiPoint();
	
	public void setMultiPoint(MultiPoint multiPoint);
	public void unsetMultiPoint();
}
