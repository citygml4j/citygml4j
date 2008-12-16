package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import org.citygml4j.impl.jaxb.citygml.AbstractAppearanceFactoryImpl;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
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

public class Appearance040FactoryImpl extends AbstractAppearanceFactoryImpl {

	@Override
	public Appearance createAppearance() {
		return new AppearanceImpl();
	}

	@Override
	public AppearanceMember createAppearanceMember() {
		return new AppearanceMemberImpl();
	}

	@Override
	public AppearanceProperty createAppearanceProperty() {
		return new AppearancePropertyImpl();
	}

	@Override
	public Color createColor() {
		return new ColorImpl();
	}

	@Override
	public Color createColor(Double red, Double green, Double blue) {
		return new ColorImpl(red, green, blue);
	}

	@Override
	public ColorPlusOpacity createColorPlusOpacity() {
		return new ColorPlusOpacityImpl();
	}

	@Override
	public ColorPlusOpacity createColorPlusOpacity(Color color, Double opacity) {
		return new ColorPlusOpacityImpl(color, opacity);
	}

	@Override
	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue, Double opacity) {
		return new ColorPlusOpacityImpl(red, green, blue, opacity);
	}

	@Override
	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue) {
		return new ColorPlusOpacityImpl(red, green, blue);
	}

	@Override
	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue, Double opacity) {
		return new ColorPlusOpacityImpl(defaultColorValue, opacity);
	}

	@Override
	public ColorPlusOpacity createColorPlusOpacity(Double defaulColorValue) {
		return new ColorPlusOpacityImpl(defaulColorValue);
	}

	@Override
	public GeoreferencedTexture createGeoreferencedTexture() {
		return new GeoreferencedTextureImpl();
	}

	@Override
	public ParameterizedTexture createParameterizedTexture() {
		return new ParameterizedTextureImpl();
	}

	@Override
	public SurfaceDataProperty createSurfaceDataProperty() {
		return new SurfaceDataPropertyImpl();
	}

	@Override
	public TexCoordGen createTexCoordGen() {
		return new TexCoordGenImpl();
	}

	@Override
	public TexCoordList createTexCoordList() {
		return new TexCoordListImpl();
	}

	@Override
	public TextureAssociation createTextureAssociation() {
		return new TextureAssociationImpl();
	}

	@Override
	public TextureCoordinates createTextureCoordinates() {
		return new TextureCoordinatesImpl();
	}

	@Override
	public TextureType createTextureType(String textureType) {
		return TextureTypeImpl.fromValue(textureType);
	}

	@Override
	public WorldToTexture createWorldToTexture() {
		return new WorldToTextureImpl();
	}

	@Override
	public WrapMode createWrapMode(String wrapMode) {
		return WrapModeImpl.fromValue(wrapMode);
	}

	@Override
	public X3DMaterial createX3DMaterial() {
		return new X3DMaterialImpl();
	}

}
