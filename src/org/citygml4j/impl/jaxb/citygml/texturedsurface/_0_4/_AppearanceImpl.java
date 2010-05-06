package org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4;

import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractGMLImpl;
import org.citygml4j.jaxb.citygml._0_4._AppearanceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
import org.citygml4j.model.citygml.texturedsurface._Appearance;

public abstract class _AppearanceImpl extends AbstractGMLImpl implements _Appearance {
	private _AppearanceType _appearanceType;

	public _AppearanceImpl(_AppearanceType _appearanceType) {
		super(_appearanceType);
		this._appearanceType = _appearanceType;
	}

	@Override
	public _AppearanceType getJAXBObject() {
		return _appearanceType;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._APPEARANCE;
	}

	public final CityGMLModule getCityGMLModule() {
		return TexturedSurfaceModule.v0_4_0;
	}

}
