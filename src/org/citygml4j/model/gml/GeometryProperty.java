package org.citygml4j.model.gml;

public interface GeometryProperty extends GMLBase, AssociationAttributeGroup {
	public AbstractGeometry getGeometry();
	public boolean isSetGeometry();

	public void setGeometry(AbstractGeometry geometry);
	public void unsetGeometry();
}
