package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.appearance._0_4.Appearance040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.appearance._1.Appearance100FactoryImpl;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceFactory;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.appearance.Color;
import org.citygml4j.model.citygml.appearance.ColorPlusOpacity;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;
import org.citygml4j.model.citygml.appearance.TextureType;
import org.citygml4j.model.citygml.appearance.WorldToTexture;
import org.citygml4j.model.citygml.appearance.WrapMode;
import org.citygml4j.model.citygml.appearance.X3DMaterial;

public abstract class AbstractAppearanceFactoryImpl implements AppearanceFactory {
	private static Appearance040FactoryImpl factory040 = new Appearance040FactoryImpl();
	private static Appearance100FactoryImpl factory100 = new Appearance100FactoryImpl();
	
	public static AppearanceFactory getInstance(AppearanceModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	@Override
	public abstract Appearance createAppearance();

	@Override
	public abstract AppearanceMember createAppearanceMember();

	@Override
	public abstract AppearanceProperty createAppearanceProperty();

	@Override
	public abstract Color createColor();

	@Override
	public abstract Color createColor(Double red, Double green, Double blue);

	@Override
	public abstract ColorPlusOpacity createColorPlusOpacity();

	@Override
	public abstract ColorPlusOpacity createColorPlusOpacity(Color color, Double opacity);

	@Override
	public abstract ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue,
			Double opacity);

	@Override
	public abstract ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue);

	@Override
	public abstract ColorPlusOpacity createColorPlusOpacity(Double red, Double green,
			Double blue, Double opacity);

	@Override
	public abstract ColorPlusOpacity createColorPlusOpacity(Double red, Double green,
			Double blue);

	@Override
	public abstract GeoreferencedTexture createGeoreferencedTexture();

	@Override
	public abstract ParameterizedTexture createParameterizedTexture();

	@Override
	public abstract SurfaceDataProperty createSurfaceDataProperty();

	@Override
	public abstract TexCoordGen createTexCoordGen();

	@Override
	public abstract TexCoordList createTexCoordList();

	@Override
	public abstract TextureAssociation createTextureAssociation();

	@Override
	public abstract TextureCoordinates createTextureCoordinates();

	@Override
	public abstract TextureType createTextureType(String textureType);

	@Override
	public abstract WorldToTexture createWorldToTexture();

	@Override
	public abstract WrapMode createWrapMode(String wrapMode);

	@Override
	public abstract X3DMaterial createX3DMaterial();

}
