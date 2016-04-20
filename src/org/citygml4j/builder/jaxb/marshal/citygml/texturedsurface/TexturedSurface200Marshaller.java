/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2016 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.jaxb.marshal.citygml.texturedsurface;

import java.util.List;

import javax.xml.bind.JAXBElement;

import net.opengis.citygml.texturedsurface._2.AbstractAppearanceType;
import net.opengis.citygml.texturedsurface._2.AppearancePropertyType;
import net.opengis.citygml.texturedsurface._2.MaterialType;
import net.opengis.citygml.texturedsurface._2.ObjectFactory;
import net.opengis.citygml.texturedsurface._2.SimpleTextureType;
import net.opengis.citygml.texturedsurface._2.TextureTypeType;
import net.opengis.citygml.texturedsurface._2.TexturedSurfaceType;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModuleComponent;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.common.base.ModelObject;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;

public class TexturedSurface200Marshaller {
	private final ObjectFactory tex = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	
	public TexturedSurface200Marshaller(CityGMLMarshaller citygml) {
		jaxb = citygml.getJAXBMarshaller();
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
	
	public void marshalAbstractAppearance(_AbstractAppearance src, AbstractAppearanceType dest) {
		jaxb.getGMLMarshaller().marshalAbstractGML(src, dest);
	}
	
	@SuppressWarnings("unchecked")
	public AppearancePropertyType marshalAppearanceProperty(_AppearanceProperty src) {
		AppearancePropertyType dest = tex.createAppearancePropertyType();

		if (src.isSetOrientation())
			dest.setOrientation(src.getOrientation());
		
		if (src.isSetAppearance()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getAppearance());
			if (elem != null && elem.getValue() instanceof AbstractAppearanceType)
				dest.set_Appearance((JAXBElement<? extends AbstractAppearanceType>)elem);
		}
		
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}
	
	public List<Double> marshalColor(_Color src) {
		return src.toList();
	}
	
	public void marshalMaterial(_Material src, MaterialType dest) {
		marshalAbstractAppearance(src, dest);
		
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
		marshalAbstractAppearance(src, dest);
		
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
