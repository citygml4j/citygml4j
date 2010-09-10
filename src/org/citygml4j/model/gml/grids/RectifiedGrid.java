package org.citygml4j.model.gml.grids;

import java.util.List;

import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.gml.geometry.primitives.Vector;

public interface RectifiedGrid extends Grid {
	public PointProperty getOrigin();
	public List<Vector> getOffsetVector();
	public boolean isSetOrigin();
	public boolean isSetOffsetVector();
	
	public void setOrigin(PointProperty origin);
	public void addOffsetVector(Vector offsetVector);
	public void setOffsetVector(List<Vector> offsetVector);
	public void unsetOrigin();
	public boolean unsetOffsetVector(Vector offsetVector);
	public void unsetOffsetVector();
}
