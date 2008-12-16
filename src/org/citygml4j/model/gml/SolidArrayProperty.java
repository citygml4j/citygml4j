package org.citygml4j.model.gml;

import java.util.List;

public interface SolidArrayProperty extends GMLBase {
	public List<AbstractSolid> getSolid();
	public boolean isSetSolid();

	public void setSolid(List<AbstractSolid> abstractSolid);
	public void addSolid(AbstractSolid abstractSolid);
	public void unsetSolid();
	public boolean unsetSolid(AbstractSolid abstractSolid);
}
