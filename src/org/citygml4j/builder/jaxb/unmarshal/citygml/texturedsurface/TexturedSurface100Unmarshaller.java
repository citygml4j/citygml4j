package org.citygml4j.builder.jaxb.unmarshal.citygml.texturedsurface;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.impl.citygml.texturedsurface._AppearancePropertyImpl;
import org.citygml4j.impl.citygml.texturedsurface._ColorImpl;
import org.citygml4j.impl.citygml.texturedsurface._MaterialImpl;
import org.citygml4j.impl.citygml.texturedsurface._SimpleTextureImpl;
import org.citygml4j.impl.citygml.texturedsurface._TexturedSurfaceImpl;
import org.citygml4j.jaxb.citygml.tex._1.AbstractAppearanceType;
import org.citygml4j.jaxb.citygml.tex._1.AppearancePropertyType;
import org.citygml4j.jaxb.citygml.tex._1.MaterialType;
import org.citygml4j.jaxb.citygml.tex._1.SimpleTextureType;
import org.citygml4j.jaxb.citygml.tex._1.TextureTypeType;
import org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.texturedsurface._Appearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class TexturedSurface100Unmarshaller {
	private final TexturedSurfaceModule module = TexturedSurfaceModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;

	public TexturedSurface100Unmarshaller(CityGMLUnmarshaller citygml) {
		jaxb = citygml.getJAXBUnmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		CityGML dest = null;

		if (src instanceof AppearancePropertyType)
			dest = unmarshalAppearanceProperty((AppearancePropertyType)src);
		else if (src instanceof MaterialType)
			dest = unmarshalMaterial((MaterialType)src);
		else if (src instanceof SimpleTextureType)
			dest = unmarshalSimpleTexture((SimpleTextureType)src);
		else if (src instanceof TexturedSurfaceType)
			dest = unmarshalTexturedSurface((TexturedSurfaceType)src);		
		else if (src instanceof TextureTypeType)
			dest = unmarshalTextureType((TextureTypeType)src);

		return dest;
	}

	public void unmarshalAppearance(AbstractAppearanceType src, _Appearance dest) {
		jaxb.getGMLUnmarshaller().unmarshalAbstractGML(src, dest);
	}

	public _AppearanceProperty unmarshalAppearanceProperty(AppearancePropertyType src) {
		_AppearanceProperty dest =  new _AppearancePropertyImpl(module);

		if (src.isSetOrientation())
			dest.setOrientation(src.getOrientation());

		if (src.isSet_Appearance()) {
			try {
				Object appearance = jaxb.unmarshal(src.get_Appearance());
				if (appearance instanceof _Appearance)
					dest.setAppearance((_Appearance)appearance);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public _Color unmarshalColor(List<Double> src) {
		_Color  dest = new _ColorImpl(module);
		dest.setColor(src);

		return dest;
	}

	public void unmarshalMaterial(MaterialType src, _Material dest) {
		unmarshalAppearance(src, dest);

		if (src.isSetShininess())
			dest.setShininess(src.getShininess());

		if (src.isSetTransparency())
			dest.setTransparency(src.getTransparency());

		if (src.isSetAmbientIntensity())
			dest.setAmbientIntensity(src.getAmbientIntensity());

		if (src.isSetSpecularColor())
			dest.setSpecularColor(unmarshalColor(src.getSpecularColor()));

		if (src.isSetDiffuseColor())
			dest.setDiffuseColor(unmarshalColor(src.getDiffuseColor()));

		if (src.isSetEmissiveColor())
			dest.setEmissiveColor(unmarshalColor(src.getEmissiveColor()));
	}

	public _Material unmarshalMaterial(MaterialType src) {
		_Material dest = new _MaterialImpl(module);
		unmarshalMaterial(src, dest);

		return dest;
	}

	public void unmarshalSimpleTexture(SimpleTextureType src, _SimpleTexture dest) {
		unmarshalAppearance(src, dest);

		if (src.isSetTextureMap())
			dest.setTextureMap(src.getTextureMap());

		if (src.isSetTextureCoordinates())
			dest.setTextureCoordinates(src.getTextureCoordinates());

		if (src.isSetTextureType())
			dest.setTextureType(unmarshalTextureType(src.getTextureType()));

		if (src.isSetRepeat())
			dest.setRepeat(src.isRepeat());
	}

	public _SimpleTexture unmarshalSimpleTexture(SimpleTextureType src) {
		_SimpleTexture dest = new _SimpleTextureImpl(module);
		unmarshalSimpleTexture(src, dest);

		return dest;
	}

	public void unmarshalTexturedSurface(TexturedSurfaceType src, _TexturedSurface dest) {
		jaxb.getGMLUnmarshaller().unmarshalOrientableSurface(src, dest);

		if (src.isSetAppearance()) {
			for (AppearancePropertyType appearanceProperty : src.getAppearance())
				dest.addAppearance(unmarshalAppearanceProperty(appearanceProperty));
		}
	}

	public _TexturedSurface unmarshalTexturedSurface(TexturedSurfaceType src) {
		_TexturedSurface dest = new _TexturedSurfaceImpl(module);
		unmarshalTexturedSurface(src, dest);

		return dest;
	}

	public _TextureType unmarshalTextureType(TextureTypeType src) {
		return _TextureType.fromValue(src.value());
	}

}
