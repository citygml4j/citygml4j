package org.citygml4j.impl.jaxb.citygml.texturedsurface._1;

import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractGMLImpl;
import org.citygml4j.jaxb.citygml.tex._1.AbstractAppearanceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
import org.citygml4j.model.citygml.texturedsurface._Appearance;

public abstract class _AppearanceImpl extends AbstractGMLImpl implements _Appearance {
	private AbstractAppearanceType _appearanceType;

	public _AppearanceImpl(AbstractAppearanceType _appearanceType) {
		super(_appearanceType);
		this._appearanceType = _appearanceType;
	}

	@Override
	public AbstractAppearanceType getJAXBObject() {
		return _appearanceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._APPEARANCE;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return TexturedSurfaceModule.v1_0_0;
	}

}
