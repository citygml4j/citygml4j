package org.citygml4j.model.module.gml;

import org.citygml4j.model.module.Module;

public interface GMLModule extends Module {
	public GMLModuleType getType();
	public GMLModuleVersion getVersion();
}
