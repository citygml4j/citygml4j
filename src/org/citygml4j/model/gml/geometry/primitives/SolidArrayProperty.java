package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

public interface SolidArrayProperty extends GeometryArrayProperty<AbstractSolid> {
	public List<AbstractSolid> getSolid();
	public boolean isSetSolid();

	public void setSolid(List<AbstractSolid> abstractSolid);
	public void addSolid(AbstractSolid abstractSolid);
	public void unsetSolid();
	public boolean unsetSolid(AbstractSolid abstractSolid);
}
