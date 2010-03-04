package org.citygml4j.impl.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.AbstractGMLImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.texturedsurface._Appearance;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public abstract class _AppearanceImpl extends AbstractGMLImpl implements _Appearance {
	private TexturedSurfaceModule module;

	public _AppearanceImpl() {
		
	}
	
	public _AppearanceImpl(TexturedSurfaceModule module) {
		this.module = module;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._APPEARANCE;
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

		_Appearance copy = (_Appearance)target;		
		return super.copyTo(copy, copyBuilder);
	}

}
