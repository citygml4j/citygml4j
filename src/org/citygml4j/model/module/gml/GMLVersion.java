package org.citygml4j.model.module.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.module.AbstractModuleConfiguration;
import org.citygml4j.model.module.Module;

public class GMLVersion extends AbstractModuleConfiguration {
	private static final List<GMLVersion> instances = new ArrayList<GMLVersion>();

	public static final GMLVersion DEFAULT;
	public static final GMLVersion v3_1_1;

	private GMLVersion(Module... modules) {
		super(modules);
		instances.add(this);
	}

	static {
		v3_1_1 = new GMLVersion(
				GMLCoreModule.v3_1_1,
				XLinkModule.v3_1_1
		);

		DEFAULT = v3_1_1;
	}

	public List<GMLModule> getGMLModules() {
		List<GMLModule> gml = new ArrayList<GMLModule>();
		for (Module module : modules)
			gml.add((GMLModule)module);

		return gml;
	}

}
