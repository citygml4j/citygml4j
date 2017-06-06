package org.citygml4j.model.module.ade;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.module.AbstractModule;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.ModuleType;
import org.citygml4j.model.module.ModuleVersion;
import org.citygml4j.model.module.citygml.CityGMLVersion;

public abstract class ADEModule extends AbstractModule {
	private final CityGMLVersion cityGMLVersion;
	private List<Module> adeDependencies;
	
	public ADEModule (
			ModuleType type, 
			ModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			CityGMLVersion cityGMLVersion) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, (Module)null);
		this.cityGMLVersion = cityGMLVersion;
		adeDependencies = new ArrayList<>(cityGMLVersion.getModules());
	}
	
	public ADEModule (
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			CityGMLVersion cityGMLVersion) {
		this(new ADEModuleType(), new ADEModuleVersion(), namespaceURI, namespacePrefix, schemaLocation, cityGMLVersion);
	}
	
	public ADEModule (
			String namespaceURI, 
			String namespacePrefix, 
			CityGMLVersion cityGMLVersion) {
		this(new ADEModuleType(), new ADEModuleVersion(), namespaceURI, namespacePrefix, null, cityGMLVersion);
	}
	
	public ADEModule (
			String namespaceURI, 
			CityGMLVersion cityGMLVersion) {
		this(new ADEModuleType(), new ADEModuleVersion(), namespaceURI, null, null, cityGMLVersion);
	}

	@Override
	public abstract boolean hasFeatureProperty(String name);
	@Override
	public abstract boolean hasGlobalFeature(String name);
	@Override
	public abstract Class<? extends CityGML> getGlobalFeatureClass(String name);
	@Override
	public abstract QName getGlobalFeatureName(Class<? extends CityGML> featureClass);

	@Override
	public final ADEModuleType getType() {
		return (ADEModuleType)super.getType();
	}

	@Override
	public final ADEModuleVersion getVersion() {
		return (ADEModuleVersion)super.getVersion();
	}

	@Override
	public final String getNamespaceURI() {
		return super.getNamespaceURI();
	}

	@Override
	public final String getNamespacePrefix() {
		return super.getNamespacePrefix();
	}

	@Override
	public final String getSchemaLocation() {
		return super.getSchemaLocation();
	}

	@Override
	public final Module[] getDependencies() {
		return adeDependencies.stream().toArray(Module[]::new);
	}

	@Override
	public final boolean isDependentOn(Module module, boolean transitive) {
		if (adeDependencies != null) {
			for (Module dependency : adeDependencies) {
				if (module == dependency)
					return true;

				if (transitive && dependency.isDependentOn(module, transitive))
					return true;			
			}
		}

		return false;
	}
	
	public final void addADEModuleDependency(ADEModule module) {
		if (adeDependencies == null)
			adeDependencies = new ArrayList<>();

		adeDependencies.add(module);
	}
	
	public CityGMLVersion getCityGMLVersion() {
		return cityGMLVersion;
	}

}
