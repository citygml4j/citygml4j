package org.citygml4j.model.gml;

import java.util.List;

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
