/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.texturedsurface;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import net.opengis.citygml.texturedsurface._2.AbstractAppearanceType;
import net.opengis.citygml.texturedsurface._2.AppearancePropertyType;
import net.opengis.citygml.texturedsurface._2.MaterialType;
import net.opengis.citygml.texturedsurface._2.SimpleTextureType;
import net.opengis.citygml.texturedsurface._2.TextureTypeType;
import net.opengis.citygml.texturedsurface._2.TexturedSurfaceType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class TexturedSurface200Unmarshaller {
	private final TexturedSurfaceModule module = TexturedSurfaceModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;

	public TexturedSurface200Unmarshaller(CityGMLUnmarshaller citygml) {
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

	public void unmarshalAbstractAppearance(AbstractAppearanceType src, _AbstractAppearance dest) {
		jaxb.getGMLUnmarshaller().unmarshalAbstractGML(src, dest);
	}

	public _AppearanceProperty unmarshalAppearanceProperty(AppearancePropertyType src) {
		_AppearanceProperty dest =  new _AppearanceProperty(module);

		if (src.isSetOrientation())
			dest.setOrientation(src.getOrientation());

		if (src.isSet_Appearance()) {
			try {
				ModelObject appearance = jaxb.unmarshal(src.get_Appearance());
				if (appearance instanceof _AbstractAppearance)
					dest.setAppearance((_AbstractAppearance)appearance);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public _Color unmarshalColor(List<Double> src) {
		_Color  dest = new _Color(module);
		dest.setColor(src);

		return dest;
	}

	public void unmarshalMaterial(MaterialType src, _Material dest) {
		unmarshalAbstractAppearance(src, dest);

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
		_Material dest = new _Material(module);
		unmarshalMaterial(src, dest);

		return dest;
	}

	public void unmarshalSimpleTexture(SimpleTextureType src, _SimpleTexture dest) {
		unmarshalAbstractAppearance(src, dest);

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
		_SimpleTexture dest = new _SimpleTexture(module);
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
		_TexturedSurface dest = new _TexturedSurface(module);
		unmarshalTexturedSurface(src, dest);

		return dest;
	}

	public _TextureType unmarshalTextureType(TextureTypeType src) {
		return _TextureType.fromValue(src.value());
	}

}
