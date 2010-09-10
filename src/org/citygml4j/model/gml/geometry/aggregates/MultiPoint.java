package org.citygml4j.model.gml.geometry.aggregates;

import java.util.List;

import org.citygml4j.model.gml.geometry.primitives.PointArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;

public interface MultiPoint extends AbstractGeometricAggregate {
	public List<PointProperty> getPointMember();
	public PointArrayProperty getPointMembers();
	public boolean isSetPointMember();
	public boolean isSetPointMembers();
	
	public void addPointMember(PointProperty pointMember);
	public void setPointMember(List<PointProperty> pointMember);
	public void setPointMembers(PointArrayProperty pointMembers);
	public void unsetPointMember();
	public boolean unsetPointMember(PointProperty pointMember);
	public void unsetPointMembers();
}
