package org.citygml4j.model.common.child;

import org.citygml4j.model.common.base.ModelObject;

public interface Child extends ModelObject {
	public ModelObject getParent();
	public void setParent(ModelObject parent);
	public boolean isSetParent();
	public void unsetParent();
}
