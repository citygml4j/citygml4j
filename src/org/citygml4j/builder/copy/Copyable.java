package org.citygml4j.builder.copy;

public interface Copyable {
	public Object copyTo(Object target, CopyBuilder copyBuilder);
	public Object copy(CopyBuilder copyBuilder);
}
