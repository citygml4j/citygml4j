package org.citygml4j.model.gml;

import org.citygml4j.geometry.Point;

public interface AbstractGeometry extends AbstractGML, SRSReferenceGroup {
	public String getGid();
	public boolean isSetGid();

	public void setGid(String gid);
	public void calcBoundingBox(Point min, Point max);
	public void unsetGid();
}
