package org.citygml4j.model.gml.geometry;

import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.base.AbstractGML;

public interface AbstractGeometry extends AbstractGML, SRSReferenceGroup {
	public String getGid();
	public boolean isSetGid();

	public void setGid(String gid);
	public BoundingBox calcBoundingBox();
	public void unsetGid();
	
	public void accept(GeometryVisitor visitor);
	public <T> T accept(GeometryFunctor<T> visitor);
}
