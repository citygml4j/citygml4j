package org.citygml4j.model.module.xal;

import org.citygml4j.model.module.AbstractModule;
import org.citygml4j.model.module.Module;

public abstract class AbstractXALModule extends AbstractModule implements XALModule {

	public AbstractXALModule (
			XALModuleType type,
			XALModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);
	}

	@Override
	public XALModuleType getType() {
		return (XALModuleType)super.getType();
	}

	@Override
	public XALModuleVersion getVersion() {
		return (XALModuleVersion)super.getVersion();
	}
	
}
