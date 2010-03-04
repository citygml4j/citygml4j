package org.citygml4j.model.module;

public interface Module {
	public ModuleType getType();
	public ModuleVersion getVersion();
	public String getNamespaceURI();
	public String getNamespacePrefix();
	public String getSchemaLocation();
	public Module[] getDependencies();
	public boolean isDependentOn(Module module, boolean transitive);
}
