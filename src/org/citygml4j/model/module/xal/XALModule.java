package org.citygml4j.model.module.xal;

import org.citygml4j.model.module.Module;

public interface XALModule extends Module {
	public XALModuleType getType();
	public XALModuleVersion getVersion();
}
