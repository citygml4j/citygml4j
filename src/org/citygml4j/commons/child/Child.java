package org.citygml4j.commons.child;

public interface Child {
	public Object getParent();
	public void setParent(Object parent);
	public boolean isSetParent();
	public void unsetParent();
}
