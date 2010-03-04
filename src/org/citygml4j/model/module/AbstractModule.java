package org.citygml4j.model.module;

public abstract class AbstractModule implements Module {
	private final ModuleType type;
	private final ModuleVersion version;
	private final String namespaceURI;
	private final String namespacePrefix;
	private final String schemaLocation;
	private final Module[] dependencies;
	
	public AbstractModule(
			ModuleType type,
			ModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation, 
			Module... dependencies) {
		this.type = type;
		this.version = version;
		this.namespaceURI = namespaceURI;
		this.namespacePrefix = namespacePrefix;
		this.schemaLocation = schemaLocation;
		this.dependencies = dependencies;
	}
	
	public ModuleType getType() {
		return type;
	}

	public ModuleVersion getVersion() {
		return version;
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public String getNamespacePrefix() {
		return namespacePrefix;
	}

	public String getSchemaLocation() {
		return schemaLocation;
	}
	
	public Module[] getDependencies() {
		return dependencies;
	}
	
	public boolean isDependentOn(Module module, boolean transitive) {
		if (dependencies != null) {
			for (Module dependency : dependencies) {
				if (module == dependency)
					return true;

				if (transitive && dependency.isDependentOn(module, transitive))
					return true;			
			}
		}

		return false;
	}

}
