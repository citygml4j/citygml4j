package org.citygml4j.model.module.gml;

import org.citygml4j.model.module.AbstractModule;
import org.citygml4j.model.module.Module;

public abstract class AbstractGMLModule extends AbstractModule implements GMLModule {

	public AbstractGMLModule (
			GMLModuleType type,
			GMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);
	}

	@Override
	public GMLModuleType getType() {
		return (GMLModuleType)super.getType();
	}

	@Override
	public GMLModuleVersion getVersion() {
		return (GMLModuleVersion)super.getVersion();
	}
	
}
