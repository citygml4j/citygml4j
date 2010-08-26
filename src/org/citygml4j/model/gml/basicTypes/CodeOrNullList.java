package org.citygml4j.model.gml.basicTypes;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface CodeOrNullList extends GML, Child, Copyable {
	public List<NameOrNull> getNameOrNull();
	public String getCodeSpace();
	public boolean isSetNameOrNull();
	public boolean isSetCodeSpace();
	
	public void setCodeSpace(String codeSpace);
	public void setNameOrNull(List<NameOrNull> nameOrNull);
	public void addNameOrNull(NameOrNull nameOrNull);
	public void unsetNameOrNull();
	public boolean unsetNameOrNull(NameOrNull nameOrNull);
	public void unsetCodeSpace();
}
