package org.citygml4j.model.gml;

public interface PriorityLocationProperty extends LocationProperty {
	public String getPriority();
	public boolean isSetPriority();
	
	public void setPriority(String priority);
	public void unsetPriority();
}
