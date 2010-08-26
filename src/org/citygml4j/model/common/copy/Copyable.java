package org.citygml4j.model.common.copy;

import org.citygml4j.builder.copy.CopyBuilder;

public interface Copyable {
	public Object copyTo(Object target, CopyBuilder copyBuilder);
	public Object copy(CopyBuilder copyBuilder);
}
