package org.citygml4j.model.gml;

import java.util.List;

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
