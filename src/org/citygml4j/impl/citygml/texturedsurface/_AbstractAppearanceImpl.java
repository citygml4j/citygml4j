package org.citygml4j.impl.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AbstractGMLImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public abstract class _AbstractAppearanceImpl extends AbstractGMLImpl implements _AbstractAppearance {
	private TexturedSurfaceModule module;

	public _AbstractAppearanceImpl() {
		
	}
	
	public _AbstractAppearanceImpl(TexturedSurfaceModule module) {
		this.module = module;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._ABSTRACT_APPEARANCE;
	}

	public final TexturedSurfaceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		_AbstractAppearance copy = (_AbstractAppearance)target;		
		return super.copyTo(copy, copyBuilder);
	}

}
