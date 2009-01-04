package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.texturedsurface._Appearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;

public class TexturedSurfaceConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected TexturedSurfaceConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected _AppearanceProperty convert_AppearanceProperty(_AppearanceProperty src) {
		_AppearanceProperty dest = citygml.create_AppearanceProperty(builder.convertContext.texModule);
		if (dest != null) {
			builder.gml.convertAssociationAttributeGroup(src, dest);

			if (src.isSetOrientation())
				dest.setOrientation(src.getOrientation());

			if (src.isSetAppearance()) {
				_Appearance appearance = src.getAppearance();
				_Appearance tmp = null;

				switch (appearance.getCityGMLClass()) {
				case _MATERIAL:
					tmp = convert_Material((_Material)appearance);
					break;
				case _SIMPLETEXTURE:
					tmp = convert_SimpleTexture((_SimpleTexture)appearance);
					break;
				}

				if (tmp != null)
					dest.setAppearance(tmp);
			}
		}

		return dest;
	}

	protected _Color convert_Color(_Color src) {
		_Color dest = citygml.create_Color(builder.convertContext.texModule);
		if (dest != null)
			dest.setColor(src.toList());

		return dest;
	}

	protected _Material convert_Material(_Material src) {
		_Material dest = citygml.create_Material(builder.convertContext.texModule);
		if (dest != null) {
			convert_Appearance(src, dest);

			if (src.isSetShininess())
				dest.setShininess(src.getShininess());

			if (src.isSetTransparency())
				dest.setTransparency(src.getTransparency());

			if (src.isSetAmbientIntensity())
				dest.setAmbientIntensity(src.getAmbientIntensity());

			if (src.isSetDiffuseColor()) {
				_Color tmp = convert_Color(src.getDiffuseColor());
				if (tmp != null)
					dest.setDiffuseColor(tmp);
			}

			if (src.isSetEmissiveColor()) {
				_Color tmp = convert_Color(src.getEmissiveColor());
				if (tmp != null)
					dest.setEmissiveColor(tmp);
			}

			if (src.isSetSpecularColor()) {
				_Color tmp = convert_Color(src.getSpecularColor());
				if (tmp != null)
					dest.setSpecularColor(tmp);
			}
		}

		return dest;
	}

	protected _SimpleTexture convert_SimpleTexture(_SimpleTexture src) {
		_SimpleTexture dest = citygml.create_SimpleTexture(builder.convertContext.texModule);
		if (dest != null) {
			convert_Appearance(src, dest);

			if (src.isSetTextureMap())
				dest.setTextureMap(src.getTextureMap());

			if (src.isSetTextureCoordinates())
				dest.setTextureCoordinates(src.getTextureCoordinates());

			if (src.isSetTextureType()) {
				_TextureType tmp = convert_TextureType(src.getTextureType());
				if (tmp != null)
					dest.setTextureType(tmp);
			}

			if (src.isSetRepeat())
				dest.setRepeat(src.getRepeat());
		}

		return dest;
	}

	protected _TexturedSurface convert_TexturedSurface(_TexturedSurface src) {
		_TexturedSurface dest = citygml.create_TexturedSurface(builder.convertContext.texModule);
		if (dest != null) {
			builder.gml.convertOrientableSurface(src, dest);

			if (src.isSetAppearance()) {
				for (_AppearanceProperty appearance : src.getAppearance()) {
					_AppearanceProperty tmp = convert_AppearanceProperty(appearance);
					if (tmp != null)
						dest.addAppearance(tmp);
				}
			}
		}

		return dest;
	}

	protected _TextureType convert_TextureType(_TextureType src) {
		return citygml.create_TextureType(src.toString(), builder.convertContext.texModule);
	}

	protected void convert_Appearance(_Appearance src, _Appearance dest) {
		builder.gml.convertAbstractGML(src, dest);
	}
}
