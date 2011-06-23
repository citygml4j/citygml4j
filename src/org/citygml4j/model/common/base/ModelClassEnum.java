package org.citygml4j.model.common.base;

public interface ModelClassEnum {
	public Class<? extends ModelObject> getInterface();
	public boolean isInstance(ModelClassEnum type);
}
