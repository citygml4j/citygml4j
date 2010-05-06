package org.citygml4j.impl.jaxb.citygml.texturedsurface._1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.impl.jaxb.gml._3_1_1.OrientableSurfaceImpl;
import org.citygml4j.jaxb.citygml.tex._1.AppearancePropertyType;
import org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.gml.GMLClass;

public class _TexturedSurfaceImpl extends OrientableSurfaceImpl implements _TexturedSurface {
	private TexturedSurfaceType texturedSurfaceType;

	public _TexturedSurfaceImpl() {
		this(new TexturedSurfaceType());
	}

	public _TexturedSurfaceImpl(TexturedSurfaceType texturedSurfaceType) {
		super(texturedSurfaceType);
		this.texturedSurfaceType = texturedSurfaceType;
	}

	@Override
	public TexturedSurfaceType getJAXBObject() {
		return texturedSurfaceType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass._TEXTUREDSURFACE;
	}

	public final CityGMLModule getCityGMLModule() {
		return TexturedSurfaceModule.v1_0_0;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._TEXTUREDSURFACE;
	}

	public List<_AppearanceProperty> getAppearance() {
		List<_AppearanceProperty> appPropList = new ArrayList<_AppearanceProperty>();

		for (AppearancePropertyType appPropType : texturedSurfaceType.getAppearance())
			appPropList.add(new _AppearancePropertyImpl(appPropType));

		return appPropList;
	}

	public void setAppearance(List<_AppearanceProperty> appearance) {
		List<AppearancePropertyType> appPropTypeList = new ArrayList<AppearancePropertyType>();

		for (_AppearanceProperty appProp : appearance)
			appPropTypeList.add(((_AppearancePropertyImpl)appProp).getJAXBObject());

		texturedSurfaceType.unsetAppearance();
		texturedSurfaceType.getAppearance().addAll(appPropTypeList);
	}

	public void addAppearance(_AppearanceProperty appearance) {
		texturedSurfaceType.getAppearance().add(((_AppearancePropertyImpl)appearance).getJAXBObject());
	}

	public boolean isSetAppearance() {
		return texturedSurfaceType.isSetAppearance();
	}

	public void unsetAppearance() {
		texturedSurfaceType.unsetAppearance();
	}
	
	public boolean unsetAppearance(_AppearanceProperty appearance) {
		if (texturedSurfaceType.isSetAppearance())
			return texturedSurfaceType.getAppearance().remove(((_AppearancePropertyImpl)appearance).getJAXBObject());
		
		return false;
	}
	
}
