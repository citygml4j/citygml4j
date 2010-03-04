package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface SolidArrayProperty extends GML, Child, Copyable {
	public List<AbstractSolid> getSolid();
	public boolean isSetSolid();

	public void setSolid(List<AbstractSolid> abstractSolid);
	public void addSolid(AbstractSolid abstractSolid);
	public void unsetSolid();
	public boolean unsetSolid(AbstractSolid abstractSolid);
}
