package org.citygml4j.model.gml;

public interface AbstractFeature extends AbstractGML {
	public BoundingShape getBoundedBy();
	public LocationProperty getLocation();
	public boolean isSetBoundedBy();
	public boolean isSetLocation();

	public void setBoundedBy(BoundingShape boundingShape);
	public void calcBoundedBy();
	public void calcBoundedBy(AbstractGeometry abstractGeometry);
	public void calcBoundedBy(AbstractFeature boundingShape);
	public void unsetBoundedBy();
	public void unsetLocation();
}
