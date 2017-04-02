package org.citygml4j.model.citygml.ade.binding;

import org.citygml4j.util.walker.Walker;

public interface ADEWalker<T extends Walker> {
	public void setParentWalker(T walker);
	public String getNamespaceURI();
}
