/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.builder.jaxb.marshal.citygml.texturedsurface;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml._0_4.MaterialType;
import org.citygml4j.jaxb.citygml._0_4.ObjectFactory;
import org.citygml4j.jaxb.citygml._0_4.SimpleTextureType;
import org.citygml4j.jaxb.citygml._0_4.TextureTypeType;
import org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType;
import org.citygml4j.jaxb.citygml._0_4._AppearancePropertyType;
import org.citygml4j.jaxb.citygml._0_4._AppearanceType;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModuleComponent;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.common.base.ModelObject;

public class TexturedSurface040Marshaller {
	private final ObjectFactory tex;
	private final JAXBMarshaller jaxb;

	public TexturedSurface040Marshaller(CityGMLMarshaller citygml) {
		jaxb = citygml.getJAXBMarshaller();

		tex = citygml.getCore040Marshaller().getObjectFactory();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;

		if (src instanceof TexturedSurfaceModuleComponent)
			src = marshal((TexturedSurfaceModuleComponent)src);

		if (src instanceof MaterialType)
			dest = tex.createMaterial((MaterialType)src);
		else if (src instanceof SimpleTextureType)
			dest = tex.createSimpleTexture((SimpleTextureType)src);
		else if (src instanceof TexturedSurfaceType)
			dest = tex.createTexturedSurface((TexturedSurfaceType)src);

		return dest;
	}

	public Object marshal(ModelObject src) {
		Object dest = null;

		if (src instanceof _AppearanceProperty)
			dest = marshalAppearanceProperty((_AppearanceProperty)src);
		else if (src instanceof _Color)
			dest = marshalColor((_Color)src);
		else if (src instanceof _Material)
			dest = marshalMaterial((_Material)src);
		else if (src instanceof _SimpleTexture)
			dest = marshalSimpleTexture((_SimpleTexture)src);
		else if (src instanceof _TexturedSurface)
			dest = marshalTexturedSurface((_TexturedSurface)src);
		else if (src instanceof _TextureType)
			dest = marshalTextureType((_TextureType)src);

		return dest;
	}

	public void marshalAppearance(_AbstractAppearance src, _AppearanceType dest) {
		jaxb.getGMLMarshaller().marshalAbstractGML(src, dest);
	}

	@SuppressWarnings("unchecked")
	public _AppearancePropertyType marshalAppearanceProperty(_AppearanceProperty src) {
		_AppearancePropertyType dest = tex.create_AppearancePropertyType();

		if (src.isSetOrientation())
			dest.setOrientation(src.getOrientation());

		if (src.isSetAppearance()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getAppearance());
			if (elem != null && elem.getValue() instanceof _AppearanceType)
				dest.set_Appearance((JAXBElement<? extends _AppearanceType>)elem);
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

	public List<Double> marshalColor(_Color src) {
		return src.toList();
	}

	public void marshalMaterial(_Material src, MaterialType dest) {
		marshalAppearance(src, dest);

		if (src.isSetShininess())
			dest.setShininess(src.getShininess());

		if (src.isSetTransparency())
			dest.setTransparency(src.getTransparency());

		if (src.isSetAmbientIntensity())
			dest.setAmbientIntensity(src.getAmbientIntensity());

		if (src.isSetSpecularColor())
			dest.setSpecularColor(marshalColor(src.getSpecularColor()));

		if (src.isSetDiffuseColor())
			dest.setDiffuseColor(marshalColor(src.getDiffuseColor()));

		if (src.isSetEmissiveColor())
			dest.setEmissiveColor(marshalColor(src.getEmissiveColor()));
	}

	public MaterialType marshalMaterial(_Material src) {
		MaterialType dest = tex.createMaterialType();
		marshalMaterial(src, dest);

		return dest;
	}

	public void marshalSimpleTexture(_SimpleTexture src, SimpleTextureType dest) {
		marshalAppearance(src, dest);

		if (src.isSetTextureMap())
			dest.setTextureMap(src.getTextureMap());

		if (src.isSetTextureCoordinates())
			dest.setTextureCoordinates(src.getTextureCoordinates());

		if (src.isSetTextureType())
			dest.setTextureType(marshalTextureType(src.getTextureType()));

		if (src.isSetRepeat())
			dest.setRepeat(src.getRepeat());
	}

	public SimpleTextureType marshalSimpleTexture(_SimpleTexture src) {
		SimpleTextureType dest = tex.createSimpleTextureType();
		marshalSimpleTexture(src, dest);

		return dest;
	}

	public void marshalTexturedSurface(_TexturedSurface src, TexturedSurfaceType dest) {
		jaxb.getGMLMarshaller().marshalOrientableSurface(src, dest);

		if (src.isSetAppearance()) {
			for (_AppearanceProperty appearanceProperty : src.getAppearance())
				dest.getAppearance().add(marshalAppearanceProperty(appearanceProperty));
		}
	}

	public TexturedSurfaceType marshalTexturedSurface(_TexturedSurface src) {
		TexturedSurfaceType dest = tex.createTexturedSurfaceType();
		marshalTexturedSurface(src, dest);

		return dest;
	}

	public TextureTypeType marshalTextureType(_TextureType src) {
		return TextureTypeType.fromValue(src.getValue());
	}

}
