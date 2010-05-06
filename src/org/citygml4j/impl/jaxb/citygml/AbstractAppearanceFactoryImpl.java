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
	
	public abstract Appearance createAppearance();

	public abstract AppearanceMember createAppearanceMember();

	public abstract AppearanceProperty createAppearanceProperty();

	public abstract Color createColor();

	public abstract Color createColor(Double red, Double green, Double blue);

	public abstract ColorPlusOpacity createColorPlusOpacity();

	public abstract ColorPlusOpacity createColorPlusOpacity(Color color, Double opacity);

	public abstract ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue,
			Double opacity);

	public abstract ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue);

	public abstract ColorPlusOpacity createColorPlusOpacity(Double red, Double green,
			Double blue, Double opacity);

	public abstract ColorPlusOpacity createColorPlusOpacity(Double red, Double green,
			Double blue);

	public abstract GeoreferencedTexture createGeoreferencedTexture();

	public abstract ParameterizedTexture createParameterizedTexture();

	public abstract SurfaceDataProperty createSurfaceDataProperty();

	public abstract TexCoordGen createTexCoordGen();

	public abstract TexCoordList createTexCoordList();

	public abstract TextureAssociation createTextureAssociation();

	public abstract TextureCoordinates createTextureCoordinates();

	public abstract TextureType createTextureType(String textureType);

	public abstract WorldToTexture createWorldToTexture();

	public abstract WrapMode createWrapMode(String wrapMode);

	public abstract X3DMaterial createX3DMaterial();

}
