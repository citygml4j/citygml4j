package org.citygml4j.model.gml;

import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public interface AbstractGeometry extends AbstractGML, SRSReferenceGroup {
	public String getGid();
	public boolean isSetGid();

	public void setGid(String gid);
	public BoundingBox calcBoundingBox();
	public void unsetGid();
	
	public void visit(GeometryVisitor visitor);
	public <T> T apply(GeometryFunction<T> visitor);
}
