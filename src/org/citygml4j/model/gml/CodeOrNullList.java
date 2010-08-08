package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

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
